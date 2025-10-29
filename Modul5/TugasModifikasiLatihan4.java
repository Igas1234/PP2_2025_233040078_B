package id.ac.unpas.pratikumprogaman2.Modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author wdqus
 */
public class TugasModifikasiLatihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 1. Atur Layout Manager ke BorderLayout
                // Sebenarnya ini tidak perlu
                // karena BorderLayout adalah Layout Manager default
                frame.setLayout(new BorderLayout());

                // 2. Buat komponen
                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                JButton btnsouth = new JButton("SOUTH)");
                JButton btnWest = new JButton("(WEST)");
                JButton btnEast = new JButton("EAST)");
                JButton btnCenter = new JButton("Tengah (CENTER)");

                // 3. Tambahkan Aksi (ActionListener) ke tombol
                btnsouth.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                 // Aksi untuk tombol kiri
            btnWest.addActionListener(e -> label.setText("Tombol WEST diklik!"));

            // Aksi untuk tombol kanan
            btnEast.addActionListener(e -> label.setText("Tombol EAST diklik!"));

            // Aksi untuk tombol tengah
            btnCenter.addActionListener(e -> label.setText("Tombol CENTER diklik!"));

                // 4. Tambahkan komponen ke frame DENGAN POSISI
                // Tambahkan semua komponen ke frame
                frame.add(label, BorderLayout.NORTH);
                frame.add(btnsouth, BorderLayout.SOUTH);
                frame.add(btnWest, BorderLayout.WEST);
                frame.add(btnEast, BorderLayout.EAST);
                frame.add(btnCenter, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
