import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
	
		scann scann = new scann();
		
		int tama�o = 0;
		int bombas = 0;

		System.out.println("Elige un tama�o del mapa entre 2 (2x2) y 10 (10x10)");
		do {
			tama�o = scann.defineTama�o();
		
		}while(tama�o <= 1 && tama�o > 10);

		System.out.println("Elige el n�mero de bombas:");
		
		do {
			bombas = scann.defineBomba();// Leemos el input

		}while(bombas <= 0 && tama�o*tama�o < bombas);
			
		Tablero tab = new Tablero();
		TableroUsuario t_usuario = new TableroUsuario();
		
		int[][] matriz = tab.inicializarTablero(tama�o);
		
		matriz = tab.introducirBombas(bombas, tama�o);
		
		matriz = tab.pistas(matriz, tama�o);
		
		Casilla[][] m_usuario = t_usuario.inicializacion(tama�o, matriz);
		
		t_usuario.PrintarTablero(tama�o);
		
		
		boolean acabado = false;
		int x= 0;
		int y = 0;
		
		while(!acabado) {
			
			do {
				System.out.println("Introduce una coordenada x v�lida:");
				x = scann.defineInt();
			}while(x < 0 || x>=tama�o);
			
			do {
				System.out.println("Introduce una coordenada y v�lida:");
				y = scann.defineInt();
			}while(y < 0 || y>=tama�o);
			
			
			m_usuario = t_usuario.DestaparCasilla(x, y);
			m_usuario = t_usuario.Expandir(tama�o);
			t_usuario.PrintarTablero(tama�o);
			int aux = 0;
			if (m_usuario[y][x].getId() == -1) {
				acabado = true;
				System.out.println("Has pisado una bomba! Has perdido!");
			}else {
				
				for(int i=0;i<tama�o;i++) {
					for(int j = 0;j<tama�o;j++) {
						if(!m_usuario[i][j].getDestapado()) {
							aux +=1;
						}
					}
				}
				if(aux == bombas) {
					acabado = true;
					System.out.println("Has ganado!");
				}
			}
		}
	}
}
