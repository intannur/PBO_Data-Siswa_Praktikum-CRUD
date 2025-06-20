/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class KoneksiPostgresql {
    
    private Connection connect;
    private String driverName = "org.postgresql.Driver";
    private String jdbc = "jdbc:postgresql://";
    private String host = "localhost://";
    private String port = "5432/";
    private String database = "crud22110337";
    private String url = jdbc + host + port + database;
    private String username = "postgres";
    private String password = "";
    public Connection getKoneksi() throws SQLException {
        if (connect == null){
            try{
                Class.forName(driverName);
                System.out.println("Class Driver Ditemukan");
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi  Database Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Databse Gagal : "+se);
                    System.exit(0);
                }
            }catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : "+ cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
    
}
