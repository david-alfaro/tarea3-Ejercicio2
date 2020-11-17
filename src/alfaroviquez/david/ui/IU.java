package alfaroviquez.david.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class IU {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void mostrarMenu() {
        output.println("*****BANCO LOS LAVADORES*****");
        output.println("1. Registrar Cliente");
        output.println("2. Listar Clientes");
        output.println("3. Registrar Cuenta Corriente");
        output.println("4. Listar Cuenta Corriente");
        output.println("5. Salir");

    }

    public int leerNumero() {
        return input.nextInt();
    }

    public String leerMensaje() {
        return input.next();
    }

    public void imprimirMensaje(String str){
        output.println(str);
    }
}
