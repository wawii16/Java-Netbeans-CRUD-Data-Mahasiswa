/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import model.MahasiswaModel;
/**
 *
 * @author dwiie
 */
public class viewCRUD extends javax.swing.JFrame {

    /**
     * Creates new form viewCRUD
     */
    String path2 = null;

    private MahasiswaModel model;
    private DefaultTableModel tableModel;
    private boolean isEditMode;

    // Rest of your existing view code...

    // Initialize the model in the constructor
    public viewCRUD() {
        initComponents();
        this.setLocationRelativeTo(null);
        txNim.setEnabled(false);

        model = new MahasiswaModel();
        tableModel = new DefaultTableModel();

        // Set the model for jTable1
        jTable1.setModel(tableModel);

        tableModel.addColumn("NIM");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Alamat");
        tableModel.addColumn("Umur");
        tableModel.addColumn("Foto");
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());

                jTable1.setRowHeight(100);
        
        TableColumn imageColumn = jTable1.getColumnModel().getColumn(4);
        imageColumn.setCellRenderer(new ImageRenderer());
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new MultiLineTableCellRenderer());        
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new MultiLineTableCellRenderer());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer());   
        loadData();
        autonumber();
    }
    
    
    public void autonumber() {
        model.autonumber(this);
    }

    public void loadData() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        String cari = jTextCari.getText();

        model.loadData(tableModel, cari);
    }

    public void clear() {
        txNama.setText("");
        txUmur.setText("");
        txAlamat.setText("");
        lblFoto.setIcon(null);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public javax.swing.JButton getBtnCancel1() {
        return btnCancel1;
    }

    public javax.swing.JButton getBtnEdit() {
        return btnEdit;
    }

    public javax.swing.JButton getBtnSimpan() {
        return btnSimpan;
    }

    public javax.swing.JButton getjButtonCari() {
        return jButtonCari;
    }

    public javax.swing.JButton getjButtonUpload() {
        return jButtonUpload;
    }

    public javax.swing.JTable getjTable1() {
        return jTable1;
    }

    public javax.swing.JTextField getjTextCari() {
        return jTextCari;
    }

    public javax.swing.JLabel getLblFoto() {
        return lblFoto;
    }

    public javax.swing.JTextField getTxAlamat() {
        return txAlamat;
    }

    public javax.swing.JTextField getTxNama() {
        return txNama;
    }

    public javax.swing.JTextField getTxNim() {
        return txNim;
    }

    public javax.swing.JTextField getTxUmur() {
        return txUmur;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txNim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txAlamat = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        txUmur = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jButtonUpload = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnCancel1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextCari = new javax.swing.JTextField();
        jButtonCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("NIM");

        txNim.setEditable(false);
        txNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNimActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat");

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txUmur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUmurActionPerformed(evt);
            }
        });

        jLabel6.setText("Umur");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jButtonUpload.setText("Upload");
        jButtonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCancel1.setText("Hapus");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txUmur)
                            .addComponent(txAlamat)
                            .addComponent(txNama)
                            .addComponent(txNim))
                        .addGap(205, 205, 205)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(jButtonUpload)
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txUmur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(jButtonUpload)
                    .addComponent(btnEdit)
                    .addComponent(btnCancel)
                    .addComponent(btnCancel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel1.setText("Data Mahasiswa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCariActionPerformed(evt);
            }
        });

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jTextCari, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
    String nim = txNim.getText();
    String nama = txNama.getText();
    String alamat = txAlamat.getText();
    String umur = txUmur.getText();

    model.saveData(nim, nama, alamat, umur, path2, this);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadActionPerformed
        // TODO add your handling code here:
        String imagePath = getImagePath();

    if (imagePath != null) {
        try {
            BufferedImage bi = ImageIO.read(new File(imagePath));
            Image img = bi.getScaledInstance(118, 113, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblFoto.setIcon(icon);
            path2 = imagePath;
        } catch (IOException ex) {
            Logger.getLogger(viewCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }//GEN-LAST:event_jButtonUploadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String nim = txNim.getText();
        String nama = txNama.getText();
        String alamat = txAlamat.getText();
        String umur = txUmur.getText();
        model.updateData(nim, nama, alamat, umur, path2, this);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        clear();
        loadData();
        btnSimpan.setEnabled(true);
        autonumber();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
int selectedRow = jTable1.getSelectedRow();

    if (selectedRow == -1) {
        // No row is selected, show an error message or handle it appropriately
        JOptionPane.showMessageDialog(this, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirmResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this data?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

    if (confirmResult == JOptionPane.YES_OPTION) {
        // User confirmed deletion, proceed with deletion
        model.deleteData(selectedRow, getTableModel(), this);
    }    
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Handle row selection and populate input fields for editing

    // Get the selected row index
    int selectedRow = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRow != -1) {
        // Disable the "Simpan" button during editing
        btnSimpan.setEnabled(false);

        // Get data from the selected row
        String nim = (String) tableModel.getValueAt(selectedRow, 0);
        String nama = (String) tableModel.getValueAt(selectedRow, 1);
        String alamat = (String) tableModel.getValueAt(selectedRow, 2);
        String umur = (String) tableModel.getValueAt(selectedRow, 3);
        Object obj = tableModel.getValueAt(selectedRow, 4);

        // Populate input fields with data
        txNim.setText(nim);
        txNama.setText(nama);
        txAlamat.setText(alamat);
        txUmur.setText(umur);

        // Display the image in the lblFoto
        if (obj instanceof Blob) {
            // Handle Blob data
            Blob imageData = (Blob) obj;

            try {
                if (imageData != null) {
                    // Convert Blob to byte array
                    byte[] bytes = imageData.getBytes(1, (int) imageData.length());

                    // Convert byte array to Image
                    ImageIcon originalIcon = new ImageIcon(bytes);

                    // Scale the image to the desired size using SCALE_SMOOTH
                    Image originalImage = originalIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);

                    // Create a new ImageIcon from the scaled image
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Set the scaled ImageIcon to your JLabel (assuming lblFoto is a JLabel)
                    lblFoto.setIcon(scaledIcon);
                } else {
                    // Handle the case where the Blob field is null (no image)
                    lblFoto.setIcon(null);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception appropriately in your application
            }
        } else if (obj instanceof ImageIcon) {
            // Handle ImageIcon data
            ImageIcon icon = (ImageIcon) obj;
            lblFoto.setIcon(icon);
        } else {
            // Handle other cases or log a warning
            System.out.println("Unexpected data type in column 4: " + obj.getClass().getName());
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCariActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jButtonCariActionPerformed

    private void txUmurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUmurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUmurActionPerformed

    private void txNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNimActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCari;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txAlamat;
    private javax.swing.JTextField txNama;
    private javax.swing.JTextField txNim;
    private javax.swing.JTextField txUmur;
    // End of variables declaration//GEN-END:variables

public String getImagePath() {
        // Assuming you have a JFileChooser for image selection
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();

        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        } else {
            return null;
        }
    }

    public String getPath2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // This method is called to get the renderer for each cell in the JTable

        // Check if the value is an ImageIcon
        if (value instanceof ImageIcon) {
            // Set the icon to the JLabel for rendering
            setIcon((ImageIcon) value);
            setText(""); // Clear the text

            // Adjust other properties as needed
            setHorizontalAlignment(CENTER); // Center the icon
            setVerticalAlignment(CENTER);

            // You can customize more properties if necessary
        } else {
            // If the value is not an ImageIcon, use the default renderer
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

        return this;
    }
}
        public class MultiLineTableCellRenderer extends DefaultTableCellRenderer {
    private JTextArea textArea;

    public MultiLineTableCellRenderer() {
        this.textArea = new JTextArea();
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
    }
        }

}