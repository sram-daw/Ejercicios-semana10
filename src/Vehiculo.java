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
        this.size = (int) (Math.random() * (2 - 1 + 1) + 1); //Genera un número aleatorio entre 1 y 2.
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

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Vehículo: " +
                "matricula=" + matricula +
                ", tipo='" + tipo + '\'' +
                ", size=" + size;
    }

    //Generación aleatoria matrícula
    public static String generarMatricula() {
        char[] matricula = new char[7];
        matricula[0] = generarNumeroAleatorio();
        matricula[1] = generarNumeroAleatorio();
        matricula[2] = generarNumeroAleatorio();
        matricula[3] = generarNumeroAleatorio();
        matricula[4] = generarLetraAleatoria();
        matricula[5] = generarLetraAleatoria();
        matricula[6] = generarLetraAleatoria();
        String matriculaAString = String.valueOf(matricula); //El array de chars se transforma en String para que sea compatible con el tipo del atributo matricula.
        return matriculaAString;
    }

    public static char generarLetraAleatoria() {
        String numString = "BCDFGHJKLMNPQRSTVWXYZ";
        char caracteres[] = numString.toCharArray(); //Se crea un array de caracteres con las letras indicadas en la anterior línea.
        int index = (int) (Math.random() * caracteres.length); //Esta función random escoge un número aleatorio del 0 al índice máximo del array.
        return caracteres[index]; //Devuelve el valor que hay en el índice que corresponde al número anterior.
    }

    public static char generarNumeroAleatorio() {
        String numString = "0123456789";
        char caracteres[] = numString.toCharArray(); //Lo mismo que en la funcion generarCharAleatorioLetra
        int index = (int) (Math.random() * caracteres.length);
        return caracteres[index];
    }

    //Generación manual de un objeto vehículo.
    public static Vehiculo crearVehiculosManual() {
        Scanner entradaMatricula = new Scanner(System.in);
        String tipo = "coche";
        boolean matriculaCorrecta = false;
        boolean tipoCorrecto = false;
        int size = 0;
        String matricula = "";
        System.out.println("Introduzca la matrícula del vehículo: ");
        while (!matriculaCorrecta) {
            matricula = entradaMatricula.nextLine().toUpperCase();
            if (!matricula.matches("^\\d{4}[B-Z^EIOU]{3}")) { //Se declara el patrón que debe tener la matrícula (empezar por 4 dígitos del 0-9 seguidos 3 letras excepto vocales.)
                System.out.println("Introduzca una matrícula válida (1234XXX): ");
            }
            if (matricula.matches("^\\d{4}[B-Z^EIOU]{3}")) {
                matriculaCorrecta = true;
            }
        }
        Scanner entradaTipo = new Scanner(System.in);
        System.out.println("Introduzca el tipo de vehículo (coche o camión): ");
        while (!tipoCorrecto) {
            tipo = entradaTipo.nextLine().toLowerCase();
            if (tipo.equals("coche")) {
                size = 1;
                tipoCorrecto = true;
            }
            if (tipo.equals("camion") || tipo.equals("camión")) {
                size = 2;
                tipoCorrecto = true;
            } else {
                System.out.println("Introduzca un tipo de vehículo válido (coche o camión): ");
            }
        }

        Vehiculo nuevoVehiculo = new Vehiculo(matricula, tipo, size);
        return nuevoVehiculo;
    }


}
