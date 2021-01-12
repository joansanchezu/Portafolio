import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
	
		scann scann = new scann();
		
		int tamaño = 0;
		int bombas = 0;

		System.out.println("Elige un tamaño del mapa entre 2 (2x2) y 10 (10x10)");
		do {
			tamaño = scann.defineTamaño();
		
		}while(tamaño <= 1 && tamaño > 10);

		System.out.println("Elige el número de bombas:");
		
		do {
			bombas = scann.defineBomba();// Leemos el input

		}while(bombas <= 0 && tamaño*tamaño < bombas);
			
		Tablero tab = new Tablero();
		TableroUsuario t_usuario = new TableroUsuario();
		
		int[][] matriz = tab.inicializarTablero(tamaño);
		
		matriz = tab.introducirBombas(bombas, tamaño);
		
		matriz = tab.pistas(matriz, tamaño);
		
		Casilla[][] m_usuario = t_usuario.inicializacion(tamaño, matriz);
		
		t_usuario.PrintarTablero(tamaño);
		
		
		boolean acabado = false;
		int x= 0;
		int y = 0;
		
		while(!acabado) {
			
			do {
				System.out.println("Introduce una coordenada x válida:");
				x = scann.defineInt();
			}while(x < 0 || x>=tamaño);
			
			do {
				System.out.println("Introduce una coordenada y válida:");
				y = scann.defineInt();
			}while(y < 0 || y>=tamaño);
			
			
			m_usuario = t_usuario.DestaparCasilla(x, y);
			m_usuario = t_usuario.Expandir(tamaño);
			t_usuario.PrintarTablero(tamaño);
			int aux = 0;
			if (m_usuario[y][x].getId() == -1) {
				acabado = true;
				System.out.println("Has pisado una bomba! Has perdido!");
			}else {
				
				for(int i=0;i<tamaño;i++) {
					for(int j = 0;j<tamaño;j++) {
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
