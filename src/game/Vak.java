package game;

import javax.swing.JButton;

public abstract class Vak extends JButton //  implements KeyListener 
{
    private boolean isMuur;
    private boolean isBarricade;
    private boolean isSleutel;
    private final boolean toegang = true;
    private Veld veld;
    private Muur muur;
    
    // veld registereren
    public Vak() {
        this.veld = veld;
        
    }
    public boolean isMuur(){
        return isMuur;
    }
    public void Muur(){
        if(muur.getId().equals("Muur")){
             muur.muurtoegang();
        }
    }
    
 
    public abstract void toon();
    
    
    
    
}