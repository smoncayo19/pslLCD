/*14 de noviembre de 2017
 *Codigo desarrollado por Ing. Sebastian Moncayo para prueba de codificacion de PSL S.A.
 *Clase test
 *Este es el tester para el visualizador de lcd 7 segmentos
 *Se reutilizaron algunos elementos del codigo LCDTester.java extraído de https://github.com/pslcorp/lcdrefactor
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class test {
	static final String CADENA_FINAL = "0,0";
	public static void main(String[] args) {
		//Declaro las listas para capturar los datos de entrada
		List<Integer> lista;
		List<List<Integer>> listaDigitos=new ArrayList<>();
		List<Integer> listaSize=new ArrayList<>();
        String comando;
        int espacio=0;
        int size;
        char[] ins; 
        String[] temp;
        
        try (Scanner lector = new Scanner(System.in)) {
            System.out.print("Espacio entre Digitos (0 a 5): ");
            //Capturo la entrada de teclado
            comando = lector.next();
            
            // Valida si es un numero
            if (lcd.isNumeric(comando)) 
            {
                espacio = Integer.parseInt(comando);
                
                // se valida que el espaciado este entre 0 y 5
                if(espacio <0 || espacio >5)
                {
                    throw new IllegalArgumentException("El espacio entre "
                            + "digitos debe estar entre 0 y 5");
                }   
            }
            else 
            {
                throw new IllegalArgumentException("Debe ingresar un entero");
            }
            do
            {
                System.out.print("Entrada: ");
                //Capturo los datos de etnrada
                comando = lector.next();
                if(!comando.equalsIgnoreCase(CADENA_FINAL))
                {
                	lista = new ArrayList<>();
                    //separo los datos por coma
                	temp=comando.split(",");
                	//Valida la cantidad de parametros
                	if(temp.length>2)
                    {
                       throw new IllegalArgumentException("Ingreso mas caracteres ,"); 
                    }
                    
                    else if(temp.length<2)
                    {
                       throw new IllegalArgumentException("No ingreso los parametros requeridos"); 
                    }
                	//la primera parte lo asigno a size
                    size=Integer.parseInt(temp[0]);
                    //Con la segunda parte creo la lista con los digitos
                    ins=temp[1].toCharArray();
                    for (int i=0;i<ins.length;i++){
                    	lista.add(Integer.parseInt(String.valueOf(ins[i])));
                    }
                    //agrego la lista y size cada uno a una lista que contiene todos los valores ingresados
                    listaSize.add(size);
                    listaDigitos.add(lista);
                }
                
            }while (!comando.equalsIgnoreCase(CADENA_FINAL));
            //Se piden datos hasta que se ingrese CADENA_FINAL
        }
        catch(Exception ex){
        	System.out.println("Error: "+ex.getMessage());
        }
        
        Iterator<Integer> iteratorSize=listaSize.iterator();
        Iterator<List<Integer>> iteratorDig=listaDigitos.iterator();
        //recorro las listas size y Digitos
        while(iteratorSize.hasNext()){
        	//instancio cada visualizador e imprimo el resultado
    		VisualizadorLcd test1= new VisualizadorLcd(iteratorDig.next(),iteratorSize.next(),espacio);
    		test1.agregarLcds();
    		test1.imprimir();
        }
	}
}
