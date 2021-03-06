package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.AhorroProgramado;
import alfaroviquez.david.bl.entidades.Cuenta;

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

public class AhorroProgramadoDAO extends CuentaDAO {
    @Override
    public void save(Cuenta nuevaCuente) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add(nuevaCuente.toCSVLine());
        try{
            Files.write(Paths.get("c:\\dev\\listaCuentasAhorroProgramado.csv"),lineas, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cuenta> findAll() {
        ArrayList<Cuenta> resul = new ArrayList<>();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("c:\\dev\\listaCuentasAhorroProgramado.csv"));
            String currentLine = reader.readLine();
            while(currentLine!=null){
                resul.add(new AhorroProgramado(currentLine));
                currentLine = reader.readLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
