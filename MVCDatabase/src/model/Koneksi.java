/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.DriverManager;

/**
 *
 * @author dwiie
 */
class Koneksi {
            private static java.sql.Connection koneksi;
    
   
    public static java.sql.Connection getKoneksi(){
        if (koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:3306/PBO";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil Terhubung");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return koneksi;
    }
    public static void main(String args[]){
        getKoneksi();
    } 
}
