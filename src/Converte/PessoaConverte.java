/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converte;

import Modelo.Pessoa;
import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author tassio
 */
public class PessoaConverte {

    public Map converterMap(Pessoa pessoa) {
        Map mapPessoa = new HashMap();
        mapPessoa.put("nome", pessoa.getNome());
        mapPessoa.put("sobrenome", pessoa.getSobrenome());
        mapPessoa.put("email", pessoa.getEmail());
        mapPessoa.put("endereco", new EnderecoConverte().converterMap(pessoa.getEndereco()));
        mapPessoa.put("telefone", new TelefoneConverte().converterMap(pessoa.getTelefone()));
        return mapPessoa;
    }

    public Pessoa converterPessoa(DBObject dbo) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId((ObjectId) dbo.get("_id"));
        pessoa.setNome(dbo.get("nome").toString());
        pessoa.setSobrenome(dbo.get("sobrenome").toString());
        pessoa.setEmail(dbo.get("email").toString());
        pessoa.setTelefone(new TelefoneConverte().converterTelefone((HashMap) dbo.get("telefone")));
        pessoa.setEndereco(new EnderecoConverte().converterEndereco((HashMap) dbo.get("endereco")));
        return pessoa;
    }

}
