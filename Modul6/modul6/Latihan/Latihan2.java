/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pratikumprogaman2.Modul6.modul6.Latihan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan2 {
    public static void main(String[] args) {
        // Buat frame utama
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Komponen GUI
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasilFahrenheit = new JLabel(""); // hasil kosong

        // Tambahkan semua ke frame
        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(hasilFahrenheit);

        // ActionListener untuk tombol konversi
        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Ambil input dari TextField
                    double celcius = Double.parseDouble(inputCelcius.getText());

                    // Rumus konversi ke Fahrenheit
                    double fahrenheit = (celcius * 9 / 5) + 32;

                    // Tampilkan hasil ke JLabel
                    hasilFahrenheit.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    // Jika input bukan angka
                    hasilFahrenheit.setText("Input tidak valid!");
                }
            }
        });

        // Tampilkan jendela
        frame.setVisible(true);
    }
}
