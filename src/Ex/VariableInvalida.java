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
public class VariableInvalida extends Exception {
    
    public VariableInvalida(String M)
    {
        System.out.println("El nombre de la variable "+M+" es Invalida" );
    }
}

