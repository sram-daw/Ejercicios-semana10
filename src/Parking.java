import java.util.Arrays;

public class Parking {
    //Esto es un array de vehículos vacío en un primer momento que se va llenando a medida que se van introduciendo los objetos Vehículo. El número de índices viene dado por la instancia en el Main gracias al parámetro que se la pasa al constructor.
    Vehiculo[] plazas;

    //n_plazas viene dado por el número que indica el usuario para la capacidad del parking.
    int n_plazas;
    int posicionParking; //Es la posición actual del array. Depende del bucle for del main.

    //En este constructor parametrizado del objeto parking estamos indicando que el atributo plazas va a ser igual a un array con un número de índices determinado por n_plazas.
    public Parking(int n_plazas, int posicionParking) {
        this.n_plazas = n_plazas;
        this.plazas = new Vehiculo[this.n_plazas];
        this.posicionParking = posicionParking;
    }


    public int getN_plazas() {
        return n_plazas;
    }

    public void setN_plazas(int n_plazas) {
        this.n_plazas = n_plazas;
    }

    public Vehiculo[] getPlazas() {
        return plazas;
    }

    public void setPlazas(Vehiculo[] plazas) {
        this.plazas = plazas;
    }

    public int getPosicionParking() {
        return posicionParking;
    }

    public void setPosicionParking(int posicionParking) {
        this.posicionParking = posicionParking;
    }

    @Override
    public String toString() {
        return "Plazas totales: " + n_plazas + "\n" +
                "Plazas vacías: " + comprobarPlazasLibres() + "\n" +
                "Vehículos aparcados: " + "\n" +
                Arrays.toString(plazas) +
                "TEST posicionParking: " + posicionParking;
    }

    //Introduce los objetos vehículo en el array
    public void aparcarVehiculo(Vehiculo vehiculoNuevo, int posicionParking) { /*pasamos por parámetros el nuevo objeto vehículo creado y la posición
         del array del bucle del main para así saber en qué posición debe la función colocar el objeto.*/

        //Esta primera parte comprueba si la plaza actual en el array está libre.
        if (this.plazas[posicionParking] == null) { //Si la posición del array correspondiente a la iteración está vacía...
            if (vehiculoNuevo.getSize() == 1) {
                this.plazas[posicionParking] = vehiculoNuevo; //... aparcar el vehículo si tiene size=1 (si es un coche). Y...
                System.out.println("Vehículo aparcado correctamente.");
            }
            if (vehiculoNuevo.getSize() == 2 ) { //... si el vehículo tiene size=2 (es un camión)...
                this.plazas[posicionParking] = vehiculoNuevo;
                this.plazas[posicionParking + 1] = vehiculoNuevo;//... aparcar el camión en ambas plazas (en i y en i+1).
                System.out.println("Vehículo aparcado correctamente.");

            }
            //A partir de aquí, si la siguiente plaza no está libre comprueba todas las demás.
        } else {
            if (vehiculoNuevo.getSize() == 1) { //Este if es para los coches
                boolean pararCuandoNull= false; //Este booleano es necesario para evitar que, tras retirar un vehículo y deje de seguirse el orden del índice, se aparque en todas las posiciones null.
                for (int i = 0; i < plazas.length && !pararCuandoNull; i++) {
                    if (this.plazas[i] == null) {
                        pararCuandoNull=true;
                        this.plazas[i] = vehiculoNuevo;
                        System.out.println("Vehículo aparcado correctamente.");
                    }
                }
            }
            if (vehiculoNuevo.getSize() == 2) { //Este if es para los camiones.
                boolean pararCuandoNull= false;
                for (int i = 0; i < plazas.length && !pararCuandoNull; i++) {
                    pararCuandoNull=true;
                    this.plazas[i] = vehiculoNuevo;
                    this.plazas[i + 1] = vehiculoNuevo;
                    System.out.println("Vehículo aparcado correctamente.");
                }
            }
        }

    }


    public void desaparcarVehiculo(String matriculaVehiculo) {
        for (int i = 0; i < this.plazas.length && this.plazas[i] != null; i++) { //Es necesario indicar como condición extra que la plaza no sea null porque si no lanza un error.
            if (this.plazas[i].getMatricula().equals(matriculaVehiculo)) {
                this.plazas[i] = null;
            }
        }
    }

    //Cuenta las plazas que hay libres
    public int comprobarPlazasLibres() {
        int cuantasPlazasLibres = 0;
        for (int i = 0; i < this.plazas.length; i++) {
            if (this.plazas[i] == null) {
                cuantasPlazasLibres++;
            }
        }
        return cuantasPlazasLibres;
    }

    //Comprueba si existen dos plazas libres consecutivas en cualquier punto del array (independientemente de la posición actual del array aka posicionParking)
    public boolean comprobarDosPlazasConsecutivasLibres() {
        boolean dosLibresConsecutivas = false;
        for (int i = 0; i < this.plazas.length; i++) {
            if (this.plazas[i] == null && i + 1 < plazas.length && this.plazas[i + 1] == null) { //es necesario añadir la condición del centro para que no siga comprobando en caso de que i+1 no entre dentro de los límites de array; de lo contrario salta un error.
                dosLibresConsecutivas = true;
            }
        }
        return dosLibresConsecutivas;
    }

    public void obtenerVehiculoPorMatricula(String matricula) {
        for (int i = 0; i < this.plazas.length; i++) {
            if (this.plazas[i] != null && this.plazas[i].getMatricula().equals(matricula)) {
                System.out.println("El vehículo con la matrícula introducida se encuentra en la plaza número " + i);
            }
        }
    }

    public void obtenerVehiculoPorPlaza(int plaza) {
        for (int i = 0; i < this.plazas.length; i++) {
            if (i == plaza) {
                System.out.println("El vehículo aparcado en la plaza " + plaza + " es: \n" + this.plazas[plaza].toString());
            }
        }
    }
}
