import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false; //sirve para parar la ejecucion del programa
        int capacidadParking; //la capacidad que introducirá el usuario
        Vehiculo vehiculoNuevo; //Instancia de un nuevo objeto Vehiculo que, de momento, está vacío.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Indique la capacidad del parking: ");
        capacidadParking = entrada.nextInt();
        /*Por cada ejecución del programa instanciamos un nuevo objeto parking.
        Ese constructor se encarga de crear el objeto parking con los atributos que hemos especificado: la capacidad indicada por el usuario y
        la posición actual del array, que en este momento es 0 ya que aun no hemos empezado el bucle for del menú que va a ir aumentando este valor.*/
        Parking parking = new Parking(capacidadParking, 0);
        while (!salir) { //Son necesarios ambos bucles (while y for) porque si se añade la condición !salir solo en el for, se para la ejecución cuando se retira un vehículo al no cumplirse la condición de isAparcar.
            //Bucle menú
            int operacion = 0;
            boolean isAparcar = true; /*este booleano nos permite añadir una condición más en el for: solo contará iteraciones en el bucle si es true,
             para que si retiramos un vehículo (o no se puede aparcar por falta de espacio) no se desplace un lugar en el array.*/
            for (int i = 0; i < parking.plazas.length && isAparcar && !salir; i++) {
                System.out.println("¿Qué desea hacer? \n1. Aparcar vehículo \n2. Retirar vehículo. \n3. Mostrar vehículos aparcados y plazas disponibles. \n4. Localizar un vehículo.  \n5. Salir.");
                operacion = entrada.nextInt();
                switch (operacion) {

                    case 1:
                        if (parking.comprobarPlazasLibres() >= 1) {
                            int modoIntroduccion;
                            Scanner entradaModoAparca = new Scanner(System.in);
                            System.out.println("¿Cómo desea aparcar el vehículo? \n1. Automáticamente  \n2. Manualmente ");
                            modoIntroduccion = entradaModoAparca.nextInt();
                            //Aparcamiento manual
                            if (modoIntroduccion == 2) {
                                vehiculoNuevo = Vehiculo.crearVehiculosManual();
                                System.out.println(vehiculoNuevo.toString()); //Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                                if (vehiculoNuevo.getSize() == 1) { //Si es un coche, llamamos al método aparcar.
                                    parking.aparcarVehiculo(vehiculoNuevo, i);//se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados.
                                    parking.setPosicionParking(i); //Hacemos que posicionParking (posición actual del índice) vaya a la par que la i del bucle.
                                }
                                if (vehiculoNuevo.getSize() == 2 && parking.comprobarDosPlazasConsecutivasLibres()) { //Si es un camión y hay 2 plazas libres consecutivas, llamamos al método aparcar y...
                                    parking.aparcarVehiculo(vehiculoNuevo, i);
                                    i += 1; //... debemos añadir 1 posición extra a la posición del array, porque ocupa 2 huecos.
                                    parking.setPosicionParking(i);
                                }
                                if (vehiculoNuevo.getSize() == 2 && parking.comprobarDosPlazasConsecutivasLibres() == false) {
                                    isAparcar = false;
                                    System.out.println("No hay dos plazas libres consecutivas para aparcar el camión.");
                                }
                            }
                            //Aparcamiento automatico
                            if (modoIntroduccion == 1) {
                                vehiculoNuevo = new Vehiculo(); //se genera un nuevo objeto Vehiculo usando el constructor parametrizado que lo genera automáticamente.
                                System.out.println(vehiculoNuevo.toString());//Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                                if (vehiculoNuevo.getSize() == 1) {
                                    parking.aparcarVehiculo(vehiculoNuevo, i); //se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados (array plazas[] y n_plazas)
                                    parking.setPosicionParking(i);
                                }
                                if (vehiculoNuevo.getSize() == 2 && parking.comprobarDosPlazasConsecutivasLibres()) {
                                    parking.aparcarVehiculo(vehiculoNuevo, i);
                                    i += 1;
                                    parking.setPosicionParking(i);
                                }
                                if (vehiculoNuevo.getSize() == 2 && parking.comprobarDosPlazasConsecutivasLibres() == false) {
                                    isAparcar = false;
                                    System.out.println("No hay dos plazas libres consecutivas para aparcar el camión.");
                                }
                            }
                            System.out.println(parking.toString()); // Para los test: muestra el array del parking.

                        } else {
                            isAparcar = false;
                            System.out.println("No hay plazas disponibles.");
                        }
                        break;
                    case 2:
                        isAparcar = false;
                        String matriculaVehiculoDesaparcar = "";
                        Scanner entradaDesaparcar = new Scanner(System.in);
                        System.out.print("Indique la matrícula correspondiente al vehículo que desea retirar: ");
                        matriculaVehiculoDesaparcar = entradaDesaparcar.nextLine();
                        parking.desaparcarVehiculo(matriculaVehiculoDesaparcar);
                        System.out.println("Vehículo retirado correctamente.");
                        break;

                    case 3:
                        System.out.println(parking.toString()); //Función para visualizar el contenido del parking.
                        break;

                    case 4:
                        isAparcar = false;
                        int metodoLocalizarVehiculo = 0;
                        Scanner entradaLocalizar = new Scanner(System.in);
                        System.out.println("Desea localizar el vehículo: \n1. Por plaza \n2. Por matrícula");
                        metodoLocalizarVehiculo = entradaLocalizar.nextInt();
                        if (metodoLocalizarVehiculo == 1) {
                            int plazaIntroducida = 0;
                            System.out.print("Introduzca el número de plaza (posición): ");
                            plazaIntroducida = entradaLocalizar.nextInt();
                            parking.obtenerVehiculoPorPlaza(plazaIntroducida);
                        }
                        if (metodoLocalizarVehiculo == 2) {
                            String matriculaIntroducida = "";
                            Scanner entradaMatriculaLocalizar = new Scanner(System.in);
                            System.out.print("Introduzca la matrícula del vehículo a localizar: ");
                            matriculaIntroducida = entradaMatriculaLocalizar.nextLine();
                            parking.obtenerVehiculoPorMatricula(matriculaIntroducida);
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                }
            }
        }
    }
}