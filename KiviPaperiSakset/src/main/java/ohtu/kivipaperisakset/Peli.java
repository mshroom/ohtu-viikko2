package ohtu.kivipaperisakset;

public class Peli {

    public static Peli luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja();
    }

    public static Peli luoHelppoYksinpeli() {
        return new KPSTekoaly(new YksinkertainenTekoaly());
    }

    public static Peli luoVaikeaYksinpeli() {
        return new KPSTekoaly(new ParannettuTekoaly(20));
    }
    
    public void pelaa() {
        
    }
}
