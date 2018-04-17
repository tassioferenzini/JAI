/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converte;

import Modelo.Telefone;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class TelefoneConverte {
    
    public Map converterMap(Telefone fone) {
        Map mapFone = new HashMap();
        mapFone.put("casa", fone.getCasa());
        mapFone.put("celular", fone.getCelular());
        return mapFone;
    }

    public Telefone converterTelefone(HashMap hashMap) {
        Telefone fone = new Telefone();
        String casa = hashMap.get("casa").toString().equalsIgnoreCase(" ") ? "-" : hashMap.get("casa").toString();
        String celular = hashMap.get("celular").toString().equalsIgnoreCase(" ") ? "-" : hashMap.get("celular").toString();
        fone.setCasa(casa);
        fone.setCelular(celular);
        return fone;
    }
    
}
