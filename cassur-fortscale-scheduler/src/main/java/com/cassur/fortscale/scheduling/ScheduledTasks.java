package com.cassur.fortscale.scheduling;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cassur.fortscale.scheduling.model.CassurUser;
import com.cassur.fortscale.scheduling.model.CassurUserDao;
import com.cassur.fortscale.scheduling.model.Client;
import com.cassur.fortscale.scheduling.model.Uba;
import com.cassur.fortscale.scheduling.model.UbaDao;
import com.cassur.fortscale.scheduling.model.User;
import com.cassur.fortscale.scheduling.model.UserDao;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 500000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));

		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://52.9.159.233/fortscale-webapp/api";
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<String> responseEntity = restTemplate.exchange(fooResourceUrl + "/user/", HttpMethod.GET,
				request, String.class);
		JSONObject jsnobject = new JSONObject(responseEntity.getBody());
		JSONArray jsonArray = jsnobject.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			User user = new User();
			JSONObject explrObject = jsonArray.getJSONObject(i);
			user.setData(explrObject.toString());
			user = userDao.save(user);
			CassurUser cassurUser = new CassurUser();
			cassurUser.setClientId(1234);
			cassurUser.setUserName(explrObject.getString("username"));
			cassurUser.setDateTime(user.getCreatedAt());
			
			Uba uba = new Uba();
			uba.setDateTime(user.getCreatedAt());
			uba.setUserId(cassurUser.getUserId());
			uba.setDateTime(user.getCreatedAt());
			uba.setUserRiskScore(33);
			cassurUser.setUba(uba);
			Client client = new Client();
			client.setClientId(1234);
			client.setClientName(explrObject.getString("username"));
			client.setClientShortName(explrObject.getString("firstname"));
			cassurUser.setClient(client);
			cassurUser = cassurUserDao.save(cassurUser);
			//ubaDao.save(uba);
		}
	}

	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * user-credentials.
	 */
	private static HttpHeaders getHeaders() {
		String plainCredentials = "admin@fortscale.com:T@fhvusu42";
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UbaDao ubaDao;
	
	@Autowired
	private CassurUserDao cassurUserDao;
}
