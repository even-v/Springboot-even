package cn.even.kingsum.origin.util;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RestClientUtil {

	private static RestTemplate restTemplate;
	private static HttpHeaders headers;
	private static StringHttpMessageConverter m ;

	public static void init(){
		if(restTemplate == null){
			m = new StringHttpMessageConverter(Charset.forName("utf-8"));
			restTemplate =  new RestTemplateBuilder().additionalMessageConverters(m).build();
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.setAcceptCharset(Arrays.asList(Charset.forName("utf-8")));
		}
	}
	
	public static String postForObject(String url,String body){
		init();
		HttpEntity<String> entity = new HttpEntity<String>(body,headers);
		return restTemplate.postForObject(url, entity, String.class);
	}

}
