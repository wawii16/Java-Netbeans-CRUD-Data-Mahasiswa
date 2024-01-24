/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author dwiie
 */
import java.awt.Image;
import javax.swing.*;
import java.io.InputStream;
import java.sql.Blob;

public class mahasiswa {
    private String nim;
    private String nama;
    private String alamat;
    private String umur;
    private Blob imageData;

    public mahasiswa(String nim, String nama, String alamat, String umur, Blob imageData) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
        this.imageData = imageData;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public Blob getImageData() {
        return imageData;
    }

    public void setImageData(Blob imageData) {
        this.imageData = imageData;
    }

    public ImageIcon getImageIcon() {
        if (imageData != null) {
            try {
                // Convert Blob to byte array
                byte[] bytes = imageData.getBytes(1, (int) imageData.length());

                // Convert byte array to Image
                ImageIcon originalIcon = new ImageIcon(bytes);

                // Scale the image to the desired size using SCALE_SMOOTH
                Image originalImage = originalIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                // Create a new ImageIcon from the scaled image
                return new ImageIcon(scaledImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
}
