/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Sintactico;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import noobprog.Utils.asmWriter;
import noobprog.Utils.tablaSimbolos;

/**
 *Clase que Contiene la tabla para un analisis sintactico logico y matematico
 * con jerarquia
 * @author antonio Caro Guerrero
 * @author Erika Gomez Ramos
 * 
 */
public class Sintactico {

    public Map<String, Estado> getMatematica() {
        return matematica;
    }

    public Map<Integer, Estado> getGmatematica() {
        return Gmatematica;
    }

    public Map<String, Estado> getTlogica() {
        return Tlogica;
    }

    public Map<Integer, Estado> getGLogica() {
        return GLogica;
    }
    
    private Map<String,Estado> matematica = new HashMap<String,Estado>();
    private Map<Integer,Estado> Gmatematica = new HashMap<Integer,Estado>();
    private Map<String,Estado> Tlogica = new HashMap<String,Estado>();
    private Map<Integer,Estado> GLogica = new HashMap<Integer,Estado>();

    public Sintactico()
    {
        //Construimos la tabla 
        //
        Estado Accep = new Estado("A",-1);
        Estado s4 = new Estado("S",4);
        Estado s5 = new Estado("S",5);
        Estado s6 = new Estado("S",6);
        Estado s7 = new Estado("S",7);
        Estado s8 = new Estado("S",8);
        Estado s9 = new Estado("S",9);
        Estado s10 = new Estado("S",10);
        Estado s11 = new Estado("S",11);
        Estado s12 = new Estado("S",12);
        Estado s13 = new Estado("S",13);
        Estado s14 = new Estado("S",14);
        Estado s15 = new Estado("S",15);
        Estado s16 = new Estado("S",16);
        Estado s25 = new Estado("S",25);    
      
        //Reducciones
        Estado r1 = new Estado("R",1);
        Estado r2 = new Estado("R",2);
        Estado r3 = new Estado("R",3);
        Estado r4 = new Estado("R",4);
        Estado r5 = new Estado("R",5);
        Estado r6 = new Estado("R",6);
        Estado r7 = new Estado("R",7);
        Estado r8 = new Estado("R",8);
        Estado r9 = new Estado("R",9);
        Estado r10 = new Estado("R",10);
        Estado r11 = new Estado("R",11);
        Estado r12 = new Estado("R",12);
        Estado r13 = new Estado("R",13);
        Estado r14 = new Estado("R",14);
        Estado r15 = new Estado("R",15);
        
        //Ir_A
        Estado i1 = new Estado("I",1);
        Estado i2 = new Estado("I",2);
        Estado i3 = new Estado("I",3);
        Estado i4 = new Estado("I",4);
        Estado i5 = new Estado("I",5);
        Estado i10 = new Estado("I",10);
        Estado i17 = new Estado("I",17);
        Estado i18 = new Estado("I",18);
        Estado i19 = new Estado("I",19);
        Estado i20 = new Estado("I",22);
        Estado i21 = new Estado("I",21);
        Estado i22 = new Estado("I",22);
        Estado i23 = new Estado("I",23);
        Estado i24 = new Estado("I",24);
        Estado i11 = new Estado("I",11);
        Estado i12 = new Estado("I",12);
        Estado i13 = new Estado("I",13);
        Estado i14 = new Estado("I",14);
        
        //Construimos la tabla
        // id
        matematica.put("0id",s5);
        matematica.put("4id",s5);
        matematica.put("6id",s5);
        matematica.put("7id",s5);
        matematica.put("8id",s5);
        matematica.put("9id",s5);
        // +
        matematica.put("1+", s6);
        matematica.put("2+", r3);
        matematica.put("3+", r6);
        matematica.put("5+", r8);
        matematica.put("10+",s6);
        matematica.put("11+",r1);
        matematica.put("12+",r2);
        matematica.put("13+",r4);
        matematica.put("14+",r5);
        matematica.put("15+",r7);
        // -
        matematica.put("1-", s7);
        matematica.put("2-", r3);
        matematica.put("3-", r6);
        matematica.put("5-", r8);
        matematica.put("10-",s7);
        matematica.put("11-",r1);
        matematica.put("12-",r2);
        matematica.put("13-",r4);
        matematica.put("14-",r5);
        matematica.put("15-",r7);
        // *
        matematica.put("2*", s8);
        matematica.put("3*", r6);
        matematica.put("5*", r8);
        matematica.put("11*",s8);
        matematica.put("12*",s8);
        matematica.put("13*",r4);
        matematica.put("14*",r5);
        matematica.put("15*",r7);
        // /
        matematica.put("2/", s9);
        matematica.put("3/", r6);
        matematica.put("5/", r8);
        matematica.put("11/",s9);
        matematica.put("12/",s9);
        matematica.put("13/",r4);
        matematica.put("14/",r5);
        matematica.put("15/",r7);
        // (
        matematica.put("0(", s4);
        matematica.put("4(", s4);
        matematica.put("6(", s4);
        matematica.put("7(",s4);
        matematica.put("8(",s4);
        matematica.put("9(",s4);
        
        // )
        
        matematica.put("2)", r3);
        matematica.put("3)", r6);
        matematica.put("5)", r8);
        matematica.put("10)", s15);
        matematica.put("11)",r1);
        matematica.put("12)",r2);
        matematica.put("13)",r4);
        matematica.put("14)",r5);
        matematica.put("15)",r7);
        
        // $
        matematica.put("1$", Accep);
        matematica.put("2$", r3);
        matematica.put("3$", r6);
        matematica.put("5$", r8);
        matematica.put("10$",s7);
        matematica.put("11$",r1);
        matematica.put("12$",r2);
        matematica.put("13$",r4);
        matematica.put("14$",r5);
        matematica.put("15$",r7);
        
        //Ir_A
        matematica.put("0A",i1);
        matematica.put("0B",i2);
        matematica.put("0C",i3);
        matematica.put("4A",i10);
        matematica.put("4B",i2);
        matematica.put("4C",i3);
        matematica.put("6B",i11);
        matematica.put("6C",i3);
        matematica.put("7B",i12);
        matematica.put("7C",i3);
        matematica.put("8C",i13);
        matematica.put("9C",i14);
        //fin de construccion de tabla sintactica 
        
        //Gramatica Matematica
        Gmatematica.put(1,new Estado("A",3));//A->a+b
        Gmatematica.put(2,new Estado("A",3));//A->a-b
        Gmatematica.put(3,new Estado("A",1));//A->b
        Gmatematica.put(4,new Estado("B",3));//b->b*c
        Gmatematica.put(5,new Estado("B",3));//b->b/c
        Gmatematica.put(6,new Estado("B",1));//b->d
        Gmatematica.put(7,new Estado("C",3));//d->(A)
        Gmatematica.put(8,new Estado("C",1));//d->id
        
        //Glogica
        GLogica.put(1,new Estado("A",3));//A->a OR b
        GLogica.put(2,new Estado("A",1));//a->B
        GLogica.put(3,new Estado("B",3));//B-> b and c
        GLogica.put(4,new Estado("B",1));//b->c
        GLogica.put(5,new Estado("C",3));//c->c==d
        GLogica.put(6,new Estado("C",3));//c->c!=d
        GLogica.put(7,new Estado("C",1));//c->d
        GLogica.put(8,new Estado("D",3));//d->d<e
        GLogica.put(9,new Estado("D",3));//d->d>e
        GLogica.put(10,new Estado("D",1));//d->e
        GLogica.put(11,new Estado("E",2));//e->!e
        GLogica.put(12,new Estado("E",3));//e->(A)
        GLogica.put(13,new Estado("E",1));//e->F
        GLogica.put(14,new Estado("E",1));//e->V
        GLogica.put(15,new Estado("E",1));//e->id
        
        //Creamos la tabla Logica
        
        //or
        Tlogica.put("1or",s11);
        Tlogica.put("2or",r2);
        Tlogica.put("3or",r4);
        Tlogica.put("4or",r7);
        Tlogica.put("5or",r10);
        Tlogica.put("8or",r13);
        Tlogica.put("9or",r14);
        Tlogica.put("10or",r15);
        Tlogica.put("17or",r11);
        Tlogica.put("18or",s11);
        Tlogica.put("19or",r1);
        Tlogica.put("20or",r3);
        Tlogica.put("21or",r5);
        Tlogica.put("22or",r6);
        Tlogica.put("23or",r8);
        Tlogica.put("24or",r9);
        Tlogica.put("25or",r12);
        
        //and
        
        Tlogica.put("1and",s12);
        Tlogica.put("2and",s12);
        Tlogica.put("3and",r4);
        Tlogica.put("4and",r7);
        Tlogica.put("5and",r10);
        Tlogica.put("8and",r13);
        Tlogica.put("9and",r14);
        Tlogica.put("10and",r15);
        Tlogica.put("17and",r11);
        Tlogica.put("19and",s12);
        Tlogica.put("20and",r3);
        Tlogica.put("21and",r5);
        Tlogica.put("22and",r6);
        Tlogica.put("23and",r8);
        Tlogica.put("24and",r9);
        Tlogica.put("25and",r12);
        
        // ==
        
        
        Tlogica.put("2==",s13);
        Tlogica.put("3==",s13);
        Tlogica.put("4==",r7);
        Tlogica.put("5==",r10);
        Tlogica.put("8==",r13);
        Tlogica.put("9==",r14);
        Tlogica.put("10==",r15);
        Tlogica.put("17==",r11);
        Tlogica.put("20==",s13);
        Tlogica.put("21==",r5);
        Tlogica.put("22==",r6);
        Tlogica.put("23==",r8);
        Tlogica.put("24==",r9);
        Tlogica.put("25==",r12);
        
        // !=
        
       
        Tlogica.put("2!=",s14);
        Tlogica.put("3!=",r4);
        Tlogica.put("4!=",r7);
        Tlogica.put("5!=",r10);
        Tlogica.put("8!=",r13);
        Tlogica.put("9!=",r14);
        Tlogica.put("10!=",r15);
        Tlogica.put("17!=",r11);
        Tlogica.put("20!=",s14);
        Tlogica.put("21!=",r5);
        Tlogica.put("22!=",r6);
        Tlogica.put("23!=",r8);
        Tlogica.put("24!=",r9);
      
        // <
        
        Tlogica.put("4<",s15);
        Tlogica.put("5<",r10);
        Tlogica.put("8<",r13);
        Tlogica.put("9<",r14);
        Tlogica.put("10<",r15);
        Tlogica.put("17<",r11);
        Tlogica.put("21<",r5);
        Tlogica.put("22<",r6);
        Tlogica.put("23<",r8);
        Tlogica.put("24<",r9);
        Tlogica.put("25<",r12);
        
        // >
        Tlogica.put("4>",s16);
        Tlogica.put("5>",r10);
        Tlogica.put("8>",r13);
        Tlogica.put("9>",r14);
        Tlogica.put("10>",r15);
        Tlogica.put("17>",r11);
        Tlogica.put("21>",s15);
        Tlogica.put("22>",s15);
        Tlogica.put("23>",r8);
        Tlogica.put("24>",r9);
        Tlogica.put("25>",r12);
        
        // !
        Tlogica.put("0!",s6);
        Tlogica.put("7!",s6);
        Tlogica.put("11!",s6);
        Tlogica.put("12!",s6);
        Tlogica.put("13!",s6);
        Tlogica.put("14!",s6);
        Tlogica.put("15!",s6);
        Tlogica.put("16!",s6);
        Tlogica.put("21!",s16);
        Tlogica.put("22!",s16);
        Tlogica.put("23!",r8);
        Tlogica.put("24!",r9);
        Tlogica.put("25!",r12);
        
        // (
        
        Tlogica.put("0(",s7);
        Tlogica.put("6(",s7);
        Tlogica.put("7(",s7);
        Tlogica.put("11(",s7);
        Tlogica.put("12(",s7);
        Tlogica.put("13(",s7);
        Tlogica.put("14(",s7);
        Tlogica.put("15(",s7);
        Tlogica.put("16(",s7);
        
        
        // )
        
        Tlogica.put("2)",r2);
        Tlogica.put("3)",r4);
        Tlogica.put("4)",r7);
        Tlogica.put("5)",r10);
        Tlogica.put("8)",r13);
        Tlogica.put("9)",r14);
        Tlogica.put("10)",r15);
        Tlogica.put("17)",r11);
        Tlogica.put("18)",s25);
        Tlogica.put("19)",r1);
        Tlogica.put("20)",r3);
        Tlogica.put("21)",r5);
        Tlogica.put("22)",r6);
        Tlogica.put("23)",r8);
        Tlogica.put("24)",r9);
        Tlogica.put("25)",r12);
        
        
        // V
        Tlogica.put("0V",s8);
        Tlogica.put("6V",s8);
        Tlogica.put("7V",s8);
        Tlogica.put("11V",s8);
        Tlogica.put("12V",s8);
        Tlogica.put("13V",s8);
        Tlogica.put("14V",s8);
        Tlogica.put("15V",s8);
        Tlogica.put("16V",s8);
        
        // F
        Tlogica.put("0F",s9);
        Tlogica.put("6F",s9);
        Tlogica.put("7F",s9);
        Tlogica.put("11F",s9);
        Tlogica.put("12F",s9);
        Tlogica.put("13F",s9);
        Tlogica.put("14F",s9);
        Tlogica.put("15F",s9);
        Tlogica.put("16F",s9);
        // id
        
        Tlogica.put("0id",s10);
        Tlogica.put("6id",s10);
        Tlogica.put("7id",s10);
        Tlogica.put("11id",s10);
        Tlogica.put("12id",s10);
        Tlogica.put("13id",s10);
        Tlogica.put("14id",s10);
        Tlogica.put("15id",s10);
        Tlogica.put("16id",s10);
       
        //$
        Tlogica.put("1$",Accep);
        Tlogica.put("2$",r2);
        Tlogica.put("3$",r4);
        Tlogica.put("4$",r7);
        Tlogica.put("5$",r10);
        Tlogica.put("8$",r13);
        Tlogica.put("9$",r14);
        Tlogica.put("10$",r15);
        Tlogica.put("17$",r11);
        Tlogica.put("19$",r1);
        Tlogica.put("20$",r3);
        Tlogica.put("21$",r5);
        Tlogica.put("22$",r6);
        Tlogica.put("23$",r8);
        Tlogica.put("24$",r9);
        Tlogica.put("25$",r12);
        //Ir_A
        Tlogica.put("0A", i1);
        Tlogica.put("0B", i2);
        Tlogica.put("0C", i3);
        Tlogica.put("0D", i4);
        Tlogica.put("0E", i5);
        Tlogica.put("6E", i17);
        Tlogica.put("7A", i18);
        Tlogica.put("7B", i2);
        Tlogica.put("7C", i3);
        Tlogica.put("7D", i4);
        Tlogica.put("7E", i5);
        Tlogica.put("11B", i19);
        Tlogica.put("11C", i3);
        Tlogica.put("11D", i4);
        Tlogica.put("11E", i5);
        Tlogica.put("12C", i20);
        Tlogica.put("12D", i4);
        Tlogica.put("12E", i5);
        Tlogica.put("13D", i21);
        Tlogica.put("13E", i5);
        Tlogica.put("14D", i22);
        Tlogica.put("14E", i5);
        Tlogica.put("15E", i23);
        Tlogica.put("16E", i24);
        
        
        
       
        
    }
    /**
     * Algoritmo de corrimiento Logico
     * @param Gramatica hasmMap que contiene la gramtica de forma (posicion,(noterminal,valorarecorrer))
     * @param Tabla 
     * @param Cadena 
     */
    public Boolean algoritmo2(Map<Integer,Estado> Gramatica,Map<String,Estado> Tabla,String[] Cadena)
    {
       
        int p = 0; //Puntero de la cadena
        Estado edo = null; //para saber el estado Actual
        Stack<Integer> pila = new Stack<Integer>(); //Guarda la pila de producciones
        Stack<String> Valores = new Stack<String>();
        pila.push(0);
        while(true)
        {   
            String sim = Cadena[p];
            if(sim.matches("^id.*"))
            {
                sim = "id";
            }
            //obtengo el primer estado que es el tope de pila y la posicion p de la Cadena 
              edo = Tabla.get(String.valueOf(pila.peek()) +""+ sim);
              
              //Si el estado es valido y es del tipo dezplazar
              if(edo != null && edo.getTipo().equals("S"))
              {
                  pila.push(edo.getDest());
                  if(sim.matches("^id.*") || sim.matches("^V")) // vemos si es un id para buscarlo en la tabla de simbolos
                  {
                     Object valor = tablaSimbolos.getObj().getValor(Cadena[p]); //obteemos el valor declarado
                     if(valor.getClass().equals(Double.class)) //si el valor de la variable es numerica 
                     {
                       Valores.push(valor.toString());
                     } 
                 }
                  else //si no simplemente lo agragamos
                  {
                    Valores.push(Cadena[p]); // guardamos el estado que este caso contiene el valor
                  }
                  p++;
              }
              else if(edo != null && edo.getTipo().equals("R"))
              {
                  //Obtemeos de la gramatica el numero de produccion mediante el estado que es R
                  Estado prod = Gramatica.get(edo.getDest());
                  //Obtemeos la cantidad de desplazamientos que se tendra de acuerdo a la produccion
                  for(int i=0;i<prod.getDest();i++)
                  {
                      //Sacamos de la pila
                      pila.pop();
                  }
                  //Obteemos el estado que se tiene que meter de los cuales estan en prod que son (A,B,C)
                  Estado p1 = Tabla.get(pila.peek().toString()+""+prod.getTipo());
                  pila.push(p1.getDest());
              }
              else if(edo != null && edo.getTipo().equals("A"))
              {
                  return true;
              }
              else
              {
                  return false;
              }
        }
        
        
        
        
    }
    
