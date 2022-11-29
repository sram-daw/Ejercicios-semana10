import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        int capacidadParking;
        Vehiculo vehiculoNuevo; //Instancia de un nuevo objeto Vehiculo que, de momento, está vacío.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Indique la capacidad del parking: ");
        capacidadParking = entrada.nextInt();
        /*Por cada ejecución del programa instanciamos un nuevo objeto parking. Como hemos creado un constructor para él, entre los paréntesis (parámetros) de este introducimos lo que solicita dicho constructor (n_plazas).
        Ese constructor se encarga de crear el objeto parking con los atributos que hemos especificado: el array plazas y el int n_plazas. Para ello utiliza el parámetro que hemos pasado para definir el nº de índices.*/
        Parking parking = new Parking(capacidadParking);

        //Bucle menú
        while (salir == false) {

            int operacion;
            System.out.println("¿Qué desea hacer? \n1. Aparcar vehículo \n2. Salir.");
            operacion = entrada.nextInt();
            switch (operacion) {
                case 1:
                    Scanner entradaModoAparca = new Scanner(System.in);
                    System.out.println("¿Cómo desea aparcar el vehículo, automáticamente o manualmente?: ");
                    String modoIntroduccion = entradaModoAparca.nextLine();
                    if (modoIntroduccion.equals("manualmente")) {
                        vehiculoNuevo = Vehiculo.crearVehiculosManual();
                        System.out.println(vehiculoNuevo.toString()); //Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".
                        parking.aparcarVehiculo(vehiculoNuevo);//se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados (array plazas[] y n_plazas)

                    }
                    if (modoIntroduccion.equals("automaticamente") | modoIntroduccion.equals("automáticamente")) {
                        vehiculoNuevo = new Vehiculo();
                        parking.aparcarVehiculo(vehiculoNuevo); //se llama al objeto parking, no a la clase, porque en este punto del programa ya es un objeto con unos atributos determinados (array plazas[] y n_plazas)
                        System.out.println(vehiculoNuevo.toString());//Para los test: muestra los atributos del vehículo nuevo haciendo uso del método generado "toString".

                    }
                    System.out.println(parking.toString());// Para los test: muestra el array del parking.


                   /* - Añade una función que permita introducir valores por
                        parámetro en el array para introducir los coches.
                         Puedes hacer primero una función que introduzca
                        por orden los valores, sin importar el tamaño de
                        momento, salvo cuando esté lleno el array.

                        Necesitarás una forma de encontrar “huecos”.
                        - A continuación, no dejes introducir camiones si no
                        tienen dos huecos seguidos libres.
                        - Añade una función que permita visualizar el parking
                        - Añade una función que permita localizar un coche en el
                        parking dado un índice (posición)
                        - Añade una función que permita localizar un coche en el
                        parking dada una matrícula.
                        - Recorre el array hasta encontrar dicha matrícula.



                        PROBLEMAS:
                        -El método aparcarVehiculo aparca el vehiculo generado (automatica o manualmente) en todos los huecos del array en lugar de en uno solo.
                        -Cómo saber qué huecos hay vacíos????
                        */


                case 2:
                    salir = true;
            }


        }

    }


}