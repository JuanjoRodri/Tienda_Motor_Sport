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
public class Cita {


    String dni;
    String Descripcion;
    Date Fecha;
    String Hora;
    int id_cita;
    int id_moto;
    int id_taller;
    int borrada;

    public int getBorrada() {
        return borrada;
    }

    public void setBorrada(int borrada) {
        this.borrada = borrada;
    }
    
        public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
        

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_moto() {
        return id_moto;
    }

    public void setId_moto(int id_moto) {
        this.id_moto = id_moto;
    }

    public int getId_taller() {
        return id_taller;
    }

    public void setId_taller(int id_taller) {
        this.id_taller = id_taller;
    }

}
