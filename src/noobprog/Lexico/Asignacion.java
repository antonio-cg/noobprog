/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Lexico;

import Ex.NoDeclarada;
import Ex.TiposIncompatible;
import Ex.ValorTipoInvalido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static noobprog.Lexico.Declaracion.ANSI_GREEN;
import static noobprog.Lexico.Declaracion.ANSI_RED;
import static noobprog.Lexico.Declaracion.ANSI_RESET;
import noobprog.Sintactico.Sintactico;
import noobprog.Utils.Tokenizador;
import noobprog.Utils.asmWriter;
import noobprog.Utils.tablaSimbolos;

/**
 *
 * @author antoniocg
 */
public class Asignacion {
    
   
    
    public static boolean Asignar(String l) throws NoDeclarada, ValorTipoInvalido, TiposIncompatible
    {
        String[] s = l.split("=");
        s[0] = s[0].trim();
        s[1] = s[1].trim();
        if(!tablaSimbolos.getObj().estaDeclarada(s[0]))
        {
            throw new NoDeclarada(s[0]);
        }
        else if(s[1].matches("^\".*|^\'.*|^[0-9]*|V|F"))
        {
           String tipo = tablaSimbolos.getObj().getTipo(s[0]);
           
           if(!AsignacionValida(tipo, s[1]))
           {
               throw new ValorTipoInvalido(s[0],tipo,s[1]);
              
           }
           else
           {
               if(tipo.contains("num"))
               {
               tablaSimbolos.getObj().modificarValor(s[0],Double.parseDouble(s[1]));
               }
               else
               {
               tablaSimbolos.getObj().modificarValor(s[0], s[1]);

               }
            }
        }
        else
        {
            Sintactico e = new Sintactico();
            String[] tokens = null;
            try {
                s[1] = s[1]+"$";
                tokens = Tokenizador.tokenize(s[1]);
            } catch (IOException ex) {
                Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(s[1].matches(".*[+|-|*|/|>|<|and|or|!=|==].*") && !s[1].matches("leer.*"))
            {
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
                String res = e.algoritmoMat(e.getGmatematica(),e.getMatematica(),tokens);
                if(res != null)
                {
                    
                    System.out.println(ANSI_GREEN+"el analisis matematico es correcto"+s[1]+ANSI_RESET);
                    //Object valor = tablaSimbolos.getObj().getValor(s[1]);
                    //tablaSimbolos.getObj().modificarValor(s[0], Double.parseDouble(res));
                           asmWriter.getObj().addCode("LEA AX,"+tablaSimbolos.getObj().getId(s[0]));
                           asmWriter.getObj().addCode("PUSH AX");
                           asmWriter.getObj().addCode("LEA AX,"+tablaSimbolos.getObj().getId(res));
                           asmWriter.getObj().addCode("PUSH AX");
                           
                           asmWriter.getObj().addCode("CALL _iguala");
                           asmWriter.getObj().addCode("MOV AX,4");
                           asmWriter.getObj().addCode("ADD SP,AX");
                    System.out.println("nombre de la variable"+s[0]+" "+s[0]+"="+res);
                    
                }
                else
                {
                    System.out.println(ANSI_RED+"El analisis matematico es incorrecto"+s[1]+ANSI_RESET);
                }
            }
            else
            {
            if(!tablaSimbolos.getObj().estaDeclarada(s[1]))
             {
                 throw new NoDeclarada(s[1]);
             }
             else
             {
                String tipo1 = tablaSimbolos.getObj().getTipo(s[0]);
                String tipo2 = tablaSimbolos.getObj().getTipo(s[1]);
                
                if(!tipo1.equals(tipo2))
                {
                    throw new TiposIncompatible(s[0],s[1]);
                            
                }
                else
                {
                    Object valor = tablaSimbolos.getObj().getValor(s[1]);
                    System.out.println("VALOR ES "+tablaSimbolos.getObj().getTipo(s[1]));
                    if(tablaSimbolos.getObj().getTipo(s[1]).contains("num"))
                    {
                        tablaSimbolos.getObj().modificarValor(s[0], Double.parseDouble(valor.toString()));
                    }
                    else
                    {
                        tablaSimbolos.getObj().modificarValor(s[0], valor.toString());
                    }
                }
             }
        }
        
        }
        
        
        return true;
    }
    
    public static void asignarValor(String[] s)
    {
        if(tablaSimbolos.getObj().getTipo(s[0]).equals("num"))
        {
       tablaSimbolos.getObj().modificarValor(s[0],Double.parseDouble(s[2]));
        }
        else
        {
        tablaSimbolos.getObj().modificarValor(s[0], s[2]);
        }
       
    }
    
    public static boolean AsignacionValida(String tipo,String valor)
    {
        if(tipo.equals("cadena"))
        {
                System.out.println(valor);
            return valor.matches("\".*\"");
        }
        else if(tipo.equals("letra"))
        {   System.out.println(valor);
            return valor.matches("\'.+\'");
        }
        else if(tipo.equals("num"))
        {
            System.out.println(tipo);
            System.out.println(valor);
            System.out.println(valor.matches("^\\d*"));
            return valor.matches("^\\d*");
        }
        else if(tipo.equals("booleano"))
        {
                System.out.println(valor);
            return valor.matches("V|F");
        }
        return false;
    }
}
