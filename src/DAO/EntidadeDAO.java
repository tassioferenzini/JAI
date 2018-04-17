/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.MongoConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class EntidadeDAO implements IDao {

    private final Class persistentClass;
    private final DBCollection dbCollection;

    public EntidadeDAO(Class persistentClass) {
        this.persistentClass = persistentClass;
        this.dbCollection = MongoConnection.getInstance().getDB().getCollection(persistentClass.getSimpleName());
    }

    protected DBCollection getDbCollection() {
        return dbCollection;
    }

    @Override
    public void save(Map value) {
        BasicDBObject document = new BasicDBObject(value);
        dbCollection.save(document);
    }

    @Override
    public void update(Map valueQuery,
            Map value) {
        BasicDBObject query = new BasicDBObject(valueQuery);
        BasicDBObject entity = new BasicDBObject(value);
        dbCollection.update(query, entity);
    }

    @Override
    public void delete(Map value) {
        BasicDBObject entity = new BasicDBObject(value);
        dbCollection.remove(entity);
    }

    @Override
    public DBObject findOne(Map value) {
        BasicDBObject query = new BasicDBObject(value);
        return dbCollection.findOne(query);
    }

    @Override
    public List findAll() {
        List list = new ArrayList();
        DBCursor cursor = dbCollection.find();
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }
        return list;
    }

}
