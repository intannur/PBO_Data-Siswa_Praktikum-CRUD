/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{ // Form_Siswa form = new Form_Siswa ();
        FormLogin form = new FormLogin();
        form.setVisible(true);
        }catch(Exception ex){
        System.out.println(ex.toString());
        }
    }
    
}
