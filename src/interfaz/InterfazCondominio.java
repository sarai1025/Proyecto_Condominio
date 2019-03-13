package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.FileWriter;

import mundo.Cuadrante;
import mundo.Condominio;

public class InterfazCondominio extends JFrame {

	// ATRIBUTOS
	/**
	 * Clase Principal del Mundo.
	 */
	public Condominio miCondominio;

	/**
	 * Es el Panel donde se muestra las Dimensiones y la Navegacion Superior
	 */
	public PanelNavegacionSuperior panelNavegacionSuperior;

	/**
	 * Es el Panel donde se muestra la Navegacion Inferior
	 */
	public PanelNavegacionInferior panelNavegacionInferior;

	/**
	 * Es el Panel donde se muestra la Navegacion Izquierda
	 */
	public PanelNavegacionIzquierda panelNavegacionIzquierda;

	/**
	 * Es el Panel donde se muestra la Navegacion Derecha
	 */
	public PanelNavegacionDerecha panelNavegacionDerecha;

	/**
	 * Es el Panel donde se muestra los Cuadrantes del Condominio
	 */
	public PanelCuadrante panelCuadrante;

	/**
	 * Es el Panel donde se muestra la Información del Cuadrante
	 */
	public PanelInformacion panelInformacion;

	/**
	 * Es el Panel donde se muestra los Botones de Funcionalidades
	 */
	public PanelExtension panelExtension;

	
	/**
	 * Panel que muestra la distancia en cuadrantes que falta para visualizar todo el condominio
	 */
	public PanelDistancia panelDistancia;
	
	/**
	 * posicion actual en las filas del cuadrante visualizado en la interfaz
	 */
	int actualFilas;

	/**
	 * posicion actual en las columnas del cuadrante visualizado en la interfaz
	 */
	int actualColumnas;

	// CONSTRUCTOR
	public InterfazCondominio() {
		
		inicializarMundo();

		setTitle("Icesi Software: Gestión de Información de Condominios");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		// JPanel Izquierdo
		JPanel panelIzquierdo = new JPanel(new BorderLayout());

		// Panel Navegacion Superior
		panelNavegacionSuperior = new PanelNavegacionSuperior(this);
		panelIzquierdo.add(panelNavegacionSuperior, BorderLayout.NORTH);
		panelNavegacionSuperior.labelValorDimension.setText(String.valueOf(miCondominio.darDimension() + ""));

		// Panel Navegacion Inferior
		panelNavegacionInferior = new PanelNavegacionInferior(this);
		panelIzquierdo.add(panelNavegacionInferior, BorderLayout.SOUTH);
		

		// Panel Navegacion Izquierda
		panelNavegacionIzquierda = new PanelNavegacionIzquierda(this);
		panelIzquierdo.add(panelNavegacionIzquierda, BorderLayout.WEST);

		// Panel Navegacion Derecha
		panelNavegacionDerecha = new PanelNavegacionDerecha(this);
		panelIzquierdo.add(panelNavegacionDerecha, BorderLayout.EAST);

		// Panel Cuadrante
		panelCuadrante = new PanelCuadrante(this);
		panelIzquierdo.add(panelCuadrante, BorderLayout.CENTER);

		add(panelIzquierdo, BorderLayout.WEST);

		// JPanel Derecho
		JPanel panelDerecho = new JPanel(new GridLayout(3, 1));

		// Panel Informacion
		panelInformacion = new PanelInformacion(this);
		panelDerecho.add(panelInformacion);

		// Panel Extension
		panelExtension = new PanelExtension(this);
		panelDerecho.add(panelExtension);

		//panel distancia
		panelDistancia = new PanelDistancia(this);
		panelDerecho.add(panelDistancia);
		panelDistancia.setBackground(Color.WHITE);

		add(panelDerecho, BorderLayout.EAST);

		// Color de los paneles
		this.getContentPane().setBackground(Color.orange);
		panelNavegacionSuperior.setBackground(Color.white);
		panelNavegacionInferior.setBackground(Color.white);
		panelNavegacionIzquierda.setBackground(Color.white);
		panelNavegacionDerecha.setBackground(Color.white);
	}

