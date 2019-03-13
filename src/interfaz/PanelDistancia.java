package interfaz;


import javax.swing.*;
import java.awt.*;

public class PanelDistancia extends JPanel{

	//ATRIBUTOS
    /**
     * Etiqueta que representa la Etiqueta de Navegación
     */
	private JLabel labNavegacion;
	/**
     * Etiqueta que representa la Etiqueta de Veces Navegación
     */
	private JLabel labNumNavegacion;

	/**
     * Es una referencia a la Clase Principal de la Interfaz Condominio
     */
	private InterfazCondominio principal;
	
	/**
     * Atributo que hace referencia a las Filas
     */
	int x = 0;
	
	/**
     * Atributo que hace referencia a las Columnas
     */
	int y = 0; 
	
	//CONSTRUCTOR
	public PanelDistancia(InterfazCondominio p){
		
		principal = p;
		
		setLayout(new GridLayout(2,3));
		
		labNavegacion = new JLabel("Coordenadas faltantes:");
		
		 x = principal.miCondominio.darNumFilas()-PanelCuadrante.ALTO;
		 
		 y= principal.miCondominio.darNumColumnas()-PanelCuadrante.ANCHO;
		 
		labNumNavegacion = new JLabel("["+x+ ";" + y+"]");
		
		add( new JLabel (""));
		add( new JLabel (""));
		add( new JLabel (""));
		add(labNavegacion);
		add(labNumNavegacion);
		add( new JLabel (""));
	}
	
	//METODOS
	/**
	 * Nombre:cambiarX().<br>
	 * Descripción: Método que se encarga de  cambiar la fila actual del condominio  .<br>
	 * @param fila - fila a cambiar
	 * @return x - nueva fila actual<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */	
	public void cambiarX(int fila){
		x = fila;
	}
	
	/**
	 * Nombre:cambiarY().<br>
	 * Descripción: Método que se encarga de  cambiar la columna actual del condominio   .<br>
	 * @param columna- columna a cambiar 
	 * @return y - nueva columna actual <br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */	
	public void cambiarY(int columna){
		y = columna;
	}
	
	/**
	 * Nombre:cambiarNavegacion().<br>
	 * Descripción: Método que se encarga de   actualizar el label de las coordenadas donde indica los movimientos faltantes para llegar al final del condominio .<br>
	 * @return fila -  <br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */	
	public void cambiarNavegacion(){
		labNumNavegacion.setText("[" + x+";"+ y +"]");
	}
}
