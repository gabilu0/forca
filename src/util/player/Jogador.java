package util.player;

public class Jogador {
	
	private String nome;
	private int tentativas = 4;
	
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public void perdeTentativa() {
		tentativas--;
		forca();
		if(tentativas == 0) {
			eliminado();
			return;
		}
		System.err.println("\n" + nome + " acaba de perder uma tentativa!!");
	}
	
	public void forca() {
		String[] enforcamento = {
				" *----*\n" +
				" |    |\n" +
				"      |\n" +
				"      |\n" +
				"      |\n" +
				"      |\n" +
				"      | ",
				" *----*\n" +
				" |    |\n" +
				" Õ    |\n" +
				"      |\n" +
				"      |\n" +
				"      |\n" +
				"      | ",
				" *----*\n" +
				" |    |\n" +
				" Õ    |\n" +
				" |    |\n" +
				" |    |\n" +
				"      |\n" +
				"      | ",
				" *----*\n" +
				" |    |\n" +
				" Õ    |\n" +
				"(|)   |\n" +
				" |    |\n" +
				"      |\n" +
				"      | ",
				" *----*\n" +
				" |    |\n" +
				" Õ    |\n" +
				"(|)   |\n" +
				" |    |\n" +
				"/ 7   |\n" +
				"      | "
		};
		if(tentativas == 4) {
			System.err.print(enforcamento[0]);
		}
		if(tentativas == 3) {
			System.err.print(enforcamento[1]);
		}
		if(tentativas == 2) {
			System.err.print(enforcamento[2]);
		}
		if(tentativas == 1) {
			System.err.print(enforcamento[3]);
		}
		if(tentativas == 0) {
			System.err.print(enforcamento[4]);
		}
 	}
	
	public boolean hasTentativas() {
		return tentativas > 0;
	}
	public void eliminado() {
		System.out.println("\n" + nome + " FOI ELIMINADO!! ):\n");
	}
	public String nome() {
		return nome;
	}
	public int tentativas() {
		return tentativas;
	}
	
	public void campeao() {
		String[] campeao = {
			"\t\t  _______   \n"+
			"\t\t //      \\ \n"+
			"\t\t//CAMPEAO \\\n"+
			"\t\t\\        //\n"+
			"\t\t \\______// \n"+
			"\t\t   || ||    \n"+
			"\t\t  _||_||_   \n"+
			"\t\t |_______|  \n"
		};
		
		System.out.println(campeao[0]);
	}
}
