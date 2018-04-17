/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author tassio
 */
public class MongoConnection {

    private static final String URI = "mongodb://jai:jai@localhost:27017/?authSource=JAI";
    private static final String DB_NAME = "JAI";
    private static MongoConnection uniqInstance;
    private MongoClient mongo;
    private DB db;

    public static synchronized MongoConnection getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new MongoConnection();
        }
        return uniqInstance;
    }

    public DB getDB() {
        if (mongo == null) {
            try {
                mongo = new MongoClient(new MongoClientURI(URI));
                db = mongo.getDB(DB_NAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return db;
    }
}
