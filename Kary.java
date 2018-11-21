/******************************************************************************
 *  Compilation:  javac Kary.java
 *  Execution:    java Kary i k
 *  Test:         ./gradlew testen
 *
 *  Eingabe: i ist ein long Wert, k ist ein int Wert zwischen 2 und 16 (jeweils inklusive)
 *  Ausgabe: Die Zahl i (die in der Basis 10 ist) als Zahl zur Basis k. Fuer k > 10 verwenden
 *  Sie die Buchstaben A-F als Ziffern.
 *
 * Hinweis: Sie koennen das Program 1.14 aus dem Buch als Vorlage verwenden, das das Problem
 *          fuer k=2 loest. http://introcs.cs.princeton.edu/java/13flow/Binary.java
 *          Beachten Sie, dass i hier im Gegensatz zu Binary.java ein long Wert sein soll!
 * 
 ******************************************************************************/

public class Kary {
    public static void main(String[] args) {
        // Implementieren Sie Ihre Loesung hier 
		if (args.length != 2) {
			System.out.println("ERROR");
			return;
		}

        long i = Long.parseLong(args[0]);
        int k = Integer.parseInt(args[1]);

		if (k < 2 || k > 16) {
			System.out.println("ERROR");
			return;
		}

        int v = 1;
        while (v<=i/k) {
            v = v*k;
        }
        // In v ist nun die groesste Potenz zur Basis k gespeichert

        while (v>0) {
            long d = i/v;
            if (d==10) System.out.print("A");
            if (d==11) System.out.print("B");
            if (d==12) System.out.print("C");
            if (d==13) System.out.print("D");
            if (d==14) System.out.print("E");
            if (d==15) System.out.print("F");
            if (d < 10) System.out.print(d);
            i = i%v;
            v = v/k;
        }
        System.out.println();
    }
}

