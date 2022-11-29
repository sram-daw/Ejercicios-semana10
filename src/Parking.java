import java.util.Arrays;

public class Parking {
    //El objeto parking tiene como atributo un array de vehículos vacío en un primer momento que se va llenando a medida que se van introduciendo los objetos Vehículo. El número de índices viene dado por la instancia en el Main gracias al parámetro que se la pasa al constructor.
    Vehiculo[] plazas;
    int n_plazas;

    //En este constructor parametrizado del objeto parking estamos indicando que el atributo plazas va a ser igual a un array con un número de índices determinado por n_plazas.
    public Parking(int n_plazas) {
        this.n_plazas = n_plazas;
        this.plazas = new Vehiculo[this.n_plazas];
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

    @Override
    public String toString() {
        return "Parking{" +
                "plazas=" + Arrays.toString(plazas) +
                ", n_plazas=" + n_plazas +
                '}';
    }

    //Introduce los objetos vehículo en el array
    void aparcarVehiculo(Vehiculo vehiculoNuevo) {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) { //Si la posición del array correspondiente a la iteración está vacía...
                if (vehiculoNuevo.getSize() == 1) {
                    plazas[i] = vehiculoNuevo; //... aparcar el vehículo si tiene size=1 (si es un coche). Y...
                }
                if (vehiculoNuevo.getSize() == 2 && plazas[i + 1] == null) { //... si el vehículo tiene size=2 (es un camión) Y el índice siguiente está vacío...
                    plazas[i] = vehiculoNuevo;
                    plazas[i + 1] = vehiculoNuevo; //... aparcar el camión en ambas plazas (en i y en i+1)
                    i = i + 2;
                }
            }

        }

    }


}
