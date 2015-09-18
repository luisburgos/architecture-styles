/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.kwiclogger.filtro;

import java.util.ArrayList;

/**
 *
 */
public class DescomponerCadena extends Filtro{
    
    private ArrayList combinaciones;

    public DescomponerCadena(){
        mensaje = "Mensaje de la clase DescomponerCadena";
    }
    
    @Override
    public Object Procesar(Object o) throws RuntimeException{
        combinaciones = new ArrayList();
        for (String cadenaAux: ((String)(o)).split(" ")) {
            combinaciones.add(cadenaAux);
        }
        System.out.println(combinaciones);
        /*if(true){
            throw new RuntimeException();
        }*/
        return combinaciones;
        
    }

    
}
