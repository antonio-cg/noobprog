/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class asmWriter {
    private StringBuilder extrablock = new StringBuilder();
    private StringBuilder codeBlock = new StringBuilder();
    private StringBuilder stackBlock = new StringBuilder();
    private StringBuilder dataBlock = new StringBuilder();
    
    
    private static asmWriter singleWriter = new asmWriter();
    
    
    /**
     * constructor privado para que no se pueda declarar 
     */
    private asmWriter()
    {
        //inicializa Pila
        stackBlock.append(";Codigo ensamblador generado por noobprog");
        stackBlock.append(System.lineSeparator());
        stackBlock.append(";Autogenerador el dia: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        stackBlock.append(System.lineSeparator());
        //inicializamos datos
        dataBlock.append("DGROUP GROUP _DATA,_BSS");
        dataBlock.append(System.lineSeparator());
        dataBlock.append("_DATA SEGMENT WORD PUBLIC 'DATA'");
        dataBlock.append(System.lineSeparator());
        //inicializamos extra
        extrablock.append("_BSS SEGMENT WORD PUBLIC 'BSS'");
        extrablock.append(System.lineSeparator());
        extrablock.append("_BSS ENDS");
        extrablock.append(System.lineSeparator());
        //inicializamos codigo
        codeBlock.append("_TEXT SEGMENT BYTE PUBLIC 'CODE'");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("ASSUME CS:_TEXT,DS:DGROUP,SS:DGROUP");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("PUBLIC _main");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _resta:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _suma:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _divi:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _multi:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _impString:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _impNumero:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _leer:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("EXTRN _iguala:NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append("_main PROC NEAR");
        codeBlock.append(System.lineSeparator());
        codeBlock.append(";---------------INICIA CODIGO GENERADO POR JAVA------------------");
        codeBlock.append(System.lineSeparator());
        
               
    }
    /**
     * Obtienes la instancia singleton
     * @return 
     */
    public static asmWriter getObj()
    {
        return singleWriter;
    }
    
    private void Cerrar()
    {
        //cerramos data
        dataBlock.append("_DATA ENDS");
        dataBlock.append(System.lineSeparator());
        //cerramos codigo
        codeBlock.append("RET");
        codeBlock.append(System.lineSeparator());
          codeBlock.append("_main ENDP");
        codeBlock.append(System.lineSeparator());
          codeBlock.append("_TEXT ENDS");
        codeBlock.append(System.lineSeparator());
          codeBlock.append("END");
        codeBlock.append(System.lineSeparator());
        
    }
    /**
     * Cierra los codigos de asm y guarda el archivo
     * @param file 
     */
    public void Guardar(String file)
    {
        File files = new File(file);
        BufferedWriter writer = null;
        
        try {
            //cerramos el archivo asm
            Cerrar();
            writer = new BufferedWriter(new FileWriter(files));
            writer.append(stackBlock.toString());
            writer.append(dataBlock.toString());
            writer.append(extrablock.toString());
            writer.append(codeBlock.toString());
            writer.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(asmWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /**
      * Añade una nueva linea al metodo data 
      * @param code 
      */
    public void addCode(String code)
    {
        codeBlock.append(code);
        codeBlock.append(System.lineSeparator());
    }
    /**
     * Añade una nueva linea de inicializacion de datos
     * @param data 
     */
    public void addData(String data)
    {
        dataBlock.append(data);
        dataBlock.append(System.lineSeparator());
    }
}
