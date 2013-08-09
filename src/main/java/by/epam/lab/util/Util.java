/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.util;

import java.io.File;

/**
 *
 * @author Alina_Shumel
 */
public class Util {

    public static String substringAfter(String text, String string, int length) {
        int position = text.indexOf(string);
        position += string.length() + 1;
        String code = text.substring(position, position + length);
        return code;

    }

    public static String getFormatSize(File file) {
        long sizeinbytes = file.length();
        long size = (long) Math.ceil(sizeinbytes / 1024.0);
        StringBuilder size_str = new StringBuilder();
        size_str.append("(");
        String _size = String.valueOf(size);
        if (size > 999) {
            size_str.append(_size.substring(0, 1));
            size_str.append(",");
            size_str.append(_size.substring(1, _size.length()));
        } else {
            size_str.append(_size);
        }
        size_str.append("K)");
        return size_str.toString();
    }
}
