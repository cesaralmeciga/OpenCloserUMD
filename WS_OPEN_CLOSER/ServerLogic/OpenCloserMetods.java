/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UMD.ServerLogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author BOG-A404-E-011
 */
public class OpenCloserMetods {
 
      //Metodo de minado
      public String CloseBlock(String datosConcatenados){//se reciben los datosConcatenados a cifrar
        String encryptedData;//Variable que contendra los datos encriptados 
        char[] edList;//Array que contendra caracter por caracter de la cadena encryptedData
        int i = 0;//Flag de control de minado
        int nonce = 0;//Nonce inicializado en 0 
        do {//Ciclo de Minado
            encryptedData = Cifrado(datosConcatenados + nonce);//Se cifran los datos concatenados con el nonce
            edList = StringToArray(encryptedData);//El String anterior se convierte a caracteres dentro del array edList 
            
            //Se comparan las tres posiciones iniciales del array con 0 (Condicion de Minado)
            if ("0".equals(Character.toString(edList[0])) && "0".equals(Character.toString(edList[1])) && "0".equals(Character.toString(edList[2]))) {
                i = 1;//Si se cumple, se concluye el ciclo y el minado finaliza
            } else {//Si no
                nonce++;//El nonce aumenta hasta cumplir la condicion de los tres ceros al inicio
            }
        } while (i < 1);
        
        /**Retorno del String "encryptedData" cumpliendo con la condicion de minado (000 al inicio)
        ADEMAS  del nonce que permitio cerrar dicho bloque**/
        return encryptedData+" "+nonce;
    }
      
    //Metodo para cifrar con SHA-256  
    private String Cifrado(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
    
    //Metodo  para convertir el hash tipo String a array tipo char[]
    private char[] StringToArray(String datosCifrados) {
        char[] Caracteres = datosCifrados.toCharArray();
        return Caracteres;
    }
}







