/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda_motor_sports;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author juanj
 */
public class AccesoDocProperties {
    
    //poner el directorio a partir del SRC
    private static final String FICHERO_CONFIGURACION ="src/main/java/com/mycompany/tiendamotorsports/config.properties";
    
    //Valores por defecto
    private static final String DRIVER_VALOR_DEFECTO = "com.mysql.cj.jdbc.Driver";
    private static final String URL_VALOR_DEFECTO = "jdbc:mysql://localhost:3306/tiendamotorsports";
    private static final String USER_VALOR_DEFECTO = "root";
    private static final String PASS_VALOR_DEFECTO = "";
    
    //Claves para leer
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASS = "pass";
    
    private Properties configuracion;
    
    private void cargar() {
		
		configuracion = new Properties();
		
		File file = new File(FICHERO_CONFIGURACION);
		
		try (FileReader configReader = new FileReader(file)) {
            configuracion.load(configReader);
        } catch(IOException e) {
            //Do nothing
        }
    }
    private String getValor(String clave) {
                       
        return (configuracion.getProperty(clave));
        
    }
    public String getDriver() {
        try {
            return getValor(DRIVER);
        } catch(Exception e) {
        	System.out.println(e);
            return DRIVER_VALOR_DEFECTO ;
            
        }
    }
    public String getUrl() {
        try {
            return getValor(URL);
        } catch(Exception e) {
            return URL_VALOR_DEFECTO ;
        }
    }
    public String getUser() {
        try {
            return getValor(USER);
        } catch(Exception e) {
            return USER_VALOR_DEFECTO ;
        }
    }
    public String getPass() {
        try {
            return getValor(PASS);
        } catch(Exception e) {
            return PASS_VALOR_DEFECTO ;
        }
    }
}
