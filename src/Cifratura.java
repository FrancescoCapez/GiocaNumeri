/**
 * La classe {@code Cifratura} permette di cifrare e decifrare stringhe
 * utilizzando il classico cifrario di Cesare con uno scostamento fisso di 3 posizioni.
 * Supporta sia lettere minuscole che maiuscole, lasciando inalterati gli altri caratteri.
 *
 * @author Capezzali Francesco
 * @see gemini.google.com/5451da8294c1cba0?hl=it#b465f733a5057325
 */
public class Cifratura {

    private static final int SPOSTAMENTO = 3;

    /**
     * Cifra una stringa data spostando ciascuna lettera alfabetica
     * di 3 posizioni in avanti nell'alfabeto.
     *
     * @param parola La stringa in chiaro da cifrare.
     * @return La stringa cifrata.
     */
    public String cifra(String parola) {
        if (parola == null) {
            return null;
        }

        StringBuilder risultato = new StringBuilder();

        for (int i = 0; i < parola.length(); i++) {
            char c = parola.charAt(i);

            // Gestione delle lettere maiuscole (A-Z)
            if (c >= 'A' && c <= 'Z') {
                char cifrato = (char) ('A' + (c - 'A' + SPOSTAMENTO) % 26);
                risultato.append(cifrato);
            }
            // Gestione delle lettere minuscole (a-z)
            else if (c >= 'a' && c <= 'z') {
                char cifrato = (char) ('a' + (c - 'a' + SPOSTAMENTO) % 26);
                risultato.append(cifrato);
            }
            // I caratteri che non sono lettere rimangono invariati
            else {
                risultato.append(c);
            }
        }

        return risultato.toString();
    }

    /**
     * Decifra una stringa precedentemente cifrata, spostando ciascuna lettera
     * alfabetica di 3 posizioni indietro nell'alfabeto.
     *
     * @param parolaCifrata La stringa cifrata da decifrare.
     * @return La stringa originale in chiaro.
     */
    public String decifra(String parolaCifrata) {
        if (parolaCifrata == null) {
            return null;
        }

        StringBuilder risultato = new StringBuilder();

        for (int i = 0; i < parolaCifrata.length(); i++) {
            char c = parolaCifrata.charAt(i);

            // Gestione delle lettere maiuscole(A-Z)
            if (c >= 'A' && c <= 'Z') {
                // Aggiungiamo 26 prima del modulo per evitare risultati negativi in Java
                char decifrato = (char) ('A' + (c - 'A' - SPOSTAMENTO + 26) % 26);
                risultato.append(decifrato);
            }
            // Gestione delle lettere minuscole(a-z)
            else if (c >= 'a' && c <= 'z') {
                char decifrato = (char) ('a' + (c - 'a' - SPOSTAMENTO + 26) % 26);
                risultato.append(decifrato);
            }
            // I caratteri che non sono lettere rimangono invariati
            else {
                risultato.append(c);
            }
        }

        return risultato.toString();
    }
}


