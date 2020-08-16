package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Connection connectToDB = new Connection("sample_analytics");
        MongoCollection<Document> coll = connectToDB.database.getCollection("accounts");
        MongoCursor singleCursor = coll.find().iterator();
        while(singleCursor.hasNext()){
            System.out.println(singleCursor.next());
        }
    }
}
