package dados;

import java.util.Random;

public class Dado {
	private int caras;
	private int valor_cara;

	Dado(){
		this.caras = 6;
	}
	Dado(int caras) {
		this.caras = caras;
	}

	public void tirar_dado() {
		Random cara_aleatoria = new Random();
		this.valor_cara = 1 + cara_aleatoria.nextInt(caras);
	}
	public int get_valor() {
		return this.valor_cara;
	}
}
