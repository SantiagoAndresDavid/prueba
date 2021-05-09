
package Dominio;


public class Serie 
{
    private int codigo;
    private String descripcion;
    private Subserie subserie[];
    private int n;
    
    public Serie()
    {
        this(1," ");
    }

    public Serie(int codigo, String descripcion)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.subserie = new Subserie[30];
        this.n = 0;
    }

    public int getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public Subserie[] getSubserie() 
    {
        return subserie;
    }

    public void setSubserie(Subserie[] subserie) 
    {
        this.subserie = subserie;
    }
    
    public int getN()
    {
        return n;
    }

    public void setN(int n) 
    {
        this.n = n;
    }
    
    void agregarSubserie(Subserie subs)
    {
        this.subserie[n] = subs;
        n++;
    }
}
