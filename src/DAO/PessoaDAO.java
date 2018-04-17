/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Converte.PessoaConverte;
import Modelo.Pessoa;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class PessoaDAO extends EntidadeDAO {

    public PessoaDAO() {
        super(Pessoa.class);
    }

    public void save(Pessoa pessoa) {
        Map mapPerson = new PessoaConverte().converterMap(pessoa);

        save(mapPerson);
    }

    public void update(Pessoa oldPessoa, Pessoa pessoa) {
        Map query = new PessoaConverte().converterMap(oldPessoa);
        Map map = new PessoaConverte().converterMap(pessoa);
        update(query, map);
    }

    public void delete(Pessoa pessoa) {
        Map map = new PessoaConverte().converterMap(pessoa);
        delete(map);
    }

    public Pessoa findPerson(Map mapKeyValue) {
        DBObject dbObject = findOne(mapKeyValue);
        Pessoa pessoa = new PessoaConverte().converterPessoa(dbObject);
        return pessoa;
    }

    public List findPersons() {
        List dbObject = findAll();
        List pessoas = new ArrayList();
        for (Object dbo : dbObject) {
            Pessoa pessoa = new PessoaConverte().converterPessoa((DBObject) dbo);
            pessoas.add(pessoa);
        }
        return pessoas;
    }

}
