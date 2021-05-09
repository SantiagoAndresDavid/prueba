
package Datos;

import Dominio.Usuario;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionUsuario implements IGestionDatos<Usuario>
{
    private List<Usuario> listUsuario;

    public List<Usuario> getListUsuario()
    {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario)
    {
        this.listUsuario = listUsuario;
    }

    public GestionUsuario()
    {
        this.listUsuario = new ArrayList<>();
    }

    @Override
    public void insertar(Usuario dato) throws ExcepcionAccesoDatos
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listUsuario.add(dato);
    }

    @Override
    public void eliminar(Usuario dato) throws ExcepcionAccesoDatos
    {
        Usuario encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listUsuario.remove(encontrado);
    }

    @Override
    public List<Usuario> leer() throws ExcepcionAccesoDatos
    {
        return listUsuario;
    }

    @Override
    public Usuario buscar(Usuario dato) throws ExcepcionAccesoDatos
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNombre()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        Usuario encontrado = null;
        for(Usuario usu:listUsuario)
        {
            if(usu.getNombre().equals(dato.getNombre()))
            {
                encontrado = usu;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Usuario original, Usuario nuevo) throws ExcepcionAccesoDatos 
    {
        Usuario encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
        encontrado.setContraseña(nuevo.getContraseña());
    }  
}
