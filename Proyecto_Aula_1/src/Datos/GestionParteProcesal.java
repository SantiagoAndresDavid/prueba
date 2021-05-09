
package Datos;

import Dominio.ParteProcesal;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionParteProcesal implements IGestionDatos<ParteProcesal>
{
    private List<ParteProcesal> listpartep;

    public List<ParteProcesal> getListpartep() 
    {
        return listpartep;
    }

    public void setListpartep(List<ParteProcesal> listpartep) 
    {
        this.listpartep = listpartep;
    }

    public GestionParteProcesal() 
    {
        this.listpartep = new ArrayList<>();
    }
    
    @Override
    public void insertar(ParteProcesal dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listpartep.add(dato);
    }

    @Override
    public void eliminar(ParteProcesal dato) throws ExcepcionAccesoDatos 
    {
        ParteProcesal encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listpartep.remove(encontrado);
    }

    @Override
    public List<ParteProcesal> leer() throws ExcepcionAccesoDatos 
    {
        return listpartep;
    }

    @Override
    public ParteProcesal buscar(ParteProcesal dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNombre()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        ParteProcesal encontrado = null;
        for(ParteProcesal part:listpartep)
        {
            if(part.getNombre().equals(dato.getNombre()))
            {
                encontrado = part;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(ParteProcesal original, ParteProcesal nuevo) throws ExcepcionAccesoDatos 
    {
        ParteProcesal encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
        encontrado.setTipoParte(nuevo.getTipoParte());
        encontrado.setTipoDocumento(nuevo.getTipoDocumento());
        encontrado.setDocumento(nuevo.getDocumento());
    }
    
}
