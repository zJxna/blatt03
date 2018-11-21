/******************************************************************************
 *  Compilation:  javac Cosinus.java
 *  Execution:    java Cosinus x
 *  Test:         ./gradlew testen
 *
 *  Eingabe: Ein double Wert x.
 *  Ausgabe: Der Cosinus von x, berechnet mit Hilfe der Taylor Reihe vom Uebungsblatt.
 *
 * 
 ******************************************************************************/

public class Cosinus {

    public static void main(String[] args) {
        // Implementieren Sie Ihre Loesung hier
        /* Die Loesung ist eine adaptierte Version von
http://introcs.cs.princeton.edu/java/13flow/Sin.java.html */

		if (args.length != 1) {
			System.out.println("ERROR");
			return;
		}
        double x = Double.parseDouble(args[0]);
        
        if (x < 0){
            System.out.println("ERROR");
            return;
        }
        
        double pi = Math.PI;

        // convert x to an angle between -2 PI and 2 PI
        x = x % (2 * pi);
        // compute the Taylor series approximation
        double term = 1.0;      // ith term
        double sum  = 1.0;      // sum of first i terms in taylor series

        // Glieder werden berechnet solange sie groesser sind als 0
        for (int i = 1; term > 0; i++) {
            term *= (x / i);
            if (i % 4 == 0) sum += term;
            if (i % 4 == 2) sum -= term;
        }
        sum = (int) (100*sum)/100.0;
        System.out.println(sum);
        //
    }
}

