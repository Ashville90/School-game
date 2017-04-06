package game;

import java.awt.Color;

/**
 *
 * @author bert-
 */
public class Barricade extends Vak {

    private int barricadewaarde;

    public Barricade(int barricadewaarde) {
        this.barricadewaarde = barricadewaarde;
         this.setText(barricadewaarde+"");
        this.setBackground(Color.red);

    }

    public void toon() {
        this.setBackground(Color.red);
    }

}

