import java.util.Scanner;

public class Vehiculo {
    private int matricula;
    private String tipo;

    private int size;

    public Vehiculo(int matricula, String tipo, int size) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.size = size;
    }

    //Generación automática de un objeto vehículo
    public Vehiculo() {
        this.matricula = generarMatricula();
        this.size = (int) (Math.random() * (2 - 1 + 1) + 1);
       if(this.size==1){
           this.tipo = "coche";
       }
        if(this.size==2){
            this.tipo = "camion";
        }

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula=" + matricula +
                ", tipo='" + tipo + '\'' +
                ", size=" + size +
                '}';
    }
//Generación aleatoria matrícula
    public static int generarMatricula() {
        int matricula;
        matricula = (int) (Math.random() * (9999));
        return matricula;
    }

    //Generación manual de un objeto vehículo.
    public static Vehiculo crearVehiculosManual() {
        Scanner entrada = new Scanner(System.in);
        int matricula=0;
        String tipo="coche";
        int size=0;
        System.out.println("Introduzca la matrícula del vehículo: ");
        matricula = entrada.nextInt();
        Scanner entradaTipo = new Scanner(System.in);
        System.out.println("Introduzca el tipo de vehículo (coche o camión): ");
        tipo = entradaTipo.nextLine();
        if (tipo.equals("coche")){
            size=1;
        }
        if (tipo.equals("camion")||tipo.equals("camión")){
            size=2;
        }

        Vehiculo nuevoVehiculo = new Vehiculo(matricula, tipo, size);
        return nuevoVehiculo;
    }


}
