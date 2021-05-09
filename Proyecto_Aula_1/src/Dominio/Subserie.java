
package Dominio;

public class Subserie 
{
    private int codigo;
    private String descripcion;
    private TipoDocumental tipoDocumental[];
    private int n;

    public Subserie()
    {
        this(1," ");
    }

    public Subserie(int codigo, String descripcion) 
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoDocumental = new TipoDocumental[30];
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

    public TipoDocumental[] getTipoDocumental()
    {
        return tipoDocumental;
    }

    public void setTipoDocumental(TipoDocumental[] tipoDocumental) 
    {
        this.tipoDocumental = tipoDocumental;
    }
    
    public int getN() 
    {
        return n;
    }

    public void setN(int n) 
    {
        this.n = n;
    }
    
    void agregarTipoDocumental(TipoDocumental tipoD)
    {
        this.tipoDocumental[n] = tipoD;
        n++;
    }
}
