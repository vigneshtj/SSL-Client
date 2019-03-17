package io.vignesh;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ClientService {

	private static final String SERVICE_URI = "https://localhost:8443/values";
	private static final String PASSWORD = "password";
	private static final String CERT_PATH = "C:/Users/saira/Documents/workspace-sts-3.9.7.RELEASE/ClientSSL/src/main/resources/server.";
	
	
	public String getValues() {
		RestTemplate restTemplate = getRestTemplete();
		
		return "from Service";
	}
	
	public RestTemplate getRestTemplete() {
	RestTemplate restTemplate = new RestTemplate();
	
	File file = new File(CERT_PATH);
	InputStream is = new FileInputStream(file);
	KeyStore keyStore = KeyStore.getInstance("JKS");
	keyStore.load(is, PASSWORD.toCharArray());
	
	//SSLContext sslcontext = SSLContexts.
   //SSLServerSocketFactory socketFactory = new SSLServerSocketFactory(new SSLContext().loadTrustMaterial(null, new TrustSelfSignedStrategy()).loadKeyMaterial(keyStore, PASSWORD.toCharArray()).build(),NoopHostnameVerifier.INSTANCE);

	SSLContext sslContext = new SSLContextBuilder()
			
	/*
	SSLServerSocketFactory socketFactory = new SSLServerSocketFactory(
			
	
	
	        new SSLContextBuilder()
	                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
	                .loadKeyMaterial(keyStore, "password".toCharArray()).build());
	
	*/SSLServerSocketFactory socketFactory = new SSLServerSocketFactory(new SSLContextBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy())
	                .loadKeyMaterial(keyStore, "password".toCharArray()).build());		
	return restTemplate;
	}
	}
	
}
