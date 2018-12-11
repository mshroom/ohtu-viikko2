package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPelaaja {

    private static final Scanner scanner = new Scanner(System.in);
    
    @Override
    protected String vastapelaajanSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();
        return tokanSiirto;
    }
}