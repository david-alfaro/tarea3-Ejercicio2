package alfaroviquez.david.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class IU {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void mostrarMenu() {
        output.println("----------------------------------------");
        output.println("       BANCO LOS LAVADOREs DOT COM      ");
        output.println("----------------------------------------");
        output.println("1. Registrar Cliente");
        output.println("2. Listar Clientes");
        output.println("3. Registro de Cuentas");
        output.println("4. Listar cuentas");
        output.println("5. Deposito");
        output.println("6. Retiro");
        output.println("7. Salir");

    }
    public void subMenu2(){
        output.println("--------------------------");
        output.println("REGISTRO DE CUENTAS");
        output.println("-------------------------");
        output.println("1. Registar Cuenta Corrientes");
        output.println("2. Registrar Cuenta de Ahorro");
        output.println("3. Registrar Cuenta de Ahorro Programado");
        output.println("4. Asociar cliente a cuenta");
        output.println("5. Volver");
    }

    public void subMenu(){
        output.println("--------------------------");
        output.println("LISTA DE CUENTAS");
        output.println("-------------------------");
        output.println("1. Listar Cuentas Corrientes");
        output.println("2. Listar Cuentas de Ahorro");
        output.println("3. Listar Cuentas de Ahorro Programado");
        output.println("4. Volver");
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
