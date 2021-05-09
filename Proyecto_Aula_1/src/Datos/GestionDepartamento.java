
package Datos;

import Dominio.Departamento;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;


public class GestionDepartamento implements IGestionDatos<Departamento>
{
    private List<Departamento> listdepar;

    public List<Departamento> getListdepar() {
        return listdepar;
    }

    public void setListdepar(List<Departamento> listdepar) {
        this.listdepar = listdepar;
    }

    public GestionDepartamento() 
    {
        this.listdepar = new ArrayList<>();
    }

    @Override
    public void insertar(Departamento dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listdepar.add(dato);
    }

    @Override
    public void eliminar(Departamento dato) throws ExcepcionAccesoDatos 
    {
        Departamento encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listdepar.remove(encontrado);
    }

    @Override
    public List<Departamento> leer() throws ExcepcionAccesoDatos 
    {
        return listdepar;
    }

    @Override
    public Departamento buscar(Departamento dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNombre()==null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");
        
        Departamento encontrado = null;
        for(Departamento dep:listdepar)
        {
            if(dep.getNombre().equals(dato.getNombre()))
            {
                encontrado = dep;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Departamento original, Departamento nuevo) throws ExcepcionAccesoDatos 
    {
        Departamento encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
        encontrado.setNombreCiudad(nuevo.getNombreCiudad());
    }
    
}
