package noobprog.Lexico;

/**
 *
 * @author antoniocg
 */
public class Analisis {
 
    
   public static int ObtieneTipo(String s)
   {
       
       //Declaracion
       if(s.matches("\\s*declara\\s+.*\\s+como\\s+[A-Za-z]+"))
       {
           return 1;
       }
       //Declaracion y Asignacion
       if(s.matches("\\s*declara.*=.*\\s*"))
       {
           return 2;
       }
       //Asignacion
       else if(s.matches("\\s*.*\\s*=\\s*.*\\s*") && !s.matches("\\s*[A-Za-z0-9]*\\s*=\\s*leer"))
       {
           return 3;
       }
       //Imprimir String
       else if(s.matches("muestra\\s*[(]\\s*\".*\"\\s*[)]\\s*"))
       {
           return 4;
       }
       //imprimir variable
       //else if(s.matches("muestra\\s*[(]\\s*.*\\s*[)]\\s*"))
       else if(s.matches("muestra\\s*\\(\\s*[A-Za-z0-9]*\\s*\\)\\s*"))
       {
           return 5;
       }
       //Lectura desde el teclado
       else if(s.matches("\\s*[A-Za-z0-9]*\\s*=\\s*leer"))
       {
           return 6;
       }
       else if(s.matches("^si\\s*([[A-Za-z0-9]|\\s|and|or|!|==|!=|<|>|\\(|\\)]*)\\s*entonces"))
       {
           return 7;
       }
       else if(s.matches("^mientras\\s*([[A-Za-z0-9]|\\s|and|or|!|==|!=|<|>|\\(|\\)]*)\\s*hacer\\s*"))
       {
           return 8;
       }
       else if(s.matches("^\\{"))
       {
           return 9;
       }
       else if(s.matches("^\\}"))
       {
           return 10;
       }
       return 0;
   }
   
   public static int ObtieneTipo(String[] s)
   {
       if(!(s.length<=0))
       {
           if(s[0].equals("declara") && s[1].equals("como"))
           {
               return 1;
           }
       }
       return -1;
   }
   
}
