/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import Entidades.Viaje;
import java.util.Comparator;
import java.util.Vector;

/**
 *
 * @author candelas
 */
public class ListarCotizacionesDistancia implements Comparator <Cotizacion>{

    public int compare(Cotizacion c1, Cotizacion c2) {
        Vector<Viaje> viajes1 = c1.getViajes();
        Vector<Viaje> viajes2 = c2.getViajes();
        int dist1=0;
        int dist2=0;
        for (int i=0; i<viajes1.size(); i++)
            dist1+=viajes1.elementAt(i).getDistancia();         
        for (int j=0; j<viajes2.size(); j++)
            dist2+=viajes2.elementAt(j).getDistancia();
        return dist1-dist2;

    }

}
