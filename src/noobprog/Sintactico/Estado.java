package noobprog.Sintactico;

/**
 *
 * @author antonio
 */
public class Estado {

    public String getTipo() {
        return tipo;
    }



    public int getDest() {
        return Dest;
    }

    
    private String tipo;
    private int Dest;
    
    /**
     * 
     * @param tipo Que tipo de estado es R(reduccion), S(Desplazamiento), A(aceptado) o alguno no terminal de producciones 
     * @param Dest Hacia que Destino Va ir 
     */
    public Estado(String tipo, int Dest)
    {
        //S
        this.tipo = tipo;
        this.Dest = Dest;     
    }
}
