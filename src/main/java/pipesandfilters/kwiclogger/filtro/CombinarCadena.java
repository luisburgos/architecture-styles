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
public class CombinarCadena extends Filtro {

    private ArrayList combinados;

    public CombinarCadena(){
        mensaje = "Mensaje de la clase CombinarCadena";
    }

    @Override
    public Object Procesar(Object o) throws RuntimeException {
        combinados = new ArrayList();
        ArrayList combinaciones = (ArrayList)o;
        combinados.add(arregloToString(combinaciones));

        for (int i = 1; i < combinaciones.size(); i++) {
            combinaciones = rotarArreglo(combinaciones);
            combinados.add(arregloToString(combinaciones));
        }

        System.out.println(combinados);
        return combinados;
    }

    private ArrayList rotarArreglo(ArrayList a){
        for (int i = 0; i < 1 ; i++) {
           // for (int j = a.size(); j > 0; j--) {
            for (int j = a.size() - 1; j > 0; j--) {
                String temp = (String)a.get(j);
                a.set(j, a.get(j - 1));
                a.set(j - 1, temp);
            }
        }

        return a;
    }

    private String arregloToString(ArrayList a){
        String aux = "";
        for (int i = 0; i < a.size(); i++) {
            aux = aux + " " + a.get(i).toString();
        }
        return aux;
    }

}
