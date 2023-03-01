package softwaredesign;

import  javax.swing.JFrame;
import java.awt.*;

public class UI {
    Main gm;

    JFrame window;

    public UI(Main gm) {
        this.gm = gm;

        createMainField();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
    }
}
