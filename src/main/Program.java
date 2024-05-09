package main;

import util.Forca;
import util.player.CriaJogador;

public class Program {

	public static void main(String[] args) {
		CriaJogador criar = new CriaJogador();
		Forca forca = new Forca(criar.criarJogadores());
		forca.jogar();
	}
}
