/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_logica;

import java.util.Scanner;

/**
 *
 * @author Aaron Rojas Vera
 */
public class Encuesta {
    private String nombre;
    private int atencionCliente;
    private int rapidez;
    private int instalaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtencionCliente() {
        return atencionCliente;
    }

    public void setAtencionCliente(int atencionCliente) {
        this.atencionCliente = atencionCliente;
    }

    public int getRapidez() {
        return rapidez;
    }

    public void setRapidez(int rapidez) {
        this.rapidez = rapidez;
    }

    public int getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(int instalaciones) {
        this.instalaciones = instalaciones;
    }
    
    public void leer(){
        Scanner leer = new Scanner(System.in);
        
        System.out.print("Ingrese nombre: ");
        nombre = leer.next();
        
        System.out.println(" PREGUNTAS");
        System.out.println("+ Atencion al cliente:");
        System.out.println("1. Satisfecho - 2. Indiferente - 3. Insatisfecho");
        do{
            atencionCliente = leer.nextInt();
            if(atencionCliente < 1 || atencionCliente > 3){
                System.out.println("\tERROR: respuest incorrecta");
            }
        }while(atencionCliente < 1 || atencionCliente > 3);
        System.out.println("+ Rapidez");
        System.out.println("1. Satisfecho - 2. Indiferente - 3. Insatisfecho");
        do{
            rapidez = leer.nextInt();
            if(rapidez < 1 || rapidez > 3){
                System.out.println("\tERROR: respuest incorrecta");
            }
        }while(rapidez < 1 || rapidez > 3);
        System.out.println("+ Instalaciones");
        System.out.println("1. Satisfecho - 2. Indiferente - 3. Insatisfecho");
        do{
            instalaciones = leer.nextInt();
            if(instalaciones < 1 || instalaciones > 3){
                System.out.println("\tERROR: respuest incorrecta");
            }
        }while(instalaciones < 1 || instalaciones > 3);
    }
}
