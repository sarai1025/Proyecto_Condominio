package interfaz;

import javax.swing.*;
import java.text.*;
import javax.swing.border.TitledBorder;

import mundo.Cuadrante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PanelInformacion extends JPanel implements ActionListener {

	// CONSTANTES
	/**
	 * Constante utilizada para el evento Reestablecer
	 */
	public final static String REESTABLECER = "Reestablecer";

	/**
	 * Constante utilizada para el evento Actualizar
	 */
	public final static String ACTUALIZAR = "Actualizar";

	// ATRIBUTOS
	/**
	 * Es una referencia a la Clase Principal de la Interfaz Condominio
	 */
	private InterfazCondominio principal;

	/**
	 * Es la Etiqueta correspondiente al Tipo del Cuadrante
	 */
	JLabel labelTipo;

	/**
	 * Es la Etiqueta correspondiente al Numero del Cuadrante
	 */
	JLabel labelNumero;

	/**
	 * Es la Etiqueta correspondiente al Responsable del Cuadrante
	 */
	JLabel labelResponsable;

	/**
	 * Es la Etiqueta correspondiente al Area Construida del Cuadrante
	 */
	JLabel labelArea;

	/**
	 * Es la Etiqueta correspondiente al Valor Comercial del Cuadrante
	 */
	JLabel labelValor;

	/**
	 * Es el Campo de Texto correspondiente al Tipo del Cuadrante
	 */
	JTextField textTipo;

	/**
	 * Es el Campo de Texto correspondiente al Numero del Cuadrante
	 */
	JTextField textNumero;

	/**
	 * Es el Campo de Texto correspondiente al Responsable del Cuadrante
	 */
	JTextField textResponsable;

	/**
	 * Es el Campo de Texto correspondiente al Area Construida del Cuadrante
	 */
	JTextField textArea;

	/**
	 * Es el Campo de Texto correspondiente al Valor Comercial del Cuadrante
	 */
	JTextField textValor;

	/**
	 * Es el Boton correspondiente a la Funcion Reestablecer
	 */
	JButton botonReestablecer;

	/**
	 * Es el Boton correspondiente a la Funcion Actualizar
	 */
	JButton botonActualizar;

	// CONSTRUCTOR
	public PanelInformacion(InterfazCondominio p) {

		principal = p;

		setLayout(new GridLayout(6, 2));

		TitledBorder border = BorderFactory.createTitledBorder("Información");
		border.setTitleColor(Color.GRAY);
		setBorder(border);
		setBackground(Color.white);

		labelTipo = new JLabel("    Tipo:");
		labelNumero = new JLabel("    Número:");
		labelResponsable = new JLabel("    Responsable:");
		labelArea = new JLabel("    Área Construida:");
		labelValor = new JLabel("    Valor Comercial:");

		textTipo = new JTextField();
		textNumero = new JTextField();
		textResponsable = new JTextField();
		textArea = new JTextField();
		textValor = new JTextField();

		botonReestablecer = new JButton("Reestablecer");
		botonReestablecer.setActionCommand(REESTABLECER);
		botonReestablecer.addActionListener(this);
		botonReestablecer.setEnabled(false);;

		botonActualizar = new JButton("Actualizar");
		botonActualizar.setActionCommand(ACTUALIZAR);
		botonActualizar.addActionListener(this);

		add(labelTipo);
		add(textTipo);
		add(labelNumero);
		add(textNumero);
		add(labelResponsable);
		add(textResponsable);
		add(labelArea);
		add(textArea);
		add(labelValor);
		add(textValor);
		add(botonReestablecer);
		add(botonActualizar);

	}

	// METODOS
	/**
	 * Nombre:refrescar(String tipo, int num, String responsable, double area, int valor).<br>
	 * Descripción: Este metodo permite si se ha editado la informacion (y aun no se ha hecho clic en el botón guardar) 
	 * cargar la información inicial del cuadrante.<br>
	 * @param tipo - Tipo de cuadrante (vivienda, árbol, calle)<br>
	 * @param num - Consecutivo<br>
	 * @param responsable - Si hace referencia a una Vivienda (el Responsable será el dueño de la misma), Si hace referencia
	 * a un árbol (el Responsable sera el dueño de una Vivienda que lo haya adoptado), Si hace referencia a una Calle (el
	 * Responsable es el condominio).<br>
	 * @param area - Si el Tipo de Cuadrante hace referencia a una Vivienda, este valor corresponde al Área construida de la
	 * misma.Para el Tipo de Cuadrante Arbol y Calle no aplica este Valor.<br>
	 * @param - valor - Si el Tipo de Cuadrante hace referencia a una Vivienda, este valor corresponde al Valor Comercial de la
	 * misma, Para el Tipo de Cuadrante Arbol y Calle no aplica este Valor.<br>
	 * @post La información continua en su estado inicial, en caso de que se haya modificado.<br>
	 * @linecode : 8 Lineas
	 * @devtime : 15 Minutos
	 */
	public void refrescar(String tipo, int num, String responsable, double area, int valor) {
		textTipo.setText(tipo);
		textNumero.setText("" + num);
		textResponsable.setText(responsable);
		textArea.setText("" +area);

		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern("#########");
		String strval = df.format(valor);
		textValor.setText(strval);
	}

	/**
	 * Nombre:actualizar(Cuadrante cuadrante).<br>
	 * Descripción: Este Metodo permite si se ha editado la información Modificar el estado de los Objetos actualmente.<br>
	 * en Memoria, pero no guarda aun el archivo en el disco duro.<br>
	 * @post Despliega una Ventana Emergente informando que los Datos se han Actualizado.<br>
	 * @linecode : 6 Lineas
	 * @devtime : 15 Minutos
	 */
	 public Cuadrante actualizar(Cuadrante cuadrante) throws Exception {
	
		cuadrante.cambiarArea(Double.parseDouble(textArea.getText()));
		cuadrante.cambiarNumero(Integer.parseInt(textNumero.getText().trim()));
		cuadrante.cambiarResponsable(textResponsable.getText());
		cuadrante.cambiarTipo(textTipo.getText());
		cuadrante.cambiarValor(Integer.parseInt(textValor.getText()));
		
		return cuadrante;
	}

	 /**
	  * Nombre:actionPerformed(ActionEvent evento).<br>
	  * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Información.<br>
	  * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel.<br>
	  * @linecode : 8 Lineas
  	  * @devtime : 10 Minutos
	  */
	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();

		if (comando.equals(REESTABLECER)) {

			principal.reestablecer();
			botonReestablecer.setEnabled(false);
		
		} else if (comando.equals(ACTUALIZAR)) {
			try {
				principal.actualizar();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Los Datos Ingresados no son Correctos");
			}
		}
	}
}