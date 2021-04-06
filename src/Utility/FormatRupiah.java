/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author User
 */
public class FormatRupiah {
    public String kurensi(long uang) {
        NumberFormat kurensiIndonesia = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        return kurensiIndonesia.format(uang);
    }
}
