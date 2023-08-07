/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package root.model;

/**
 *
 * @author victor
 */

/**
 *
 * @author victor
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author victor
 */
public class model {
    
    public long getidentidad(String ident) {
    LocalDate identificacion = LocalDate.parse(ident);
    long identidad = ChronoUnit.YEARS.between(identificacion, LocalDate.now());
    return identidad;
    }

    public long getnombre(String identidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    }
    


    

    


    
    

    

