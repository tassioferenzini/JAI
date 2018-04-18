/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojai;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tassio
 */
public class ExemploJAI_Simples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //savePes();
        //savePub();
        //update();
        //delete();
        list();

        System.exit(0);
    }

    private static void savePes() {

        MongoClientURI mongoURI = new MongoClientURI("mongodb://jai:jai@localhost:27017/?authSource=JAI");
        MongoClient mongodb = new MongoClient(mongoURI);
        MongoDatabase db = mongodb.getDatabase("JAI");

        BasicDBObject pessoa = new BasicDBObject();
        pessoa.put("nome", "Humberto");
        pessoa.put("sobrenome", "Dalpra");
        pessoa.put("email", "humbertodalpra@gmail.com");

        BasicDBObject tel = new BasicDBObject();
        tel.put("celular", Long.parseLong("32988330000"));
        pessoa.put("telefone", tel);

        BasicDBObject end = new BasicDBObject();
        end.put("tipoLogradouro", "Rua");
        end.put("logradouro", "B");
        end.put("numero", "1");
        end.put("bairro", "Centro");
        end.put("cidade", "Juiz de Fora");
        end.put("cep", "36100-000");

        pessoa.put("endereco", end);

        BasicDBObject pessoa2 = new BasicDBObject();
        pessoa2.put("nome", "Tassio");
        pessoa2.put("sobrenome", "Sirqueira");
        pessoa2.put("email", "tassio@tassio.eti.br");

        BasicDBObject tel2 = new BasicDBObject();
        tel2.put("casa", Long.parseLong("3232730000"));
        tel2.put("celular", Integer.parseInt("984440000"));
        pessoa2.put("telefone", tel2);

        BasicDBObject end2 = new BasicDBObject();
        end2.put("tipoLogradouro", "Rua");
        end2.put("logradouro", "A");
        end2.put("numero", "1");
        end2.put("bairro", "Centro");
        end2.put("cidade", "Matias Barbosa");
        end2.put("cep", "36120-000");

        pessoa2.put("endereco", end2);

        BasicDBObject pessoa3 = new BasicDBObject();
        pessoa3.put("nome", "João");
        pessoa3.put("sobrenome", "Nunes");

        BasicDBObject end3 = new BasicDBObject();
        end3.put("tipoLogradouro", "Av");
        end3.put("logradouro", "Cardoso");
        end3.put("numero", "1");
        end3.put("bairro", "Borboleta");
        end3.put("cidade", "Juiz de Fora");
        end3.put("cep", "36110-100");

        pessoa3.put("endereco", end3);

        MongoCollection<BasicDBObject> colecaoPessoa = db.getCollection("Pessoa", BasicDBObject.class);
        colecaoPessoa.insertOne(pessoa);
        colecaoPessoa.insertOne(pessoa2);
        colecaoPessoa.insertOne(pessoa3);

    }

    private static void savePub() {

        MongoClientURI mongoURI = new MongoClientURI("mongodb://jai:jai@localhost:27017/?authSource=JAI");
        MongoClient mongodb = new MongoClient(mongoURI);
        MongoDatabase db = mongodb.getDatabase("JAI");

        BasicDBObject pub = new BasicDBObject();
        pub.put("artigo", "Using Ontology and Data Provenance to Improve Software Processes");
        List autor = new ArrayList();
        autor.add("Tassio");
        autor.add("Humberto");
        pub.put("autor", autor);

        BasicDBObject pub2 = new BasicDBObject();
        pub2.put("artigo", "A Software Framework for Data Provenance");
        pub2.put("autor", "Tassio");

        BasicDBObject pub3 = new BasicDBObject();
        pub3.put("artigo", "Newsql: An alternative to nosql and old sql for new oltp apps");
        pub3.put("autor", "Stonebraker");

        MongoCollection<BasicDBObject> colecaoPublicacoes = db.getCollection("Publicacoes", BasicDBObject.class);
        colecaoPublicacoes.insertOne(pub);
        colecaoPublicacoes.insertOne(pub2);
        colecaoPublicacoes.insertOne(pub3);

    }

    private static void update() {

        MongoClientURI mongoURI = new MongoClientURI("mongodb://jai:jai@localhost:27017/?authSource=JAI");
        MongoClient mongodb = new MongoClient(mongoURI);
        MongoDatabase db = mongodb.getDatabase("JAI");
        MongoCollection<BasicDBObject> colecaoPessoa = db.getCollection("Pessoa", BasicDBObject.class);

        BasicDBObject query = new BasicDBObject();
        query.put("nome", "João");

        BasicDBObject pessoa = new BasicDBObject();
        pessoa.put("nome", "João");
        pessoa.put("sobrenome", "Silva");

        BasicDBObject end = new BasicDBObject();
        end.put("tipoLogradouro", "Av");
        end.put("logradouro", "Cardoso");
        end.put("numero", "1");
        end.put("bairro", "Borboleta");
        end.put("cidade", "Juiz de Fora");
        end.put("cep", "36110-100");
        pessoa.put("endereco", end);

        BasicDBObject update = new BasicDBObject();
        update.put("$set", pessoa);

        colecaoPessoa.updateOne(query, update);

    }

    private static void delete() {

        MongoClientURI mongoURI = new MongoClientURI("mongodb://jai:jai@localhost:27017/?authSource=JAI");
        MongoClient mongodb = new MongoClient(mongoURI);
        MongoDatabase db = mongodb.getDatabase("JAI");
        MongoCollection<BasicDBObject> colecaoPessoa = db.getCollection("Pessoa", BasicDBObject.class);

        BasicDBObject query = new BasicDBObject();
        query.append("nome", "João");
        colecaoPessoa.deleteOne(query);

    }

    private static void list() {

        MongoClientURI mongoURI = new MongoClientURI("mongodb://jai:jai@localhost:27017/?authSource=JAI");
        MongoClient mongodb = new MongoClient(mongoURI);
        MongoDatabase db = mongodb.getDatabase("JAI");
        MongoCollection<BasicDBObject> colecaoPessoa = db.getCollection("Pessoa", BasicDBObject.class);

        for (BasicDBObject doc : colecaoPessoa.find()) {
            System.out.println(doc);
        }
        
    }

}
