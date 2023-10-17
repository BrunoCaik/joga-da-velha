package base;

import java.util.Random;

public class Partida {
	
	private Papel papel;
	private Tipo jogador;
	private boolean vitoria;
	private Random gerador = new Random();
	
	public Partida() {
		papel = new Papel();
		
		int numero = gerador.nextInt(2);
		if(numero == 0)
			jogador = Tipo.BOLINHA;
		else
			jogador = Tipo.XIZ;
		
		vitoria = false;
	}
	
	public Papel pegarPapel() {
		return papel;
	}
	
	public Tipo pegarJogador() {
		return jogador;
	}
	
	public boolean pegarVitoria() {
		return vitoria;
	}
	
	public void passarTurno() {
		if(jogador == Tipo.BOLINHA)
			jogador = Tipo.XIZ;
		else
			jogador = Tipo.BOLINHA;
	}
	
	public void botarFigura(String posicao) {
		
		char ch = posicao.charAt(0);
		int linha = Integer.parseInt(posicao.substring(1)) - 1;
		
		int coluna = 0;
		if(ch == 'a')
			coluna = 0;
		else if(ch == 'b')
			coluna = 1;
		else if(ch == 'c')
			coluna = 2;
		else 
			throw new ExcecaoVelha("Aposição não existe");
		
		if(!papel.estaVazio(linha, coluna)) {
			throw new ExcecaoVelha("A posição não esta vazia");
		}
		
		papel.botarFigura(new Figura(linha, coluna, jogador));
		
	}
	
	public boolean testarCondicaoDeJogo() {
		for(int i=0; i<3; i++) {
			
			//testando linhas
			if(papel.pegarVelha()[i][0] != null && papel.pegarVelha()[i][1] != null && papel.pegarVelha()[i][2] != null) {
				if(papel.pegarVelha()[i][0].pegarTipo() == papel.pegarVelha()[i][1].pegarTipo() && papel.pegarVelha()[i][0].pegarTipo()==papel.pegarVelha()[i][2].pegarTipo()) {
					vitoria = true;
					return true;
				}
			}
			
			//testando colunas
			if(papel.pegarVelha()[0][i] != null && papel.pegarVelha()[1][i] != null && papel.pegarVelha()[2][i] != null) {
				if(papel.pegarVelha()[0][i].pegarTipo() == papel.pegarVelha()[1][i].pegarTipo() && papel.pegarVelha()[0][i].pegarTipo()==papel.pegarVelha()[2][i].pegarTipo()) {
					vitoria = true;
					return true;
				}
			}	
		}
		
		//testando diagonal principal
		if(papel.pegarVelha()[0][0] != null && papel.pegarVelha()[1][1] != null && papel.pegarVelha()[2][2] != null) {
			if(papel.pegarVelha()[0][0].pegarTipo() == papel.pegarVelha()[1][1].pegarTipo() && papel.pegarVelha()[0][0].pegarTipo()==papel.pegarVelha()[2][2].pegarTipo()) {
				vitoria = true;
				return true;
			}
		}
		
		//testando diagonal secundaria
		if(papel.pegarVelha()[0][2] != null && papel.pegarVelha()[1][1] != null && papel.pegarVelha()[2][0] != null) {
			if(papel.pegarVelha()[0][2].pegarTipo() == papel.pegarVelha()[1][1].pegarTipo() && papel.pegarVelha()[0][2].pegarTipo()==papel.pegarVelha()[2][0].pegarTipo()) {
				vitoria = true;
				return true;
			}
		}
		
		//empate
		int soma = 0;
		for(int i=0; i<3; i++) {
		    for(int j=0; j<3; j++) {
		        if(papel.pegarVelha()[i][j] != null) 
		            soma += 1;
		    }
		}
		if(soma == 9)
		    return true;

		
		return false;
	}

}
