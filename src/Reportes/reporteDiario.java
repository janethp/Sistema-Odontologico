/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author yanet
 */
public class reporteDiario {
  
    private String cedula;
    private String nombre;
    private String apellido;
    private String tratamiento;
    private String hora;

    public reporteDiario(String cedula, String tratamiento, String hora) {
        this.cedula = cedula;
       
        this.tratamiento = tratamiento;
        this.hora = hora;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

}
