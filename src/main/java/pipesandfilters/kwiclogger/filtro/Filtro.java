/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.kwiclogger.filtro;

import pipesandfilters.kwiclogger.filtro.logger.Logger;

/**
 *
 */
public abstract class Filtro {

    private Tuberia tuberia;
    protected String mensaje;

    public abstract Object Procesar(Object o) throws RuntimeException;
    
    public void Ejecutar(Object o){
    	try{
    		Object r = Procesar(o);
            Logger.getLogger().log(this.getClass(), mensaje);
    		enviarATuberia(r);
    	}catch(RuntimeException ex){
    		enviarATuberiaConExcepcion(ex,o,this.getClass());
    	}
    }

    private void enviarATuberia(Object o) {
    	if(tuberia != null)
        	tuberia.enviar(o);
    }

    protected void enviarATuberiaConExcepcion(Exception e, Object o, Class c){
        if(tuberia == null){
            System.out.println(
                    "Ocurrió una excepción:\n" + "Tipo: "+ e.getClass().getSimpleName() + "\nEn clase: " + c.getSimpleName() + " " +e);
        }else{
            tuberia.pass(e, o, c);
        }
    }

    public void setTuberia(Tuberia tuberia) {
        this.tuberia = tuberia;
    }
    
}
