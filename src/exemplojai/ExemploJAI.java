/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojai;

import DAO.PessoaDAO;
import DAO.PublicacaoDAO;
import Modelo.Endereco;
import Modelo.Pessoa;
import Modelo.Publicacoes;
import Modelo.Telefone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class ExemploJAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //save();
        //savePub();
        //update();
        //delete();
        System.exit(0);
    }

    private static void save() {
        List autor = new ArrayList();
        autor.add("Tassio");
        autor.add("Humberto");
        Publicacoes pub = new Publicacoes("NOSQL", autor);
        new PublicacaoDAO().save(pub);

        Telefone fone = new Telefone("3232323375", "32999334400");
        Endereco end = new Endereco("Rua", "Azul", 230, "Vista Alegre", "Bananal", "12365-000");
        Pessoa pessoa = new Pessoa("João", "de Souza", "", fone, end);
        new PessoaDAO().save(pessoa);

        Telefone fone2 = new Telefone("3232324455", "32988334400");
        Endereco end2 = new Endereco("Av", "7", 120, "Mundo Novo", "Rio de Janeiro", "12460-000");
        Pessoa pessoa2 = new Pessoa("Luiz", "Almeida", "luiz@mail.com", fone2, end2);
        new PessoaDAO().save(pessoa2);

        Telefone fone3 = new Telefone(" ", " ");
        Endereco end3 = new Endereco("Rua", "Branco", 30, "Alegre", "Jardim", "14365-000");
        Pessoa pessoa3 = new Pessoa("Carlos", "de Souza", "", fone3, end);
        new PessoaDAO().save(pessoa3);

        List pessoas = new PessoaDAO().findPersons();
        for (Object pes : pessoas) {
            System.out.println(pes.toString());
        }
    }

    private static void savePub() {

        List autor = new ArrayList();
        autor.add("Tassio");
        autor.add("Humberto");
        Publicacoes pub = new Publicacoes("Using Ontology and Data Provenance to Improve Software Processes", autor);

        List autor2 = new ArrayList();
        autor2.add("Tassio");
        Publicacoes pub2 = new Publicacoes("A Software Framework for Data Provenance", autor2);

        List autor3 = new ArrayList();
        autor3.add("Stonebraker");
        Publicacoes pub3 = new Publicacoes("Newsql: An alternative to nosql and old sql for new oltp apps", autor3);

        new PublicacaoDAO().save(pub);
        new PublicacaoDAO().save(pub2);
        new PublicacaoDAO().save(pub3);

    }

    private static void update() {
        Map map = new HashMap();
        map.put("nome", "João");
        Pessoa query = new PessoaDAO().findPerson(map);

        Telefone fone = new Telefone("3232002100", "32999110022");
        Endereco end = new Endereco("Rua", "C", 100, "Monte Alegre", "Natal", "12360-000");
        Pessoa pessoa = new Pessoa("Zé", "Silva", "", fone, end);
        new PessoaDAO().update(query, pessoa);

        Map map2 = new HashMap();
        map2.put("nome", "Zé");
        Pessoa novaPessoa = new PessoaDAO().findPerson(map2);
        System.out.printf("Old:> " + query + "\nNew:> " + novaPessoa.toString());
    }

    private static void delete() {
        Map map = new HashMap();
        map.put("nome", "Zé");
        Pessoa query = new PessoaDAO().findPerson(map);
        new PessoaDAO().delete(query);

        List pessoas = new PessoaDAO().findPersons();
        for (Object pes : pessoas) {
            System.out.println(pes.toString());
        }
    }

}
