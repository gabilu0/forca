package util.player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CriaJogador {
	
	public List<Jogador> criarJogadores() {
		Scanner sc = new Scanner(System.in);
		List<Jogador> jogadores = new ArrayList<Jogador>();
		
		System.out.print("\tBem vindo a SUPER FORCA\n"
				+ "Quantos jogadores deseja cadastrar? ");
		int quantidade;
		while(true) {
			try {
				quantidade = sc.nextInt(); sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.print("\n\t\tErro.\n DIGITE O NÚMERO DE JOGADORES: ");
				sc.next();
			}
		}
		

		
		for(int i=1;i<=quantidade;i++) {
			System.out.print("Nome do " + i + "° jogador: ");
			String nome = sc.nextLine().toUpperCase();
			
			Jogador jogador = new Jogador(nome);
			jogadores.add(jogador);
		}
		return jogadores;
	}
	
}
