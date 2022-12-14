import java.util.Arrays;

public class Parking {
    //Esto es un array de vehículos vacío en un primer momento que se va llenando a medida que se van introduciendo los objetos Vehículo. El número de índices viene dado por la instancia en el Main gracias al parámetro que se la pasa al constructor.
    Vehiculo[] plazas;

    //n_plazas viene dado por el número que indica el usuario para la capacidad del parking.
    int n_plazas;


    //En este constructor parametrizado del objeto parking estamos indicando que el atributo plazas va a ser igual a un array con un número de índices determinado por n_plazas.
    public Parking(int n_plazas) {
        this.n_plazas = n_plazas;
        this.plazas = new Vehiculo[this.n_plazas];
    }
    @Override
    public String toString() {
        return "Plazas totales: " + n_plazas + "\n" +
                "Plazas vacías: " + comprobarPlazasLibres() + "\n" +
                "Vehículos aparcados: " + "\n" +
                Arrays.toString(plazas);
    }

    //Introduce los objetos vehículo en el array
    public void aparcarVehiculo(Vehiculo vehiculoNuevo) { //pasamos por parámetros el nuevo objeto vehículo creado
        if (vehiculoNuevo.getSize() == 1) { //Este if es para los coches
            boolean pararCuandoNull = false; //Este booleano es necesario para evitar que, tras retirar un vehículo y deje de seguirse el orden del índice, se aparque en todas las posiciones null.
            for (int i = 0; i < plazas.length && !pararCuandoNull; i++) {
                if (this.plazas[i] == null) {
                    pararCuandoNull = true;
                    this.plazas[i] = vehiculoNuevo;
                    System.out.println("Vehículo aparcado correctamente.");
                }
            }
        }
        if (vehiculoNuevo.getSize() == 2) { //Este if es para los camiones.
            boolean pararCuandoNull = false;
            for (int i = 0; i < plazas.length && !pararCuandoNull; i++) {
                if (this.plazas[i] == null) {
                    pararCuandoNull = true;
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

    //Nos da el número de plaza del vehículo según su matrícula.
    public void obtenerVehiculoPorMatricula(String matricula) {
        for (int i = 0; i < this.plazas.length; i++) {
            if (this.plazas[i] != null && this.plazas[i].getMatricula().equals(matricula)) {
                System.out.println("El vehículo con la matrícula introducida se encuentra en la plaza número " + i);
            }
            try {
                if (i == this.plazas.length - 1 && !this.plazas[i].getMatricula().equals(matricula)) { /*Esta línea de código es testada gracias al try (funciona como ifs de forma continua).
                     Cuando el bucle llega a la última posición del array sin haber encontrado la matrícula introducida, quiere decir que no hay ningún vehículo con dicha matrícula.*/
                }
            } catch (NullPointerException e) { //Evita que salga el error null pointer exception (se usa junto con try). En su lugar lanza el siguiente mensaje:
                System.out.println("La matrícula introducida no coincide con ningún vehículo aparcado.");
            }
        }
    }


    //Nos devuelve los datos del vehículo dada la plaza.
    public void obtenerVehiculoPorPlaza(int plaza) {
        for (int i = 0; i < this.plazas.length; i++) {
            if (i == plaza) {
                try {
                    System.out.println("El vehículo aparcado en la plaza " + plaza + " es: \n" + this.plazas[plaza].toString());
                } catch (NullPointerException e) {
                    System.out.println("No hay ningún vehículo aparcado en esta plaza.");
                }
            }
        }
    }
}
