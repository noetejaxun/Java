/*	Desarrollador:	Luis Noé Tejaxún Quisque
 *  Carné: 	1990-16-16820
 *  Fecha:	30/08/2017
 *  Modificación:	31/08/2017 15:28
 * */

package dados_enum;

public class Juego {
	private static int valor_dado_uno;
	private static int valor_dado_dos;
	private static int suma_dados;
	private static int nueva_suma_dados;
	private enum Estado {GANA, TIRO_JUGADOR, GANA_LA_CASA};

	Estado verificar_suma_dados(int valor_dado_uno, int valor_dado_dos) {
		suma_dados = valor_dado_uno + valor_dado_dos;

		if(suma_dados == 7 || suma_dados == 11) {
			return Estado.GANA;
		} else if (suma_dados >= 4 && suma_dados <= 6 || suma_dados >= 8 && suma_dados <= 10) {
			return Estado.TIRO_JUGADOR;
		} else {
			return Estado.GANA_LA_CASA;
		}
	}

	Estado tirar_dados() {
		Juego juego = new Juego();
		Dado dado_uno = new Dado(6);
		Dado dado_dos = new Dado(6);

		dado_uno.tirar_dado();
		valor_dado_uno = dado_uno.get_valor();
		dado_dos.tirar_dado();
		valor_dado_dos = dado_dos.get_valor();

		Estado suma_verificada = juego.verificar_suma_dados(valor_dado_uno, valor_dado_dos);
		return suma_verificada;
	}

	public static void main(String[] args) {
		Juego juego = new Juego();
		Estado suma_verificada;

		suma_verificada = juego.tirar_dados();

		System.out.printf("Valor dado uno: %d\n", valor_dado_uno);
		System.out.printf("Valor dado dos: %d\n", valor_dado_dos);
		System.out.printf("Suma de los dados: %d\n",suma_dados);

		if (suma_verificada == Estado.GANA) {
			System.out.println("Felicidades, ganaste :)");
		} else if (suma_verificada == Estado.GANA_LA_CASA){
			System.out.println("Lo sentimos, gana la casa :(");
		} else {
			while (suma_verificada == Estado.TIRO_JUGADOR) {
				System.out.println("\nTiro Jugador :)\n");
				nueva_suma_dados = suma_dados;

				suma_verificada = juego.tirar_dados();

				System.out.printf("Valor dado uno: %d\n", valor_dado_uno);
				System.out.printf("Valor dado dos: %d\n", valor_dado_dos);
				System.out.printf("Suma de los dados: %d\n",suma_dados);

				if (suma_dados == nueva_suma_dados) {
					System.out.println("Genial, Ganaste :)");
					break;
				} else if (suma_verificada == Estado.TIRO_JUGADOR){
					continue;
				} else {
					System.out.println("Lo sentimos los tiros no fueron iguales, gana la casa :(");
					break;
				}
			}
		}
	}
}
