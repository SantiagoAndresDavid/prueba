
package Dominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class Principal
{
    public static void main(String[] args)
    {
        //PRUEBA CLASE TIPO DOCUMENTAL
        System.out.println("*****************************PRUEBA TIPO DOCUMENTAL****************************\n");
        TipoDocumental tipoD = new TipoDocumental(10, "Desacato");
        System.out.println(tipoD.getCodigo()+ " " + tipoD.getDescripcion());
        
        //PRUEBA CLASE SUBSERIE
        System.out.println("*****************************PRUEBA SUBSERIE****************************\n");
        Subserie subS = new Subserie(12, "Acciones de tutela");
        subS.agregarTipoDocumental(tipoD);
        System.out.println(subS.getCodigo()+" "+subS.getDescripcion());
        for (int i = 0; i < subS.getN(); i++) 
        {
            System.out.println(subS.getTipoDocumental()[i].getDescripcion());
        }
        
        //PRUEBA CLASE SERIE
        System.out.println("*****************************PRUEBA SERIE****************************\n");
        Serie series = new Serie(5, "acciones constitucionales");
        series.agregarSubserie(subS);
        System.out.println(series.getCodigo()+" "+series.getDescripcion());
        for (int i = 0; i < series.getN(); i++) 
        {
            System.out.println(series.getSubserie()[i].getDescripcion());
        }
        
        //PRUEBA CLASE CUADERNO
        System.out.println("*****************************PRUEBA CUADERNO****************************\n");
        Cuaderno cuaderno = new Cuaderno(1, 10, "cuaderno verde");
        System.out.println("codigo"+" "+cuaderno.getCodigo()+" "+"numero de cuadernoos"+" "+ cuaderno.getNumeroCuadernos()+" "+ cuaderno.getDescripcion());
        
        //PRUEBA CLASE PARTE PROCESAL
        System.out.println("*****************************PRUEBA PARTE PROCESAL****************************\n");
        ParteProcesal parteP = new ParteProcesal(1, "persona natural", "jhon santana", 1067, "cedula");
        System.out.println("codigo: "+" "+ parteP.getCodigo()+" "+
                            "tipo de persona: "+" "+parteP.getTipoParte()+" "+"nombre: "+" "+
                                parteP.getNombre()+" "+"tipo de documento: "+" "+parteP.getTipoDocumento());
        
        //PRUEBA CLASE DESPACHO JUDICIAL
        System.out.println("*****************************PRUEBA DESPACHO JUDICIAL****************************\n");
        DespachoJudicial despaJudicial = new DespachoJudicial(1, "despacho del cesar", "cesar", "valledupar", "municipal");
        System.out.println("codigo: "+" "+ despaJudicial.getCodigo()+" "+"nombre: "+" "+ despaJudicial.getNombre()+" "+
                            "departamento: "+" "+ despaJudicial.getDepartamento()+" "+"Ciudad: "+" "+ despaJudicial.getCiudad()+" "+
                            "categoria: "+" "+ despaJudicial.getCategoria());
        
        //PRUEBA CLASE CIUDAD
        System.out.println("*****************************PRUEBA CIUDAD****************************\n");
        Ciudad ciu = new Ciudad(1, "valledupar");
        System.out.println("codigo: "+" "+ ciu.getCodigo()+" "+"nombre: "+ ciu.getNombre());
        
        //PRUEBA CLASE DEPARTAMENTO
        System.out.println("*****************************PRUEBA DEPARTAMENTO****************************\n");
        Departamento depar = new Departamento(1, "cesar");
        depar.agregarCiudad(ciu);
        System.out.println("codigo: "+" "+ depar.getCodigo()+" "+"nombre: "+ depar.getNombre());
        for (int i = 0; i < depar.getN(); i++) 
        {
            System.out.println(depar.getNombreCiudad()[i].getNombre());
        }
        
        //PRUEBA CLASE METADATOS EXPEDIENTE
        MetaDatoExpediente metaExped = new MetaDatoExpediente(11, 645654655, "Si");
        metaExped.agregarParteProcesal(parteP);
        System.out.println("*********************METADATOS EXPEDIENTE***************************");
        System.out.println("codigo: " + metaExped.getCodigo()+" "+ "numero radicacion" +" "+ metaExped.getNumeroRadicacion()+
                            " "+ "expediente fisico" +" "+ metaExped.getExpedienteFisico());
        for (int i = 0; i < metaExped.getN1(); i++) 
        {
            System.out.println("parte procesal: "+" "+metaExped.getParteProcesal()[i].getNombre());
        }
        
        metaExped.agregarNumeroCuaderno(cuaderno);
        for (int i = 0; i < metaExped.getN2(); i++)
        {
            System.out.println("numero cuadernos: "+" "+metaExped.getNumeroCuaderno()[i].getNumeroCuadernos());
        }
        
        metaExped.agregarDescripcionCuaderno(cuaderno);
        for (int i = 0; i < metaExped.getN3(); i++) 
        {
            System.out.println("descripcion cuaderno: "+" "+metaExped.getDescripcionCuaderno()[i].getDescripcion());
        }
        
        metaExped.agregarDepartamento(depar);
        System.out.println("departamento: "+ metaExped.getDepartamento().getNombre());
        for (int i = 0; i < depar.getN(); i++) 
        {
            System.out.println("ciudad: "+depar.getNombreCiudad()[i].getNombre());
        }
        
        metaExped.agregarDespachoJudicial(despaJudicial);
        System.out.println("despacho judicial: "+metaExped.getDespachoJudicial().getNombre());
        
        metaExped.agregarSerie(series);
        System.out.println("serie: "+ metaExped.getSerie().getDescripcion());
        for (int i = 0; i < series.getN(); i++) 
        {
            System.out.println("subserie: "+ series.getSubserie()[i].getDescripcion());
        }
        for (int i = 0; i < subS.getN(); i++) 
        {
            System.out.println("tipo documental: " +subS.getTipoDocumental()[i].getDescripcion());
        }
        
        //PRUEBA CLASE METADATOS DOCUMENTOS
        System.out.println("*********************METADATOS DOCUMENTO***************************");
        
        Date fecha = null;
        Date fecha1 = null;
        try
        {
            SimpleDateFormat fechaHora = new SimpleDateFormat("yyyy/MM/dd");
            String Date = fechaHora.format(new Date("2015/11/02"));
            String Date1 = fechaHora.format(new Date("2018/07/08"));
            fecha = fechaHora.parse(Date);
            fecha1 = fechaHora.parse(Date1);
        }catch (ParseException ex){
            
        }
        
        MetaDatoDocumento metaD = new MetaDatoDocumento(13, "accion de tutela",  fecha, fecha1, 1, 15, 1, 15, "pdf", 500, "digitalizado", "todo bien");
        System.out.println("codigo: "+ metaD.getCodigo()+" "+ "nombre: "+ " "+ metaD.getNombre());
        System.out.println("fecha creada: "+metaD.getFechaCreada());
        System.out.println("fecha incorporada: "+metaD.getFechaIncorporada());
        System.out.println("orden: "+ metaD.getOrden()+" " +"numero paginas: " + metaD.getNumeroPaginas()+" "+ 
                            "pagina inicio: "+" "+ metaD.getPagInicio()+" "+"pagina final: "+" "+ metaD.getPagFinal());
        System.out.println("formato: "+ metaD.getFormato()+" "+"tamaño: "+ metaD.getTamaño()+" "+"origen: "+ metaD.getOrigen()+
                            " "+"observacion: "+ metaD.getObservacion());
        
        //PRUEBA CLASE PROCESO
        System.out.println("*********************PROCESO***************************");
        Proceso prc = new Proceso(1);
        System.out.println("codigo: " + prc.getCodigo());
        prc.agregarMetadatoExpediente(metaExped);
        System.out.println("********Metadatos Expediente********");
        System.out.println("codigo: "+prc.getMetadatosExpediente().getCodigo());
        System.out.println("departamento: "+prc.getMetadatosExpediente().getDepartamento().getNombre());
        for (int i = 0; i < depar.getN(); i++) 
        {
            System.out.println("ciudad: "+ prc.getMetadatosExpediente().getDepartamento().getNombreCiudad()[i].getNombre());
        }
        System.out.println("despacho judicial: "+prc.getMetadatosExpediente().getDespachoJudicial().getNombre());
        System.out.println("Serie: "+prc.getMetadatosExpediente().getSerie().getDescripcion());
        for (int i = 0; i < series.getN(); i++) 
        {
            System.out.println("subserie: "+ prc.getMetadatosExpediente().getSerie().getSubserie()[i].getDescripcion());
        }
        System.out.println("numero radicacion: "+ prc.getMetadatosExpediente().getNumeroRadicacion());
        for (int i = 0; i < metaExped.getN1(); i++) 
        {
            System.out.println("parte procesal: "+ prc.getMetadatosExpediente().getParteProcesal()[i].getNombre());
        }
        for (int i = 0; i < metaExped.getN1(); i++) 
        {
            System.out.println("numero de cuadernos: "+ prc.getMetadatosExpediente().getNumeroCuaderno()[i].getNumeroCuadernos());
        }   
        for (int i = 0; i < metaExped.getN1(); i++) 
        {
            System.out.println("descripcion cuadernos: "+ prc.getMetadatosExpediente().getDescripcionCuaderno()[i].getDescripcion());
        }
        System.out.println("expediente fisico: " + prc.getMetadatosExpediente().getExpedienteFisico());
        
        System.out.println("********Metadatos Expediente********");
        prc.agregarMetadatoDocumento(metaD);
        System.out.println("codigo: "+ prc.getMetadatosDocumento().getCodigo());
        System.out.println("nombre: "+ prc.getMetadatosDocumento().getNombre());
        System.out.println("fecha creada: "+ prc.getMetadatosDocumento().getFechaCreada());
        System.out.println("fecha incorporada: "+ prc.getMetadatosDocumento().getFechaIncorporada());
        System.out.println("numero paginas: "+ prc.getMetadatosDocumento().getNumeroPaginas());
        System.out.println("pagina inicio: "+ prc.getMetadatosDocumento().getPagInicio());
        System.out.println("pagina final: "+ prc.getMetadatosDocumento().getPagFinal());
        System.out.println("formato: "+ prc.getMetadatosDocumento().getFormato());
        System.out.println("tamaño: "+ prc.getMetadatosDocumento().getTamaño());
        System.out.println("origen: "+ prc.getMetadatosDocumento().getOrigen());
        System.out.println("observacion: "+ prc.getMetadatosDocumento().getObservacion());
        
        //PRUEBA CLASE ROLES
        System.out.println("***************************PRUEBA ROL******************************");
        Roles roles = new Roles(1, "administrador");
        System.out.println("codigo: " + roles.getCodigo()+" "+"Nombre" +" "+ roles.getNombre());
        
        //PRUEBA CLASE USUARIOS
        System.out.println("*****************************PRUEBA USUARIO****************************");
        Usuario usua = new Usuario(1, "jhon", "1234");
        System.out.println("codigo: "+ usua.getCodigo()+" "+"nombre: "+ usua.getNombre()+" "+"contraseña: "+ 
                            usua.getContraseña());
        usua.agregarRol(roles);
        System.out.println(usua.getRol().getNombre());
    }
}
