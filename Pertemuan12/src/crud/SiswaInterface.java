/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crud;

import java.sql.ResultSet;

public interface SiswaInterface {
    public String simpanData(String id, String nama, String alamat);
    public String ubahData(String id, String nama, String alamat);
    public String hapusData(String id);
    public ResultSet tampilData();
    public ResultSet cariData(String keyword);
}
