
package com.raizcampesina.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
    {
        private static final String URL = "jdbc:mysql://localhost:3306/raiz_campesina";
        private static final String USER = "root";
        private static final String PASSWORD = "Qwertyuiop!0";
        
        public static Connection conectar() throws SQLException
            {
                return DriverManager.getConnection (URL, USER, PASSWORD);
            }
    }