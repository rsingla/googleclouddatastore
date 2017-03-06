package com.bills.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

@SpringBootApplication
public class GoogleCloudStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleCloudStoreApplication.class, args);
	}
	
  @Bean
  public Datastore cloudDatastoreService() {
      return DatastoreOptions.getDefaultInstance().getService();
  }
}
