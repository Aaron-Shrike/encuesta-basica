/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_presentacion;

import cap_logica.Encuesta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Aaron Rojas Vera
 */
public class Rojas01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Encuesta> encuestas = new ArrayList<>();
        
        int op;
        
        do{
            op = menu();
             
            switch(op){
                case 1: registrarEncuesta(encuestas);
                    break;
                case 2: resultadosPorcentajes(encuestas);
                    break;
                case 3: mayorSatisfaccion(encuestas);
                    break;
            }
        }while(op != 4);
    }
    
    private static int menu() {
        Scanner leer = new Scanner(System.in);
        
        int opcion;
        
        System.out.println("\n\n");
        System.out.println("---------- MENU ---------- ");
        System.out.println("[1] Registrar Encuesta");
        System.out.println("[2] Mostrar los resultados de cada pregunta expresados en porcetajes");
        System.out.println("[3] Indicar cual de las 3 preguntas tuvo mayor satisfaccion");
        System.out.println("[4] Salir");      
        
        do{
            System.out.print("  Ingrese Opcion: ");
            opcion = leer.nextInt();
        }while(opcion < 1 || opcion > 4);
        
        return opcion;
    }

    private static void registrarEncuesta(ArrayList<Encuesta> auxList) {
        Encuesta encu = new Encuesta();
        
        encu.leer();
        
        auxList.add(encu);
        
        System.out.println("\n * Encuesta registrada exitosamente");
    }

    private static void resultadosPorcentajes(ArrayList<Encuesta> auxList) {
        Iterator<Encuesta> elemento;
        
        int pregunta1[] = {0,0,0}, pregunta2[] = {0,0,0}, pregunta3[] = {0,0,0};  
        
        if(!auxList.isEmpty()){
        
            elemento = auxList.iterator();
            
            while(elemento.hasNext()){
                Encuesta e = elemento.next();
                                 
                if(e.getAtencionCliente() == 1){
                    pregunta1[0]++;
                }
                if(e.getAtencionCliente() == 2){
                    pregunta1[1]++;
                }
                if(e.getAtencionCliente() == 3){
                    pregunta1[2]++;
                }
                
                if(e.getRapidez() == 1){
                    pregunta2[0]++;
                }
                if(e.getRapidez() == 2){
                    pregunta2[1]++;
                }
                if(e.getRapidez() == 3){
                    pregunta2[2]++;
                }
                
                if(e.getInstalaciones()== 1){
                    pregunta3[0]++;
                }
                if(e.getInstalaciones() == 2){
                    pregunta3[1]++;
                }
                if(e.getInstalaciones() == 3){
                    pregunta3[2]++;
                }
            }
            
            int total1 = pregunta1[0]+pregunta1[1]+pregunta1[2];
            int total2 = pregunta2[0]+pregunta2[1]+pregunta2[2];
            int total3 = pregunta3[0]+pregunta3[1]+pregunta3[2];
            
            System.out.println("\n-- PREGUNTA 01 --");
            System.out.println("+ Satisfecho: " + (pregunta1[0]*100)/total1 + "%");
            System.out.println("+ Indiferente: " + (pregunta1[1]*100)/total1 + "%");
            System.out.println("+ Insatisfecho: " + (pregunta1[2]*100)/total1 + "%");
            
            System.out.println("\n-- PREGUNTA 02 --");
            System.out.println("+ Satisfecho: " + (pregunta2[0]*100)/total2 + "%");
            System.out.println("+ Indiferente: " + (pregunta2[1]*100)/total2 + "%");
            System.out.println("+ Insatisfecho: " + (pregunta2[2]*100)/total2 + "%");
            
            System.out.println("\n-- PREGUNTA 03 --");
            System.out.println("+ Satisfecho: " + (pregunta3[0]*100)/total3 + "%");
            System.out.println("+ Indiferente: " + (pregunta3[1]*100)/total3 + "%");
            System.out.println("+ Insatisfecho: " + (pregunta3[2]*100)/total3 + "%");
        }
    }

    private static void mayorSatisfaccion(ArrayList<Encuesta> auxList) {
        Iterator<Encuesta> elemento;
        
        int pregunta1 = 0, pregunta2 = 0, pregunta3 = 0;  
        
        if(!auxList.isEmpty()){
        
            elemento = auxList.iterator();
            
            while(elemento.hasNext()){
                Encuesta e = elemento.next();
                                 
                if(e.getAtencionCliente() == 1){
                    pregunta1++;
                }
                
                if(e.getRapidez() == 1){
                    pregunta2++;
                }
                
                if(e.getInstalaciones()== 1){
                    pregunta3++;
                }
            }
            
            int total = pregunta1 + pregunta2 + pregunta3;
            
            System.out.println("\n -- PREGUNTA CON MAYOR SATISFACCION -- ");
            
            if(pregunta1 > pregunta2 &&  pregunta1 > pregunta3){
                System.out.println("1. Atencion al cliente: " + (pregunta1*100)/total + "%");
            }
            if(pregunta2 > pregunta1 &&  pregunta2 > pregunta3){
                System.out.println("2. Rapidez: " + (pregunta2*100)/total + "%");
            }
            if(pregunta3 > pregunta1 &&  pregunta3 > pregunta2){
                System.out.println("3. Instalaciones: " + (pregunta3*100)/total + "%");
            }
        }
    }
    
}
