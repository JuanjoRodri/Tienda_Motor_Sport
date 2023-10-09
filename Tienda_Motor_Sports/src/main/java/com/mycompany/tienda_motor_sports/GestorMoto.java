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
public class GestorMoto {
    
    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/tiendamotorsports";
    String user= "root";
    String pass="";
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public Moto leerMoto(String matricula){ //añadiremos los "filtros"

        Moto m= null;
        try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user,pass);
        
            
            String query ="select * FROM moto WHERE matricula=?"; //Aqui los where.
            ps=conn.prepareStatement(query);
            ps.setString(1, matricula);
            rs=ps.executeQuery();
            while(rs.next()){
                m = new Moto();
                m.setAnyo(rs.getInt(1));
                m.setColor(rs.getString(2));
                m.setId_cliente(rs.getInt(3));
                m.setId_moto(rs.getInt(4));
                m.setMarca(rs.getString(5));
                m.setMatricula(rs.getString(6));
                m.setModelo(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorMoto.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
    }return m;
      
    }
    public void actualizarMoto(int anyo,String color, String marca, String matricula, String modelo){
        
        try{
                Class.forName(driver);
                conn=DriverManager.getConnection(url,user,pass);
                conn.createStatement();
                ps=conn.prepareStatement("UPDATE moto set anyo=?, color=?, marca=?, modelo=? Where matricula=?");
                ps.setInt(1, anyo);
                ps.setString(2, color);
                //ps.setInt(3,id_cliente);
                ps.setString(3, marca);
                ps.setString(5, matricula);
                ps.setString(4, modelo);

                //ps.setInt(7, id_moto);
                ps.executeUpdate();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
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
    public void borrarMoto(int id){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("DELETE FROM moto where id_moto="+id);
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
    public void crearMoto(String anyo,String color, String marca, String matricula, String modelo){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("INSERT INTO moto (anyo,color,marca,matricula,modelo,id_cliente) VALUES (?, ?,?,?, ?,0);");
            ps.setString(1, anyo);
            ps.setString(2, color);
            ps.setString(3,marca);
            ps.setString(4, matricula);
            ps.setString(5,modelo);
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
     public Moto leerMotoID(int id){ //añadiremos los "filtros"

        Moto m= null;
        try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user,pass);
        
            
            String query ="select * FROM moto WHERE id_moto=?"; //Aqui los where.
            ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                m = new Moto();
                m.setAnyo(rs.getInt(1));
                m.setColor(rs.getString(2));
                m.setId_cliente(rs.getInt(3));
                m.setId_moto(rs.getInt(4));
                m.setMarca(rs.getString(5));
                m.setMatricula(rs.getString(6));
                m.setModelo(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorMoto.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
    }return m;
      
    }
     public void actualizarMotoCliente(int anyo,String color, String marca, String matricula, String modelo, int idCliente){
        
        try{
                Class.forName(driver);
                conn=DriverManager.getConnection(url,user,pass);
                conn.createStatement();
                ps=conn.prepareStatement("UPDATE moto set anyo=?, color=?, marca=?, modelo=?,id_cliente=? Where matricula=?");
                ps.setInt(1, anyo);
                ps.setString(2, color);
                //ps.setInt(3,id_cliente);
                ps.setString(3, marca);
                ps.setString(6, matricula);
                ps.setString(4, modelo);
                ps.setInt(5, idCliente);
                //ps.setInt(7, id_moto);
                ps.executeUpdate();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
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
