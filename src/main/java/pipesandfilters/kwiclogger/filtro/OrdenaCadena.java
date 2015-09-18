/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.kwiclogger.filtro;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class OrdenaCadena extends Filtro {

    public OrdenaCadena(){
        mensaje = "Mensaje de la clase OrdenarCadena";
    }

    @Override
    public Object Procesar(Object o) throws RuntimeException{
        Object[] aux = ((ArrayList)o).toArray();
        Arrays.sort(aux);
        /*if(true){
            throw new RuntimeException();
        }*/
        return aux;
    }
    
}
