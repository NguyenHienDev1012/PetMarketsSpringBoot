package com.petmarkets2020.firebase;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {
    @PostConstruct
    public void initialize() throws IOException {
    	try {
       	 
        	InputStream is = new ClassPathResource("/pet-market-6996-key.json").getInputStream();
        
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(is))
                    .setDatabaseUrl("https://pet-market-6996-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
