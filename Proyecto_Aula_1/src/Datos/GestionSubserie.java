
package Datos;

import Dominio.Subserie;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionSubserie implements IGestionDatos<Subserie>
{
    private List<Subserie> listSubs;

    public List<Subserie> getListSubs()
    {
        return listSubs;
    }

    public void setListSubs(List<Subserie> listSubs) 
    {
        this.listSubs = listSubs;
    }

    public GestionSubserie() 
    {
        this.listSubs = new ArrayList<>();
    }
    
    @Override
    public void insertar(Subserie dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getDescripcion()== null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene DESCRIPCION");
        }
        listSubs.add(dato);
    }

    @Override
    public void eliminar(Subserie dato) throws ExcepcionAccesoDatos 
    {
        Subserie encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listSubs.remove(encontrado);
    }

    @Override
    public List<Subserie> leer() throws ExcepcionAccesoDatos 
    {
        return listSubs;
    }

    @Override
    public Subserie buscar(Subserie dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getDescripcion()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        Subserie encontrado = null;
        for(Subserie sub:listSubs)
        {
            if(sub.getDescripcion().equals(dato.getDescripcion()))
            {
                encontrado = sub;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Subserie original, Subserie nuevo) throws ExcepcionAccesoDatos 
    {
        Subserie encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setDescripcion(nuevo.getDescripcion());
        encontrado.setTipoDocumental(nuevo.getTipoDocumental());
    }
    
}
