
package Dominio;

public class ParteProcesal 
{
    private int codigo;
    private String tipoParte;
    private String nombre;
    private int documento;
    private String tipoDocumento;
    
    public ParteProcesal()
    {
        
    }
    
    public ParteProcesal(int codigo, String tipoP, String nombre, int documento, String tipoD)
    {
        this.codigo = codigo;
        this.tipoParte = tipoP;
        this.nombre = nombre;
        this.documento = documento;
        this.tipoDocumento = tipoD;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte)
    {
        this.tipoParte = tipoParte;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getDocumento() 
    {
        return documento;
    }

    public void setDocumento(int documento)
    {
        this.documento = documento;
    }

    public String getTipoDocumento() 
    {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento)
    {
        this.tipoDocumento = tipoDocumento;
    }
}
