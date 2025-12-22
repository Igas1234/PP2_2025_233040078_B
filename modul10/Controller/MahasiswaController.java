package id.ac.unpas.pratikumprogaman2.modul10.Controller;

import id.ac.unpas.pratikumprogaman2.modul10.Model.MahasiswaModel;
import id.ac.unpas.pratikumprogaman2.modul10.View.MahasiswaView;
import javax.swing.*;

public class MahasiswaController {

    MahasiswaView view;
    MahasiswaModel model;

    public MahasiswaController(MahasiswaView view, MahasiswaModel model) {
        this.view = view;
        this.model = model;

        view.btnSimpan.addActionListener(e -> simpan());
        view.btnEdit.addActionListener(e -> edit());
        view.btnHapus.addActionListener(e -> hapus());
        view.btnClear.addActionListener(e -> clearForm());
        view.btnCari.addActionListener(e -> cari());

        view.tableMahasiswa.getSelectionModel()
                .addListSelectionListener(e -> isiFormDariTabel());

        loadData();
    }

    void loadData() {
        view.model.setRowCount(0);
        try {
            int no = 1;
            for (Object[] row : model.getAll()) {
                view.model.addRow(new Object[]{
                    no++, row[0], row[1], row[2]
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    void simpan() {
        try {
            if (view.txtNama.getText().trim().isEmpty() ||
                view.txtNIM.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
                return;
            }

            if (model.nimExists(view.txtNIM.getText())) {
                JOptionPane.showMessageDialog(view, "NIM sudah ada!");
                return;
            }

            model.insert(
                view.txtNama.getText(),
                view.txtNIM.getText(),
                view.txtJurusan.getText()
            );

            JOptionPane.showMessageDialog(view, "Data berhasil ditambahkan");
            loadData();
            clearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                view,
                "Data gagal ditambahkan!\n" + e.getMessage()
            );
        }
    }

    void edit() {
        try {
            if (view.tableMahasiswa.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(
                    view,
                    "Pilih data di tabel terlebih dahulu!"
                );
                return;
            }

            model.update(
                view.txtNama.getText(),
                view.txtJurusan.getText(),
                view.txtNIM.getText()
            );

            JOptionPane.showMessageDialog(view, "Data berhasil diubah");
            loadData();
            clearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                view,
                "Data gagal diubah!\n" + e.getMessage()
            );
        }
    }

    void hapus() {
        try {
            if (view.tableMahasiswa.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(
                    view,
                    "Pilih data yang akan dihapus!"
                );
                return;
            }

            int konfirmasi = JOptionPane.showConfirmDialog(
                view,
                "Yakin ingin menghapus data ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
            );

            if (konfirmasi != JOptionPane.YES_OPTION) return;

            model.delete(view.txtNIM.getText());

            JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
            loadData();
            clearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                view,
                "Data gagal dihapus!\n" + e.getMessage()
            );
        }
    }

    void cari() {
        loadData();
    }

    void clearForm() {
        view.txtNama.setText("");
        view.txtNIM.setText("");
        view.txtJurusan.setText("");
        view.txtNIM.setEditable(true);
        view.tableMahasiswa.clearSelection();
    }

    void isiFormDariTabel() {
        int row = view.tableMahasiswa.getSelectedRow();
        if (row >= 0) {
            view.txtNama.setText(view.model.getValueAt(row, 1).toString());
            view.txtNIM.setText(view.model.getValueAt(row, 2).toString());
            view.txtJurusan.setText(view.model.getValueAt(row, 3).toString());
            view.txtNIM.setEditable(false);
        }
    }
}
