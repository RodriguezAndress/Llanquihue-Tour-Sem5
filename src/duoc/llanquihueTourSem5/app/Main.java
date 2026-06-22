package duoc.llanquihueTourSem5.app;
import duoc.llanquihueTourSem5.model.Tour;
import duoc.llanquihueTourSem5.service.GestorDatos;
import duoc.llanquihueTourSem5.util.Archivo;


import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //Clase Menu, para mostrar los tours disponibles, hacer búsquedas por parametro y salir, esto leyendo el archivo txt
    //Se usa Scanner para leer la intereacción del usuario

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        GestorDatos gestor = new GestorDatos();
        gestor.cargarTours();
        ArrayList<Tour> toursLeidos = Archivo.leerLista();

        boolean salir = false;
        while (!salir) {
            System.out.println(".....::::MENU::::.......");
            System.out.println("1. Mostrar Tours");
            System.out.println("2. Buscar por Nombre");
            System.out.println("3. Buscar por Clasificación");
            System.out.println("4. Buscar por Precio");
            System.out.println("5. Salir");

            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    gestor.mostrarTours();
                    break;
                case "2":
                    buscarNombre(toursLeidos, sc);
                    break;
                case "3":
                    buscarClasificacion(toursLeidos, sc);
                    break;
                case "4":
                    buscarPrecio(toursLeidos, sc);
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;

            }
        }
    }
    //Se definen los metodos descritpos en el switch donde se hace la busqueda por parametros.

    private static void buscarNombre(ArrayList<Tour> toursLeidos, Scanner sc){
        System.out.println("Ingrese nombre a buscar:");
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for (Tour tour : toursLeidos) {
            if (nombre.equals(tour.getNombre())) {
                System.out.println("Encontrado: " + tour);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Tour no encontrado");
        }
    }
    private static void buscarClasificacion(ArrayList<Tour> toursLeidos, Scanner sc){
        System.out.println("Ingrese la clasificación del tour a buscar:");
        String clasificacion = sc.nextLine();
        boolean encontrado = false;

        for (Tour tour : toursLeidos) {
            if (clasificacion.equals(tour.getTipo())) {
                System.out.println("Encontrado: " + tour);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Tour no encontrado");
        }
    }
    private static void buscarPrecio(ArrayList<Tour> toursLeidos, Scanner sc){
        System.out.println("Ingrese el precio del tour a buscar:");
        try{
            boolean encontrado = false;
            double precio = Double.parseDouble(sc.nextLine());
            for (Tour tour : toursLeidos) {
                if (precio == tour.getPrecio()) {
                    System.out.println("Encontrado: " + tour);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Tour no encontrado");
            }
        }catch (NumberFormatException e){
            System.out.println("Precio no valido o Datos erroneos");
        }
    }

    public static void main(String[] args) {
        menu();
    }


}
