import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;

public class Tablero {

	
	private int[][] matriz;
	
	
	public int[][] inicializarTablero(int n) {
		
		matriz = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j = 0;j<n;j++) {
			matriz[i][j] = 0;
			}
		}
		return matriz;
	}



	public int[][] introducirBombas(int n, int tamaño) {

		Rand RandBomb = new Rand();
		matriz = RandBomb.introducirBomba(n, matriz, tamaño);
		
		return matriz;
		
	}



	public int[][] pistas(int[][] matriz, int tamaño) {
		
		for(int i=0;i<tamaño;i++) {
			for(int j = 0;j<tamaño;j++) {
			//ir casilla por casilla y comprobar el num de bombas alrededor.
				if (matriz[i][j] == -1) {
					if (i == 0) {
						if(j==0) {
							
							if (matriz[i+1][j] != -1) {matriz[i+1][j]++;};
							if (matriz[i+1][j+1] != -1) {matriz[i+1][j+1]++;};
							if (matriz[i][j+1] != -1) {matriz[i][j+1]++;};
						
							
						}else {if (j==tamaño-1) {
							
							if (matriz[i][j-1] != -1) {
								matriz[i][j-1]++;};
							if (matriz[i+1][j-1] != -1) {matriz[i+1][j-1]++;};
							if (matriz[i+1][j] != -1) {matriz[i+1][j]++;};
							
							
						}else {
							//normales j=1,etc
							if (matriz[i][j-1] != -1) {matriz[i][j-1]++;};
							if (matriz[i][j+1] != -1) {matriz[i][j+1]++;};
							if (matriz[i+1][j-1] != -1) {matriz[i+1][j-1]++;};
							if (matriz[i+1][j] != -1) {matriz[i+1][j]++;};
							if (matriz[i+1][j+1] != -1) {matriz[i+1][j+1]++;};
							
						}
							}
					}else {
						if(i==tamaño-1) {
							if(j==0) {
								
								if (matriz[i-1][j] != -1) {matriz[i-1][j]++;};
								if (matriz[i-1][j+1] != -1) {matriz[i-1][j+1]++;};
								if (matriz[i][j+1] != -1) {matriz[i][j+1]++;};
								
								
							}else {if (j==tamaño-1) {
								
								if (matriz[i][j-1] != -1) {matriz[i][j-1]++;};
								if (matriz[i-1][j-1] != -1) {matriz[i-1][j-1]++;};
								if (matriz[i-1][j] != -1) {matriz[i-1][j]++;};
								
							}else {
								//normales j=1,etc
								if (matriz[i][j-1] != -1) {matriz[i][j-1]++;};
								if (matriz[i][j+1] != -1) {matriz[i][j+1]++;};
								if (matriz[i-1][j-1] != -1) {matriz[i-1][j-1]++;};
								if (matriz[i-1][j] != -1) {matriz[i-1][j]++;};
								if (matriz[i-1][j+1] != -1) {matriz[i-1][j+1]++;};
								
							}
						}
					}else {
						if(j==0) {
							
							if (matriz[i-1][j] != -1) {matriz[i-1][j]++;};
							if (matriz[i+1][j] != -1) {matriz[i+1][j]++;};
							if (matriz[i-1][j+1] != -1) {matriz[i-1][j+1]++;};
							if (matriz[i][j+1] != -1) {matriz[i][j+1]++;};
							if (matriz[i+1][j+1] != -1) {matriz[i+1][j+1]++;};
							
							
						}else {if (j==tamaño-1) {
							
							if (matriz[i-1][j] != -1) {matriz[i-1][j]++;};
							if (matriz[i+1][j] != -1) {matriz[i+1][j]++;};
							if (matriz[i-1][j-1] != -1) {matriz[i-1][j-1]++;};
							if (matriz[i][j-1] != -1) {matriz[i][j-1]++;};
							if (matriz[i+1][j-1] != -1) {matriz[i+1][j-1]++;};
							
						}else {
							//normales j=1,etc
							if (matriz[i-1][j-1] != -1) {matriz[i-1][j-1]++;};
							if (matriz[i-1][j] != -1) {matriz[i-1][j]++;};
							if (matriz[i-1][j+1] != -1) {matriz[i-1][j+1]++;};
							if (matriz[i][j-1] != -1) {matriz[i][j-1]++;};
							if (matriz[i][j+1] != -1) {matriz[i][j+1]++;};
							if (matriz[i+1][j-1] != -1) {matriz[i+1][j-1]++;};
							if (matriz[i+1][j] != -1) {matriz[i+1][j]++;};
							if (matriz[i+1][j+1] != -1) {matriz[i+1][j+1]++;};
							
							
				}
				
			}

					}
					}
				}
			}
		}
		return matriz;
	}



}
