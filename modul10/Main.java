/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package id.ac.unpas.pratikumprogaman2.modul10;

import id.ac.unpas.pratikumprogaman2.modul10.View.MahasiswaView;
import id.ac.unpas.pratikumprogaman2.modul10.Model.MahasiswaModel;
import id.ac.unpas.pratikumprogaman2.modul10.Controller.MahasiswaController;

public class Main {
    public static void main(String[] args) {
        MahasiswaView view = new MahasiswaView();
        MahasiswaModel model = new MahasiswaModel();
        new MahasiswaController(view, model);
        view.setVisible(true);
    }
}
