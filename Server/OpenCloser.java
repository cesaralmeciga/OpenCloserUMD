/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UMD.Server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.UMD.ServerLogic.OpenCloserMetods;

/**
 *
 * @author BOG-A404-E-011
 */
@WebService(serviceName = "OpenCloser")
public class OpenCloser {

 /**
  * Web service operation
  */
 @WebMethod(operationName = "OpenCloserServer")
 public String OpenCloserServer(@WebParam(name = "DatosConcatenados") String DatosConcatenados) {
    OpenCloserMetods OCS = new OpenCloserMetods();//Objeto  para acceder a las clases locales del servidor
    String rta = OCS.CloseBlock(DatosConcatenados);//Envio de datos a cifrar al metodo CloseBlock
    return rta;//Retorno de datos minados
 }

}
