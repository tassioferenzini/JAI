/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converte;

import Modelo.Publicacoes;
import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author tassio
 */
public class PublicacaoConverte {

    public Map converterMap(Publicacoes pub) {
        Map mapPublicacao = new HashMap();
        mapPublicacao.put("artigo", pub.getArtigo());
        mapPublicacao.put("autor", pub.getAutor());
        return mapPublicacao;
    }

    public Publicacoes converterPublicacoes(DBObject dbo) {
        Publicacoes pub = new Publicacoes();
        pub.setId((ObjectId) dbo.get("_id"));
        pub.setAutor((List) dbo.get("autor"));
        pub.setArtigo(dbo.get("artigo").toString());
        return pub;
    }

}
