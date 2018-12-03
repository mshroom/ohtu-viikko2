package laskin;

import javafx.scene.control.*;

public class Summa implements Komento {
    private TextField tuloskentta;
    private String tuloskentta_edellinen;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        this.tuloskentta_edellinen = this.tuloskentta.getText();
        int arvo = 0; 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        } 
        sovellus.plus(arvo);        
        
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        tuloskentta.setText(tuloskentta_edellinen);
    }
    
}
