
package Dominio;


public class Proceso 
{
    private int codigo;
    private MetaDatoExpediente metadatosExpediente;
    private MetaDatoDocumento metadatosDocumento;

    public Proceso()
    {
        this(1);
    }

    public Proceso(int codigo)
    {
        this.codigo = codigo;
        this.metadatosExpediente = new MetaDatoExpediente();
        this.metadatosDocumento = new MetaDatoDocumento();
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public MetaDatoExpediente getMetadatosExpediente() 
    {
        return metadatosExpediente;
    }

    public void setMetadatosExpediente(MetaDatoExpediente metadatosExpediente) 
    {
        this.metadatosExpediente = metadatosExpediente;
    }

    public MetaDatoDocumento getMetadatosDocumento() 
    {
        return metadatosDocumento;
    }

    public void setMetadatosDocumento(MetaDatoDocumento metadatosDocumento) 
    {
        this.metadatosDocumento = metadatosDocumento;
    }
    
    void agregarMetadatoExpediente(MetaDatoExpediente metaE)
    {
        this.metadatosExpediente = metaE; 
    }
    
    void agregarMetadatoDocumento(MetaDatoDocumento metaD)
    {
        this.metadatosDocumento = metaD;
    }
}
