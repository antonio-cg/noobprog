/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author antoniocg
 */
public class tablaSimbolos {
    private static final  Map<String,simbolo> vals = new HashMap<>();
    private static  int id = 0;
    private static tablaSimbolos singleSimbolos = new tablaSimbolos();
    private tablaSimbolos()
    {
        
    }
    /**
     * Obtiene el siguiente numero que se generara
     * @return 
     */
    public  int getNextId()
    {
        return id;
    }
    public void insertaSimbolo(String nom,String tipo,Object val)
    {  
        if(val==null)
        {
            val = 0.0;
        }
        System.out.println("Insertamos "+nom+" del tipo "+tipo+"con valor "+val +"con id" + id);
        vals.put(nom,new simbolo("id"+id,tipo,val));
        id++;
    }
    
    //para insertar un numero dentro de la tabla pero el nombre quedara como id+numero
    public String insertaNum(Double n)
    {
       System.out.println("+++++++++++++++++++++++Insertamos numero con id"+id+"con valor "+n);

        vals.put("id"+id, new simbolo("id"+id,"num",n));
        String idR = "id" + id;
        id++;
        return idR;
    }
    
    public String getId(String nom)
    {
        System.out.println(nom);
        String s = vals.get(nom).getNombre();
        if(s.isEmpty())
        {
            return ""; 
        }
       return s ;
    }
    public String getTipo(String nom)
    {
        String s = vals.get(nom).getTipo();
        if(s.isEmpty())
        {
            return ""; 
        }
       return s ;
    }
    
    public String getTipoById(String id)
    {
        for(simbolo val : vals.values())
       {
           if(val.getNombre().equals(id))
           {
               return val.getTipo();
           }
           
       }
        return null;
    }
    
    public Object getValorById(String id)
    {
        for(simbolo val : vals.values())
       {
           if(val.getNombre().equals(id))
           {
               return val.getValor();
           }
           
       }
        return null;
    }
    
    public Object getValor(String nom)
    {
    System.out.println("Buscando "+nom);
    
    if(vals.get(nom) == null)
    {
        return null;
    }
       return vals.get(nom).getValor();
    }
    
    public Object getById(String id)
    {
       for(simbolo val : vals.values())
       {
           if(val.getNombre().equals(id))
           {
               return val.getValor();
           }
           
       }
    
       return null;
    }
    
    public boolean estaDeclarada(String s)
    {
        System.out.println("VARIABLE DECLARADA "+s);
        Boolean r = vals.containsKey(s);
        return r;
    }
    /**
     * iimprime tabla de simbolos
     */
    public void print()
    {
        System.out.println("=====================================================");
        System.out.println("==================TABLA DE SIMBOLOS==================");
      Iterator it = vals.entrySet().iterator();
      
      while(it.hasNext())
      {
          Map.Entry e = (Map.Entry)it.next();
          simbolo s = (simbolo)e.getValue();
          System.out.print(e.getKey()+" "+s.getValor()+" "+s.getNombre()+" "+s.getTipo()+" ");
          System.out.println("");
          
      }
      
    }
    //Parte del objeto singleton para obtener la instacia
    public static tablaSimbolos getObj()
    {
        return singleSimbolos;
    }
    
    
    
    public void modificarValor(String nom,Object valor)
    {
        vals.get(nom).setValor(valor);
    }
    
    public void addToAsm()
    {
         Iterator it = vals.entrySet().iterator();
      
      while(it.hasNext())
      {
          String str = "";
          Map.Entry e = (Map.Entry)it.next();
          simbolo s = (simbolo)e.getValue();
          
            if(s.getValor().getClass().equals(Double.class))
            {
                Double temp = (double)s.getValor();
                str = s.getNombre()+ " dw "+ temp.intValue();
            }
            else if(s.getValor().getClass().equals(String.class))
            {
            str = s.getNombre()+ " db "+ s.getValor() +",11" ;
            }
            asmWriter.getObj().addData(str);
            //System.out.print(e.getKey()+" "+s.getValor()+" "+s.getNombre()+" "+s.getTipo()+" ");
            //System.out.println("");
          }
      
    }
}
