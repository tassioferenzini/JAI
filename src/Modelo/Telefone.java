/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author tassio
 */
public class Telefone {

    private String casa;
    private String celular;

    public Telefone(String casa, String celular) {
        this.casa = casa;
        this.celular = celular;
    }

    public Telefone() {
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Telefone{" + "casa=" + casa + ", celular=" + celular + '}';
    }
    
}
