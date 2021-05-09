
package Vista;

import java.util.Scanner;


public class VistaConsola 
{
    private String titulos[] = {"1. Buscar Documento",
                              "2. Buscar Expediente",
                              "3. Agregar ",
                              "4. Eliminar ",
                              "0. Salir"};
    
    private int opcion;
    private Scanner lector = new Scanner(System.in);
    
    public void ejecutarMenu()
    {
         do{
            this.imprimirTitulos();
            this.leerOpcion();
            this.ejecutarOpion();
            
         }while(this.opcion!=0); 
    }
    
    public void imprimirTitulos()
    {
        
        System.out.println("\n******************MENU*****************");
        for(int i=0; i< this.titulos.length;i++){
            System.out.println(this.titulos[i]);
        }
    }
    
    public void leerOpcion()
    {
        boolean excepcion=true;
        do{
            try{
                System.out.print("\nSelecciones una opcion: ");
                this.opcion = this.lector.nextInt();
                 excepcion = false;
            }catch(java.util.InputMismatchException ime){
                System.out.println("Se requiere valor entero, intente nuevamente");
                excepcion = true;
                this.lector.nextLine();
            } 
        }while(excepcion);
    }
    
    public void ejecutarOpion()
    {
        switch(this.opcion){
            
            case 1: 
                    break;
            case 2: 
                    break;
            case 3: //this.vitaBuscarPublicacion();
                    break;
            case 4: //this.vitaEliminarPublicacion();
                    break;
            case 0:  System.out.println("Ha salido de la aplicacion");
                     break;
            default: System.out.println("Opcion no valida, intente nuevamente");
        }
    }
}
