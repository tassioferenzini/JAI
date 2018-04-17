/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.DBObject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public interface IDao {

    void save(Map value);

    void update(Map valueQuery, Map value);

    void delete(Map value);

    DBObject findOne(Map value);

    List findAll();

}
