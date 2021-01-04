/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobamvc;

import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orenji
 */
public class ViewPraktikum extends JFrame{
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jlnim = new JLabel("Nim : ");
    JTextField jtnim = new JTextField();
    JLabel jlnama = new JLabel("Nama : ");
    JTextField jtnama = new JTextField();
    JLabel jlalamat = new JLabel("Alamat : ");
    JTextField jtalamat = new JTextField();
    JLabel jcari = new JLabel("Cari NIM: ");
    JTextField jtcari = new JTextField();
    
    JButton jbtambah = new JButton("Tambah");
    JButton jbupdate = new JButton("Update");
    JButton jbcancel = new JButton("Cancel");
    JButton jbcari = new JButton("Cari NIM");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nim", "Nama", "Alamat"};
    
    public ViewPraktikum(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(750,450); // x , y
        
        add(scrollPane);
        scrollPane.setBounds(20, 40, 480, 300);
        
        // CARI NIM ============================================== :P
        add(jbcari);
        jbcari.setBounds(510, 20, 90, 20);
        add(jtcari);
        jtcari.setBounds(20, 20, 480, 20);
        
        // NIM =================================================================
        add(jlnim);
        jlnim.setBounds(510, 40, 90, 20);
        add(jtnim);
        jtnim.setBounds(510, 60, 120, 20);
        
        // NAMA ================================================================
        add(jlnama);
        jlnama.setBounds(510, 80, 90, 20);
        add(jtnama);
        jtnama.setBounds(510, 100, 120, 20);
        
        // ALAMAT ==============================================================
        add(jlalamat);
        jlalamat.setBounds(510, 120, 90, 20);
        add(jtalamat);
        jtalamat.setBounds(510, 140, 120, 20);
        
        
        // BUTTON ==============================================================
        add(jbtambah);
        jbtambah.setBounds(510, 180, 90, 20);
        
        add(jbupdate);
        jbupdate.setBounds(510, 220, 90, 20);
        
        add(jbcancel);
        jbcancel.setBounds(510, 260, 90, 20);
        
       
    }
    
    
    //Buat ngambil data texfield
    public String getNim(){
        return jtnim.getText();
    }
    
    public String getNama(){
        return jtnama.getText();
    }
    
    public String getAlamat(){
        return jtalamat.getText();
    }
    public String getNim2() {//buat ambil nim yang mau dicari
    	return jtcari.getText();
    }
}
