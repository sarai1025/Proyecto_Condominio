package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Condominio {

	// ATRIBUTOS
	/**
	 * La Matriz de Cuadrantes
	 */
	public Cuadrante[][] cuadrantes;

	/**
	 * Este Valor representa la Dimension de la Matriz
	 */
	private String dimension;

	/**
	 * Este Valor representa las Filas del Condominio
	 */
	private int numFilas;
	
	/**
	 * Este Valor representa las Columnas del Condominio
	 */
	private int numColumnas;

	/**
	 * Este Valor representa el Lado del Cuadrante
	 */
	private int ladoCuadrante;

	// CONTRUCTOR
	/**
	 * Metodo:Condominio()<br>
	 * Descripción:Construye un Nuevo Condominio especificados en el Archivo de Entrada.<br>
	 * <b>post: </b> Se construyó un Nuevo Condominio del tamaño especificado en el Archivo.<br>
	 * @param archivo- Es el Archivo que contiene la información (filas, columnas)del Condominio. archivo != null.
	 * @throws Exception Se lanza una Excepción si hay problemas cargando el Archivo.<br>
	 * @linecode 9 Lineas
	 * @devtime 20 Minutos
	 */
	public Condominio() {
		
		dimension = "";
		numFilas = 0;
		numColumnas = 0;
		ladoCuadrante = 0;

		cuadrantes = new Cuadrante[numFilas][numColumnas];
		for (int i = 0; i < cuadrantes.length; i++) {
			for (int j = 0; j < cuadrantes[i].length; i++) {
				cuadrantes[i][j] = new Cuadrante(cuadrantes[i][j].darTipo(), cuadrantes[i][j].darNumero(),
						cuadrantes[i][j].darResponsable(), cuadrantes[i][j].darValor());
			}
		}
		
	}

	/**
	 * Metodo:Condominio(File archivo).<br>
	 * Descripción:Construye un Nuevo Condominio especificados en el Archivo de Entrada.<br>
	 * <b>post: </b> Se construyó un Nuevo Condominio del tamaño especificado en el Archivo.<br>
	 * @param archivo- Es el Archivo que contiene la información (filas, columnas) del Condominio. archivo != null.<br>
	 * @throws Exception Se lanza una Excepción si hay problemas cargando el Archivo.<br>
	 * @linecode 2 Lineas
	 * @devtime 2 Minutos
	 */
	public Condominio(File archivo) throws Exception {		
		Properties datos = cargarCondominio(archivo);
		inicializarCondominio(datos);
	}

	/**
	 * Metodo:cargarDominio(File archivo).<br>
	 * Descripción:Este metodo se encarga de Cargar la información del Condominio en un objeto de tipo Properties. <br>
	 * @param archivo - Es el archivo que contiene la Configuración de los Cuadrantes que estarán en el Condominio.<br>
	 * @return datos - objeto de la Clase Properties con la Información del Archivo.<br>
	 * @throws Exception Si el Archivo no tiene el Formato esperado, el metodo lanza una Excepción.<br>
	 * @linecode 8 Lineas
	 * @devtime 5 Minutos
	 */
	public Properties cargarCondominio(File archivo) throws Exception {
		
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(archivo);
		try {
			datos.load(in);
			in.close();
		} catch (Exception e) {
			throw new Exception("Formato inválido");
		}
		
		return datos;

	}

	/**
	 * Metodo:inicializarCondominio(File archivo).<br>
	 * Descripción:Este metodo permite inicializar un Condominio con los Cuadrantes contenidos en un Archivo de Properties.<br>
	 * <b>post: </b> El Condominio está inicializado con la Información del Archivo.<br>	 * 
	 * @param archivo - Es el Archivo que contiene la Configuración de los Cuadrantes que estarán en el Condominio.<br>
	 * @throws Exception Si existe algun problema Leyendo el Archivo, el metodo lanza una Excepción.<br>
	 * @linecode 22 Lineas
	 * @devtime 30 Minutos
	 */
	public void inicializarCondominio(Properties datos) {
		
		String columnas = datos.getProperty("condominio.columnas");
		numColumnas = Integer.parseInt(columnas);

		String filas = datos.getProperty("condominio.filas");
		numFilas = Integer.parseInt(filas);

		dimension = numFilas + " x " + numColumnas;

		cuadrantes = new Cuadrante[numFilas][numColumnas];

		ladoCuadrante = Integer.parseInt(datos.getProperty("condominio.ladoCuadrante"));

		int contador = 1;

		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {

				String tipoCuadrante = datos.getProperty("condominio.fila" + (i + 1) + ".columna" + (j + 1) + ".tipo");

				if (tipoCuadrante.equals("A")) {
					String responsable = datos
							.getProperty("condominio.fila" + (i + 1) + ".columna" + (j + 1) + ".responsable");
					cuadrantes[i][j] = new Cuadrante("Árbol", contador, responsable, 0);

				} else if (tipoCuadrante.equals("V")) {
					String xvalor = datos
							.getProperty("condominio.fila" + (i + 1) + ".columna" + (j + 1) + ".valorComercial");
					int valor = Integer.parseInt(xvalor);
					String responsable = datos
							.getProperty("condominio.fila" + (i + 1) + ".columna" + (j + 1) + ".responsable");
					cuadrantes[i][j] = new Cuadrante("Vivienda", contador, responsable, valor); 
				} else {
					cuadrantes[i][j] = new Cuadrante("Calle", contador, "Constructora Meléndez", 0);
				}
				contador++;
			}

		}
	}

	/**
	 * Metodo: darDimension().<br>
	 * Descripción: Este Metodo se encarga de Retornar la dimensión del Condominio.<br>
	 * @return numero - Retorna la Dimensión del Condominio.<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */
	public String darDimension() {
		return dimension;
	}

	/**
	 * Metodo: darCuadrante().<br>
	 * Descripcion: Este Metodo se encarga de Retornar el cuadrante del Condominio <br>
	 * @return numero - Retorna el cuadrante del condominio.<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */
	public Cuadrante[][] darCuadrante() {
		return cuadrantes;
	}

	/**
	 * Metodo: darNumFilas
	 * Descripción: Este Metodo se encarga de Retornar las Filas del Condominio.<br>
	 * @return numFilas - Retorna las Filas del Condominio..<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */
	public int darNumFilas() {
		return numFilas;
	}

	/**
	 * Metodo: darNumColumnas<br>
	 * Descripción: Este Metodo se encarga de Retornar las Columnas del Condominio.<br>
	 * @return numColumnas - Retorna las Columnas del Condominio..<br>
	 * @linecode : 1 Linea
	 * @devtime : 1 Minuto
	 */
	public int darNumColumnas() {
		return numColumnas;
	}

	/**
	 * Metodo: viviendaMasCostosa()<br>
	 * Descripción: Este Metodo se encarga de encontrar la Vivienda mas Costosa del Condominio.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * @return vivienda - Vivienda mas Costosa del Condominio.<br>
	 * @linecode : 8 Lineas
	 * @devtime : 15 Minutos
	 */
	public Cuadrante viviendaMasCostosa() {
		Cuadrante vivienda = null;
		int valor = 0;
		for (int i = 0; i < cuadrantes.length; i++) {
			for (int j = 0; j < cuadrantes[i].length; j++) {
				if (cuadrantes[i][j].darValor() > valor) {
					valor = cuadrantes[i][j].darValor();
					vivienda = cuadrantes[i][j];
				}
			}
		}

		return vivienda;
	}

	/**
	 * Nombre: cantidades.<br>
	 * Descripción: Este Metodo permite Contar el numero de Viviendas, Arboles y Calles que existen en el Condominio.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * <b>post:</b> Se contaron la cantidad de Viviendas, Arboles y Calles que existen en el Condominio.<br>
	 * @linecode : 10 Lineas
	 * @devtime : 15 Minutos
	 */
	public int[] cantidades() {
		int[] cantidad = new int[3];

		for (int i = 0; i < cuadrantes.length; i++) {
			for (int j = 0; j < cuadrantes[i].length; j++) {
				if (cuadrantes[i][j].darTipo().equals("Árbol")) {
					cantidad[0]++;
				} else if (cuadrantes[i][j].darTipo().equals("Vivienda")) {
					cantidad[1]++;
				} else {
					cantidad[2]++;
				}
			}

		}
		return cantidad;
	}

	/**
	 * Nombre: areaVehicular.<br>
	 * Descripción: Este Metodo permite calcular el Área Vehicular del Condominio.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * @return areaTotal - Área Total Vehicular del Condominio<br>
	 * @linecode : 7 Lineas
	 * @devtime : 15 Minutos
	 */
	public double areaVehicular() {
		double areaCuadrante = ladoCuadrante * ladoCuadrante;
		double areaTotal = 0.0;
		for (int i = 0; i < cuadrantes.length; i++) {
			for (int j = 0; j < cuadrantes[0].length; j++) {
				if (cuadrantes[i][j].darTipo().equals("Calle"));
				areaTotal += areaCuadrante;
			}
		}
		return areaTotal;
	}
	
	/**
	 * Nombre: calleMasLarga.<br>
	 * Descripción: Este Metodo permite calcular la Calle mas Larga del Condominio.<br>
	 * @return mensaje - Se despliega una Ventana Emergente indicando la Coordenada Inicial y Final del Condominio<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * @linecode : 30 Lineas
	 * @devtime : 50 Minutos
	 */
	public String calleMasLarga(){
		
		String mensaje = "";
		int calleMasLarga = 0;
		String coordenadaInicial ="";
		String direccion="";
		String coordenadaFinal ="";
		
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				int calleA =0;
				int cuadranteH=0;
				int cuadranteV =0;
				
				if( cuadrantes[i][j].darTipo().equals("Calle")){
					boolean terminoV = false;
					for (int k = 0; k <numFilas-1 && !terminoV; k++){
						if(cuadrantes[i+k][j].darTipo().equals("Calle")){
							cuadranteV++;
						} else terminoV=true;
						
					}
					boolean terminoH = false;
					for (int k = 0; k < numColumnas-j && !terminoH; k++) {
						if(cuadrantes[i][j+k].darTipo().equals("Calle")){
							cuadranteH++;
						}else terminoH = true;
					}
				if ( cuadranteV>cuadranteH){
					calleA = cuadranteV;
				}else calleA = cuadranteH;
				if ( calleA> calleMasLarga){
					calleMasLarga = calleA;
					coordenadaInicial = i+";"+j;
				}
			}	
		}
	}mensaje = "La Calle más Larga se ubica en la Posición Inicial ["+coordenadaInicial+"] y Termina en la Posición Final [  ]";
	return mensaje;
	
	}
	

	/**
	 * Nombre: parqueMasGrande.<br>
	 * Descripción: Este Metodo permite calcular el Parque más Grande del Condominio.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * @return mensaje - Mensaje con las Coordenadas del Parque Mas Grande del Condominio <br>
	 * @linecode : 64 Lineas
	 * @devtime : 90 Minutos
	 */
	public String parqueMasGrande() {
		int cantAncho = 0;
		int cantAlto = 0;
		boolean casa = false;
		String coordenadas = "";

		for (int i = 0; i < cuadrantes.length; i++) {
			for (int j = 0; j < cuadrantes[0].length; j++) {
				if (cuadrantes[i][j].darTipo().equals("Árbol")) {
					if (cantAncho == 0 && cantAlto == 0) {
						if (i != 0 && cuadrantes[i - 1][j].darTipo().equals("Calle") && j == 0) {
							coordenadas = i+1 + "," + j+1;
						} else if (i != 0 && cuadrantes[i - 1][j].darTipo().equals("Calle") && j != 0
								&& cuadrantes[i][j - 1].darTipo().equals("Calle")
								&& cuadrantes[i - 1][j - 1].darTipo().equals("Calle")) {
							coordenadas = i+1 + "," + j+1;
						} else if (j != 0 && cuadrantes[i][j - 1].darTipo().equals("Calle") && i == 0) {
							coordenadas = i+1 + "," + j+1;
						} else if ( j== 0 && i ==0) {
							coordenadas = i+1 + "," + j+1;
						}
					}
					if (coordenadas != "") {
						if (i != 0 && j != 0
								&& (cuadrantes[i - 1][j].darTipo().equals("Árbol")
										|| cuadrantes[i - 1][j].darTipo().equals("Calle"))
								&& (cuadrantes[i][j - 1].darTipo().equals("Árbol")
										|| cuadrantes[i][j - 1].darTipo().equals("Calle"))
								&& (cuadrantes[i - 1][j - 1].darTipo().equals("Árbol")
										|| cuadrantes[i - 1][j - 1].darTipo().equals("Calle"))) {
							cantAncho++;
						} else if (i == 0 && j != 0
								&& (cuadrantes[i][j - 1].darTipo().equals("Árbol")
										|| cuadrantes[i][j - 1].darTipo().equals("Calle"))) {
							cantAncho++;
						} else if (j == 0 && i != 0
								&& (cuadrantes[i - 1][j].darTipo().equals("Árbol")
										|| cuadrantes[i - 1][j].darTipo().equals("Calle"))
								&& cuadrantes[i][j].darTipo().equals("Árbol")) {
							cantAncho = 0;
						} else if (i == 0 && j == 0) {
							cantAncho++;
						}
					}
				} else if (cuadrantes[i][j].darTipo().equals("Vivienda")) {
					cantAncho = 0;
					cantAlto = 0;
					casa = true;
					coordenadas ="";
				} else if (cuadrantes[i][j].darTipo().equals("Calle") && casa == true) {
					cantAncho = 0;
					cantAlto = 0;
					coordenadas ="";
					casa = false;
				} else if (cuadrantes[i][j].darTipo().equals("Calle") && casa == false) {
					j = cuadrantes[0].length;
				}
			}
			if (cantAncho != 0) {
				cantAlto++;
			} 
		} if (coordenadas == ""){
			coordenadas = "No hay parques";
		}
		
		return coordenadas;
	}
	
	/**
	 * Nombre: area(int i, int j).<br>
	 * Descripción: Este Metodo permite calcular el Área Vehicular del Condominio.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * @return area - Retorna el Área Vehicular del Condominio<br>
	 * @linecode : 10 Lineas
	 * @devtime : 15 Minutos
	 */
	public double area(int i, int j){
		double area = 0.0;
		int cantArbol = 0;
		int arbolesTotales = 0;
					if( j!= 0){
						if (cuadrantes[i][j-1].darTipo().equals("Árbol")){
							cantArbol ++;
						}
					} 
					if ( i!= 0){
						if ( cuadrantes[i-1][j].darTipo().equals("Árbol")){
							cantArbol++;
						}
					} 
					
					if ( i != 0 && j!=0){
						if ( cuadrantes[i-1][j-1].darTipo().equals("Árbol")){
							cantArbol++;
						}
					} 
					
					if (i != cuadrantes.length -1){
						if (cuadrantes[i+1][j].darTipo().equals("Árbol")){
							cantArbol++;
						}
					}
					
					if ( j!= cuadrantes[0].length -1){
						if (cuadrantes[i][j+1].darTipo().equals("Árbol")){
							cantArbol++;
						}
					} 
					
					if (i != cuadrantes.length -1 && j!= cuadrantes[0].length -1  ){
						if ( cuadrantes[i-1][j-1].darTipo().equals("Árbol")){
							cantArbol++;
					}
					}
						
				    if( i!= cuadrantes.length-1 && j != 0){
				    	if ( cuadrantes[i+1][j-1].darTipo().equals("Árbol")){
				    		cantArbol++;
			     	   }
			       }
				    if ( i != 0 && j != cuadrantes[0].length-1){
				    	if ( cuadrantes[i-1][j+1].darTipo().equals("Árbol")){
				    		cantArbol++;
				    	}
				    }
				    for (int k = 0; k < cuadrantes.length; k++) {
						for (int k2 = 0; k2 < cuadrantes[0].length; k2++) {
							if ( cuadrantes[i][j].darTipo().equals("Árbol")){
								arbolesTotales++;
							}
						}
					}
				    if ( arbolesTotales!= 0){
				    	area = cantArbol/arbolesTotales;
				    	area = area * (ladoCuadrante*ladoCuadrante);
				    } 
				    
				    return area;
		}
	
	/**
	 * Nombre: guardarCondominio(File archivo).<br>
	 * Descripción: Este Metodo permite guardar un archivo tipo Properties en disco.<br>
	 * <b>pre: </b> cuadrantes != null<br>
	 * <b>pre: </b> cada posicion del arreglo de los cuadrantes se encuentra inicializada<br>
	 * </post>: Se guardo un archivo tipo Properties en disco
	 * @linecode : 12 Lineas
	 * @devtime : 20 Minutos
	 */
	public Properties guardarCondominio(File archivo) {
		
		Properties props = new Properties();
		
		try {     
	       
			props.setProperty("condominio.filas", "String.valueOf(darNumFilas())");
			//props.setProperty("condominio.filas", String.valueOf(numFilas));
	        //props.setProperty("condominio.columnas", String.valueOf(numColumnas));
	        //props.setProperty("condominio.ladoCuadrante", String.valueOf(ladoCuadrante));
	        File f = new File("miEjemplo.properties");
	        OutputStream out = new FileOutputStream( f );
	        props.store(out, "This is an optional header comment string");
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
		return props;
	}

}

