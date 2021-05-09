
package Datos;

import Dominio.MetaDatoExpediente;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionMetadatoExpediente implements IGestionDatos<MetaDatoExpediente>
{
    private List<MetaDatoExpediente> listmetaE;

    public List<MetaDatoExpediente> getListmetaE() {
        return listmetaE;
    }

    public void setListmetaE(List<MetaDatoExpediente> listmetaE) {
        this.listmetaE = listmetaE;
    }

    public GestionMetadatoExpediente() 
    {
        this.listmetaE = new ArrayList<>();
    }

    @Override
    public void insertar(MetaDatoExpediente dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getCodigo() == 0)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene CODIGO");
        }
        listmetaE.add(dato);
    }

    @Override
    public void eliminar(MetaDatoExpediente dato) throws ExcepcionAccesoDatos 
    {
        MetaDatoExpediente encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listmetaE.remove(encontrado);
    }

    @Override
    public List<MetaDatoExpediente> leer() throws ExcepcionAccesoDatos 
    {
        return listmetaE;
    }

    @Override
    public MetaDatoExpediente buscar(MetaDatoExpediente dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getCodigo()==0)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        MetaDatoExpediente encontrado = null;
        for(MetaDatoExpediente metaE:listmetaE)
        {
            if(String.valueOf(metaE.getCodigo()).equals(dato.getCodigo()))
            {
                encontrado = metaE;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(MetaDatoExpediente original, MetaDatoExpediente nuevo) throws ExcepcionAccesoDatos
    {
        MetaDatoExpediente encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setDepartamento(nuevo.getDepartamento());
        encontrado.setCiudad(nuevo.getCiudad());
        encontrado.setDespachoJudicial(nuevo.getDespachoJudicial());
        encontrado.setSerie(nuevo.getSerie());
        encontrado.setSubserie(nuevo.getSubserie());
        encontrado.setNumeroRadicacion(nuevo.getNumeroRadicacion());
        encontrado.setParteProcesal(nuevo.getParteProcesal());
        encontrado.setNumeroCuaderno(nuevo.getNumeroCuaderno());
        encontrado.setDescripcionCuaderno(nuevo.getDescripcionCuaderno());
        encontrado.setExpedienteFisico(nuevo.getExpedienteFisico());
    }
    
}
