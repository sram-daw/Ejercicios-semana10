import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        int capacidadParking; //la capacidad que introducirá el usuario
        Vehiculo vehiculoNuevo; //Instancia de un nuevo objeto Vehiculo que, de momento, está vacío.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Indique la capacidad del parking: ");
        capacidadParking = entrada.nextInt();
        /*Por cada ejecución del programa instanciamos un nuevo objeto parking.
        Ese constructor se encarga de crear el objeto parking con los atributos que hemos especificado: la capacidad indicada por el usuario y
        la posición actual del array, que en este momento es 0 ya que aun no hemos empezado el bucle for del menú que va a ir aumentando este valor.*/
        Parking parking = new Parking(capacidadParking, 0);

        //Bucle menú
        while (salir == false) {
            int operacion;
            boolean isAparcar = true; /*este booleano nos permite añadir una condición más en el for: solo contará iteraciones en el bucle si es true,
             para que si retiramos un vehículo no se desplace un lugar en el array.*/
            for (int i = 0; i < parking.plazas.length && isAparcar; i++) {
                System.out.println("¿Qué desea hacer? \n1. Aparcar vehículo \n2. Retirar vehículo. \n3. Mostrar vehículos aparcados y plazas disponibles.  \n4. Salir.");
                operacion = entrada.nextInt();
                switch (operacion) {

                    case 1:
                        if (parking.comprobarPlazasLibres() >= 1) {
                            String modoIntroduccion;
                            Scanner entradaModoAparca = new Scanner(System.in);
                            System.out.println("¿Cómo desea aparcar el vehículo, automáticamente o manualmente?: ");
                            modoIntroduccion = entradaModoAparca.nextLine().toLowerCase();
                            if (modoIntroduccion.equals("manualmente")) {
                                vehiculoNuevo = Vehiculo.crearVehiculosManual();
                                System.out.println(vehiculoNuevo.toString()); //Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                                parking.aparcarVehiculo(vehiculoNuevo, i);//se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados.
                           /*En los dos siguientes ifs indicamos que si el vehículo que se ha aparcado ocupa 1 hueco,
                           el nuevo valor de la posición actual del array es equivalente al valor de i (la iteración del bucle), mientras que si ocupa 2 huecos debe desplazarse 1 extra en la posición del array.*/
                                if (vehiculoNuevo.getSize() == 1) {
                                    parking.setPosicionParking(i); //Hacemos que posicionParking (posición actual del índice) vaya a la par que la i del bucle.
                                }
                                if (vehiculoNuevo.getSize() == 2) {
                                    i += 1;
                                    parking.setPosicionParking(i);
                                }
                            }
                            if (modoIntroduccion.equals("automaticamente") | modoIntroduccion.equals("automáticamente")) {
                                vehiculoNuevo = new Vehiculo(); //se genera un nuevo objeto Vehiculo usando el constructor parametrizado que lo genera automáticamente.
                                parking.aparcarVehiculo(vehiculoNuevo, i); //se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados (array plazas[] y n_plazas)
                                System.out.println(vehiculoNuevo.toString());//Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                                if (vehiculoNuevo.getSize() == 1) {
                                    parking.setPosicionParking(i);
                                }
                                if (vehiculoNuevo.getSize() == 2) {
                                    i += 1;
                                    parking.setPosicionParking(i);
                                }
                            }
                            System.out.println(parking.toString()); // Para los test: muestra el array del parking.

                        } else {
                            System.out.println("No hay plazas disponibles.");
                        }
                        break;
                    case 2:
                        isAparcar = false;
                        int matriculaVehiculoDesaparcar = 0;
                        Scanner entradaDesaparcar = new Scanner(System.in);
                        System.out.print("Indique la matrícula correspondiente al vehículo que desea retirar: ");
                        matriculaVehiculoDesaparcar = entradaDesaparcar.nextInt();
                        parking.desaparcarVehiculo(matriculaVehiculoDesaparcar);
                        break;

                    case 3:
                        System.out.println(parking.toString()); //Función para visualizar el contenido del parking.
                        break;

                    case 4:
                        salir = true;
                        break;
                }
            }
        }
    }
}