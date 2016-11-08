package com.cassur.fortscale.scheduling;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.codec.binary.Base64;
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
		ResponseEntity<CoreJson> responseEntity = restTemplate.exchange(fooResourceUrl + "/user/", HttpMethod.GET, request, CoreJson.class);
			for(Data data : responseEntity.getBody().getData()){
				User user = new User();
				user.setAdministratorAccount(data.getAdministratorAccount());
				user.setDisplayName(data.getDisplayName());
				user.setExecutiveAccount(data.getExecutiveAccount());
				user.setFollowed(data.getFollowed());
				user.setId(data.getId());
				user.setNoDomainUsername(data.getNoDomainUsername());
				user.setSearchField(data.getSearchField());
				user.setUsername(data.getUsername());
				user.setUserServiceAccount(data.getUserServiceAccount());
				userDao.save(user);
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
}
