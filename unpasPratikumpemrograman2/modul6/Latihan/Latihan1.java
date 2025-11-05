package id.ac.unpasPratikumpemrograman2.modul6.Latihan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Latihan1 {
    public static void main(String[] args) {
        // Frame utama
        JFrame frame = new JFrame("Kalkulator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Komponen layar (tempat menampilkan angka dan hasil)
        JTextField layar = new JTextField();
        layar.setEditable(false); // Supaya tidak bisa diketik manual
        frame.add(layar, BorderLayout.NORTH);

        // Panel untuk tombol-tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // Array tombol untuk memudahkan pembuatan
        String[] tombol = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "0", ".", "=", "/",
            "C"
        };

        // Variabel untuk menyimpan nilai sementara
        final double[] angka1 = {0};
        final String[] operator = {""};

        // Tambahkan tombol ke panel
        for (String teks : tombol) {
            JButton btn = new JButton(teks);

            // Tambahkan ActionListener ke setiap tombol
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = e.getActionCommand();

                    // Jika tombol angka atau titik ditekan
                    if (input.matches("[0-9.]")) {
                        layar.setText(layar.getText() + input);
                    }
                    // Jika tombol operator ditekan
                    else if (input.matches("[+\\-x/]")) {
                        angka1[0] = Double.parseDouble(layar.getText());
                        operator[0] = input;
                        layar.setText(""); // kosongkan layar untuk angka berikutnya
                    }
                    // Jika tombol "=" ditekan
                    else if (input.equals("=")) {
                        double angka2 = Double.parseDouble(layar.getText());
                        double hasil = 0;

                        switch (operator[0]) {
                            case "+": hasil = angka1[0] + angka2; break;
                            case "-": hasil = angka1[0] - angka2; break;
                            case "x": hasil = angka1[0] * angka2; break;
                            case "/": 
                                if (angka2 != 0) hasil = angka1[0] / angka2;
                                else {
                                    layar.setText("Error");
                                    return;
                                }
                                break;
                        }

                        layar.setText(String.valueOf(hasil));
                    }
                    // Jika tombol "C" ditekan (Clear)
                    else if (input.equals("C")) {
                        layar.setText("");
                        angka1[0] = 0;
                        operator[0] = "";
                    }
                }
            });

            panel.add(btn);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
