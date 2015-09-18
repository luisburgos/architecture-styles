/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.kwiclogger.filtro;

/**
 *
 */
public class Salida extends Filtro{

    public Salida(){
        mensaje = "Mensaje de la clase Salida";
    }

    @Override
    public Object Procesar(Object o) throws RuntimeException {
        System.out.println("Respuesta: ");
        impirmirArray(o);
        return o;
    }
    
    private  void impirmirArray(Object o){
        Object[] a = (Object[])o;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
