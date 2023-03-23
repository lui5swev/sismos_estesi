import java.util.Random;
import java.util.Scanner;

public class sismos {
    public static void main(String[] args) {
        double[][] matriz = new double[10][7];
        menu(matriz);
    }

    private static void menu(double[][] matriz){
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Que accion desea realizar? Ingrese el numero correspondiente");
        System.out.println("[1] Ingresar Datos");
        System.out.println("[2] Mostrar sismo de mayor magnitud");
        System.out.println("[3] Contar sismos mayores o iguales a 5.0");
        System.out.println("[4] Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("[5] Salir");
        String respuesta = teclado.next();

        switch (respuesta){
            case "1": ingresarDatos(matriz);
            break;
            case "2": mayorSismo(matriz);
            break;
            case "3": contarSismos5(matriz);
            break;
            case "4": enviarSMS(matriz);
            break;
            case "5": System.exit(0);
            break;
            default:
                System.out.println("Ingrese una opcion valida");
                menu(matriz);
            break;
        }
        menu(matriz);
    }

    private static void enviarSMS(double[][] matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if(matriz[i][j]>=7.0) {
                    System.out.println("EMERGENCIA!!! Sismo de "+matriz[i][j]);
                }
            }
        }
    }

    private static void contarSismos5(double[][] matriz) {
        int numSismos = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if(matriz[i][j]>=5.0) {
                    numSismos += 1;
                }
            }
        }
        System.out.println("El numero de Sismos iguales o mayores a 5.0 es de: "+numSismos);
    }

    private static void mayorSismo(double[][] matriz) {
        double numMayor = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (matriz[i][j]>numMayor){
                    numMayor = matriz[i][j];
                }
            }
        }

        System.out.println("El sismo de mayor Magnitud es de: "+numMayor);
    }


    private static void ingresarDatos(double[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                matriz[i][j] = random.nextDouble() * 10;
            }
        }


        //String[] semana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        System.out.println("          Lunes              Martes            Miercoles           Jueves            Viernes            Sabado           Domingo");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println(" ");
        }

    }
}
