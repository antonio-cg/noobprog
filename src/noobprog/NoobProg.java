/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog;

import Ex.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import noobprog.Lexico.Analisis;
import noobprog.Lexico.Asignacion;
import noobprog.Lexico.Declaracion;
import noobprog.Lexico.Impresion;
import noobprog.Lexico.Lectura;
import noobprog.Lexico.tipos;
import noobprog.Lexico.PalRes;
import noobprog.Lexico.decision;
import noobprog.Utils.asmWriter;
import static noobprog.Utils.comentario.QuitaTabs;
import static noobprog.Utils.comentario.QuitarComentario;
import noobprog.Utils.tablaSimbolos;

/**
 *Programa principal que analiza linea por linea 
 * @author antoniocg
 */
public class NoobProg {

    /**
     * @param args the command line arguments
     * @throws Ex.TiposIncompatible
     * @throws Ex.tipoInvalido
     * @throws Ex.PalabraReservada
     * @throws Ex.VariableInvalida
     * @throws Ex.VariableDeclarada
     * @throws Ex.ValorTipoInvalido
     * @throws Ex.NoDeclarada
     * @throws java.io.IOException
     */
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
    public static void main(String[] args) throws  IOException {
       //cosillas
        
        
        //declaramos variables 
        int llaves = 0;
        int Linea = 0;
        String[] tokens;
        tipos t = new tipos();
        PalRes pr = new PalRes();
        //tablaSimbolos ts = new tablaSimbolos();
        String line = null;
        //CambiaR ruta 
        String ruta = "/home/antonio/Documentos/Tecnologico/7/automatas/NoobProg/prueba.noob";
        String guardado = "/home/antonio/Documentos/Tecnologico/7/automatas/NoobProg/pruebaLimpio.noob";
        
        FileWriter fileWriter = new FileWriter(guardado);
        //Leemos el archivo 
        FileReader fileReader = new FileReader(ruta);

           
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           //leer linea por linea
            
        while((line = bufferedReader.readLine()) != null) {
            try {
                //Limpiamos Comentarios
                line=QuitarComentario(line);
                line=QuitaTabs(line);
                
                //generamos los tokens 
//                String[] token = Tokenizador.tokenize(line);
//                for(String s:token)
//                {
//                    System.out.println(s);
//                }
                switch(Analisis.ObtieneTipo(line))
                {
                    //Declaracion       -> declaracion <variable> como <tipo>
                    case 1:
                        System.out.println(ANSI_BLUE+"Linea "+Linea+": "+line+" es Declaracion"+ANSI_RESET);
                        Declaracion.declarar(line);
                        break;
                        //declarar y Asignar -> Declaracion <variable> como <tipo> = 100
                    case 2:
                        Declaracion.declararYAsignar(line);
                        System.out.println(ANSI_BLUE + "Linea "+Linea+": "+line+" es Declaracion y asignacion"+ANSI_RESET);
                        break;
                        //Asignacion        -> <nomVariable> = <Valor>
                    case 3:
                        
                        System.out.println(ANSI_BLUE + ANSI_BOLD + "Linea "+Linea+": "+line+" es asignacion"+ANSI_RESET);
                        Asignacion.Asignar(line);
                        break;
                        
                    case 4:
                        Impresion.imprimeString(line);
                        
                        System.out.println(ANSI_BLUE + "Linea "+Linea+": "+line+" es Imprime String"+ANSI_RESET);
                        break;
                    case 5:
                        Impresion.imprimeVar(line);
                        System.out.println(ANSI_BLUE + "Linea "+Linea+": "+line+" es Imprime variable"+ANSI_RESET);
                        break;
                    case 6:
                        Lectura.leer(line);
                        System.out.println(ANSI_BLUE + "Linea "+Linea+": "+line+" es lectura del teclado"+ANSI_RESET);
                        break;
                    case 7:
                        System.out.println(ANSI_BLUE + "Linea "+Linea+": "+line+" es desicion"+ANSI_RESET);
                        String limpia2 = line.replaceAll("^si\\s*\\(([[A-Za-z0-9]|\\s|and|or|!|==|!=|<|>|\\(|\\)]*)\\)\\s*entonces", "$1");  
                       
                        if(decision.logico(limpia2))
                        {
                            System.out.println(ANSI_GREEN + "Analisis Logico en desicion correcto"+ANSI_RESET);
                        }
                        else
                        {
                           System.out.println(ANSI_RED + "Analisis Logico en desicion incorrecto"+ANSI_RESET);

                        }
                        break;
                    case 8:
                        System.out.println(ANSI_BLUE + "Linea "+Linea+": "+line+" es ciclo Mientras"+ANSI_RESET);
                        String limpia = line.replaceAll("^mientras\\s*\\(([[A-Za-z0-9]|\\s|and|or|!|==|!=|<|>|\\(|\\)]*)\\)\\s*hacer\\s*", "$1");  
                         if(decision.logico(limpia))
                        {
                            System.out.println(ANSI_GREEN + "Analisis Logico en ciclo  correcto"+ANSI_RESET);
                        }
                        else
                        {
                           System.out.println(ANSI_RED + "Analisis Logico en ciclo incorrecto"+ANSI_RESET);

                        }
                        break;
                    case 9:
                        llaves++;
                        break;
                    case 10:
                        llaves--;
                        break;
                    case 0:
                        
                        break;
                }
                
                Linea++;
            } catch (tipoInvalido ex) {
         //       Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PalabraReservada ex) {
           //     Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (VariableInvalida ex) {
             //   Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (VariableDeclarada ex) {
               // Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ValorTipoInvalido ex) {
               // Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoDeclarada ex) {
               // Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TiposIncompatible ex) {
               // Logger.getLogger(NoobProg.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                }   
            
             //   bufferedWriter.write(line);
               // bufferedWriter.newLine();
                 
               

            // Cerramos
            asmWriter.getObj();
            tablaSimbolos.getObj().addToAsm();
            //CAMBIAR DIRECCION 
            asmWriter.getObj().Guardar("/home/antonio/Documentos/Tecnologico/7/automatas/NoobProg/TC/BIN/output.asm");
            bufferedReader.close();         
            bufferedWriter.close();
          
         
        
       
          
       
        
        
      
       //imprimir tabla de simbolos
        
         tablaSimbolos.getObj().print();
       
      
        if(llaves!=0)
        {
            System.out.println("Error en las llaves");
        }

           
        
     
         
    }
    
    
    public static int getType(Object n)
    {
        
       
    

        return 1;
    }
}
