package duoc.llanquihueTourSem5.service;

import duoc.llanquihueTourSem5.model.Tour;
import duoc.llanquihueTourSem5.util.Archivo;
import java.util.ArrayList;

public class GestorDatos {
    private ArrayList<Tour> tours;

    public GestorDatos() {
        //Se crea una lista vacia
        tours = new ArrayList<>();
    }

    public void cargarTours() {
        tours = Archivo.leerLista();
    }

    public void mostrarTours() {
        for (Tour t : tours) {
            System.out.println(t.getNombre() + " ; " + t.getTipo() + " ; $" + t.getPrecio());
        }
    }
}