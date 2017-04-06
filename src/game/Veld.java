package game;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jeroen
 */
public class Veld extends JFrame
        implements KeyListener {

    private int aantalRijen;
    private int aantalMijnen;
    private Vak[][] vak;
    private JPanel panel;
    private final int SIZE = 60;
    public int py;
    public int px;
    public int ny;
    public int nx;
    static JButton resetbutton;

    public Veld(int aantalRijen) {
        this.aantalRijen = aantalRijen;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();

        maakVeld();
        initComponents();
    }

    private void plaatsRij(int rij) {
        for (int i = 0; i < this.aantalRijen; i++) {
            panel.add(vak[rij][i]);
            vak[rij][i].setSize(SIZE, SIZE);
            vak[rij][i].setLocation(SIZE * i, SIZE * rij);
            vak[0][0].setBackground(Color.GREEN);
            vak[aantalRijen - 1][aantalRijen - 1].setBackground(Color.RED);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (py <= aantalRijen - 2) {
            //    System.out.println("ny:" + ny);
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                vak[ny = py + 1][px].setBackground(Color.black);
                vak[py][px].setBackground(Color.white);
                py = ny;
                px = nx;
            }     
            
        }
        if (py > 0) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                vak[ny = py - 1][px].setBackground(Color.black);
                vak[py][px].setBackground(Color.white);
                py = ny;
                px = nx;
            }
        }
        if (px > 0) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                vak[py][nx = px - 1].setBackground(Color.black);
                vak[py][px].setBackground(Color.white);
                py = ny;
                px = nx;
            }
        }
        if (px <= aantalRijen - 2) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                vak[py][px].setBackground(Color.white);
                vak[py][nx = px + 1].setBackground(Color.black);
                py = ny;
                px = nx;
            }
        }
        checkGewonnen();
        repaint();
    }

    public void checkGewonnen() {
        if (nx == aantalRijen - 1 && ny == aantalRijen - 1) {
            JOptionPane.showMessageDialog(this, "Gefeliciteerd, u heeft gewonnen!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setName("Sleutel Barricade");
        this.setSize(800, 800);
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        resetbutton = new JButton("reset");
        resetbutton.setSize(100, SIZE);
        resetbutton.setLocation(0, 600);
        panel.add(resetbutton);
        resetbutton.addActionListener(new ClickListener());

        for (int i = 0; i < this.aantalRijen; i++) {
            plaatsRij(i);
        }
    }

    /**
     * hier wordt het veld aangemaakt
     * barricade sleutels en muren worden meteen geplaatst.
     */
    private void maakVeld() {
        vak = new Vak[aantalRijen][aantalRijen];
        for (int rij = 0; rij < aantalRijen; rij++) {
            for (int kolom = 0; kolom < aantalRijen; kolom++) {
                Vak v;
                if (rij == 2 && kolom == 5) {
                    v = new Sleutel(100);
                } else if (rij == 3) {
                    v = new Barricade(100);
                } else if (rij == 1 && kolom == 0 || rij == 1 && kolom == 3 || rij == 1 && kolom == 4 || 
                            rij == 1 && kolom == 6 || rij == 1 && kolom == 7 || rij == 1 && kolom == 8 || rij == 1 && kolom == 9 || rij == 3 && kolom == 6 ||
                                rij == 4 && kolom == 4 || rij == 4 && kolom == 6 || rij == 5 && kolom == 4 || rij == 6 && kolom == 4 || rij == 6 && kolom == 5 ||
                                    rij == 6 && kolom == 6 || rij == 7 && kolom == 6 || rij == 7 && kolom == 8 || rij == 7 && kolom == 9) {
                    v = new Muur();
                    System.out.println();
                } else {
                    v = new Leeg();
                }
                vak[rij][kolom] = v;
            }
        }
        

    }
    
   

//  public void checkGewonnen(){
//       if (nx == 8 && ny == 8) {
//            JOptionPane.showMessageDialog(null, "Gefeliciteerd, u heeft gewonnen!");
//        }
//  }
    private static class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hallo");
        }

    }

    public static void main(String[] args) {
        Veld veld = new Veld(10);
        veld.setVisible(true);
    }

}

