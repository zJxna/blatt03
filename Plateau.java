/******************************************************************************
 *  Compilation:  javac Plateau.java
 *  Execution:    java Plateau x1 x2 x3 ... xn
 *
 *  Eingabe: Beliebig viele Integer Zahlen.
 *  Ausgabe: Die Laenge und die Startposition des laengsten Plateaus.
 *           Ein Plateau ist eine Sequenz gleicher Zahlen, die durch zwei
 *           niedrigere Zahlen direkt links bzw. rechts davon begrenzt wird.
 *           Die Ausgabe soll ERROR sein, wenn weniger als drei Zahlen
 *           uebergeben werden.
 *           Die Ausgabe fuer die Laenge soll 0 und die Position -1 sein, wenn
 *           es kein laengstes Plateau gibt.
 *
 *  Beispiel:
 
 $ java Plateau 2 3 3 3 1 2 2 1
 Laenge: 3
 Index: 1
 
 * In dem Beispiel gibt es zwei Plateaus (Index 1 mit Laenge 3 und Index 5 mit Laenge 2)
 *
 *
 ******************************************************************************/

public class Plateau {
    public static void main(String args[]) {
        // Implementieren Sie Ihre Loesung hier
        if (args.length < 3) {
            System.out.println("ERROR");
        } else {
            // Initialisierung
            int[] zahlen = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                zahlen[i] = Integer.parseInt(args[i]);
            }
            
            int len = 0;
            int pos = -1;
            
            int tmp_len = 0;
            int tmp_pos = -1;
            
            boolean plateau = false;
            
            // Durchlaufe alle Zahlen
            for (int i = 1; i < args.length; i++) {
                // Beginnt hier ein Plateau?
                if (zahlen[i - 1] < zahlen[i]) {
                    plateau = true;
                    tmp_len = 1;
                    tmp_pos = i;
                }
                // Sind wir auf einem Plateau und ist die aktuelle Zahl gleich der
                // vorhergehenden?
                else if (plateau && zahlen[i - 1] == zahlen[i]) {
                    tmp_len++;
                }
                // Wir verlassen das Plateau und vergleichen desssen Laenge mit bisher
                // gefundenen Plateaus. Gegebenenfalls aktualisieren wir.
                else if (plateau && zahlen[i - 1] > zahlen[i]) {
                    if (tmp_len > len) {
                        len = tmp_len;
                        pos = tmp_pos;
                    }
                    plateau = false;
                }
            }
            // Ausgabe
            System.out.println("Laenge: " + len);
            System.out.println("Index: " + pos);
        }
    }
}