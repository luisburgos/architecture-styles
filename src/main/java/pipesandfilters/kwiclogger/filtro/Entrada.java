/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.kwiclogger.filtro;
import java.util.Scanner;

/**
 *
 */
public class Entrada {
    public static void main(String[] args) {

        Tuberia tuberia1 = new Tuberia();
        Tuberia tuberia2 = new Tuberia();
        Tuberia tuberia3 = new Tuberia();
        Tuberia tuberia4 = new Tuberia();
        
        Filtro descomponer = new DescomponerCadena();
        Filtro combinar = new CombinarCadena();
        Filtro ordenar = new OrdenaCadena();
        Filtro salida = new Salida();
        
        Scanner s = new Scanner(System.in);
        
        
        tuberia1.setFiltro(descomponer);
        descomponer.setTuberia(tuberia2);
        tuberia2.setFiltro(combinar);
        combinar.setTuberia(tuberia3);
        tuberia3.setFiltro(ordenar);
        ordenar.setTuberia(tuberia4);
        tuberia4.setFiltro(salida);
        
        System.out.println("Pon tu cadena: ");
        tuberia1.enviar(s.nextLine());
    }
}
