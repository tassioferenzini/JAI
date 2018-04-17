/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converte;

import Modelo.Endereco;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tassio
 */
public class EnderecoConverte {

    public Map converterMap(Endereco end) {
        Map mapEnd = new HashMap();
        mapEnd.put("tipoLogradouro", end.getTipoLogradouro());
        mapEnd.put("logradouro", end.getLogradouro());
        mapEnd.put("bairro", end.getBairro());
        mapEnd.put("cep", end.getCep());
        mapEnd.put("cidade", end.getCidade());
        mapEnd.put("numero", end.getNumero());
        return mapEnd;
    }

    public Endereco converterEndereco(HashMap hashMap) {
        Endereco end = new Endereco();
        end.setLogradouro((hashMap.get("logradouro").toString()));
        end.setTipoLogradouro((hashMap.get("tipoLogradouro").toString()));
        end.setBairro((hashMap.get("bairro").toString()));
        end.setCep((hashMap.get("cep").toString()));
        end.setCidade((hashMap.get("cidade").toString()));
        end.setNumero(Integer.parseInt(hashMap.get("numero").toString()));
        return end;
    }

}
