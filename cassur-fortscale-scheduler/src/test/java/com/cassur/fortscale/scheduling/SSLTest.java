//package com.cassur.fortscale.scheduling;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.fail;
//
//import java.security.cert.X509Certificate;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.TrustStrategy;
//import org.junit.Test;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//public class SSLTest {
//
////	@Test
////	public void test() {
////		fail("Not yet implemented");
////	}
//	
//	@Test
//	public void opensSSLPage() throws Exception {
//		 System.setProperty("https.protocols", "TLSv1.1");
//	    String uri = "https://52.9.159.233/fortscale-webapp/api/user";
//	    TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//
//	    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
//	            .loadTrustMaterial(null, acceptingTrustStrategy)
//	            .build();
//
//	    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
//
//	    CloseableHttpClient httpClient = HttpClients.custom()
//	            .setSSLSocketFactory(csf)
//	            .build();
//
//	    HttpComponentsClientHttpRequestFactory requestFactory =
//	            new HttpComponentsClientHttpRequestFactory();
//
//	    requestFactory.setHttpClient(httpClient);
//
//	    RestTemplate restTemplate = new RestTemplate(requestFactory);
//	    ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
//	    assertThat(entity.getStatusCode(), equalTo(200));
//	}
//
//}
