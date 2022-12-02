import java.util.Scanner;

public class Vehiculo {
    private String matricula;
    private String tipo;

    private int size;

    public Vehiculo(String matricula, String tipo, int size) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.size = size;
    }

    //Generación automática de un objeto vehículo
    public Vehiculo() {
        this.matricula = generarMatricula();
        this.size = (int) (Math.random() * (2 - 1 + 1) + 1);
        if (this.size == 1) {
            this.tipo = "coche";
        }
        if (this.size == 2) {
            this.tipo = "camion";
        }

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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
    public static String generarMatricula() {
        char[] matricula = new char[7];
        matricula[0] = generarCharAleatorioNumero();
        matricula[1] = generarCharAleatorioNumero();
        matricula[2] = generarCharAleatorioNumero();
        matricula[3] = generarCharAleatorioNumero();
        matricula[4] = generarCharAleatorioLetra();
        matricula[5] = generarCharAleatorioLetra();
        matricula[6] = generarCharAleatorioLetra();
        String matriculaAString = String.valueOf(matricula); //El array de chars se transforma en String para que sea compatible con el tipo del atributo matricula.
        return matriculaAString;
    }

    public static char generarCharAleatorioLetra() {
        String numString = "BCDFGHJKLMNPQRSTVWXYZ";
        char caracteres[] = numString.toCharArray();
        int index = (int) (Math.random() * caracteres.length);
        return caracteres[index];
    }

    public static char generarCharAleatorioNumero() {
        String numString = "0123456789";
        char caracteres[] = numString.toCharArray();
        int index = (int) (Math.random() * caracteres.length);
        return caracteres[index];
    }


    //Generación manual de un objeto vehículo.
    public static Vehiculo crearVehiculosManual() {
        Scanner entrada = new Scanner(System.in);
        String matricula = "";
        String tipo = "coche";
        int size = 0;
        System.out.println("Introduzca la matrícula del vehículo: ");
        matricula = entrada.nextLine();
        Scanner entradaTipo = new Scanner(System.in);
        System.out.println("Introduzca el tipo de vehículo (coche o camión): ");
        tipo = entradaTipo.nextLine();
        if (tipo.equals("coche")) {
            size = 1;
        }
        if (tipo.equals("camion") || tipo.equals("camión")) {
            size = 2;
        }

        Vehiculo nuevoVehiculo = new Vehiculo(matricula, tipo, size);
        return nuevoVehiculo;
    }


}
