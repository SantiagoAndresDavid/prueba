
package Datos;

import Excepciones.ExcepcionAccesoDatos;
import java.util.List;


public interface IGestionDatos<T>
{
    void insertar(T dato)throws ExcepcionAccesoDatos;
    void eliminar(T dato)throws ExcepcionAccesoDatos;
    List<T> leer()throws ExcepcionAccesoDatos;
    T buscar(T dato)throws ExcepcionAccesoDatos;
    void actualizar(T original,T nuevo)throws ExcepcionAccesoDatos;
}
