/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author danas
 */

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropretiesGetter {
    public String getProperties(String name) {
        String value = null;
        InputStream inputStream;

        try {
            Properties prop = new Properties();
            String Nome_Ficheiro_Prop = "InfoBD.properties";
            inputStream = getClass().getResourceAsStream(Nome_Ficheiro_Prop);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("file '" + Nome_Ficheiro_Prop + "' not found");
            }

            value = prop.getProperty(name);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return value;
    }
}
