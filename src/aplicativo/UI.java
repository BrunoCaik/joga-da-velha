package aplicativo;

import java.util.Scanner;

import base.Figura;
import base.Papel;

public class UI {
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void printarPapel(Papel papel) {
		for(int i=0; i<3; i++) {
			System.out.print(i+1+" ");
			for(int j=0; j<3; j++) {
				System.out.print("["+figura(papel.pegarVelha()[i][j])+"]");
				
			}
			System.out.println();
		}
		System.out.println("   a  b  c");
		
	}
	
	private static String figura(Figura figura) {
		if(figura != null) {
			return figura.toString();
		}
		else {
			return " ";
		}
	}
	
	public static String lerPosicao(Scanner sc) {
		String posicao = sc.nextLine();
		return posicao;
	}
	
}
