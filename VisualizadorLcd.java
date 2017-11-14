/*14 de noviembre de 2017
 *Codigo desarrollado por Ing. Sebastian Moncayo para prueba de codificacion de PSL S.A.
 *Clase VisualizadorLcd
 *Modelo la pantalla LCD como una lista de numeros, su respectiva lista de digitos lcd, el tamano de cada
 *digito y el espacio entre digito
 */

package lcd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class VisualizadorLcd {
	//Lista de digitos
	private List<Integer> listaDigitos;
	//Lista de digitos lcd
	private List<lcd> listaLcds;
	//Tamano de cada digito
	private int size;
	//Espacio entre digitos
	private int espacio;
	
	//Constructor que asigna la lista de digitos, el tamano size y el espacio
	public VisualizadorLcd (List<Integer> listaDigitos, int size, int espacio){
		this.listaDigitos=listaDigitos;
		this.size=size;
		this.espacio=espacio;
	}
	
	//Metodo que instancia y agrega los correspondientes digitos lcd's a la lista del visualizador
	public void agregarLcds(){
		Iterator<Integer> iterator = this.listaDigitos.iterator();
		//Creo la lista de digitos lcd
		this.listaLcds=new ArrayList<lcd>();
		//Recorro la lista de digitos
		while (iterator.hasNext()){
			//Instancio y creo cada digito
			lcd dig=new lcd(iterator.next(),this.size);
			dig.crearDigito();
			dig.asignarSegmentos(dig.encenderSegmentos());
			//Agrego cada digito a la lista
			this.listaLcds.add(dig);
		}
	}
	
	//Metodo que imprime los digitos del visualizador 
	public void imprimir(){
		Iterator<lcd> iterator = this.listaLcds.iterator();
		String temp[][];
		// Calcula el numero de filas de cada digito
		int filas = this.listaLcds.get(0).getNumFilas();
        // Calcula el numero de columnas de cada digito
        int columnas = this.listaLcds.get(0).getNumColumnas();
        //Recorro cada fila del visualizador
        for(int i=0;i<filas;i++){
        	iterator = this.listaLcds.iterator();
        	//Recorro la lista de digitos lcd's
			while(iterator.hasNext()){
				//Obtengo la matriz del digito correspondiente
				temp=iterator.next().getMatriz();
				//Imprimo la fila del digito correspondiente
				for (int j=0;j<columnas;j++){
					System.out.print(temp[i][j]);
				}
				//Imprimo los espacios correspondientes
				for (int k=0;k<this.espacio;k++){
					System.out.print(" ");	
				}	
			}
			//Salto de linea
			System.out.println();
        }
	}
	
}
