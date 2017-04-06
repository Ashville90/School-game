/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;

/**
 *
 * @author bert-
 */
public class Muur extends Vak {

    private final String id;
    private boolean toegang;
    

    /**
     *
     */
    public Muur() {
        id = "Muur";
        this.setBackground(Color.blue);
        toegang = true;
    }

    public String getId() {
        return id;
    }
    
    public boolean muurtoegang(){
        return !toegang;
    }
    
    
    public void toon() {
        this.setBackground(Color.blue);
    }

}
