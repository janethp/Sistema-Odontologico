/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.sql.*;
import java.sql.DriverManager;
        
public class conexionDB {
    Connection cn;    
    Statement st;
    
 public Connection conexion(){

    try{
Class.forName("com.mysql.jdbc.Driver");
cn = DriverManager.getConnection("jdbc:mysql://localhost/historias","root","yanet123");
System.out.println("Conexion establecida");
}catch(Exception e){
System.out.println(e.getMessage());
}return cn;
}
    
Statement createStatement(){
    throw new UnsupportedOperationException("No soportado");
}
}
