/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class ValidasiForm {
    private String dialogTitle = "";
    private String dialogMessage = "";
    private boolean isValid = false;
    /**
     * Untuk mengatur judul kotak dialog
     * @param dialogTitle merupakan inputan yang nantinya menjadi judul kotak dialog
    */
    protected void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }
    /**
     * Untuk mengambil judul kotak dialog
     * @return dialogTitle yang merupakan judul itu sendiri
    */
    protected String getDialogTitle() {
        return dialogTitle;
    }
    /**
     * Untuk memasukkan value ke dalam dialogMessage
     * @param dialogMessage 
     */
    protected void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }
    /**
     * Untuk mendapatkan value dialogMessage 
     * @return dialogMessage yang merupakan isi pesan
    */
    protected String getDialogMessage() {
        return dialogMessage;
    }
    /**
     * Berfungsi sebagai setter dari variabel isValid
     * @param isValid 
     */
    protected void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    /**
     * Berfungsi sebagai getter dari variabel isValid
     * @return isValid
     */
    protected boolean getIsValid() {
        return isValid;
    }
    /**
     * Mengecek validitas dari value yang harus diisi
     * @param label
     * @param value
     * @return 
     */
    protected boolean isRequiredValid(String label, String value) {
        setIsValid(!value.equals(""));
        
        setDialogTitle(isValid ? "Sukses" : "Oops");
        setDialogMessage(isValid ? "" : label + " wajib diisi.");
        
        return isValid;
    }
    /**
     * Mengecek validitas dari angka
     * @param label
     * @param value
     * @return 
     */
    protected boolean isNumberValid(String label, String value) {
        Pattern pattern = Pattern.compile("[0-9]+");
        
        setIsValid(pattern.matcher(value).matches());
        
        setDialogTitle(isValid ? "Sukses" : "Oops");
        setDialogMessage(isValid ? "" : label + " wajib berupa angka.");
        
        return isValid;
    }
    /**
     * Mengecek apakah angka tersebut lebih dari nol
     * @param label
     * @param value
     * @return 
     */
    protected boolean isNumberMoreThanZero(String label, String value) {
        setIsValid(Integer.parseInt(value) > 0);
        
        setDialogTitle(isValid ? "Sukses" : "Oops");
        setDialogMessage(isValid ? "" : label + " jumlah tidak boleh nol atau minus.");
        
        return isValid;
    }
    /**
     * Berfungsi untuk menampilkan isi pesan dialog
     */
    protected void showMessageDialog() {
        JOptionPane.showMessageDialog(
            null,
            dialogMessage, 
            dialogTitle, 
            isValid ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
        );
    }
}
