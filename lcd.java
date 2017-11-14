/*14 de noviembre de 2017
 *Codigo desarrollado por Ing. Sebastian Moncayo para prueba de codificacion de PSL S.A.
 *Clase lcd
 *La clase lcd modela cada digito lcd
 *La modelo como un objeto con una matriz que representa los 7 segmentos, el digito que representa 
 *el numero, el tamano que debe tener el digito y las constantes simbolicas para los segmentos
 */

package lcd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lcd{
	//Atributos
	//Matriz de segmentos del digito
	private String [][] matriz;
	//Numero que representa el digito
	private int digito;
	//Tamano del digito, es constante para todos los objetos de la clase
	static public int size;
	//Constantes que representa el simbolo con el que se reconoce cada segmento, horizontal o vertical
	static final String SEGMENTO_HORIZONTAL="-";
	static final String SEGMENTO_VERTICAL="|";
	//constructor que asigna el digito y el tamano
	public lcd(int digito, int size){
		this.digito=digito;
		lcd.size=size;
	}
	
	//Metodos
	//Metodo que calcula el numero de columnas de cada digito
	public int getNumColumnas(){
		return lcd.size + 2;
	}
	
	//Metodo que calcula el numero de filas de cada digito
	public int getNumFilas(){
		return (2 * lcd.size) + 3;
	}
	
	//Metodo que obtiene la matriz del digito lcd
	public String[][] getMatriz(){
		return this.matriz;
	}
	
	//metodo que dimensiona e iniciliza la matriz del digito
	public void crearDigito(){
		// Calcula el numero de filas de cada digito
		int filas = this.getNumFilas();
        // Calcula el numero de columnas de cada digito
        int columnas = this.getNumColumnas();
        //Creo e inicializo la matriz
		this.matriz= new String[filas][columnas];
		for (int i=0;i<filas;i++){
			for (int j=0;j<columnas;j++){
				this.matriz[i][j]=" ";
			}
		}
	}

	//Metodo que retorna una lista con el número de los segmentos que se deben "encender" para representar el digito
	//Note que cada segmeto lo represento de la forma:
	// 1
	//6 2
	// 7
	//5 3
	// 4
	public List<Integer> encenderSegmentos(){
		List<Integer> listaSegmentos = new ArrayList<>();
		//"Segun el digito, guardo en una lista los segmentos que se deben "encender"
		switch(this.digito){
			case 1:
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				break;
			case 2:
				listaSegmentos.add(1);
				listaSegmentos.add(2);
				listaSegmentos.add(4);
				listaSegmentos.add(5);
				listaSegmentos.add(7);
				break;
			case 3:
				listaSegmentos.add(1);
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				listaSegmentos.add(4);
				listaSegmentos.add(7);
				break;
			case 4:
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				listaSegmentos.add(6);
				listaSegmentos.add(7);
				break;
			case 5:
				listaSegmentos.add(1);
				listaSegmentos.add(3);
				listaSegmentos.add(4);
				listaSegmentos.add(6);
				listaSegmentos.add(7);
				break;
			case 6:
				listaSegmentos.add(1);
				listaSegmentos.add(3);
				listaSegmentos.add(4);
				listaSegmentos.add(5);
				listaSegmentos.add(6);
				listaSegmentos.add(7);
				break;
			case 7:
				listaSegmentos.add(1);
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				break;
			case 8:
				listaSegmentos.add(1);
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				listaSegmentos.add(4);
				listaSegmentos.add(5);
				listaSegmentos.add(6);
				listaSegmentos.add(7);
				break;
			case 9:
				listaSegmentos.add(1);
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				listaSegmentos.add(6);
				listaSegmentos.add(7);
				break;
			case 0:
				listaSegmentos.add(1);
				listaSegmentos.add(2);
				listaSegmentos.add(3);
				listaSegmentos.add(4);
				listaSegmentos.add(5);
				listaSegmentos.add(6);
				break;
			}
		return listaSegmentos;
		}
	
	//Metodo que recibe la lista de segmentos y asigna el simbolo correspondiente (| ó -) a las casillas
	//de la matriz segun tambien el atributo size
	public void asignarSegmentos(List<Integer> listaSegmentos){
        Iterator<Integer> iterator = listaSegmentos.iterator();
        
        while (iterator.hasNext()) {
        	switch (iterator.next()){
        		case 1:
        			for (int i=1;i<=size;i++){
        				this.matriz[0][i]=lcd.SEGMENTO_HORIZONTAL;
        			}
        			break;
        		case 2:
        			for (int i=1;i<=size;i++){
        				this.matriz[i][size+1]=lcd.SEGMENTO_VERTICAL;
        			}
        			break;
        		case 3:
        			for (int i=size+2;i<=(size*2)+1;i++){
        				this.matriz[i][size+1]=lcd.SEGMENTO_VERTICAL;
        			}
        			break;
        		case 4:
        			for (int i=1;i<=size;i++){
        				this.matriz[(size*2)+2][i]=lcd.SEGMENTO_HORIZONTAL;
        			}
        			break;
        		case 6:
        			for (int i=1;i<=size;i++){
        				this.matriz[i][0]=lcd.SEGMENTO_VERTICAL;
        			}
        			break;
        		case 5:
        			for (int i=size+2;i<=(size*2)+1;i++){
        				this.matriz[i][0]=lcd.SEGMENTO_VERTICAL;
        			}
        			break;
        		case 7:
        			for (int i=1;i<=size;i++){
        				this.matriz[size+1][i]=lcd.SEGMENTO_HORIZONTAL;
        			}
        			break;
        		default:
        			break;
        	}
        }
	}

	public void imprimir(){
		int filas = this.getNumFilas();
        // Calcula el numero de columnas de cada digito
        int columnas = this.getNumColumnas();
		for (int i=0;i<filas;i++){
			for (int j=0;j<columnas;j++){
				System.out.print(this.matriz[i][j]);
			}
			System.out.println();
		}
	}
	//Metodo que verifica si una cadena es numerica, tomada de ImpresorLCD.java
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}


