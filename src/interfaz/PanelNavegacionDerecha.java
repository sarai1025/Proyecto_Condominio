package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import mundo.Condominio;

public class PanelNavegacionDerecha extends JPanel implements ActionListener{
	
	//CONSTANTES
	/**
	 * Es la Constante que identifica el evento de avanzar hacia la Derecha
	 */
	public static final String DERECHA = "derecha";
	
	//ATRIBUTOS
	/**
	 * Es el Botón que se utilizará para mostrar la Navegación Derecha
	 */
	JButton butDerecha;
	
	/**
	 * Relacion que conecta el panel con la interfaz principal
	 */
	private InterfazCondominio principal;
	
	//CONSTRUCTOR	
	public PanelNavegacionDerecha(InterfazCondominio prin){
		
		principal = prin;
		
		setLayout(new BorderLayout());
		
		ImageIcon icono_Derecha = new ImageIcon( "img/derecha.png" );
		butDerecha = new JButton ("");
		butDerecha.setIcon(icono_Derecha);
		butDerecha.setActionCommand(DERECHA);
		butDerecha.addActionListener(this);
	    butDerecha.setBorderPainted(false);
	    butDerecha.setBackground(Color.white);
		
		add(butDerecha, BorderLayout.EAST);
	}
	
	//METODOS
	/**
	 * Nombre:actionPerformed(ActionEvent evento).<br>
	 * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Navegacion Derecha.<br>
	 * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel
	 * @linecode : 3 Lineas
	 * @devtime : 5 Minutos
	 */
	public void actionPerformed (ActionEvent e){
		String comando = e.getActionCommand();
		if ( comando.equals(DERECHA)){
			 principal.derecha();
		} 
	}
}