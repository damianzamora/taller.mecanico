package persistencia;

import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import modelo.SistemaTaller;
import com.google.gson.GsonBuilder;

public class GestorJson {

    public SistemaTaller cargarSistema(String nombreArchivo) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        

        try {

            FileReader reader = new FileReader(nombreArchivo);

            SistemaTaller sistema = gson.fromJson(reader,
                    SistemaTaller.class);

            reader.close();

            return sistema;

        } catch (Exception e) {

            return null;

        }

    }

    public void guardarSistema(SistemaTaller sistema,
            String nombreArchivo) {

       Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {

            String json = gson.toJson(sistema);

            FileWriter fileWriter = new FileWriter(nombreArchivo);

            fileWriter.write(json);

            fileWriter.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
