package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dwiie
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MahasiswaModel;
import view.viewCRUD;


public class MahasiswaController {

    private MahasiswaModel model;
    private viewCRUD view;

    public MahasiswaController(MahasiswaModel model, viewCRUD view) {
        this.model = model;
        this.view = view;

        // Add action listeners to the view components
        view.getBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
            }
        });

        view.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed(e);
            }
        });

        view.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButtonActionPerformed(e);
            }
        });

        view.getBtnCancel1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });

        view.getjButtonUpload().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadButtonActionPerformed(e);
            }
        });

        view.getjButtonCari().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cariButtonActionPerformed(e);
            }
        });

        // Other listeners as needed...
    }
    

    private void saveButtonActionPerformed(ActionEvent evt) {
        // Extract data from the view and call model to save data
        // Use view.getXXX() to get values from the view components
        String nim = view.getTxNim().getText();
        String nama = view.getTxNama().getText();
        String alamat = view.getTxAlamat().getText();
        String umur = view.getTxUmur().getText();
        String path = view.getPath2();  
        model.saveData(nim, nama, alamat, umur, path, view);
    }

    private void editButtonActionPerformed(ActionEvent evt) {
        // Extract data from the view and call model to update data
        // Use view.getXXX() to get values from the view components
        String nim = view.getTxNim().getText();
        String nama = view.getTxNama().getText();
        String alamat = view.getTxAlamat().getText();
        String umur = view.getTxUmur().getText();
        String path = view.getPath2();
        model.updateData(nim, nama, alamat, umur, path, view);
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        // Call model to clear data and update view
        model.clear(view);
        model.loadData(view.getTableModel(), view.getjTextCari().getText());
        view.getBtnSimpan().setEnabled(true);
        model.autonumber(view);
    }

    private void deleteButtonActionPerformed(ActionEvent evt) {
        // Call model to delete data and update view
        int selectedRow = view.getjTable1().getSelectedRow();
        model.deleteData(selectedRow, view.getTableModel(), view);
    }

    private void uploadButtonActionPerformed(ActionEvent evt) {
 
    }

    private void cariButtonActionPerformed(ActionEvent evt) {
        // Call model to load data based on search criteria
        model.loadData(view.getTableModel(), view.getjTextCari().getText());
    }

    // Other methods as needed...
}

