package Main;

import java.util.Scanner;
import java.util.Random;

/**
 * Simon dice, trabajo 2ª Evaluación
 * 
 * @author cayet
 */

public class Engine {

	/**
	 * Empezamos haciendo un enum con los colores que se van a utilizar para jugar
	 * al Simon dice.
	 */

	enum tColores {
		Rojo, Verde, Azul, Dorado
	}

	/**
	 * Array donde se fija el numero maximo de secuencia de colores.
	 */

	static int MAX_COLORES_SEQ = 12;
	static tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * Este método lo utilizamos para saber cual es la primera letra de cada color
	 * para identificarlos y, asi, nos devuelve cualquiera de los 4 colores puestos
	 * anteriormente en el enum tColores.
	 * 
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */

	private tColores charToColor(char _color) {
		tColores colores = null;
		char letraColores = Character.toLowerCase(_color);
		
		switch (letraColores) {
		case 'r':
			colores = tColores.Rojo;
			break;
		case 'v':
			colores = tColores.Verde;
			break;
		case 'a':
			colores = tColores.Azul;
			break;
		case 'd':
			colores = tColores.Dorado;
			break;
			
		default:
			System.out.println("Lo siento, has fallado el siguiente color");

		}
		return colores;
	}

	/**
	 * Método para dar un número y nos devuelve cualquiera de los 4 colores puestos
	 * anteriormente en el enum tColores.
	 * 
	 * @param _numero representa el número entero.
	 * @return
	 */

	private tColores intToColor(int _numero) {
		tColores posicion = null;
		
		switch (_numero) {
		case 0:
			posicion = tColores.Rojo;
			break;
		case 1:
			posicion = tColores.Azul;
			break;
		case 2:
			posicion = tColores.Verde;
			break;
		case 3:
			posicion = tColores.Dorado;
			break;

		}
		return posicion;
	}

	/**
	 * Este método genera una secuencia con numeros random o aleatorios.
	 * 
	 * @param _numColores representa el número de colores que tiene el tipo
	 *                    enumerado tColores.
	 */

	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, 4);
			secuenciaColores[i] = intToColor(aleatorio);

		}
	}

	/**
	 * Este método comprueba si el jugador ha acertado o ha fallado el color.
	 * 
	 * @param _index índice que el color ocupa dentro del array secuenciaColores.
	 * @param _color color introducido por el usuario.
	 * @return
	 */

	public boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;

	}

	/**
	 * Este método muestra la secuencia por pantalla y, así, el jugador pueda
	 * memorizarlo.
	 * 
	 * @param _numero número de la secuencia actual.
	 */

	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.println(secuenciaColores[i] + " ");
		}
	}

	/**
	 * Este es el menú de inicio para jugar.
	 */

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1- Jugar || 2- Salir");
		Scanner sc1 = new Scanner(System.in);
		int menu = sc1.nextInt();
		if (menu == 1) {
			System.out.println("Empieza el juego");
			play();
		} else if (menu == 2) {
			System.out.println("Salistes del juego");
			start();
		} else {
			System.out.println("Número no disponible");
			menu();
		}
	}

	/**
	 * Este es el inicio del juego donde te saludan, tienes que poner tu nombre y
	 * pulsar ENTER para empezar a jugar.
	 */

	public void start() {
		System.out.println("Welcome to Simon Dice!");
		System.out.println("What is your name? ");
		Scanner scanner = new Scanner(System.in);
		String persona = scanner.nextLine();
		System.out.println("Hello " + persona + ", press ENTER to start playing");
		menu();
	}

	/**
	 * Control del juego.
	 */

	public void play() {
		
		generarSecuencia(12);

		for (int i = 0; i < MAX_COLORES_SEQ; i++) {

		System.out.println("Pulsa ENTER para empezar a jugar");
		new Scanner(System.in).nextLine();
		for(int j = 0; j < 30; j++) {
			System.out.println();
		}
		mostrarSecuencia(3 + i);
		System.out.println();
		
		int numerosecuencia = i + 1;
		
		System.out.println("Presiona Enter cuando memorices la secuencia" + numerosecuencia);
		new Scanner(System.in).nextLine();
		
		for (int n = 0; n < 30; n++) {
			System.out.println();
		}
		
		System.out.println("¿Cuál era la secuencia de colores?");
		for (int k = 0; k < 3 + i; k++) {
			System.out.println("Introduce el color en la posición " + (k + 1) + ": ");
			char secuenciaUsuario = new Scanner(System.in).next().charAt(0);
			tColores colorEscogido = charToColor(secuenciaUsuario);

			if (comprobarColor(k, colorEscogido)) {
				System.out.println("correcto, bien hecho");
			} else {
				System.out.println("Incorrecto, fin del juego");
				menu();
			}
		}

		while (i == MAX_COLORES_SEQ - 3) {
			System.out.println("Has ganado, terminaste el juego");
			menu();
		}		
      }
   }
}