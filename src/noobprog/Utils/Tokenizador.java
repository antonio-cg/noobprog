    package noobprog.Utils;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Clase general para generar tokens a partir de un String
 * @author antonio
 */
public class Tokenizador {
  /**
   * 
   * @param s
   * @return
   * @throws IOException 
   */
    public static String[] tokenize(String s) throws IOException {
     StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
     tokenizer.ordinaryChar('-');  //no parsea el menos como parte del numero
     tokenizer.ordinaryChar('/');
     
      List<String> tokBuf = new ArrayList<String>(); //guarda los tokens 
    while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
   
        
    switch(tokenizer.ttype) {
      case StreamTokenizer.TT_NUMBER://Es un numero
        tokBuf.add(String.valueOf(tokenizer.nval));
        break;
      case StreamTokenizer.TT_WORD: // es una palabra
        tokBuf.add(tokenizer.sval);
        break;
      case '\"': //si el caracter es un iniciador de una String entre comillas
        tokBuf.add(tokenizer.sval);
        break;
      default:  // operator
          //System.out.println("Operando " + tokenizer.ttype);
          int actual = tokenizer.ttype;
          //si el token actual es ! o = sacaremos el siguiente token y veremos si = para las combinaciones !=
          if(tokenizer.ttype==33 || tokenizer.ttype == 61)
          {  
              //Scamos el token que sigue
              tokenizer.nextToken();
              //Vemos si es un =
              if(tokenizer.ttype == 61)
              {
                  if(actual == 33)//Si el anterior era un !
                  {
                      tokBuf.add("!=");
                  }
                  else if(actual == 61) //si el anterior era un = 
                  {
                      tokBuf.add("==");
                  }
              }
              else
              {
                  //regresamos al token anterior 
                  tokenizer.pushBack();
                  tokBuf.add(String.valueOf((char) actual)); //lo agregamos
              }
                      
          }
          else//si no es ni ! = simplemente lo agregamos a la lista
          {
            tokBuf.add(String.valueOf((char) actual));
          }
            
                }
  }
       
  return tokBuf.toArray(new String[tokBuf.size()]); 
}
    
    
}
