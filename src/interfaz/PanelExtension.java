package interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import mundo.Cuadrante;
import mundo.Condominio;


public class PanelExtension extends JPanel implements ActionListener{

	//CONSTANTES
	/**
	 * Es la constante identifica el evento de Cargar Archivo
	 */
	public final static String CARGAR_ARCHIVO = "Cargar Archivo";
		
	/**
	 * Es la constante identifica el evento de informar la Vivienda Mas Costosa
	 */
	public final static String VIVIENDA_COSTOSA = "Vivienda Mas Costosa";
	
	/**
	 * Es la constante identifica el evento de Contar el Numero Total de Viviendas, Arboles y Calles 
	 */
	public final static String CANTIDADES = "Cantidades";
		
	/**
	 * Es la constante identifica el evento de Calcular Area del Condominio
	 */
	public final static String AREA = "Area";
	
	/**
	 * Es la constante identifica el evento de Indicar la Coordenada de Inicio y Final de la Calle mas Larga
	 */
	public final static String CALLE_LARGA = "Calle Mas Larga";
		
	/**
	 * Es la constante identifica el evento de Encontrar el Parque mas Grande del Condiminio
	 */
	public final static String PARQUE_GRANDE = "Parque Mas Grande";
	
	/**
	 * Es la constante identifica el evento de Cargar Archivo
	 */
	public final static String GUARDAR_ARCHIVO = "Guardar Archivo";
	
	/**
	 * Es la constante identifica el evento de Informar Arborizacion
	 */
	public final static String VISUALIZAR_CUADRANTE_INICIAL = "Visualizar Cuadrante Inicial";	
	
	/**
	 * Es la constante identifica el evento de Visualizar Cuadrante Final
	 */
	public final static String VISUALIZAR_CUADRANTE_FINAL = "Visualizar Cuadrante Final";	
	
	/**
	 * Es la constante identifica el evento de Visualizar todo el Condominio
	 */
	public final static String VISUALIZACION_GENERAL = "Visualizacion General";

	//ATRIBUTOS
	/**
     * Es una referencia a la Clase Principal de la Interfaz Condominio
     */
    private InterfazCondominio principal;
    
    /**
     * Es una referencia del Mundo
     */
    private Condominio miCondominio;
    
	/**
     * Es el Boton correspondiente a la Funcion Cargar Archivo
     */
	JButton botonCargarArchivo;
	
	/**
     * Es el Boton correspondiente a la Funcion Vivienda Mas Costosa
     */
	JButton botonViviendaMasCostosa;
	
	/**
     * Es el Boton correspondiente a la Funcion Cantidades
     */
	JButton botonCantidades;
	
	/**
     * Es el Boton correspondiente a la Funcion Area Vehicular Total
     */
	JButton botonAreaVehicularTotal;
	
	/**
     * Es el Boton correspondiente a la Funcion Calle Mas Larga
     */
	JButton botonCalleMasLarga;
	
	/**
     * Es el Boton correspondiente a la Funcion Parque Mas Grande
     */
	JButton botonParqueMasGrande;
	
	/**
     * Es el Boton correspondiente a la Funcion Visualizar Cuadrante Inicial
     */
	JButton botonVisualizarCuadranteInicial;
	
	/**
     * Es el Boton correspondiente a la Funcion Guardar en Archivo
     */
	JButton botonGuardarArchivo;
	
	/**
     * Es el Boton correspondiente a la Funcion Visualizar Cuadrante Final
     */
	JButton botonVisualizarCuadranteFinal;
	
