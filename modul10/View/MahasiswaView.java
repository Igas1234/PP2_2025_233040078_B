/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pratikumprogaman2.modul10.View;

/**
 *
 * @author 62812
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MahasiswaView extends JFrame {

    public JTextField txtNama, txtNIM, txtJurusan, txtCari;
    public JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    public JTable tableMahasiswa;
    public DefaultTableModel model;

    public MahasiswaView() {
        setTitle("MVC CRUD Mahasiswa");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // FORM
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.add(new JLabel("Nama"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // BUTTON
        JPanel panelButton = new JPanel();
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelButton.add(btnSimpan);
        panelButton.add(btnEdit);
        panelButton.add(btnHapus);
        panelButton.add(btnClear);

        // CARI
        JPanel panelCari = new JPanel();
        txtCari = new JTextField(15);
        btnCari = new JButton("Cari");
        panelCari.add(txtCari);
        panelCari.add(btnCari);

        JPanel atas = new JPanel(new BorderLayout());
        atas.add(panelForm, BorderLayout.NORTH);
        atas.add(panelButton, BorderLayout.CENTER);
        atas.add(panelCari, BorderLayout.SOUTH);
        add(atas, BorderLayout.NORTH);

        // TABLE
        model = new DefaultTableModel(
            new String[]{"No", "Nama", "NIM", "Jurusan"}, 0
        );
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);
    }
}
