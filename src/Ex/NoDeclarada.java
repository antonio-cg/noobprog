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
public class NoDeclarada extends Exception {
    
    public NoDeclarada (String M)
    {
        System.out.println("Error: la variable "+M+" no esta declarada" );
    }
    
}
