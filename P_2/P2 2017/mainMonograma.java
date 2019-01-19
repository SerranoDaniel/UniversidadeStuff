

import java.util.*;

import java.lang.*;

class mainMonograma {

    public static void main( String[] args ) {     
        Monograma mon = new Monograma();
        String name = mon.anagramScanner();
        mon.extrair(name);
        System.out.print(mon.toString());
    }
}