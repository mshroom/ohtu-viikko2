package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPelaaja {
    
    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly;
    
    public KPSTekoaly(Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected String vastapelaajanSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
