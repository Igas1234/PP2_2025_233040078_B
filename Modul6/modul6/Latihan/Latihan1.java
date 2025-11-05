/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pratikumprogaman2.Modul6.modul6.Latihan;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*; // <- penting untuk FlowLayout
import javax.swing.JTextField;

/**
 *
 * @author 62812
 */
public class Latihan1 {
    public static void main(String[] args) {
        // buat kalkulator
        JFrame frame = new JFrame("Kalkulator");
        frame.setSize(300, 400);

        // buat layar (tempat menampilkan angka)
        JTextField layar = new JTextField();
        frame.add(layar, BorderLayout.NORTH);

        // buat panel untuk menampung tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // tambahkan tombol-tombol ke panel
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("+"));

        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("-"));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("x"));

        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("/"));

        panel.add(new JButton("c"));

        // tambahkan panel ke frame
        frame.add(panel);

        // tampilkan frame
        frame.setVisible(true);
    }
}

