/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maria
 */
public class FormatTanggal {
    private Date tanggal;
    private String format;
    /**
     * Untuk mengisi tanggal yang akan diformat dan mengisi format yang akan digunakan
     * @param tanggal
     * @param format 
     */
    public FormatTanggal(Date tanggal, String format) {
        this.tanggal = tanggal;
        this.format = format;
    }
    /**
    * Untuk yang menyusun tanggal sesuai format tertentu.
    * @return simpleDateFormat.format(tanggal) yang merupakan fungsi dari library simpleDateFormat
    */
    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(tanggal);
    }
}
