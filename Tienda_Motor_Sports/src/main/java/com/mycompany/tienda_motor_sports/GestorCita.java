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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanj
 */
public class GestorCita {
    
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/tiendamotorsports";
    String user= "root";
    String pass="";
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
 
    public Cita leerCita(String Dni){ //añadiremos los "filtros"

        Cita c= null;
        try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user,pass);
        
            
            String query ="select * FROM cita WHERE DNI=?"; //Aqui los where.
            ps=conn.prepareStatement(query);
            ps.setString(1, Dni);
            rs=ps.executeQuery();
            while(rs.next()){
                c = new Cita();
                c.setDescripcion(rs.getString(1));
                c.setFecha(rs.getDate(2));
                c.setHora(rs.getString(3));
                c.setId_cita(rs.getInt(4));
                c.setId_moto(rs.getInt(5));
                c.setId_taller(rs.getInt(6));
                c.setDni(rs.getString(7));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorCita.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
    }return c;
      
    }
    
    public void actualizarCita(String descripcion,Date fecha, String hora,String dni){
        
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
        

        
            
                
            conn.createStatement();
            ps=conn.prepareStatement("UPDATE cita set descripcion=?, fecha=?, hora=? Where DNI=?");
            ps.setString(1, descripcion);
            ps.setDate(2, new java.sql.Date(fecha.getTime()));
            ps.setString(3,hora);
            ps.setString(4, dni);
            

            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
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
    
    public void borrarCita(int id){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("UPDATE cita set Borrada=1 Where id_cita=?");
            //ps.setInt(1, 1);
            ps.setInt(1, id);
            
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
    public void crearCita(String descripcion,Date fecha, String hora, int id_moto,String dni){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("INSERT INTO cita (descripcion,fecha,hora,id_moto,id_taller,DNI,Borrada) VALUES (?, ?, ?, ?,1,?,0);");
            ps.setString(1, descripcion);
            ps.setDate(2, new java.sql.Date(fecha.getTime()));
            ps.setString(3, hora); 
            ps.setInt(4, id_moto);
            ps.setString(5, dni);
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
    public Cita leerCitaPorIdTaller(int id){ //añadiremos los "filtros"

        Cita c= null;
        try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user,pass);
        
            
            String query ="select * FROM cita WHERE id_cita= ?"; //Aqui los where.
            ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                c = new Cita();
                c.setDescripcion(rs.getString(1));
                c.setFecha(rs.getDate(2));
                c.setHora(rs.getString(3));
                c.setId_cita(rs.getInt(4));
                c.setId_moto(rs.getInt(5));
                c.setId_taller(rs.getInt(6));
                c.setDni(rs.getString(7));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorCita.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
    }return c;
      
    }
    
}
