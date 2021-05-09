
package Dominio;


public class MetaDatoExpediente
{
    private int codigo;
    private Departamento departamento;
    private Ciudad ciudad;
    private DespachoJudicial despachoJudicial;
    private Serie serie;
    private Subserie subserie;
    private int numeroRadicacion;
    private ParteProcesal parteProcesal[];
    private Cuaderno numeroCuaderno[];
    private Cuaderno descripcionCuaderno[];
    private String expedienteFisico;
    private int n1;
    private int n2;
    private int n3;

    public MetaDatoExpediente() 
    {
        this(1, 677532664, " ");
    }

    public MetaDatoExpediente(int codigo, int numeroRadicacion, String expedienteFisico) 
    {
        this.codigo = codigo;
        this.departamento = new Departamento();
        this.ciudad = new Ciudad();
        this.despachoJudicial = new DespachoJudicial();
        this.serie = new Serie();
        this.subserie = new Subserie();
        this.numeroRadicacion = numeroRadicacion;
        this.parteProcesal = new ParteProcesal[10];
        this.numeroCuaderno = new Cuaderno[20];
        this.descripcionCuaderno = new Cuaderno[20];
        this.expedienteFisico = expedienteFisico;
        this.n1 = 0;
        this.n2 = 0;
        this.n3 = 0;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    public Departamento getDepartamento()
    {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) 
    {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() 
    {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) 
    {
        this.ciudad = ciudad;
    }

    public DespachoJudicial getDespachoJudicial() 
    {
        return despachoJudicial;
    }

    public void setDespachoJudicial(DespachoJudicial despachoJudicial) 
    {
        this.despachoJudicial = despachoJudicial;
    }

    public Serie getSerie()
    {
        return serie;
    }

    public void setSerie(Serie serie) 
    {
        this.serie = serie;
    }

    public Subserie getSubserie() 
    {
        return subserie;
    }

    public void setSubserie(Subserie subserie) 
    {
        this.subserie = subserie;
    }

    public int getNumeroRadicacion() 
    {
        return numeroRadicacion;
    }

    public void setNumeroRadicacion(int numeroRadicacion) 
    {
        this.numeroRadicacion = numeroRadicacion;
    }

    public ParteProcesal[] getParteProcesal() 
    {
        return parteProcesal;
    }

    public void setParteProcesal(ParteProcesal[] parteProcesal)
    {
        this.parteProcesal = parteProcesal;
    }

    public Cuaderno[] getNumeroCuaderno() 
    {
        return numeroCuaderno;
    }

    public void setNumeroCuaderno(Cuaderno[] numeroCuaderno)
    {
        this.numeroCuaderno = numeroCuaderno;
    }

    public Cuaderno[] getDescripcionCuaderno() 
    {
        return descripcionCuaderno;
    }

    public void setDescripcionCuaderno(Cuaderno[] descripcionCuaderno) 
    {
        this.descripcionCuaderno = descripcionCuaderno;
    }

    public String getExpedienteFisico()
    {
        return expedienteFisico;
    }

    public void setExpedienteFisico(String expedienteFisico) 
    {
        this.expedienteFisico = expedienteFisico;
    }

    public int getN1() 
    {
        return n1;
    }

    public void setN1(int n1) 
    {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2)
    {
        this.n2 = n2;
    }

    public int getN3() 
    {
        return n3;
    }

    public void setN3(int n3) 
    {
        this.n3 = n3;
    }
    
    void agregarParteProcesal(ParteProcesal parteP)
    {
        this.parteProcesal[n1] = parteP;
        n1++;
    }
    
    void agregarNumeroCuaderno(Cuaderno cuad)
    {
        this.numeroCuaderno[n2] = cuad;
        n2++;
    }
    
    void agregarDescripcionCuaderno(Cuaderno cuad)
    {
        this.descripcionCuaderno[n3] = cuad;
        n3++;
    }
    
    void agregarDepartamento(Departamento depar)
    {
        this.departamento = depar; 
    }
    
    void agregarDespachoJudicial(DespachoJudicial despaJ)
    {
        this.despachoJudicial = despaJ; 
    }
    
    void agregarSerie(Serie serie)
    {
        this.serie = serie;
    }
}
