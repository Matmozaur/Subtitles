package subchanger;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class SubChanger {

    
    public static void main(String[] args) {       
         EventQueue.invokeLater(() -> {
             SubchangerGUI frame = new SubchangerGUI();
             frame.setTitle("TextComponentTest");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setBounds(10, 10, 600, 400);
             frame.setVisible(true);
         });
    }
    
}
