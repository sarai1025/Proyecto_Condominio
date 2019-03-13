package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNavegacionInferior extends JPanel implements ActionListener {
	
	//CONSTANTES	
	/**
	 * Es la Constante que identifica el evento de avanzar hacia la Abajo
	 */	
	public final static String ABAJO = "inferior";
	
	//ATRIBUTOS
	/**
	 * Es el Botón que se utilizará para mostrar la Navegación Inferior
	 */
	JButton butAbajo ;
	
	/**
	 * Relacion que conecta el panel con la interfaz principal
	 */
	private InterfazCondominio principal;

	//CONSTRUCTOR	
	public PanelNavegacionInferior(InterfazCondominio p){
		principal = p;
		setLayout(new BorderLayout());
		
		ImageIcon icono_Inferior = new ImageIcon( "img/inferior.png" );
		butAbajo = new JButton ("");
		butAbajo.setIcon(icono_Inferior);
		butAbajo.setActionCommand(ABAJO);
		butAbajo.addActionListener(this);
		butAbajo.setBorderPainted(false);
		butAbajo.setBackground(Color.white);
		
		add(butAbajo, BorderLayout.CENTER);
	   
	}
	
	//METODOS
	
	/**
	 * Nombre:actionPerformed(ActionEvent evento).<br>
	 * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Navegacion Inferior.<br>
	 * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel.<br>
	 * @linecode : 3 Lineas
	 * @devtime : 5 Minutos
	 */
	public void actionPerformed(ActionEvent e){
		String comando = e.getActionCommand();
		if ( comando.equals(ABAJO)){
			principal.abajo();
		}
	}
}