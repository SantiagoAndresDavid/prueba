
package Dominio;


public class Usuario 
{
    private int codigo;
    private String nombre;
    private String contraseña;
    private Roles rol;

    public Usuario()
    {
        this(1," ", " ");
    }

    public Usuario(int codigo, String nombre, String contraseña)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = new Roles();
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

    public String getContraseña() 
    {
        return contraseña;
    }

    public void setContraseña(String contraseña) 
    {
        this.contraseña = contraseña;
    }

    public Roles getRol() 
    {
        return rol;
    }

    public void setRol(Roles rol) 
    {
        this.rol = rol;
    }
    
    void agregarRol(Roles rol)
    {
        this.rol = rol; 
    }
}
