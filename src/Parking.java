import java.util.Arrays;

public class Parking {
    //El objeto parking tiene como atributo un array de vehículos vacío en un primer momento que se va llenando a medida que se van introduciendo los objetos Vehículo. El número de índices viene dado por la instancia en el Main gracias al parámetro que se la pasa al constructor.
    Vehiculo[] plazas;
    int n_plazas;

    int posicionParking;

    //En este constructor parametrizado del objeto parking estamos indicando que el atributo plazas va a ser igual a un array con un número de índices determinado por n_plazas.
    /*public Parking(int n_plazas) {
        this.n_plazas = n_plazas;
        this.plazas = new Vehiculo[this.n_plazas];
    }*/
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
        return "Parking{" +
                "plazas=" + Arrays.toString(plazas) +
                ", n_plazas=" + n_plazas +
                ", posicionParking=" + posicionParking +
                '}';
    }

    //Introduce los objetos vehículo en el array
    public void aparcarVehiculo(Vehiculo vehiculoNuevo, int posicionParking) { /*pasamos por parámetros el nuevo objeto vehículo creado y la posición
         del array del main para así saber en qué posición debe la función colocar el objeto.*/
        if (plazas[posicionParking] == null) { //Si la posición del array correspondiente a la iteración está vacía...
            if (vehiculoNuevo.getSize() == 1) {
                plazas[posicionParking] = vehiculoNuevo; //... aparcar el vehículo si tiene size=1 (si es un coche). Y...
            }
            if (vehiculoNuevo.getSize() == 2 && plazas[posicionParking + 1] == null) { //... si el vehículo tiene size=2 (es un camión) Y el índice siguiente está vacío...
                plazas[posicionParking] = vehiculoNuevo;
                plazas[posicionParking + 1] = vehiculoNuevo; //... aparcar el camión en ambas plazas (en i y en i+1). Luego...
                posicionParking = posicionParking + 1; // ... para la siguiente iteración, i será igual a i(posición actual)+1 (pues el camión ocupa la posición actual y la siguiente).
                // Al empezar la siguiente iteración se sumará 1 más (i++) por la propia condición del for, que es el siguiente hueco vacío. Es decir, si estuviésemos en la posición 2, tras hacer este proceso se adelantaría a la posición 3 (el camión estaría en 2 y 3).
                //Al empezar de nuevo el bucle, empieza en i++ (posición 4, que es la siguiente posición vacía).
            }
        } else {
            System.out.println("No hay plazas vacías.");
        }
    }

    public void desaparcarVehiculo(int matriculaVehiculo) {
       for (int i=0; i<this.plazas.length;i++){
           if (this.plazas[i].getMatricula()==matriculaVehiculo){
            this.plazas[i]=null;
           }
       }


    }

}
