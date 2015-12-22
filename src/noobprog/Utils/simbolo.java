/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noobprog.Utils;

/**
 *
 * @author antoniocg
 */
public class simbolo {
    private Object valor;
    private String nombre;
    private String tipo;
    public simbolo(String nom,String tipo, Object valor)
    {
        this.valor = valor;
        this.nombre = nom;
        this.tipo = tipo;
    }
    
    
    
    public void setValor(Object valor) {
        if(valor == null)
        {
            this.valor = 0;
        }
        else
        {
            this.valor = valor;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
