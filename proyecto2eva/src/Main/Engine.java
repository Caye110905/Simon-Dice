package Main;

import java.util.Random;
import java.util.Scanner;

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

	public static int MAX_COLORES_SEQ = 12;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * Este método lo utilizamos para saber cual es la primera letra de cada color
	 * para identificarlos y, asi, nos devuelve cualquiera de los 4 colores puestos
	 * anteriormente en el enum tColores.
	 * 
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */

	public tColores charToColor(char _color) {
		char _colores = 0;
		char letraColores = Character.toLowerCase(_colores);
		switch (letraColores) {
		case 'r':
			return tColores.Rojo;
		case 'v':
			return tColores.Verde;
		case 'a':
			return tColores.Azul;
		case 'd':
			return tColores.Dorado;
		default:
			System.out.println("Lo siento, has fallado el siguiente color");

		}
		return null;
	}

	/**
	 * Método para dar un número y nos devuelve cualquiera de los 4 colores puestos
	 * anteriormente en el enum tColores.
	 * 
	 * @param _numero representa el número entero.
	 * @return
	 */

	public tColores intToColor(int _numero) {
		switch (_numero) {
		case '1':
			return tColores.Rojo;
		case '2':
			return tColores.Azul;
		case '3':
			return tColores.Verde;
		case '4':
			return tColores.Dorado;

		default:
			System.out.println("Número sin encontrar");

		}
		return null;
	}

	/**
	 * Este método genera una secuencia con numeros random o aleatorios.
	 * 
	 * @param _numColores representa el número de colores que tiene el tipo
	 *                    enumerado tColores.
	 */

	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < _numColores; i++) {
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
		for (int i = 0; i < secuenciaColores.length; i++) {
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Simon Dice!");
		System.out.println("What is your name? ");
		String persona = scanner.nextLine();
		System.out.println("Hello " + persona + ", press ENTER to start playing");
		menu();
	}

	/**
	 * Funcionamiento del juego utilizando el método play.
	 */

	public void play() {
		
	}

}
