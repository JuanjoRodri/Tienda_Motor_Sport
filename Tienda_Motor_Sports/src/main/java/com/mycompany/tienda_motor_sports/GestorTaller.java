/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda_motor_sports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanj
 */
public class GestorTaller {
    
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/tiendamotorsports";
    String user= "root";
    String pass="";
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public Taller leerTaller(String id_taller){
        
        Taller t=new Taller();
        
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            
            String query = "select * FROM taller WHERE id_taller="+id_taller;
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                t = new Taller();
                t.setId_taller(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setDireccion(rs.getString(3));
                t.setTelefono(rs.getInt(4));
                t.setCorreo(rs.getString(5));
            }    
        }catch (SQLException ex) {
            Logger.getLogger(GestorTaller.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }
        return t;   
    }
    public void actualizarTaller(int id_taller,String nombre,String direccion, int telefono, String correo){
        try{
                Class.forName(driver);
                conn=DriverManager.getConnection(url,user,pass);
        
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
             e.printStackTrace();
        
            try{
                
                conn.createStatement();
                ps=conn.prepareStatement("UPDATE taller set nombre=?, direccion=?, telefono=?, correo=? Where id_taller=?");
                ps.setString(1, nombre);
                ps.setString(2, direccion);
                ps.setInt(3,telefono);
                ps.setString(4, correo);
                ps.setInt(4, id_taller);

                ps.executeUpdate();
            }catch(SQLException ex){
                e.printStackTrace();
            }finally{
                try{
                    if(conn!=null){
                        conn.close();
                    }
                }catch(SQLException ex){
                    
                }
            }        
        } 
    } 
    public void borrarTaller(int id){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("DELETE FROM taller where id_tallet="+id);
            ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();   
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException ex){
                    
            }
        }
    }
    public void crearTaller(String nombre, String direccion, int telefono, String correo){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("INSERT INTO Taller ( nombre, direccion, telefono, correo) VALUES ( ?, ?, ?, ?);");
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono); 
            ps.setString(4, correo);
            ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();   
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException ex){
                    
            }
        }        
    }
}
