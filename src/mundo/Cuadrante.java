package mundo;


public class Cuadrante {
	
	//CONSTANTES
	/**
	 * Es la Constante que identifica el Árbol de un Cuadrante
	 */
	public final static String A = "A";
	
	/**
	 * Es la Constante que identifica la Vivienda de un Cuadrante
	 */
	public final static String V = "V";
	
	/**
	 * Es la Constante que identifica la Calle de un Cuadrante
	 */
	public final static String C = "C";
	
	//ATRIBUTOS
	/**
     * Este Valor representa el tipo del Cuadrante
     */
	private String tipo;
	
	/**
     * Este Valor representa un Consecutivo del Cuadrante
     */
	private int numero;
	
	/**
     * Este Valor representa el Dueño del Cuadrante
     */
	private String responsable;
	
	/**
     * Este Valor representa el Area Construida para el Cuadrante tipo Vivienda
     */
	private double area;
	
	/**
     * Este Valor representa el Valor Comercial para el Cuadrante tipo Vivienda
     */
	private int valor;
	
	
	//CONSTRUCTOR
	public Cuadrante(String tipox, int num, String resp, int val){
		tipo = tipox;
		numero = num;
		responsable = resp;
		area = 0.0;
		valor = val;
	}
	
	//METODOS    
    /**
     * Metodo: darTipo().<br>
     * Descripcion: Este Metodo se encarga de Retornar el Tipo de Cuadrante.<br>
     * @return tipo - Retorna el tipo del Cuadrante
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public String darTipo (){
		return tipo;
	}
	
	/**
     * Metodo:cambiarTipo(String tipo).<br>
     * Descripcion: Este Metodo se encarga de Modificar el Tipo del Cuadrante.<br>
     * @param tipo Nuevo tipo.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void cambiarTipo(String tip){
		tipo = tip;
	}

	/**
     * Metodo: darNumero().<br>
     * Descripcion: Este Metodo se encarga de Retornar el Numero de Cuadrante.<br>
     * @return numero - Retorna el numero del Cuadrante
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public int darNumero() {
		return numero;
	}

	/**
     * Metodo:cambiarNumero(int numero).<br>
     * Descripcion: Este Metodo se encarga de Modificar el numero del Cuadrante.<br>
     * @param numero Nuevo numero.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void cambiarNumero(int numero) {
		this.numero = numero;
	}

	/**
     * Metodo: darResponsable().<br>
     * Descripcion: Este Metodo se encarga de Retornar el Responsable del Cuadrante.<br>
     * @return responsable - Retorna el responsable del Cuadrante
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public String darResponsable() {
		return responsable;
	}

	/**
     * Metodo:cambiarResponsable(String responsable).<br>
     * Descripcion: Este Metodo se encarga de Modificar el responsable del Cuadrante.<br>
     * @param responsable Nuevo responsable.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void cambiarResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
     * Metodo: darArea().<br>
     * Descripcion: Este Metodo se encarga de Retornar el Area Construida de la Vivienda.<br>
     * @return area - Retorna el área construida de la Vivienda
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public double darArea() {
		return area;
	}

	/**
     * Metodo:cambiarArea(double area).<br>
     * Descripcion: Este Metodo se encarga de Modificar el Area Construida de la Vivienda.<br>
     * @param area Nueva area.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void cambiarArea(double area) {
		this.area = area;
	}

	/**
     * Metodo: darValor().<br>
     * Descripcion: Este Metodo se encarga de Retornar el Valor Comercial de la Vivienda.<br>
     * @return valor - Retorna el Valor Comercial de la Vivienda
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public int darValor() {
		return valor;
	}

	/**
     * Metodo:cambiarValor(int valor).<br>
     * Descripcion: Este Metodo se encarga de Modificar el Valor Comercial de la Vivienda.<br>
     * @param valor Nuevo valor.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void cambiarValor(int valor) {
		this.valor = valor;
	}
}