	// METODOS
	/**
	 * Nombre: inicializarMundo().<br> 
	 * Descripción: Metodo encargado de preguntar el Archivo del cual se quiere Cargar la información del
	 * Condominio.<br> 
	 * <b>post:</b> Se obtiene el Archivo que el usuario quiere cargar en Memoria.<br>
	 * @linecode 11 Lineas
	 * @devtime 10 Minutos
	 */
	public void inicializarMundo() {
		
		JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Abrir Archivo del Condominio");
		int resultado = fc.showOpenDialog(this);
		File archivoCondominio = fc.getSelectedFile();
		if (archivoCondominio != null && resultado == JFileChooser.APPROVE_OPTION) {

			try {
				miCondominio = new Condominio(archivoCondominio);

			} catch (Exception e) {
				System.out.println(e.toString());
				JOptionPane.showMessageDialog(this, "Error Al Cargar El Archivo!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Nombre: derecha().<br>
	 * Descripción: Método permite Mover la Visualización del Condominio hacia la Derecha.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * <b>post:</b> Se visualizarón los Cuadrantes hacia la Derecha del Condominio.<br>
	 * @linecode : 10 Lineas
	 * @devtime : 30 Minutos
	 */
	public void derecha() {
		actualColumnas++;
		panelNavegacionIzquierda.butIzquierda.setEnabled(true);

		// Matriz Emergente que será la que se muestre en la Interfaz
		Cuadrante[][] cuadranteMatriz = new Cuadrante[PanelCuadrante.ALTO][PanelCuadrante.ANCHO];
		for (int i = 0, l = actualFilas; i < PanelCuadrante.ALTO; i++, l++) {
			for (int j = 0, k = actualColumnas; j < PanelCuadrante.ANCHO; j++, k++) {
				System.out.println("Mostrar[" + i + "][" + j + "] <- Origen[" + l + "][" + k + "]");
				cuadranteMatriz[i][j] = miCondominio.darCuadrante()[l][k];
			}
		}
		
		if (actualColumnas == (miCondominio.darNumColumnas() - PanelCuadrante.ANCHO)) {
			panelNavegacionDerecha.butDerecha.setEnabled(false);
		}
		panelCuadrante.imagenBoton(cuadranteMatriz);
		panelDistancia.cambiarY(miCondominio.darNumColumnas()-PanelCuadrante.ANCHO-actualColumnas);
        panelDistancia.cambiarNavegacion();
	}

	/**
	 * Nombre: izquierda().<br>
	 * Descripción: Método permite Mover la Visualización del Condominio hacia la Izquierda.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * <b>post:</b> Se visualizarón los Cuadrantes hacia la Izquierda del Condominio.<br>
	 * @linecode : 10 Lineas
	 * @devtime : 30 Minutos
	 */
	public void izquierda() {
		actualColumnas--;
		panelNavegacionDerecha.butDerecha.setEnabled(true);
		
		// Matriz emergente que sera la que se muestre en la Interfaz
		Cuadrante[][] cuadranteMatriz = new Cuadrante[PanelCuadrante.ALTO][PanelCuadrante.ANCHO];
		for (int i = 0, l = actualFilas; i < PanelCuadrante.ALTO; i++, l++) {
			for (int j = 0, k = actualColumnas; j < PanelCuadrante.ANCHO; j++, k++) {
				System.out.println("Mostrar[" + i + "][" + j + "] <- Origen[" + l + "][" + k + "]");
				cuadranteMatriz[i][j] = miCondominio.darCuadrante()[l][k];
			}
		}
		panelCuadrante.imagenBoton(cuadranteMatriz);
		panelDistancia.cambiarY(miCondominio.darNumColumnas()-PanelCuadrante.ANCHO-actualColumnas);
	      panelDistancia.cambiarNavegacion();
		if (actualColumnas < 1) {
			panelNavegacionIzquierda.butIzquierda.setEnabled(false);
		}
	}

	/**
	 * Nombre: arriba().<br>
	 * Descripción: Método permite Mover la Visualización del Condominio hacia Arriba.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * <b>post:</b> Se visualizarón los Cuadrantes hacia arriba del Condominio.<br>
	 * @linecode : 10 Lineas
	 * @devtime : 30 Minutos
	 */
	public void arriba() {
		actualFilas--;
		panelNavegacionInferior.butAbajo.setEnabled(true);
		
		// Matriz emergente que sera la que se muestre en la Interfaz
		Cuadrante[][] cuadranteMatriz = new Cuadrante[PanelCuadrante.ALTO][PanelCuadrante.ANCHO];
		for (int i = 0, k = actualFilas; i < PanelCuadrante.ALTO; i++, k++) {
			for (int j = 0, l = actualColumnas; j < PanelCuadrante.ANCHO; j++, l++) {
				System.out.println("Mostrar[" + i + "][" + j + "] <- Origen[" + k + "][" + l + "]");
				cuadranteMatriz[i][j] = miCondominio.darCuadrante()[k][l];
			}
		}
		panelCuadrante.imagenBoton(cuadranteMatriz);
		panelDistancia.cambiarX(miCondominio.darNumFilas()-PanelCuadrante.ALTO-actualFilas);
		panelDistancia.cambiarNavegacion();
		if (actualFilas < 1) {
			panelNavegacionSuperior.butArriba.setEnabled(false);
		}

	}

	/**
	 * Nombre: abajo().<br>
	 * Descripción: Método permite Mover la Visualización del Condominio hacia Abajo.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * <b>post:</b> Se visualizaron los Cuadrantes hacia abajo del Condominio.<br>
	 * @linecode : 10 Lineas
	 * @devtime : 30 Minutos
	 */
	public void abajo() {
		actualFilas++;
		panelNavegacionSuperior.butArriba.setEnabled(true);

		// Matriz emergente que sera la que se muestre en la interfaz
		Cuadrante[][] cuadranteMatriz = new Cuadrante[PanelCuadrante.ALTO][PanelCuadrante.ANCHO];
		for (int i = 0, k = actualFilas; i < PanelCuadrante.ALTO; i++, k++) {
			for (int j = 0, l = actualColumnas; j < PanelCuadrante.ANCHO; j++, l++) {
				System.out.println("Mostrar[" + i + "][" + j + "] <- Origen[" + k + "][" + l + "]");
				cuadranteMatriz[i][j] = miCondominio.darCuadrante()[k][l];
			}
		}
		panelCuadrante.imagenBoton(cuadranteMatriz);
		panelDistancia.cambiarX(miCondominio.darNumFilas()-PanelCuadrante.ALTO-actualFilas);
		panelDistancia.cambiarNavegacion();
		
		if (actualFilas == (miCondominio.darNumFilas() - PanelCuadrante.ALTO)) {
			panelNavegacionInferior.butAbajo.setEnabled(false);
		}
	}

	/**
	 * Nombre: pulsarBotonCuadrante(int fila, int col).<br>
	 * Descripción: Método permite Obtener la información correspondiente del Cuadrante que se requiere.<br>
	 * @param fila - hace referencia a una Fila del Cuadrante que se requiere.<br>
	 * @param columna - hace referencia a una Columna del Cuadrante que se requiere.<br>
	 * <b>post:</b> Se Visualizaron los datos del respectivo Cuadrante en la Interfaz.<br>
	 * @linecode : 3 Lineas
	 * @devtime : 20 Minutos
	 */
	public void pulsarBotonCuadrante(int fila, int col) {
				Cuadrante cuadrante = miCondominio.cuadrantes[fila + actualFilas][col + actualColumnas];
				panelInformacion.refrescar(cuadrante.darTipo(), cuadrante.darNumero(), cuadrante.darResponsable(),cuadrante.darArea(), cuadrante.darValor());
				panelInformacion.botonReestablecer.setEnabled(true);
	}
		
	/**
	 * Nombre: reestablecer().<br>
	 * Descripción: Método permite Cargar la Información Inicial del Cuadrante.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando que los Datos Iniciales se cargaron.Se Reestablecio la Información del respectivo Cuadrante en la Interfaz.<br>
	 * @linecode : 2 Lineas
	 * @devtime : 15 Minutos
	 */
	public void reestablecer(){
//		JFileChooser fc = new JFileChooser("./data");
//		fc.setDialogTitle("Abrir Archivo del Condominio");
//		File archivoCondominio = fc.getSelectedFile();
//			try {
//				miCondominio.inicializarCondominio(miCondominio.cargarCondominio(archivoCondominio));
//				Cuadrante cuadrante = miCondominio.cuadrantes[panelCuadrante.darFila() + actualFilas][ panelCuadrante.darColumna()+actualColumnas];
//				panelInformacion.refrescar(cuadrante.darTipo(), cuadrante.darNumero(), cuadrante.darResponsable(), cuadrante.darArea(), cuadrante.darValor());
//				
//			} catch (Exception e) {
//				e.printStackTrace();
		
		Cuadrante cuadrante = miCondominio.cuadrantes[panelCuadrante.darFila() + actualFilas][ panelCuadrante.darColumna()+actualColumnas];
		panelInformacion.refrescar(cuadrante.darTipo(), cuadrante.darNumero(), cuadrante.darResponsable(), cuadrante.darArea(), cuadrante.darValor());
		}
			
	
	
	/**
	 * Nombre: actualizar().<br>
	 * Descripción: Método permite Modificar el estado de los Objetos actualmente en Memoria.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando que los Datos fueron Actualizados.<br>
	 * @throws Exception Si los Valores Ingresados no son Correctos.<br>
	 * @linecode : 3 Lineas
	 * @devtime : 20 Minutos
	 */
	public void actualizar() throws Exception{
		Cuadrante cuadrante = miCondominio.cuadrantes[panelCuadrante.darFila() + actualFilas][ panelCuadrante.darColumna()+actualColumnas];
		Cuadrante temporal = panelInformacion.actualizar(cuadrante);
		miCondominio.cuadrantes[panelCuadrante.darFila() + actualFilas][ panelCuadrante.darColumna()+actualColumnas] = temporal;
		JOptionPane.showMessageDialog(this, "Los Datos Modificados del Cuadrante Se han Actualizado Correctamente");
	}
	/**
	 * Nombre: viviendaMasCostosa().<br>
	 * Descripción: Método permite encontrar la Vivienda mas Costosa de todo el Condominio.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando acerca de la Vivienda mas Costosa de todo el Condominio y se cargo en el Panel Información.<br>
	 * @linecode : 3 Lineas
	 * @devtime :  10 Minutos
	 */
	public void viviendaMasCostosa(){
		Cuadrante vivienda =miCondominio.viviendaMasCostosa();
		panelInformacion.refrescar(vivienda.darTipo(), vivienda.darNumero(), vivienda.darResponsable(),vivienda.darArea(), vivienda.darValor());
		JOptionPane.showMessageDialog(this,"La "+vivienda.darTipo()+" número "+vivienda.darNumero()+" de "+vivienda.darResponsable()+", con un área de "+vivienda.darArea()+" m2, es la más costosa con un valor comercial de $ "+vivienda.darValor()+" pesos.");
	}
	
	/**
	 * Nombre: cantidades().<br>
	 * Descripción: Método permite Obtener el número total de Viviendas, Arboles y Calles del Condominio.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando el numero total de Viviendas, Árboles y Calles del Condominio.<br>
	 * @linecode : 2 Lineas
	 * @devtime :  10 Minutos
	 */
	public void cantidades(){
		String mensaje = "En el condominio hay la sig. cantidad  de:\n Viviendas: "+miCondominio.cantidades()[0] +"\n Árboles: "+ miCondominio.cantidades()[1]+"\n Calles: "+miCondominio.cantidades()[2];
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Nombre: cantidades().<br>
	 * Descripción: Método permite obtener el Area Vehicular del Condominio.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando el Area Vehicular del Condominio.<br>
	 * @linecode : 2 Lineas
	 * @devtime :  10 Minutos
	 */
	public void areaVehicular(){
		String mensaje = "El Condominio tiene un Área Vehicular de "+miCondominio.areaVehicular() + " metros.";
				JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Nombre: parqueMasGrande().<br>
	 * Descripción: Método permite obtener el Parque más Grande del Condominio.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando el Parque más Grande del Condominio.<br>
	 * @linecode : 2 Lineas
	 * @devtime :  10 Minutos
	 */
	public void parqueMasGrande(){
		String mensaje = miCondominio.parqueMasGrande();
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Nombre: calleMasLarga().<br>
	 * Descripción: Método permite obtener la calle mas larga  del Condominio.<br>
	 * <b>post:</b> Se desplego una Ventana Emergente informando la calle mas larga del Condominio.<br>
	 * @linecode : 2 Lineas
	 * @devtime :  5 Minutos
	 */
	public void calleMasLarga(){
		String mensaje = miCondominio.calleMasLarga();
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	/**
	 * Nombre: visualizarCuadranteInicial().<br>
	 * Descripción: Método permite Visualizar el Cuadrante Inicial del Condominio.<br>
	 * <b>post:</b> Se visualiza el Cuadrante Inicial del Condominio.<br>
	 * @linecode : 4 Lineas
	 * @devtime :  10 Minutos
	 */
	public void visualizarCuadranteInicial(){
		for (int j = 0; j < miCondominio.darNumColumnas()- PanelCuadrante.ANCHO; j++) {
			izquierda();
		}		
		for (int i = 0; i < miCondominio.darNumFilas() -PanelCuadrante.ALTO; i++) {
			arriba();
		}
		JOptionPane.showMessageDialog(this,"El Cuadrante Inicial del Condominio se ha Cargado");
	}
	
	
	/**
	 * Nombre: visualizarCuadranteFinal().<br>
	 * Descripción: Método permite Visualizar el Cuadrante Final del Condominio.<br>
	 * <b>post:</b> Se visualiza el Cuadrante Final del Condominio.<br>
	 * @linecode : 4 Lineas
	 * @devtime :  10 Minutos
	 */
	public void visualizarCuadranteFinal(){
		for (int j = 0; j < miCondominio.darNumColumnas()- PanelCuadrante.ANCHO; j++) {
			derecha();
		}		
		for (int i = 0; i < miCondominio.darNumFilas() -PanelCuadrante.ALTO; i++) {
			abajo();
		}
		JOptionPane.showMessageDialog(this,"El Cuadrante Final del Condominio se ha Cargado");
	}
	
	/**
	 * Nombre: visualizarGeneral().<br>
	 * Descripción: Método permite realizar una Visualización General del Condominio.<br>
	 * <b>post:</b> Se Visualiza de manera General el Condominio.<br>
	 * @linecode : 11 Lineas
	 * @devtime :  15 Minutos
	 */
	public void visualizacionGeneral(){
		String mensaje = "";
		for (int i = 0; i < miCondominio.darNumFilas(); i++) {
			for (int j = 0; j < miCondominio.darNumColumnas(); j++) {
				if(miCondominio.darCuadrante()[i][j].darTipo().equals("Árbol")){
					mensaje += " *  ";
				} else if (miCondominio.darCuadrante()[i][j].darTipo().equals("Vivienda")){
					mensaje += " ^ ";
				}else if (miCondominio.darCuadrante()[i][j].darTipo().equals("Calle")){
					mensaje += " | | ";
				}
			}mensaje += "\n";
		}
		JOptionPane.showMessageDialog(this, mensaje, "   Mapa", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	/**
	 * Nombre: finalizarMundo().<br>
	 * Descripción: Método permite Guardar la Informacion Actual en un Archivo del Tipo Properties.<br>
	 * <b>post:</b> Se guardo el Archivo Properties con la Información del Condominio.<br>
	 * @linecode : Lineas
	 * @devtime : Minutos
	 */
	public void finalizarMundo(){
		
		//Creamos el objeto JFileChooser
		JFileChooser fs = new JFileChooser("./data");
		fs.setDialogTitle("Guardar Archivo del Condominio");
		
		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
		int resultado = fs.showSaveDialog(this);
		 
		//Si el usuario, pincha en aceptar
		if(resultado==JFileChooser.APPROVE_OPTION){
		 
		    //Seleccionamos el fichero
		    File fichero= fs.getSelectedFile();
		    try{
		    	FileWriter fw = new FileWriter(fichero.getPath());		    	
		    }
		    catch(Exception e){
				JOptionPane.showMessageDialog(this, "Error Al Cargar El Archivo!", "Error",JOptionPane.INFORMATION_MESSAGE);
		    }
		} 
	}

	/**
	 * Nombre:main()<br>
	 * Descripción: Método que se encarga de Iniciar la Interfaz.<br>
	 * <b>post:</b> -La Interfaz se ejecuta con Exito<br>
	 * 
	 * @linecode : 6 Lineas
	 * @devtime : 5 Minutos
	 */
	public static void main(String[] args) {
		try {
			InterfazCondominio interfaz = new InterfazCondominio();
			interfaz.pack();
			interfaz.setLocationRelativeTo(null);
			interfaz.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
