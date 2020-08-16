package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
    MongoDatabase database;

    Connection(){
        ConnectionString connString = new ConnectionString(
                "mongodb+srv://dbUser:dbPassword@cluster0-1bxg9.mongodb.net/");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("sample_analytics");
    }


}
