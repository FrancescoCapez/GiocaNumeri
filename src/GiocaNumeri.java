import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francesco Capezzali
 */
public class GiocaNumeri {


    public static void main(String[] args){
        try {
            Cifratura cifratura = new Cifratura();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci il nome del primo giocatore");
            String nome1 = scanner.nextLine();
            System.out.println("Inserisci la parola del primo giocatore");
            String parola1 = scanner.nextLine();
            System.out.println("Inserisci il nome del secondo giocatore");
            String nome2 = scanner.nextLine();
            System.out.println("Inserisci la parola del secondo giocatore");
            String parola2 = scanner.nextLine();
            System.out.println("INIZIO");
            Giocatore g1 = new Giocatore(nome1, parola1, cifratura);
            Thread tg1 = new Thread(g1);
            tg1.start();
            Thread.currentThread().sleep(5000);
            Giocatore g2 = new Giocatore(nome2, parola2, cifratura);
            Thread tg2 = new Thread(g2);
            tg2.start();

            try{
                tg1.join();
            } catch (InterruptedException e) {
                System.err.println("Errore di transizione da RUNNING a WAITING ");
            }
            System.out.println("FINE");
        } catch (InterruptedException ex) {
            System.err.println("Errore di transizione da RUNNING a WAITING  "+ex.getMessage());
        }
    }

}
