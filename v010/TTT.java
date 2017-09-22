/*
						____________
La versión v010 está |Mal Formateada| 
					----------------
Esto es una mierda!!
	Se ven cosas como que no esta sangrado el código.¿Eres capaz de leerlo?
	FORMATEO DE CÓDIGO LIMIPIO

	Justificación:
	Formateo de código es importante. Es demasiado importante como
	para ignorarlo y es demasiado importante como para tratarlo
	religiosamente. El formateo de código trata sobre la comunicación y
	la comunicación es de primer orden para los desarrolladores
	profesionales.

	Implicaciones:
	▫ Una línea entre grupos lógicos (atributos y cada método).
	▫ Los atributos deben declararse al principio de la clase
	▫ Las funciones dependientes en que una llama a otra, deberían estar
	verticalmente cerca: primero la llamante y luego la llamada
	▫ Grupos de funciones que realizan operaciones parecidas, deberían
	permanencer juntas
	▫ Las variables deberían declararse tan cerca como sea posible de su
	utilización
	▫ Los programadores prefieren líneas cortas (~40, máximo 80/120)
	▫ Utilizamos el espacio en blanco horizontal para asociar las cosas que
	están fuertemente relacionadas y disociar las cosas que están más
	débilmente relacionadas y para acentuar la precedencia de
	operadores
	▫ Un código es una jerarquía. Hay información que pertenece al archivo
	como un todo, a las clases individuales dentro del archivo, a los
	métodos dentro de las clases, a los bloques dentro de los métodos, y
	de forma recursiva a los bloques dentro de los bloques. Cada nivel de
	esta jerarquía es un ámbito en el que los nombres pueden ser
	declaradas y en la que las declaraciones y sentencias ejecutables se
	interpretan. Para hacer esta jerarquía visible, hay que sangrar la
	líneas de código fuente de forma proporcional a su posición en la
	jerarquía.

	Violaciones:
	▫ No uses tabuladroes entre los tipos y las variables para una
	disposición por columnas
	▫ Nunca rompas las reglas de sangrado por muy pequeñas que sean las
	líneas.

	Máximas:
	▫“Conceptos que están estrechamente relacionados deben mantenerse
	verticalmente cercanos” [Martin, R.]
	▫ Un equipo de desarrolladores deben ponerse de acuerdo sobre un
	único estilo de formato y luego todos los miembros de ese equipo
	debe usar ese estilo. 

	"La calidad del Software es una sumatoria de infinitesimos. El mejor código del mundo bien diseñado dependencias, tamaño, etc. Pero dispuesto de esta manera...Que no hay quien lo lea esto es un asco"
*/

class TTT {
	// atributos /////////////////////////////////////////////
	private char[][] box; // 3x3 casillas
	public static char[] color = { 'x', 'o' }; // colores de los jugadores
	private int zeroOrOne; // turno
//	private boolean ticTacToe;
	private Start s; // arrancar
	private Put p; // poner
	private Move m; // mover
	public TTT() { // inicializo atributos
	zeroOrOne = 0;
//	ticTacToe = false;
	box = new char[3][3]; s = new Start(box); p = new Put(box);
	}
	// métodos /////////////////////////////////////////////
	public void exec() {
	do {
	s.write();
	// mientras no esté completo el tablero, pone; luego mueve
	if (!this.complete()) {
	p.put(zeroOrOne, this);} else {
	m.move(zeroOrOne, this);}
	zeroOrOne = (zeroOrOne + 1) % 2;
	} while (!this.existTTT());
	// no arranca, solo para escribir el tablero
	s.write();this.message(zeroOrOne);
	}

	public boolean complete() {
	int c = 0;
	for (int contRow = 0; contRow < 3; contRow++) {
	for (int contColumn = 0; contColumn < 3; contColumn++) {
	if (box[contRow][contColumn]!='_') {c++;}}}
	return c == 6;}

	public boolean existTTT() {
	return this.existTTT('x')|| this.existTTT('o');}

	public boolean existTTT(char token) {
	// si está en el centro
	if (box[1][1]==token) {
	// si está arriba izquierda
	if (box[0][0]==token) {
	// si está abajo derecha
	return box[2][2]==token;
	}
	// si está arriba derecha
	if (box[0][2]==token) {
	// si está abajo izquirda
	return box[2][0]==token;
	}
	if (box[0][1]==token) {
	return box[2][1]==token;
	}
	if (box[1][0]==token) {
	return box[1][2]==token;
	}
	return false;
	}
	if (box[0][0]==token) {
	if (box[0][1]==token) {
	return box[0][2]==token;
	}
	if (box[1][0]==token) {
	return box[2][0]==token;
	}
	return false;
	}
	if (box[2][2]==token) {
	if (box[1][2]==token) {
	return box[0][2]==token;
	}
	if (box[2][1]==token) {
	return box[2][0]==token;
	}
	return false;
	}
	return false;
	}

	public boolean empty(int r, int c) {
	return box[r][c]=='_';}

	//si una casilla está llena de una ficha
	public boolean full(int r, int c, char t) {
	return box[r][c]==t;}

	public void clear() {
	for (int i = 0; i < 3; i++) {
	for (int j = 0; j < 3; j++) {
	box[i][j] = '_';}}}

	public void message(int turn) {// porque se cambió en turno
	turn = (turn + 1) % 2;
	System.out.println("Victoria!!!! " + TTT.color[turn] + "! "+ TTT.color[turn] + "! " + TTT.color[turn]+ "! Victoria!!!!");}

	public static void main(String[] args) {
	new TTT().exec();}}