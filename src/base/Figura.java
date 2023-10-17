package base;

public class Figura {

	private int linha;
	private int coluna;
	private Tipo tipo;
	
	public Figura(int linha, int coluna, Tipo tipo) {
		this.linha = linha;
		this.coluna = coluna;
		this.tipo = tipo;
	}
	
	public int pegarLinha() {
		return linha;
	}
	
	public int pegarColuna() {
		return coluna;
	}
	
	public Tipo pegarTipo() {
		return tipo;
	}
	
	public String toString() {
		if(tipo == Tipo.BOLINHA) {
			return "O";
		}
		else {
			return "X";
		}
	}
}
