package base;

public class Papel {

	private Figura[][] velha;
	
	public Papel() {
		velha = new Figura[3][3];
	}
	
	public Figura[][] pegarVelha(){
		return velha;
	}
	
	public boolean estaVazio(int row, int column) {
		
		if(!posicaoExiste(row, column)) {
			throw new ExcecaoVelha("Esta posição não existe");
		}
		
		if(velha[row][column] != null) {
			return false;
		}
		return true;
	}
	
	public boolean posicaoExiste(int row, int column) {
		return row >=0 && row <= 2 && column >= 0 && column <= 2;
	}
	
	public void botarFigura(Figura figura) {
		
		velha[figura.pegarLinha()][figura.pegarColuna()] = figura;
	}
	
	
}