	/**
     * Es el Boton correspondiente a la Funcion Calcular Cuadrantes por Tipo
     */
	JButton botonVisualizacionGeneral;

	
	//CONSTRUCTOR
	public PanelExtension( InterfazCondominio p) {
		
		principal = p;
		
		setLayout(new GridLayout(5,2));
		
		TitledBorder border = BorderFactory.createTitledBorder("Opciones");
		border.setTitleColor(Color.GRAY);
		setBorder(border);
	    setBackground(Color.white);
		
		botonCargarArchivo = new JButton("Cargar Archivo");
		botonCargarArchivo.setActionCommand(CARGAR_ARCHIVO);
		botonCargarArchivo.addActionListener(this);
		
		botonViviendaMasCostosa = new JButton ("Vivienda Más Costosa");
		botonViviendaMasCostosa.setActionCommand(VIVIENDA_COSTOSA);
		botonViviendaMasCostosa.addActionListener(this);
		
		botonCantidades = new JButton ("Cantidades");
		botonCantidades.setActionCommand(CANTIDADES);
		botonCantidades.addActionListener(this);
		
		botonAreaVehicularTotal = new JButton ("Área Vehicular Total");
		botonAreaVehicularTotal.setActionCommand(AREA);
		botonAreaVehicularTotal.addActionListener(this);
		
		botonCalleMasLarga = new JButton ("Calle Más Larga");
		botonCalleMasLarga.setActionCommand(CALLE_LARGA);
		botonCalleMasLarga.addActionListener(this);
		
		botonParqueMasGrande = new JButton ("Parque Más Grande");
		botonParqueMasGrande.setActionCommand(PARQUE_GRANDE);
		botonParqueMasGrande.addActionListener(this);
				
		botonGuardarArchivo = new JButton ("Guardar en Archivo");
		botonGuardarArchivo.setActionCommand(GUARDAR_ARCHIVO);
		botonGuardarArchivo.addActionListener(this);
		
		//BOTONES DE FUNCIONALIDADES ADICIONALES
		botonVisualizarCuadranteInicial = new JButton ("Visualizar Cuadrante Inicial");
		botonVisualizarCuadranteInicial.setActionCommand(VISUALIZAR_CUADRANTE_INICIAL);
		botonVisualizarCuadranteInicial.addActionListener(this);
		
		botonVisualizarCuadranteFinal = new JButton ("Visualizar Cuadrante Final");
		botonVisualizarCuadranteFinal.setActionCommand(VISUALIZAR_CUADRANTE_FINAL);
		botonVisualizarCuadranteFinal.addActionListener(this);
		
		botonVisualizacionGeneral = new JButton ("Visualización general");
		botonVisualizacionGeneral.setActionCommand(VISUALIZACION_GENERAL);
		botonVisualizacionGeneral.addActionListener(this);
		
		add(botonCargarArchivo);
		add(botonViviendaMasCostosa);
		add(botonCantidades);
		add(botonAreaVehicularTotal);
		add(botonCalleMasLarga);
		add(botonParqueMasGrande);
		add(botonVisualizarCuadranteInicial);
		add(botonGuardarArchivo);
		add(botonVisualizarCuadranteFinal);
		add(botonVisualizacionGeneral);
	}
	
	//METODOS
	/**
	 * Nombre:actionPerformed(ActionEvent evento).<br>
	 * Descripción: Método que se encarga de atrapar los eventos de los Botones del Panel Extension.<br>
	 * @param evento - es el parametro que recibe el actionPerformed() indicando que evento ocurrio en el Panel.<br>
	 * @linecode : 
	 * @devtime : 30 Minutos
	 */
	public void actionPerformed(ActionEvent evento){	
		
		String comando = evento.getActionCommand(); 
		
		if(comando.equals(CARGAR_ARCHIVO)){
			principal.setVisible(false);
			InterfazCondominio ventana = new InterfazCondominio();
			ventana.pack();
			ventana.setLocationRelativeTo(null);
			ventana.setVisible( true );	
		}
		else if(comando.equals(VIVIENDA_COSTOSA)){
			principal.viviendaMasCostosa();
		}
		else if(comando.equals(CANTIDADES)){
			principal.cantidades();
		}
		else if(comando.equals(AREA)){
			principal.areaVehicular();
		}
		else if(comando.equals(CALLE_LARGA)){
			principal.calleMasLarga();
		}
		else if(comando.equals(PARQUE_GRANDE)){
			principal.parqueMasGrande();
		}
		else if (comando.equals(VISUALIZAR_CUADRANTE_INICIAL)){
			principal.visualizarCuadranteInicial();
		}
		else if (comando.equals(VISUALIZAR_CUADRANTE_FINAL)){
			principal.visualizarCuadranteFinal();
		}
		else if (comando.equals(VISUALIZACION_GENERAL)){
			principal.visualizacionGeneral();
		}
		else if(comando.equals(GUARDAR_ARCHIVO)){
			principal.finalizarMundo();		
		}
	}
}