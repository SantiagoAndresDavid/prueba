
package Datos;

import Dominio.MetaDatoDocumento;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionMetadatoDocumento implements IGestionDatos<MetaDatoDocumento>
{
    private List<MetaDatoDocumento> listmetaD;

    public List<MetaDatoDocumento> getListmetaD() {
        return listmetaD;
    }

    public void setListmetaD(List<MetaDatoDocumento> listmetaD) {
        this.listmetaD = listmetaD;
    }

    public GestionMetadatoDocumento()
    {
        this.listmetaD = new ArrayList<>();
    }

    @Override
    public void insertar(MetaDatoDocumento dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listmetaD.add(dato);
    }

    @Override
    public void eliminar(MetaDatoDocumento dato) throws ExcepcionAccesoDatos 
    {
        MetaDatoDocumento encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listmetaD.remove(encontrado);
    }

    @Override
    public List<MetaDatoDocumento> leer() throws ExcepcionAccesoDatos 
    {
        return listmetaD;
    }

    @Override
    public MetaDatoDocumento buscar(MetaDatoDocumento dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNombre()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        MetaDatoDocumento encontrado = null;
        for(MetaDatoDocumento metaD:listmetaD)
        {
            if(metaD.getNombre().equals(dato.getNombre()))
            {
                encontrado = metaD;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(MetaDatoDocumento original, MetaDatoDocumento nuevo) throws ExcepcionAccesoDatos 
    {
        MetaDatoDocumento encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
        encontrado.setFechaCreada(nuevo.getFechaCreada());
        encontrado.setFechaIncorporada(nuevo.getFechaIncorporada());
        encontrado.setOrden(nuevo.getOrden());
        encontrado.setNumeroPaginas(nuevo.getNumeroPaginas());
        encontrado.setPagInicio(nuevo.getPagInicio());
        encontrado.setPagFinal(nuevo.getPagFinal());
        encontrado.setFormato(nuevo.getFormato());
        encontrado.setTamaño(nuevo.getTamaño());
        encontrado.setOrigen(nuevo.getOrigen());
        encontrado.setObservacion(nuevo.getObservacion());
    }
    
}
