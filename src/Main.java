import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        int capacidadParking; //la capacidad que introducirá el usuario
        Vehiculo vehiculoNuevo; //Instancia de un nuevo objeto Vehiculo que, de momento, está vacío.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Indique la capacidad del parking: ");
        capacidadParking = entrada.nextInt();
        /*Por cada ejecución del programa instanciamos un nuevo objeto parking. Como hemos creado un constructor para él, entre los paréntesis (parámetros) de este introducimos lo que solicita dicho constructor (n_plazas).
        Ese constructor se encarga de crear el objeto parking con los atributos que hemos especificado: el array plazas y el int n_plazas. Para ello utiliza el parámetro que hemos pasado para definir el nº de índices.*/
        Parking parking = new Parking(capacidadParking, 0);

        //Bucle menú
        while (salir == false) {
            int operacion;
            boolean isAparcar = true; /*este booleano nos permite añadir una condición más en el for: solo contará iteraciones en el bucle si es true,
             para que si retiramos un vehículo no se desplace un lugar en el índice.*/
            System.out.println("¿Qué desea hacer? \n1. Aparcar vehículo \n2. Retirar vehículo. \n3. Salir.");
            operacion = entrada.nextInt();
            for (int i = 0; i < parking.plazas.length && isAparcar; i++) {
                switch (operacion) {
                    case 1:
                        String modoIntroduccion;
                        Scanner entradaModoAparca = new Scanner(System.in);
                        System.out.println("¿Cómo desea aparcar el vehículo, automáticamente o manualmente?: ");
                        modoIntroduccion = entradaModoAparca.nextLine();
                        if (modoIntroduccion.equals("manualmente")) {
                            vehiculoNuevo = Vehiculo.crearVehiculosManual();
                            System.out.println(vehiculoNuevo.toString()); //Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                            parking.aparcarVehiculo(vehiculoNuevo, i);//se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados (array plazas[] y n_plazas)
                            parking.setPosicionParking(i); //indicamos que el nuevo valor de la posición del array es equivalente al valor de i (la iteración del bucle).
                        }
                        if (modoIntroduccion.equals("automaticamente") | modoIntroduccion.equals("automáticamente")) {
                            vehiculoNuevo = new Vehiculo();
                            parking.aparcarVehiculo(vehiculoNuevo, i); //se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados (array plazas[] y n_plazas)
                            System.out.println(vehiculoNuevo.toString());//Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                            parking.setPosicionParking(i);
                        }
                        System.out.println(parking.toString()); // Para los test: muestra el array del parking.

                    case 2:
                        isAparcar = false;
                        int matriculaVehiculoDesaparcar;
                        Scanner entradaDesaparcar = new Scanner(System.in);
                        System.out.print("Indique la matrícula correspondiente al vehículo que desea retirar: ");
                        matriculaVehiculoDesaparcar = entradaDesaparcar.nextInt();
                        parking.desaparcarVehiculo(matriculaVehiculoDesaparcar);


                    case 3:
                        salir = true;
                }
            }
        }
    }
}