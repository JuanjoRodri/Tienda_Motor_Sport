/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda_motor_sports;

import java.util.Date;

/**
 *
 * @author juanj
 */
public class ComprobacionDatosCliente {
    
    
    
   public boolean PrimerFiltro(String nombre,String apellidoUno,String apellidoDos){
        boolean todobien=false;

        Boolean nombreComprobado = ComprobarPalabra(nombre);
        Boolean apellidoUnoComprobado = ComprobarPalabra(apellidoUno);
        Boolean apellidoDosComprobado = ComprobarPalabra(apellidoDos);
        if(nombreComprobado.equals(true) & apellidoUnoComprobado.equals(true) & apellidoDosComprobado.equals(true)){
        todobien=true;
        }else{
            todobien=false;
        }
        return todobien;
    }
    
     public boolean ComprobarPalabra(String nombre){
        boolean nombrepaso=true;
        boolean sololetras=false;
        boolean total=false;
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (c >='0' && c <='9'){
                nombrepaso=false;
            }else if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == ' ')||( c == 'ª'))){
                sololetras=true;
            }else{
                sololetras=false;
                nombrepaso=false;
            }
        }
        total=nombrepaso & sololetras;
        return total;
    }
     public boolean ComprobarDni(String dni){
          boolean dnicomprobar=false;
          GestorCliente cliente= new GestorCliente();
          Cliente c = cliente.leerCliente(dni);
          try{
              if(c.getDNI().equals(dni)){
              dnicomprobar=true;
              }
            }catch(Exception e){
              dnicomprobar=false;
            }
          
          
         return dnicomprobar;
     }
     public boolean HoraYMinutosCorrectos(int hora, int minutos){
         boolean total= false;
         boolean horasBien=false;
         if (hora >= 0 && hora <= 24){
             horasBien=true;
         }else{
             horasBien=false;
         }
         
         boolean minutosBien=false;
         if (minutos >= 0 && minutos <= 59){
             minutosBien=true;
         }else{
             minutosBien=false;
         }
         total=horasBien && minutosBien;
         return total;
     }
     
     

     
}
