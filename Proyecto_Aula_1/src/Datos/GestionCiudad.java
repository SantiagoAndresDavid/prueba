
package Datos;

import Dominio.Ciudad;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionCiudad implements IGestionDatos<Ciudad>
{
    private List<Ciudad> listCiu;

    public List<Ciudad> getListCiu() {
        return listCiu;
    }

    public void setListCiu(List<Ciudad> listCiu) {
        this.listCiu = listCiu;
    }

    public GestionCiudad() 
    {
        this.listCiu = new ArrayList<>();
    }

    @Override
    public void insertar(Ciudad dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listCiu.add(dato);
    }

    @Override
    public void eliminar(Ciudad dato) throws ExcepcionAccesoDatos
    {
        Ciudad encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listCiu.remove(encontrado);
    }

    @Override
    public List<Ciudad> leer() throws ExcepcionAccesoDatos 
    {
        return listCiu;
    }

    @Override
    public Ciudad buscar(Ciudad dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNombre()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        Ciudad encontrado = null;
        for(Ciudad ciu:listCiu)
        {
            if(ciu.getNombre().equals(dato.getNombre()))
            {
                encontrado = ciu;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Ciudad original, Ciudad nuevo) throws ExcepcionAccesoDatos 
    {
        Ciudad encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
    }
}
