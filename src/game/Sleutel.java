package game;

import java.awt.Color;

/**
 *
 * @author bert-
 */
public class Sleutel extends Vak {
    private int sleutelwaarde;
    
    public Sleutel(int sleutelwaarde) {
        this.sleutelwaarde = sleutelwaarde;
        this.setText(sleutelwaarde+"");
        this.setBackground(Color.green);
    }

    @Override
    public String toString() {
        return "*";
    }
    
    public  void toon(){
        this.setBackground(Color.green);
    }
}

