package post;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        User p = new User(true, "matejp91@gmail.com", "Matej", "Petrovic", "ZSD123");
        try {
            URL url = new URL("http://89.216.56.107:8080/restfull/rest/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Method", "POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            PrintWriter pw = new PrintWriter(connection.getOutputStream());
            pw.print(new Gson().toJson(p));
            pw.close();
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            connection.disconnect();

        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