    public Boolean algoritmo(Map<Integer,Estado> Gramatica,Map<String,Estado> Tabla,String[] Cadena)
    {
       
        int p = 0; //Puntero de la cadena
        Estado edo = null; //para saber el estado Actual
        Stack<Integer> pila = new Stack<Integer>(); //Guarda la pila de producciones
        Stack<String> Valores = new Stack<String>();
        pila.push(0);
        while(true)
        {   
             
            //obtengo el primer estado que es el tope de pila y la posicion p de la Cadena 
            String sim = Cadena[p];
            if(sim.matches("^id.+"))
            {
                sim = "id";
            }
              edo = Tabla.get(String.valueOf(pila.peek()) +""+ sim);
              
              //Si el estado es valido y es del tipo dezplazar
              if(edo != null && edo.getTipo().equals("S"))
              {
                  pila.push(edo.getDest());
                  if(sim.matches("^id.*") || sim.matches("^V|F")) // vemos si es un id para buscarlo en la tabla de simbolos
                  {
                     
                     Object valor = tablaSimbolos.getObj().getById(Cadena[p]);
                     if(valor!=null && (valor.getClass().equals(Double.class) || valor.getClass().equals(String.class))) //si el valor de la variable es numerica 
                     {
                       Valores.push(valor.toString());
                     } 
                     if(sim.matches("^V|F"))
                     {
                         Valores.push(sim);
                     }
                 }
                  else //si no simplemente lo agragamos
                  {
                  Valores.push(Cadena[p]); // guardamos el estado que este caso contiene el valor
                  }
                  p++;
              }
              else if(edo != null && edo.getTipo().equals("R"))
              {
                  //Resolvemos la ecuacion matematica
                  int dest = edo.getDest();
                  String a = "";
                  Boolean a1,b1;
                  String b = "";
                 switch(dest)
                 {
                     case 1: //a or b
                         System.out.println("es un or");
                         b = Valores.pop();
                         Valores.pop();
                         a = Valores.pop();
                         
                         if(a.matches("V|F") && b.matches("V|F"))//solo podemos hacer OR a nivel logico true or false
                         {
                             if(a.matches("^V"))
                             {
                                 a1 = true;
                             }else
                             {
                                 a1 = false;
                             }
                             
                             if(b.matches("^V"))
                             {
                                 b1 = true;
                             }else
                             {
                                 b1 = false;
                             }
                             
                             if(a1||b1)
                             {
                                 Valores.push("V");
                                 
                             }else
                             {
                                 Valores.push("F");
                             }
                             
                         }else
                         {
                             System.out.println("Error la instrucción or solo funciona con operadores logicos");
                             return false;
                             
                         }
                         
                         
                         
                         
                         
                         break;
                     case 3: //a and b
                         System.out.println("es un and");
                         b = Valores.pop();
                         Valores.pop();
                         a = Valores.pop();
                         
                         if(a.matches("V|F") && b.matches("V|F"))//solo podemos hacer OR a nivel logico true or false
                         {
                             if(a.matches("^V"))
                             {
                                 a1 = true;
                             }else
                             {
                                 a1 = false;
                             }
                             
                             if(b.matches("^V"))
                             {
                                 b1 = true;
                             }else
                             {
                                 b1 = false;
                             }
                             
                             if(a1&&b1)
                             {
                                 Valores.push("V");
                                 
                             }else
                             {
                                 Valores.push("F");
                             }
                             
                         }else
                         {
                             System.out.println("Error la instrucción AND solo funciona con operadores logicos");
                             return false;
                             
                         }
                         break;
                     case 5: //a == b
                         System.out.println("es un ==");
                        
                         b = Valores.pop();
                         Valores.pop();
                         a = Valores.pop();
                         
                        if(a.equals(b))
                        {
                            Valores.push("V");
                                 
                        }else
                        {
                            Valores.push("F");
                        }
                         break;
                     case 6: // a != b
                         System.out.println("es un a!=b");
                         b = Valores.pop();
                         Valores.pop();
                         a = Valores.pop();
                        if(!a.equals(b))
                        {
                            Valores.push("V");
                                 
                        }else
                        {
                            Valores.push("F");
                        }
                         break;
                     case 8:// a < b 
                         
                         try
                         {
                         System.out.println("es un <");
                         b = Valores.pop();
                         Valores.pop();
                         a = Valores.pop();
                         
                         if(a.matches("V|F") || b.matches("V|F"))//solo podemos hacer OR a nivel logico true or false
                         {
                              System.out.println("Error el operando < solo funciona con numeros");
                             return false;
                             
                         }else
                         {
                            if(a.matches("\\d+\\.\\d+") && a.matches("\\d+\\.\\d+"))
                            {
                                int tempa = (int)Double.parseDouble(a);
                                int tempb = (int)Double.parseDouble(b);
                                if(tempa<tempb)
                                {
                                      Valores.push("V");
                                 
                                 }else
                                 {
                                     Valores.push("F");
                                 }
                            }
                           
                             
                         }
                         }
                         catch(Exception e)
                         {
                             e.printStackTrace();
                             System.out.println("pasa algo");
                         }
                         break;
                     case 9: // a > b
                         System.out.println("es un >");
                             
                         b = Valores.pop();
                         Valores.pop();
                         a = Valores.pop();
                         
                         if(a.matches("V|F") || b.matches("V|F"))//solo podemos hacer OR a nivel logico true or false
                         {
                              System.out.println("Error  el operando > solo funciona con numeros");
                             return false;
                             
                         }else
                         {
                            if(a.matches("\\d+\\.\\d+") && b.matches("\\d+\\.\\d+"))
                            {
                                int tempa = (int)Double.parseDouble(a);
                                int tempb = (int)Double.parseDouble(b);
                                if(tempa>tempb)
                                {
                                      Valores.push("V");
                                 
                                 }else
                                 {
                                     Valores.push("F");
                                 }
                            }
                           
                             
                         }
                         break;
                     case 11: // !a
                         System.out.println("es un !");
                          a = Valores.pop();
                          Valores.pop();
                         
                         
                         if(a.matches("V|F"))//solo podemos hacer OR a nivel logico true or false
                         {
                             if(a.matches("^V"))
                             {
                                 a1 = true;
                             }else
                             {
                                 a1 = false;
                             }
                             
                            
                             
                             if(!a1)
                             {
                                 Valores.push("V");
                                 
                             }else
                             {
                                 Valores.push("F");
                             }
                             
                         }else
                         {
                             System.out.println("Error el operador ! solo funciona con operadores logicos");
                             return false;
                             
                         }
                         break;
                     case 12://(A)
                         System.out.println("es un (A)");
                         Valores.pop();
                         a = Valores.pop();
                         Valores.pop();
                         Valores.push(a);
                         
                         break;
                      
                 }
                  
                  //Obtemeos de la gramatica el numero de produccion mediante el estado que es R
                  
                  Estado prod = Gramatica.get(edo.getDest());
                  //Obtemeos la cantidad de desplazamientos que se tendra de acuerdo a la produccion
                  
                  for(int i=0;i<prod.getDest();i++)
                  {
                      //Sacamos de la pila
                      pila.pop();
                  }
                  //Obteemos el estado que se tiene que meter de los cuales estan en prod que son (A,B,C)
                  Estado p1 = Tabla.get(pila.peek().toString()+""+prod.getTipo());
                  pila.push(p1.getDest());
                  
              }
              else if(edo != null && edo.getTipo().equals("A"))
              {
                  System.out.println("Resultado de la operacion: " + Valores.peek());
                  return true;
              }
              else
              {
                  return false;
              }
        }
        
    }
    
