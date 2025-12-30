package com.neurofleetx.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.neurofleetx.repository")
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Yahan humne connection string mein database name lock kar diya hai
        return MongoClients.create("mongodb://localhost:27017/neurofleetx");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "neurofleetx");
    }
}