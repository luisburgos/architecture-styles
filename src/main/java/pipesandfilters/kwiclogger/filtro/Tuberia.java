/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.kwiclogger.filtro;

/**
 *
 */
public class Tuberia {
    private Filtro filtro;
    
    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
    
    public void enviar(Object o){
            filtro.Ejecutar(o);
    }

    public void pass(Exception e, Object o, Class c) {
        if(filtro != null){
            filtro.enviarATuberiaConExcepcion(e, o, c);
        }
    }
}
