import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studenti
 */
public class GiocaNumeri {


    public static void main(String[] args){
        try {
            Cifratura cifratura = new Cifratura();
            System.out.println("INIZIO");
            Giocatore g1 = new Giocatore("Francesca", cifratura);
            Thread tg1 = new Thread(g1);
            tg1.start();

            Thread.currentThread().sleep(5000);

            Giocatore g2 = new Giocatore("Milena", cifratura);
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