    public String algoritmoMat(Map<Integer,Estado> Gramatica,Map<String,Estado> Tabla,String[] Cadena)
    {
        
        int p = 0; //Puntero de la cadena
        Estado edo = null; //para saber el estado Actual
        Stack<Integer> pila = new Stack<Integer>(); //Guarda la pila de producciones
        Stack<String> Valores = new Stack<String>();
        Stack<String> VId = new Stack<String>();
        pila.push(0);
      
        while(true)
        {   
             
            //obtengo el primer estado que es el tope de pila y la posicion p de la Cadena 
            String sim = Cadena[p];
            if(sim.matches("^id.*"))
            {
                sim = "id";
            }
              edo = Tabla.get(String.valueOf(pila.peek()) +""+ sim);
              
              //Si el estado es valido y es del tipo dezplazar
              if(edo != null && edo.getTipo().equals("S"))
              {
                  pila.push(edo.getDest());
//                  if(sim.matches("^id.*")) // vemos si es un id para buscarlo en la tabla de simbolos
//                  {
//                     Object valor = tablaSimbolos.getObj().getValorById(Cadena[p]);
//                     if(valor.getClass().equals(Double.class)) //si el valor de la variable es numerica 
//                     {
//                       Valores.push(valor.toString());
//                       VId.push(Cadena[p]);
//                     } 
//                 }
//                  else //si no simplemente lo agragamos
//                  {
//                  Valores.push(Cadena[p]); // guardamos el estado que este caso contiene el valor
//                  VId.push(Cadena[p]);
//                  }
                  VId.push(Cadena[p]);
                  p++;
              }
              else if(edo != null && edo.getTipo().equals("R"))
              {
                  //Resolvemos la ecuacion matematica
                  int dest = edo.getDest();
                  if(dest==1)
                  {
                      System.out.println("ES SUMA");
                      String sim2 = VId.pop();
                      VId.pop();
                      String sim1 = VId.pop();
                      String sim3 = tablaSimbolos.getObj().insertaNum(0.0);
                      System.out.println(sim3 +"="+sim1+"+"+sim2);
                      VId.push(sim3);
                      //GENERACION ASM
                      asmWriter.getObj().addCode("LEA AX,"+sim3);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim2);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim1);
                      asmWriter.getObj().addCode("PUSH AX");
                       asmWriter.getObj().addCode("CALL _suma");
                       asmWriter.getObj().addCode("MOV AX,6");
                      asmWriter.getObj().addCode("ADD SP,AX");
                      
                      
                      //FIN GENERACION ASM
                      
//                      double num2 = Double.parseDouble(Valores.pop());
//                      Valores.pop();
//                      double num1 = Double.parseDouble(Valores.pop());
//                      int res = (int)num1 + (int)num2;
//                      Valores.push(String.valueOf(res)); //metemos a la pila el resultado
                  }else if(dest == 2)
                  {
                      String sim1 = VId.pop();
                      VId.pop();
                      String sim2 = VId.pop();
                      String sim3 = tablaSimbolos.getObj().insertaNum(0.0);
                      System.out.println(sim3 +"="+sim1+"-"+sim2);
                      VId.push(sim3);
                      //GENERACION ASM
                      asmWriter.getObj().addCode("LEA AX,"+sim3);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim2);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim1);
                      asmWriter.getObj().addCode("PUSH AX");
                       asmWriter.getObj().addCode("CALL _resta");
                       asmWriter.getObj().addCode("MOV AX,6");
                      asmWriter.getObj().addCode("ADD SP,AX");
                      
                      
                      //FIN GENERACION ASM
                      
