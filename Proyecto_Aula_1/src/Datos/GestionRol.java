
package Datos;

import Dominio.Roles;

import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;

public class GestionRol implements IGestionDatos<Roles>
{
    private List<Roles> listRoles;

    public List<Roles> getListRoles()
    {
        return listRoles;
    }

    public void setListRoles(List<Roles> listRoles)
    {
        this.listRoles = listRoles;
    }

    public GestionRol() 
    {
        this.listRoles = new ArrayList<>();
    }
    
    @Override
    public void insertar(Roles dato) throws ExcepcionAccesoDatos
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listRoles.add(dato);
    }

    @Override
    public void eliminar(Roles dato) throws ExcepcionAccesoDatos
    {
        Roles encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listRoles.remove(encontrado);
    }

    @Override
    public List<Roles> leer() throws ExcepcionAccesoDatos 
    {
        return listRoles;
    }

    @Override
    public Roles buscar(Roles dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNombre()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        Roles encontrado = null;
        for(Roles rol:listRoles)
        {
            if(rol.getNombre().equals(dato.getNombre()))
            {
                encontrado = rol;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Roles original, Roles nuevo) throws ExcepcionAccesoDatos 
    {
        Roles encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
    }
}
