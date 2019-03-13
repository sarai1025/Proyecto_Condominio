package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelNavegacionIzquierda extends JPanel implements ActionListener{
	
	//CONSTANTES
	/**
	 * Es la Constante que identifica el evento de avanzar hacia la Izquierda
	 */	
	public static final String IZQUIERDA = "izquierda";
	
	//ATRIBUTOS
	/**
	 * Es el Botón que se utilizará para mostrar la Navegación Izquierda
	 */
	JButton butIzquierda ;
	
	
	/**
	 * Relacion que conecta el panel con la interfaz principal
	 */
	private InterfazCondominio principal;
	
	//CONSTRUCTOR
	public PanelNavegacionIzquierda(InterfazCondominio p){
		
		principal = p;
		
		setLayout(new BorderLayout());
		
		ImageIcon icono_Izquierda = new ImageIcon( "img/izquierda.png" );
		butIzquierda = new JButton ("");
		butIzquierda.setIcon(icono_Izquierda);
		butIzquierda.setActionCommand(IZQUIERDA);
		butIzquierda.addActionListener(this);
	    butIzquierda.setBorderPainted(false);
	    butIzquierda.setBackground(Color.white);

		add(butIzquierda, BorderLayout.WEST);
	}
	
	//METODOS
	/**
	 * Nombre:actionPerformed(ActionEvent evento).<br>
	 * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Navegacion Izquierda.<br>
	 * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel.<br>
	 * @linecode : 3 Lineas
	 * @devtime : 5 Minutos
	 */
	public void actionPerformed (ActionEvent e){
		String comando = e.getActionCommand();
		if ( comando.equals(IZQUIERDA)){
			principal.izquierda();
		}
	}	
}