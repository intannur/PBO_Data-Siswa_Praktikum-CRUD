/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class CRUD extends SiswaAbstract implements SiswaInterface {
    private String id, nama, alamat;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUD(){
        try { KoneksiMysql connection = new KoneksiMysql();
        CRUDkoneksi = connection.getKoneksi();
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    @Override
    public void setID(String id){
        this.id = id;
    }
    
    @Override
    public String getID(){
        return id;
    }
    
    @Override 
    public void setNama(String nama){
        this.nama = nama;
    }
    
    @Override
    public String getNama(){
        return nama;
    }
    
    @Override
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    @Override
    public String getAlamat(){
        return alamat;
    }
    
    @Override
    public ResultSet tampilData(){
        CRUDquery = "select * from siswa";
        try{
            CRUDstat  = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    @Override
    public String simpanData(String id, String nama, String alamat){
        CRUDquery = "insert into siswa values (?,?,?)";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, alamat);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    @Override
    public String ubahData(String id, String nama, String alamat){
        CRUDquery = "update siswa set nama=?, alamat=? where id=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, alamat);
            CRUDpsmt.setString(3, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
            return "Data berhasil  diubah.";
        }catch (Exception e){
            return  "Gagal mengubah data: " + e.getMessage();
        }
    }

    @Override
    public String hapusData(String id){
        CRUDquery = "delete from siswa where id=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
            return "Data berhasil  dihapus.";
        }catch (Exception e){
            return "Gagal menghapus data: " + e.getMessage();
        }
    }
    
    @Override
    public ResultSet cariData(String keyword) {
    CRUDquery = "SELECT * FROM siswa WHERE id LIKE ? OR nama LIKE ?";
    try {
        CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
        CRUDpsmt.setString(1, "%" + keyword + "%");
        CRUDpsmt.setString(2, "%" + keyword + "%");
        CRUDhasil = CRUDpsmt.executeQuery();
    } catch (Exception e) {
        System.out.println("Gagal mencari data: " + e.getMessage());
    }
    return CRUDhasil;
}
}
