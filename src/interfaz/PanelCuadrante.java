package interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mundo.Cuadrante;
import mundo.Condominio;

public class PanelCuadrante extends JPanel implements ActionListener {

	//ATRIBUTOS
	/**
     * Es una referencia a la Clase Principal de la Interfaz Condominio
     */
    private InterfazCondominio principal;
    
	/**
     * Es una matriz de Botones que se utilizará para mostrar las Imagenes de los Cuadrantes
     */
    private JButton[][] cuadrantes;
    
    /**
     * Es una Constante que representa el Ancho del Panel Cuadrante
     */
    public final static int ANCHO = 5;
    
    /**
     * Es una Constante que representa el ALTO del Panel Cuadrante
     */
    public final static int ALTO = 4;
    
    
    //  ATRIBUTOS
    /**
     * Fila que representa al boton seleccionado
     */
    private int fila;
    /**
     * columna que representa al boton seleccionado
     */
    private int columna;
    
    //CONSTRUCTOR
	public PanelCuadrante( InterfazCondominio p) {
		
		principal = p;
		setLayout(new GridLayout(ALTO, ANCHO));
		
		cuadrantes = new JButton[ALTO][ANCHO];		
		for( int fila=0; fila<ALTO; fila++){
			for(int columna=0; columna<ANCHO; columna++ ){
				
				cuadrantes[fila][columna] = new JButton();				
				cuadrantes[fila][columna].addActionListener(this);
				cuadrantes[fila][columna].setActionCommand(fila + "_"+columna);
				cuadrantes[fila][columna].setBackground(Color.LIGHT_GRAY);
				cuadrantes[fila][columna].setBorderPainted(true);
				cuadrantes[fila][columna].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add (cuadrantes[fila][columna]);
				
			}
		}
			principal.panelNavegacionSuperior.butArriba.setEnabled(false);
			principal.panelNavegacionIzquierda.butIzquierda.setEnabled(false);
			imagenBoton(principal.miCondominio.cuadrantes);
	}
	
	//METODOS
	/**
	 * Nombre:imagenBoton(Cuadrante[][] cuadranteMundo).<br>
	 * Descripción: Este metodo se encarga de colocar las Imagenes en los Cuadrantes del Condominio, de acuerdo al Tipo
	 * (Vivienda, Árbol, Calle).<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * <b>post: </b> Se cargaron las Imagenes del Condominio de acuerdo al Tipo.<br>
	 * @param cuadranteMundo Es la matriz de Cuadrantes que forman el Condominio. cuadranteMundo != null.
	 * @linecode 7 Lineas
	 * @devTime 15 Minutos
	 */
	public void imagenBoton (Cuadrante[][] cuadranteMundo){
		
		for ( int i = 0; i< ALTO; i++){
			for (int j = 0; j<ANCHO; j++){
				
				if (cuadranteMundo[i][j].darTipo().equals("Árbol")){
					cuadrantes[i][j].setIcon(new ImageIcon ("img/arbol.png"));
				} else if ( cuadranteMundo[i][j].darTipo().equals("Vivienda")){
					cuadrantes[i][j].setIcon(new ImageIcon ("img/casa.png"));
				} else { cuadrantes[i][j].setIcon(new ImageIcon (""));
				
				}
			}
		}
	}
	
	/**
	 * Metodo: darCuadrantes()
	 * Descripción: devuelve el arreglo de los botones contenidos en la matriz del cuadrante principal del condominio
	 * @return cuadrantes - Matriz Cuadrantes
	 * @linecode : 1 Lineas
	 * @devtime : 1 Minuto
	 */
	public JButton[][] darCuadrantes(){
		return cuadrantes;
	}
	
	/**
	 * Nombre:darFila().<br>
	 * Descripción: Método que se encarga de retornar la Fila del Cuadrante.<br>
	 * @return fila . Fila del Cuadrante<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */	
	public int darFila(){
		return fila;
	}
	
	/**
	 * Nombre:darColumna().<br>
	 * Descripción: Método que se encarga de retornar la Columna del Cuadrante.<br>
	 * @return columna . Columna del Cuadrante<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */	
	public int darColumna(){
		return columna;
	}

	/**
	 * Nombre:actionPerformed(ActionEvent evento).<br>
	 * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Cuadrante.<br>
	 * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel.<br>
	 * @linecode : 0 Lineas
	 * @devtime : 1 Minutos
	 */
	public void actionPerformed(ActionEvent evento) {	
		String comando = evento.getActionCommand();
		String[] posicion = comando.split("_");
		 fila = Integer.parseInt(posicion[0]);
		columna = Integer.parseInt(posicion[1]);
		principal.pulsarBotonCuadrante(fila, columna);
	}
}
