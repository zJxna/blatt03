/******************************************************************************
 *  Compilation:  javac Bughunt04.java
 *  Execution:    java Bughunt04 x1 x2
 *
 *  Eingabe: eine oder zwei Zahlen
 *  Ausgabe: siehe Tests
 *
 ******************************************************************************/

public class Bughunt04 {
    public static void main(String[] args) {
        /* Orientieren Sie sich an den Testfaellen, um herauszufinden,
         * wie die genaue Augabe aussehen soll. Sie duerfen davon ausgehen, dass
         * es ausreicht die Anzahl der Parameter zu pruefen.*/
        if (args.length < 1 || args.length > 2) {
            System.out.println("ERROR");
            return;
        }
        
        System.out.println("Eindimensionaler Fall");
        int z = Integer.parseInt(args[0]);
        
        int a[] = new int[z];
        // Initialisieren des Arrays (die genauen Werte sind nicht wichtig)
        int index;
        for (index = 0; index < z; index++) {
            a[index] = index;
        }
        
        index = 0;
        while (index < z / 2) {
            // swap tauscht in a die Elemente an den beiden uebergebenen Stellen
            a = swap(a, index, (z - 1) - index);
            index++;
        }
        
        // Ausgabe des Arrays (hier sind keine Fehler)
        for (index = 0; index < z - 1; index++) {
            System.out.print(a[index] + " ");
        }
        System.out.println(a[z - 1]);
        
        
        if (args.length == 2) {
            System.out.println("\nZweidimensionaler Fall");
            int s = Integer.parseInt(args[1]);
            int[][] b = new int[z][s];
            
            // Initialisieren des Arrays (die genauen Werte sind nicht wichtig)
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < s; j++) {
                    b[i][j] = j * i;
                }
            }
            
            // Ausgabe des Arrays
            // Ab hier ist das Programm fehlerfrei
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < s - 1; j++) {
                    System.out.print(b[i][j] + " ");
                }
                System.out.println(b[i][s - 1]);
            }
        }
    }
    
    public static int[] swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return a;
    }
}
