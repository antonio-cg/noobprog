/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Lexico;

import Ex.PalabraReservada;
import Ex.ValorTipoInvalido;
import Ex.VariableDeclarada;
import Ex.VariableInvalida;
import Ex.tipoInvalido;
import java.io.IOException;
import noobprog.Sintactico.Sintactico;
import noobprog.Utils.Tokenizador;
import noobprog.Utils.Utils;
import noobprog.Utils.tablaSimbolos;



/**
 *
 * @author antoniocg
 */
public class Declaracion {
    public static final String ANSI_BOLD = "\033[1m";
     public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static boolean declarar(String s) throws tipoInvalido, PalabraReservada, VariableInvalida, VariableDeclarada
    {
        
        String[] tks = Utils.getTokens(s);
        
        if(!tipos.esTipoValido(tks[3]))
        {
            throw new tipoInvalido(tks[3]);
            
        }
        else if(PalRes.esPaReservada(tks[1]))
        {
            throw new PalabraReservada(tks[1]);
        }
        else if(!esVarValida(tks[1]))
        {
            throw new VariableInvalida(tks[1]);
        }
        else if(tablaSimbolos.getObj().estaDeclarada(tks[1]))
        {
            throw new VariableDeclarada(tks[1]);
        }
        else
        {
        tablaSimbolos.getObj().insertaSimbolo(tks[1],tks[3],null);
           System.out.println("declarada" + tks[1]);
        return true;
        }
    }
    //Declara <variable> como <tipo> = 100
    public static boolean declararYAsignar(String s) throws tipoInvalido, PalabraReservada, VariableInvalida, VariableDeclarada, ValorTipoInvalido, IOException
    {
        
        String[] tks = Utils.getTokens(s);
        System.out.println("deckara y asigna"+tks[5]);
        if(!tipos.esTipoValido(tks[3]))
        {
            throw new tipoInvalido(tks[3]);
        }
        else if(PalRes.esPaReservada(tks[1]))
        {
            throw new PalabraReservada(tks[1]);
        }
        else if(!esVarValida(tks[1]))
        {
            throw new VariableInvalida(tks[1]);
        }
        else if(tablaSimbolos.getObj().estaDeclarada(tks[1]))
        {
            throw new VariableDeclarada(tks[1]);
        }
        else if(!Asignacion.AsignacionValida(tks[3], tks[5]) && !tks[5].matches("[\\d|+|-|*|/|\\(|\\)]*")) 
        {
            throw new ValorTipoInvalido(tks[1],tks[3],tks[5]);
        }
        else
        {   
            //enviamos al analizador matematico
            Sintactico e = new Sintactico();
            tks[5]=tks[5]+"$";
            String[] tokens = Tokenizador.tokenize(tks[5]);
            //si hay alguna matematica
            if(tks[5].matches("^[\\d|+|-|*|/|\\(|\\)|$]*"))
            {
                System.out.println("es una expresion matematica");
                for(int i=0;i<tokens.length;i++)
            {
                System.out.println(tokens[i]);
                //si el string es un numero
                if(tokens[i].matches("-?\\d+(\\.\\d+)?"))
                {
                    Double parse = Double.parseDouble(tokens[i]);
                    tokens[i] = tablaSimbolos.getObj().insertaNum(parse);
                    
                    
                }else if(tokens[i].matches("\\w*") && !tokens[i].matches("and|or|\\!"))//es una palabra por lo cual buscamos si esta declarada
                {
                   
                    if(!tablaSimbolos.getObj().estaDeclarada(tokens[i]))
                    {
                        System.out.println(ANSI_RED+"La variable " + tokens[i] + " no esta declarada"+ANSI_RESET);
                        return false;
                    }
                    else
                    {
                        //obtenemos el id de la variable
                        tokens[i]=tablaSimbolos.getObj().getId(tokens[i]);
                    }
                }
            }
                //dejamos los id para poder resolverlo en el momento
//            for(int i=0;i<tokens.length;i++)//quitamos los id para dejarlos limpios
//            {
//                if(tokens[i].matches("id[0-9]*"))
//                {
//                    tokens[i] = tokens[i].replaceAll("(id)[0-9]*", "$1");
//                }
//            }
                
                String res = e.algoritmoMat(e.getGmatematica(),e.getMatematica(),tokens);
                if(res != null)
                {
                    
                    System.out.println(ANSI_GREEN+"el analisis matematico es correcto"+tks[5]+ANSI_RESET);
                    tablaSimbolos.getObj().insertaSimbolo(tks[1],tks[3],Double.parseDouble(res));
                    
                }
                else
                {
                    System.out.println(ANSI_RED+"El analisis matematico es incorrecto"+tks[5]+ANSI_RESET);
                }
            }
            else
            {
                tablaSimbolos.getObj().insertaSimbolo(tks[1],tks[3],Double.parseDouble(tks[5]));
                System.out.println("declarada" + tks[1]);
            }
       
        } 
        return true;
        
    }
    
    
    /**
     * Declaracion pepe como bool = 10
     * @param s
     * @return 
     */
    public static boolean esVarValida(String s)
    {
        return s.matches("[A-Z|a-z][A-Za-z0-9]*");
    }
    
    public static boolean esDeclaracionCorrecta(String s)
    {
        return s.matches("como");
    }
    
    public static boolean esCadenaValida(String s)
    {
        return s.matches("^.*");
    }
    
     public static boolean esNumValida(String s)
    {
        return s.matches("[0-9]*\\.?[0-9]*");
    }
     
    
     
    
     
     
    
}

