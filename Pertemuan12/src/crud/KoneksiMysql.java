/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class KoneksiMysql {
    
    private Connection connect;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost";
    private String port = "3306";
    private String database = "crud22110337";
    private String url = jdbc + host + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC";
    private String username = "root";
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
                    throw se;
                }
            }catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : "+ cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
    
}
