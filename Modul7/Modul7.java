package id.ac.unpas.pratikumprogaman2.Modul7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Modul7 extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // ==========================
    // TAB INPUT
    // ==========================
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Nama Siswa
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Mata Pelajaran
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {
                "Matematika Dasar",
                "Bahasa Indonesia",
                "Algoritma dan Pemrograman I",
                "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);

        // Tombol Reset
        JButton btnReset = new JButton("Reset");
        panel.add(btnReset);

        // Event Simpan
        btnSimpan.addActionListener(e -> prosesSimpan());

        // Event Reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        });

        return panel;
    }

    // ==========================
    // TAB TABEL
    // ==========================
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk tombol Hapus
        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnHapus = new JButton("Hapus Data");
        panelBottom.add(btnHapus);

        // Event Hapus
        btnHapus.addActionListener(e -> {
            int row = tableData.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
                return;
            }
            tableModel.removeRow(row);
        });

        panel.add(panelBottom, BorderLayout.SOUTH);

        return panel;
    }

    // ==========================
    // LOGIKA SIMPAN
    // ==========================
    private void prosesSimpan() {

        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // Validasi nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi nama minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal 3 karakter!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;

        // Validasi nilai angka + range
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus 0 - 100!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       String grade;
int kategori = nilai / 10;

switch (kategori) {
    case 10:
    case 9:
    case 8:
        grade = "A";
        break;

    case 7:
        grade = "AB";
        break;

    case 6:
        grade = "B";
        break;

    case 5:
        grade = "BC";
        break;

    case 4:
        grade = "C";
        break;

    case 3:
        grade = "D";
        break;

    default:
        grade = "E";
        break;
}


        // Tambahkan ke tabel
        Object[] baris = {nama, matkul, nilai, grade};
        tableModel.addRow(baris);

        // Reset form
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        tabbedPane.setSelectedIndex(1);
    }

    // ==========================
    // CONSTRUCTOR
    // ==========================
    public Modul7() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Input Data", createInputPanel());
        tabbedPane.addTab("Daftar Nilai", createTablePanel());

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Modul7().setVisible(true));
    }
}
