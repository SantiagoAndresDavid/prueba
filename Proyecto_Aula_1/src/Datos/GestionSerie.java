
package Datos;

import Dominio.Serie;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionSerie implements IGestionDatos<Serie>
{
    private List<Serie> listserie;

    public List<Serie> getListserie() {
        return listserie;
    }

    public void setListserie(List<Serie> listserie) {
        this.listserie = listserie;
    }

    public GestionSerie() 
    {
        this.listserie = new ArrayList<>();
    }
    
    @Override
    public void insertar(Serie dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getDescripcion()== null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene DESCRIPCION");
        }
        listserie.add(dato);
    }

    @Override
    public void eliminar(Serie dato) throws ExcepcionAccesoDatos
    {
        Serie encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listserie.remove(encontrado);
    }

    @Override
    public List<Serie> leer() throws ExcepcionAccesoDatos
    {
        return listserie;
    }

    @Override
    public Serie buscar(Serie dato) throws ExcepcionAccesoDatos
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getDescripcion()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        Serie encontrado = null;
        for(Serie seri:listserie)
        {
            if(seri.getDescripcion().equals(dato.getDescripcion()))
            {
                encontrado = seri;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Serie original, Serie nuevo) throws ExcepcionAccesoDatos 
    {
        Serie encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setDescripcion(nuevo.getDescripcion());
        encontrado.setSubserie(nuevo.getSubserie());
    }
    
}
