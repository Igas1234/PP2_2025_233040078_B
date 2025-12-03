package id.ac.unpas.pratikumprogaman2.modul8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("");
    private JLabel lblKeliling = new JLabel(""); // Label keliling
    private JButton btnHitung = new JButton("Hitung Luas & Keliling");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {

        this.setTitle("Kalkulator Persegi Panjang (MVC)");
        this.setSize(400, 250);
        this.setLayout(new GridLayout(6, 2, 10, 10)); 

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);

        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);

        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);

        this.add(new JLabel("Keliling:"));  // tampilkan judul keliling
        this.add(lblKeliling);              // nilai keliling

        this.add(btnHitung);
        this.add(btnReset);
    }

    // Mengambil nilai panjang dari Textfield
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    // Mengambil nilai lebar dari Textfield
    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Menampilkan hasil luas ke Label
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }

    // 🆕 Menampilkan hasil keliling ke Label
    public void setKeliling(double keliling) {
        lblKeliling.setText(String.valueOf(keliling));
    }

    // RESET INPUTAN
    public void resetInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("");
        lblKeliling.setText(""); // 🆕 reset keliling
    }

    // Menampilkan pesan error
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Listener tombol Hitung
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    // Listener tombol RESET
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}
