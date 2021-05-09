
package Dominio;

public class Departamento 
{
    private int codigo;
    private String nombre;
    private Ciudad nombreCiudad[];
    private int n;

    public Departamento() 
    {
        this(1," ");
    }

    public Departamento(int codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreCiudad = new Ciudad[40];
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

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Ciudad[] getNombreCiudad()
    {
        return nombreCiudad;
    }

    public void setNombreCiudad(Ciudad[] nombreCiudad)
    {
        this.nombreCiudad = nombreCiudad;
    }
    
    public int getN() 
    {
        return n;
    }

    public void setN(int n) 
    {
        this.n = n;
    }
    
    void agregarCiudad(Ciudad ciu)
    {
        this.nombreCiudad[n] = ciu;
        n++;
    }
}
