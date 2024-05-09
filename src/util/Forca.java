package util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import util.player.Jogador;

public class Forca {
	
	private static Scanner sc = new Scanner(System.in);
	private String palavra = "RACIONALIDADE";
	char[] escondida = new char[palavra.length()];
	private List<Jogador> jogadores = new ArrayList<>();

	public Forca(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public void jogar() {
		for (int i = 0; i < palavra.length(); i++) {
			escondida[i] = '_';
		}

		int jogadorAtual = 0;
		int rodada = 1;
		primeiro: while (true) {
			Jogador jogador = jogadores.get(jogadorAtual);
			if (jogador.hasTentativas()) {
				System.out.println(
						"\n\nVez do(a) jogador(a) " + jogador.nome() + "\n\t\tTentativas restantes: " + jogador.tentativas());
				jogador.forca();
				System.out.println(escondida);

				if (rodada >= 2) {
					System.out.println("[1] TENTAR PALAVRA");
					System.out.println("[2] TENTAR LETRA");
					int escolha;
					while(true) {
						try {
							escolha = sc.nextInt();
							sc.nextLine();
							if(escolha > 2) {
								throw new InputMismatchException();
							}
							break;
						} catch(InputMismatchException e) {
							System.err.println("Digite uma escolha válida!!");
							sc.next();
						}
					}	
					
					if (escolha == 1) {
						tentarPalavra(jogador);
					} else {
						tentarLetra(jogador);
					}
				} else {
					tentarLetra(jogador);
				}

				if (verificaPalavra(escondida, jogador)) {
					break primeiro;
				}

			} else {
				jogadores.remove(jogadorAtual);
			}

			if (jogadores.isEmpty()) {
				fimDeJogo();
				sc.close();
				break primeiro;
			} else {
				jogadorAtual = (jogadorAtual + 1) % jogadores.size();
			}
			rodada = jogadorAtual == 0 ? (rodada + 1) : (rodada);
		}
	}

	private void tentarLetra(Jogador jogador) {
		System.out.print("Digite UMA letra: ");
		char letra = sc.nextLine().toUpperCase().charAt(0);
		System.out.println();
		verificaLetra(letra, jogador);
	}

	private void verificaLetra(char letra, Jogador jogador) {
		if (palavra.indexOf(letra) >= 0) {
			for (int i = 0; i < palavra.length(); i++) {
				if (palavra.charAt(i) == letra) {
					this.escondida[i] = letra;
				}
			}
			System.out.print("\t" + jogador.nome() + " ACERTOU UMA LETRA!!");
		} else {
			jogador.perdeTentativa();
		}
	}

	private void tentarPalavra(Jogador jogador) {
		System.out.print("\nDigite a palavra:");
		char[] palavra = sc.nextLine().toUpperCase().toCharArray();

		if (this.palavra.equals(new String(palavra).toUpperCase())) {
			escondida = this.palavra.toCharArray();
		} else {
			jogador.perdeTentativa();
		}
	}

	private boolean verificaPalavra(char[] matriz, Jogador jogador) {
		if (this.palavra.equals(new String(matriz).toUpperCase())) {
			System.out.println(
					"\n\tParabéns " + jogador.nome() + " você acertou a palavra!!!\n\tA palavra era: " + palavra);
			escondida = palavra.toCharArray();
			jogador.campeao();
			return true;
		} else {
			return false;
		}
	}

	private void fimDeJogo() {
		System.out.println("Nenhum Jogador foi pareo para a SUPER FORCA!!\n" + "\t\tFIM DE JOGO\n" + "\ta palavra era ("
				+ palavra + ")");
	}
}
