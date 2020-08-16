package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CodecRegistry pojoCodecRegistry;

        ConnectionString connString = new ConnectionString(
                "mongodb+srv://dbUser:dbPassword@cluster0-1bxg9.mongodb.net/");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("sample_analytics");
        MongoCollection<Document> coll = database.getCollection("accounts");
        MongoCursor singleCursor = coll.find().iterator();
        while(singleCursor.hasNext()){
            System.out.println(singleCursor.next());
        }




    }
}
