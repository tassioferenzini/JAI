/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Converte.PublicacaoConverte;
import Modelo.Publicacoes;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class PublicacaoDAO extends EntidadeDAO {

    public PublicacaoDAO() {
        super(Publicacoes.class);
    }

    public void save(Publicacoes p) {
        Map mapPerson = new PublicacaoConverte().converterMap(p);
        save(mapPerson);
    }

    public void update(Publicacoes oldPessoa, Publicacoes pessoa) {
        Map query = new PublicacaoConverte().converterMap(oldPessoa);
        Map map = new PublicacaoConverte().converterMap(pessoa);
        update(query, map);
    }

    public void delete(Publicacoes p) {
        Map map = new PublicacaoConverte().converterMap(p);
        delete(map);
    }

    public Publicacoes findPerson(Map mapKeyValue) {
        DBObject dbObject = findOne(mapKeyValue);
        Publicacoes p = new PublicacaoConverte().converterPessoa(dbObject);
        return p;
    }

    public List findPersons() {
        List dbObject = findAll();
        List ps = new ArrayList();
        for (Object dbo : dbObject) {
            Publicacoes p = new PublicacaoConverte().converterPessoa((DBObject) dbo);
            ps.add(p);
        }
        return ps;
    }

}
