
package Datos;

import Dominio.Cuaderno;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;

public class GestionCuaderno implements IGestionDatos<Cuaderno>
{
    private List<Cuaderno> listCuad;

    public List<Cuaderno> getListCuad() {
        return listCuad;
    }

    public void setListCuad(List<Cuaderno> listCuad) {
        this.listCuad = listCuad;
    }

    public GestionCuaderno() 
    {
        this.listCuad = new ArrayList<>();
    }

    @Override
    public void insertar(Cuaderno dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNumeroCuadernos() == 0)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene CUADERNOS");
        }
        listCuad.add(dato);
    }

    @Override
    public void eliminar(Cuaderno dato) throws ExcepcionAccesoDatos 
    {
        Cuaderno encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listCuad.remove(encontrado);
    }

    @Override
    public List<Cuaderno> leer() throws ExcepcionAccesoDatos 
    {
        return listCuad;
    }

    @Override
    public Cuaderno buscar(Cuaderno dato) throws ExcepcionAccesoDatos
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getNumeroCuadernos()==0)
            throw new ExcepcionAccesoDatos("El CUADERNO a buscar es de tipo NULL");
        
        Cuaderno encontrado = null;
        for(Cuaderno cua:listCuad)
        {
            if(String.valueOf(cua.getNumeroCuadernos()).equals(dato.getNumeroCuadernos()))
            {
                encontrado = cua;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Cuaderno original, Cuaderno nuevo) throws ExcepcionAccesoDatos 
    {
        Cuaderno encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNumeroCuadernos(nuevo.getNumeroCuadernos());
        encontrado.setDescripcion(nuevo.getDescripcion());
    }
    
}
