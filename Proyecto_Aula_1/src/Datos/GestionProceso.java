
package Datos;

import Dominio.Proceso;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;
import java.util.ArrayList;
import java.util.List;

public class GestionProceso implements IGestionDatos<Proceso>
{
    private List<Proceso> listproc;

    public List<Proceso> getListproc() 
    {
        return listproc;
    }

    public void setListproc(List<Proceso> listproc) 
    {
        this.listproc = listproc;
    }

    public GestionProceso() 
    {
        this.listproc = new ArrayList<>();
    }

    @Override
    public void insertar(Proceso dato) throws ExcepcionAccesoDatos 
    {
        if (dato == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getCodigo()== 0)
        {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene CODIGO");
        }
        listproc.add(dato);
    }

    @Override
    public void eliminar(Proceso dato) throws ExcepcionAccesoDatos 
    {
        Proceso encontrado = buscar(dato);
        if (encontrado == null) 
        {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listproc.remove(encontrado);
    }

    @Override
    public List<Proceso> leer() throws ExcepcionAccesoDatos 
    {
        return listproc;
    }

    @Override
    public Proceso buscar(Proceso dato) throws ExcepcionAccesoDatos 
    {
        if(dato==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(dato.getCodigo()==0)
            throw new ExcepcionAccesoDatos("El CODIGO a buscar es de tipo NULL");
        
        Proceso encontrado = null;
        for(Proceso prc:listproc)
        {
            if(String.valueOf(prc.getCodigo()).equals(dato.getCodigo()))
            {
                encontrado = prc;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Proceso original, Proceso nuevo) throws ExcepcionAccesoDatos 
    {
        Proceso encontrado = buscar(original);
        if (encontrado == null)
        {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setMetadatosExpediente(nuevo.getMetadatosExpediente());
        encontrado.setMetadatosDocumento(nuevo.getMetadatosDocumento());
    }
}
