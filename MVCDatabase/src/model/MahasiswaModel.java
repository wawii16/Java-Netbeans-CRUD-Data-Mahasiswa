/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dwiie
 */
import com.mysql.cj.jdbc.Blob;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.viewCRUD;

public class MahasiswaModel {

    public void autonumber(viewCRUD view) {
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM mahasiswa ORDER BY nim DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NimMhs = r.getString("nim").substring(8);
                String TH = "" + (Integer.parseInt(NimMhs) + 1);
                String Nol = "";

                if (TH.length() == 1) {
                    Nol = "00";
                } else if (TH.length() == 2) {
                    Nol = "0";
                } else if (TH.length() == 3) {
                    Nol = "";
                }

                view.getTxNim().setText("41521010" + Nol + TH);

            } else {
                view.getTxNim().setText("41521010001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("autonumber error");
        }
    }
    

    public void clear(viewCRUD view) {
        // Your clear logic here
    }

    public void loadData(DefaultTableModel model, String cari) {
 model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE '%" + cari + "%'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] rowData = new Object[5];
                rowData[0] = r.getString("nim");
                rowData[1] = r.getString("nama");
                rowData[2] = r.getString("alamat");
                rowData[3] = r.getString("umur");
                Blob blob = (Blob) r.getBlob("imageData");
                
                if (blob != null) {
                    byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                    ImageIcon imageIcon = new ImageIcon(imageBytes);
                    Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    rowData[4] = new ImageIcon(scaledImage);
                } else {
                    rowData[4] = null;
                }

                model.addRow(rowData);
            }

            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat memuat data: " + e.getMessage());
        }    }

    public void saveData(String nim, String nama, String alamat, String umur, String path, viewCRUD view) {
 // TODO add your handling code here:
        
        
              if (path == null) {
            JOptionPane.showMessageDialog(null, "Harus ada foto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO mahasiswa(nim, nama, alamat, umur, imageData) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nim);
            p.setString(2, nama);
            p.setString(3, alamat);
            p.setString(4, umur);
            InputStream is = new FileInputStream(new File(path));
            p.setBlob(5, is);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Terjadi Kesalahan");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            view.loadData();
            view.autonumber();
            view.clear();
        }
    }

    public void updateData(String nim, String nama, String alamat, String umur, String path, viewCRUD view) {
try {
        Connection c = Koneksi.getKoneksi();
        String sql = "UPDATE mahasiswa SET nama=?, alamat=?, umur=?, imageData=? WHERE nim=?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, nama);
        p.setString(2, alamat);
        p.setString(3, umur);

        if (path != null) {
            InputStream is = new FileInputStream(new File(path));
            p.setBlob(4, is);
        } else {
            p.setNull(4, java.sql.Types.BLOB);
        }

        p.setString(5, nim);
        p.executeUpdate();
        p.close();
        JOptionPane.showMessageDialog(null, "Data Telah Diubah");
    } catch (SQLException | FileNotFoundException e) {
        e.printStackTrace();
        System.out.println("Terjadi Kesalahan");
    } finally {
        view.loadData();
        view.autonumber();
        view.clear();
    }    }

    public void deleteData(int selectedRow, DefaultTableModel model, viewCRUD view) {
if (selectedRow != -1) {
        // Get the value in the first column (assuming it's the ID or key)
        String nimToDelete = (String) model.getValueAt(selectedRow, 0);

        try {
            Connection connection = Koneksi.getKoneksi();
            String sql = "DELETE FROM mahasiswa WHERE nim = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nimToDelete);
                preparedStatement.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(view, "Data Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error deleting data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresh the table after deletion
        loadData(model, view.getjTextCari().getText());
    }
    }
    
    public void uploadImage(String nim, String imagePath) {
        try {
            Connection connection = Koneksi.getKoneksi();
            String sql = "UPDATE mahasiswa SET imageData = ? WHERE nim = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                InputStream imageStream = new FileInputStream(new File(imagePath));
                preparedStatement.setBlob(1, imageStream);
                preparedStatement.setString(2, nim);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | IOException e) {
            System.out.println("Terjadi kesalahan saat mengupload gambar: " + e.getMessage());
        }
    }


    // Other methods as needed...
}
