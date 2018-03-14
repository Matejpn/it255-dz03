package get;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/posts");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Greška : HTTP error: " + connection.getResponseCode());
            }

            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String output;
            String json = "";
            while ((output = bufferReader.readLine()) != null) {
                json += output;
            }
            connection.disconnect();

            Gson gson = new Gson();
            ArrayList<Posts> lista = gson.fromJson(json, new TypeToken<ArrayList<Posts>>() {
            }.getType());

            for (Posts posts : lista) {
                System.out.println(posts.toString());
                
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
