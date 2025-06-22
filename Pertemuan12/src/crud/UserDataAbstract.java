package crud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public abstract class UserDataAbstract {
    protected String userID;
    protected String password;

    public abstract void setUserID(String userID);
    public abstract String getUserID();

    public abstract void setPassword(String password);
    public abstract String getPassword();
}
