package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNavegacionSuperior extends JPanel implements ActionListener{
	
	//CONSTANTES
	/**
	 * Es la constante identifica el evento de avanzar hacia Arriba
	 */
	public final static String ARRIBA = "arriba";
	
	
	/**
	 * relacion con la ventana de la interfaz principal
	 */
    private InterfazCondominio principal;
	
    
    
	//ATRIBUTOS
	/**
	 * Es la Etiqueta que se utilizará para mostrar la Dimensión 
	 */
	JLabel labelDimension ;
	
	/**
	 * Es la Etiqueta que se utilizará para mostrar los Valores de la Dimensión
	 */
	JLabel labelValorDimension ;
	
	/**
	 * El Botón que se utilizará para mostrar la Navegación Superior
	 */
	JButton butArriba ;
	
	//CONSTANTES
	public PanelNavegacionSuperior( InterfazCondominio p){
		
		principal = p;
		
		setLayout( new GridLayout(1,3));
		
		labelDimension = new JLabel ("    Dimensiones:");
		labelValorDimension= new JLabel("");
//		labelValorDimension.setText(""+ principal.miCondominio.darDimension());
		
		ImageIcon icono_Superior = new ImageIcon( "img/arriba.png" );
		butArriba = new JButton ("");
		butArriba.setIcon(icono_Superior);
		butArriba.setActionCommand(ARRIBA);
		butArriba.addActionListener(this);
		butArriba.setBorderPainted(false);
	    butArriba.setBackground(Color.white);
		
		JLabel label1 = new JLabel("");
		JLabel label2 = new JLabel("");
				
		add(labelDimension);
		add(labelValorDimension);
		add(butArriba);
		add(label1);
		add(label2);		
	}
	
	//METODOS
	/**
	 * Nombre:actionPerformed(ActionEvent evento).<br>
	 * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Navegacion Superior.<br>
	 * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel.<br>
	 * @linecode : 3 Lineas
	 * @devtime : 5 Minutos
	 */
	public void actionPerformed ( ActionEvent e){
		String comando = e.getActionCommand();
		if ( comando.equals(ARRIBA)){
			principal.arriba();
		}
	}
	
	
}
