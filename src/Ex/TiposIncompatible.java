/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex;

/**
 *
 * @author antoniocg
 */
public class TiposIncompatible extends Exception {
    
    public TiposIncompatible(String M,String N)
    {
        System.out.println("La variable " + M + " y " + N + " son de tipos incompatibles" );
    }
}