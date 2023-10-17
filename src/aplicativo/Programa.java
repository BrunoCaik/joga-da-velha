package aplicativo;

import java.util.Scanner;

import base.ExcecaoVelha;
import base.Partida;

public class Programa {

	public static void main(String[] args) {
		
		Partida partida = new Partida();
		Scanner sc = new Scanner(System.in);
		
		while(!partida.testarCondicaoDeJogo()) {
			
			try {
			
			     UI.printarPapel(partida.pegarPapel());
			     System.out.println();
			     System.out.print(partida.pegarJogador()+": ");
			     partida.botarFigura(UI.lerPosicao(sc));
			
			     if(!partida.testarCondicaoDeJogo()) {
						partida.passarTurno();
						UI.clearScreen();
				  }
			
			}
			catch(ExcecaoVelha e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(RuntimeException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}
		
		if(partida.pegarVitoria()) {
			System.out.println("VITORIDA DO "+partida.pegarJogador());
		}
		else
			System.out.println("EMPATE");
		
	}

}
