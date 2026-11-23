import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class GestioneFile {
    public GestioneFile(String nomeGiocatore) {
        File file = new File(nomeGiocatore + " -gioco-del" + LocalDate.now() + ".txt");
        InputStream is = null;
        BufferedReader br = null;
        try {
            is = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(is));
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
