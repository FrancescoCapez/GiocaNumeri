import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Capezzali Francesco
 */
public class Giocatore implements Runnable {
    private final Cifratura cifratura;
    String nome;
    String parola;
    int punteggio;

    public Giocatore(String nome,String parola, Cifratura cifratura){
        this.nome= nome;
        this.parola= parola;
        this.cifratura=cifratura;
    }

    @Override
    public void run(){
        gioca();
    }

    public void gioca(){
        int numero = 3;
        Long tempoInizio = System.currentTimeMillis();
        //inserire parola da tastiera
        //inserire nome giocatore da tastiera

        String parolaCifrata = cifratura.cifra(parola);
        System.out.println("parola cifrata: "+ parolaCifrata);
        //scrivere su un file numero punteggio e parola cifrata (id.giocatore-gioco del dataoggi .txt)

        punteggio = 100;

        System.out.println("giocatore: "+ nome);

        for (int i=0; i<numero; i++){
            try {
                System.out.println("giocatore "+nome +" i: "+i);
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException ex) {
                System.err.println("Errore nella transiozione da RUNNING a SLEEPING "+ex.getMessage());
            }
        }

        System.out.println("Giocatore "+nome +" punteggio: "+punteggio + " Parola " + cifratura.decifra(parolaCifrata));
        Long tempoFine = System.currentTimeMillis();
        System.out.println("Giocatore: " + nome +"Tempo: "+ (tempoFine - tempoInizio) /1000);
    }

}