package id.ac.unpas.pratikumprogaman2.modul5;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author wdgus
 */
public class Latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jendela dengan Label");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JLabel label = new JLabel("Ini adalah JLabel.");
            frame.add(label);
            
            frame.setVisible(true);
        });
    }
}