                      System.out.println("ES RESTA");
//                      double num2 = Double.parseDouble(Valores.pop());
//                      Valores.pop();
//                      double num1 = Double.parseDouble(Valores.pop());
//                      int res = (int)num1 - (int)num2;
//                      Valores.push(String.valueOf(res)); //metemos a la pila el resultado
                  }else if(dest == 4)
                  {
                      System.out.println("ES MUltiplicacion");
                      String sim1 = VId.pop();
                      VId.pop();
                      String sim2 = VId.pop();
                      String sim3 = tablaSimbolos.getObj().insertaNum(0.0);
                      VId.push(sim3);
                      System.out.println(sim3 +"="+sim1+"*"+sim2);
                       //GENERACION ASM
                      asmWriter.getObj().addCode("LEA AX,"+sim3);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim2);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim1);
                      asmWriter.getObj().addCode("PUSH AX");
                       asmWriter.getObj().addCode("CALL _multi");
                       asmWriter.getObj().addCode("MOV AX,6");
                      asmWriter.getObj().addCode("ADD SP,AX");
                      
                      
                      //FIN GENERACION ASM
                      
//                      double num2 = Double.parseDouble(Valores.pop());
//                      Valores.pop();
//                      double num1 = Double.parseDouble(Valores.pop());
//                      int res = (int)num1 * (int)num2;
//                      Valores.push(String.valueOf(res)); //metemos a la pila el resultado
                  }else if(dest == 5)
                  {
                      System.out.println("ES DIVISION");
                      
                      String sim1 = VId.pop();
                      VId.pop();
                      String sim2 = VId.pop();
                      String sim3 = tablaSimbolos.getObj().insertaNum(0.0);
                      VId.push(sim3);
                      System.out.println(sim3 +"="+sim1+"/"+sim2);
                       //GENERACION ASM
                      asmWriter.getObj().addCode("LEA AX,"+sim3);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim2);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim1);
                      asmWriter.getObj().addCode("PUSH AX");
                       asmWriter.getObj().addCode("CALL _divi");
                       asmWriter.getObj().addCode("MOV AX,6");
                      asmWriter.getObj().addCode("ADD SP,AX");
                      
                      
                      //FIN GENERACION ASM
                      
