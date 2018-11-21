/******************************************************************************
 *  Compilation:  javac Median.java
 *  Execution:    java Median a b c d e
 *  Testen:       ./gradlew testen
 *
 *  Eingabe: Fuenf unterschiedliche ganze Zahlen a, b, c, d und e.
 *  Ausgabe: Der Median der Werte, d.h. eine der fuenf Zahlen, so dass genau
 *           zwei der Zahlen kleiner und zwei der Zahlen groesser sind.
 *
 *  Referenzen: https://de.wikipedia.org/wiki/Euklidischer_Algorithmus#Iterative_Variante
 *
 ******************************************************************************/

public class Median {
    public static void main(String[] args) {
        // Implementieren Sie Ihre Loesung hier
        
        if (args.length != 5) {
            System.out.println("ERROR");
            return;
        }
        
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);
        
        if (a == b || a == c || a == d || a == e ||
            b == c || b == d || b == e ||
            c == d || c == e ||
            d == e) {
            System.out.println("ERROR");
            return;
        }
        
        int min, max, med, median = 0;
        
        // Bestimme median, min und max von a,b und c
        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        if (c > max) {
            med = max;
            max = c;
        } else if (c < min) {
            med = min;
            min = c;
        } else {
            med = c;
        }
        
        median = med;
        if (d > med && d < max && e > d) {
            median = d;
        }
        if (e > med && e < max && d > e) {
            median = e;
        }
        if (d < med && d > min && e < d) {
            median = d;
        }
        if (e < med && e > min && d < e) {
            median = e;
        }
        if (d > max && e > max) {
            median = max;
        }
        if (d < min && e < min) {
            median = min;
        }
        if (d < med && e > med) {
            median = med;
        }
        
        System.out.println(median);
    }
}
