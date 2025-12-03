package id.ac.unpas.pratikumprogaman2.modul8.controller;

import id.ac.unpas.pratikumprogaman2.modul8.model.PersegiPanjangModel;
import id.ac.unpas.pratikumprogaman2.modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {

    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Listener tombol HITUNG
        this.view.addHitungListener(new HitungListener());

        // Listener tombol RESET
        this.view.addResetListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.resetInput();
            }
        });
    }

    // Inner class untuk tombol HITUNG
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungLuas();
                model.hitungKeliling();  // hitung keliling

                view.setHasil(model.getLuas());
                view.setKeliling(model.getKeliling());  // tampilkan keliling

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
}
