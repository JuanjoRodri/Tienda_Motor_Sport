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
public class GestorCliente{

    String driver ="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/tiendamotorsports";
    String user= "root";
    String pass="";
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
   
    public Cliente leerCliente(String dniCliente){ //añadiremos los "filtros"
        String dni=dniCliente;
        Cliente c= null;
        try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user,pass);
        
            
            String query ="select * FROM clientes WHERE dni=?"; //Aqui los where.
            ps=conn.prepareStatement(query);
            ps.setString(1, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setApellidoUno(rs.getString(1));
                c.setApellidoDos(rs.getString(2));   
                c.setDNI(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setId(rs.getInt(5));
                c.setMatricula(rs.getString(6));
                c.setNombre(rs.getString(7));
                c.setTelefono(rs.getInt(8));
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException e){
        e.printStackTrace();
    }return c;
      
    }
    
    public void actualizarCliente(String apellidoUno,String apellidoDos,String dni,String email, String nombre, int telefono){
        
        try{
                Class.forName(driver);
                conn=DriverManager.getConnection(url,user,pass);
  
                conn.createStatement();
                ps=conn.prepareStatement("UPDATE clientes set Apellido_Uno=?, apellido_Dos=?, email=?, nombre=?, telefono=? WHERE dni=?");
                ps.setString(1, apellidoUno);
                ps.setString(2, apellidoDos);

                ps.setString(3,email);
                ps.setString(4,nombre);
                ps.setInt(5, telefono);        
                ps.setString(6,dni);
               // ps.setString(7, matricula);
                


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
    
    public void borrarCliente(int id){
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("DELETE FROM clientes WHERE id_cliente="+id);
            ps.executeUpdate();
            System.out.println("Cliente borrado con exito");
            
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
    public boolean crearCliente(String apellidoUno,String apellidoDos,String dni,String email, String nombre, int telefono){
  
        try{
            
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            conn.createStatement();
            
            ps=conn.prepareStatement("INSERT INTO clientes (Apellido_Uno,apellido_Dos,dni,email,matricula,nombre,telefono) VALUES (?, ?, ?, ?, NULL, ?, ?);");
            ps.setString(1, apellidoUno);
            ps.setString(2, apellidoDos);
            ps.setString(3, dni);
            ps.setString(4,email);
            ps.setString(5, nombre);
            ps.setInt(6, telefono);
            ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(ClassNotFoundException e){      
            e.printStackTrace(); 
            return false;  
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException ex){
                    
            }
        } return true;       
    } 
    public void actualizarClienteMatricula(String apellidoUno,String apellidoDos,String dni,String email, String nombre, int telefono,String matricula){
        
        try{
                Class.forName(driver);
                conn=DriverManager.getConnection(url,user,pass);
  
                conn.createStatement();
                ps=conn.prepareStatement("UPDATE clientes set Apellido_Uno=?, apellido_Dos=?, email=?, nombre=?,matricula=?, telefono=? WHERE dni=?");
                ps.setString(1, apellidoUno);
                ps.setString(2, apellidoDos);

                ps.setString(3,email);
                ps.setString(4,nombre);
                ps.setInt(6, telefono);        
                ps.setString(7,dni);
                ps.setString(5, matricula);
                


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