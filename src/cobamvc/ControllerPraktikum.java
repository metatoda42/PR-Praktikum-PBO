/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobamvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Orenji
 */
public class ControllerPraktikum {
    
    ModelPraktikum modelpraktikum;
    ViewPraktikum viewpraktikum;

    public ControllerPraktikum(ViewPraktikum vpc, ModelPraktikum mpc) {
        this.modelpraktikum = mpc;
        this.viewpraktikum = vpc;
        
        if (modelpraktikum.getBanyakData() != 0) {
            String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
            viewpraktikum.tabel.setModel((new JTable(dataMahasiswa, viewpraktikum.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewpraktikum.jbtambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = viewpraktikum.getNim();
                String nama = viewpraktikum.getNama();
                String alamat = viewpraktikum.getAlamat();
                modelpraktikum.insertMahasiswa(nim, nama, alamat);

                String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
            }
        });
        
        viewpraktikum.jbupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nim = viewpraktikum.getNim();
                String nama = viewpraktikum.getNama();
                String alamat = viewpraktikum.getAlamat();
                modelpraktikum.updateMahasiswa(nim, nama, alamat);
                
                String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
            }
        });
        
        viewpraktikum.jbcari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nim = viewpraktikum.getNim2();   
                String dataMahasiswa[][] = modelpraktikum.carimahasiswa(nim);
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
            }
        });
        
        viewpraktikum.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewpraktikum.tabel.getSelectedRow();
                int kolom = viewpraktikum.tabel.getSelectedColumn(); // ga kepake sekarang

                String dataterpilih = viewpraktikum.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NIM " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelpraktikum.deleteMahasiswa(dataterpilih);
                    String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                    viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