//                      double num2 = Double.parseDouble(Valores.pop());
//                      Valores.pop();
//                      double num1 = Double.parseDouble(Valores.pop());
//                      if(num2 <= 0)//Checamos la division por 0
//                      {
//                          System.out.println("ERROR EN DIVISION POR 0"); 
//                          return null;
//                      }
//                      if(num1 == 0)
//                      {
//                            Valores.push(String.valueOf(0)); //si es 0 entonces metemos un 0 a la pila
//                      }
//                      else
//                      {
//                      int res = (int)num1 / (int)num2;
//                      
//                      Valores.push(String.valueOf(res)); //metemos a la pila el resultado
//                      
//                      }
                   }else if(dest == 7)
                  {
                      System.out.println("son parentesis");
                      VId.pop();
                      String sim1 = VId.pop();
                      VId.pop();
                      String sim3 = tablaSimbolos.getObj().insertaNum(0.0);
                      VId.push(sim3);
                     
                      
                      System.out.println(sim3 +"="+sim1);
                      //GENERACION ASM
                      asmWriter.getObj().addCode("LEA AX,"+sim3);
                      asmWriter.getObj().addCode("PUSH AX");
                      asmWriter.getObj().addCode("LEA AX,"+sim1);
                      asmWriter.getObj().addCode("PUSH AX");
                       asmWriter.getObj().addCode("CALL _iguala");
                       asmWriter.getObj().addCode("MOV AX,4");
                      asmWriter.getObj().addCode("ADD SP,AX");
                      
                      
//                      //FIN GENERACION ASM
//                      Valores.pop();
//                      double num1 = Double.parseDouble(Valores.pop());
//                      Valores.pop();
//                     
//                      Valores.push(String.valueOf(num1)); //metemos a la pila el resultado
                  }
                  
                  //Obtemeos de la gramatica el numero de produccion mediante el estado que es R
                  
                  Estado prod = Gramatica.get(edo.getDest());
                  //Obtemeos la cantidad de desplazamientos que se tendra de acuerdo a la produccion
                  
                  for(int i=0;i<prod.getDest();i++)
                  {
                      //Sacamos de la pila
                      pila.pop();
                  }
                  //Obteemos el estado que se tiene que meter de los cuales estan en prod que son (A,B,C)
                  Estado p1 = Tabla.get(pila.peek().toString()+""+prod.getTipo());
                  pila.push(p1.getDest());
                  
              }
              else if(edo != null && edo.getTipo().equals("A"))
              {
                  
                  return VId.peek();
              }
              else
              {
                  return null;
              }
        }
        
    }
}