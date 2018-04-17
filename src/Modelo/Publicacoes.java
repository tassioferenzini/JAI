/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author tassio
 */
public class Publicacoes {

    private ObjectId id;
    private String artigo;
    private List autor;

    public Publicacoes() {
    }

    public Publicacoes(String artigo, List autor) {
        this.artigo = artigo;
        this.autor = autor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    public List getAutor() {
        return autor;
    }

    public void setAutor(List autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Publicacoes{" + "id=" + id + ", artigo=" + artigo + ", autor=" + autor + '}';
    }

}
