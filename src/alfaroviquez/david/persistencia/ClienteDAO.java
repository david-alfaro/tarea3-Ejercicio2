package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Cliente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void save(Cliente nuevoCliente){
        ArrayList<String> lines = new ArrayList<>();
        lines.add(nuevoCliente.toCSVLine());
        try {
            Files.write(Paths.get("c:\\dev\\listadeClientes.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Cliente> getAll(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("c:\\dev\\listadeClientes.csv"));
            String currentLine = reader.readLine();
            while(currentLine!=null){
                listaClientes.add(new Cliente(currentLine));
                currentLine=reader.readLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return listaClientes;
    }
}


