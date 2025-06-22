/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crud;

/**
 *
 * @author USER
 */
public interface LoginDatabaseInterface {
    public String cekLogin(String userID, String password);
    public void Logout(String userID);
    
}
