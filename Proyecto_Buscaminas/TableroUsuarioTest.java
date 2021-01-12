import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroUsuarioTest {

	@Test
	public void testInicializacion() {
		//Testeamos la inicialización con un tablero de tamaño 5
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(5);
		matriz = tab.introducirBombas(10, 5);
		matriz = tab.pistas(matriz, 5);
		
		TableroUsuario t_u = new TableroUsuario();		
		Casilla[][] m_usuario = t_u.inicializacion(5, matriz);
		
	
		for(int i=0;i<5;i++) {
			for(int j = 0;j<5;j++) {
			
			assertEquals(matriz[i][j],m_usuario[i][j].getId());
			assertEquals(false,m_usuario[i][j].getDestapado());
			}
		}
		
		//Testeamos la inicialización con un tablero de tamaño 20
		Tablero tab2 = new Tablero();
		int[][] matriz2 = tab2.inicializarTablero(20);
		matriz2 = tab2.introducirBombas(10,20);
		matriz2 = tab2.pistas(matriz2, 20);
		
		TableroUsuario t_u2 = new TableroUsuario();		
		Casilla[][] m_usuario2 = t_u2.inicializacion(20, matriz2);
		
	
		for(int i=0;i<20;i++) {
			for(int j = 0;j<20;j++) {
			
			assertEquals(matriz2[i][j],m_usuario2[i][j].getId());
			assertEquals(false,m_usuario2[i][j].getDestapado());
			}
		}
		
		//Testeamos la inicialización con un tablero de tamaño 10
		Tablero tab3 = new Tablero();
		int[][] matriz3 = tab3.inicializarTablero(10);
		matriz3 = tab3.introducirBombas(10,10);
		matriz3 = tab3.pistas(matriz3, 10);
				
		TableroUsuario t_u3 = new TableroUsuario();		
		Casilla[][] m_usuario3 = t_u3.inicializacion(10, matriz3);
				
		
		for(int i=0;i<10;i++) {
			for(int j = 0;j<10;j++) {
					
			assertEquals(matriz3[i][j],m_usuario3[i][j].getId());
			assertEquals(false,m_usuario3[i][j].getDestapado());
			}
		}		
	}
	
	@Test
	public void testExpandir() {
		int tam = 5;
		int bomb = 0;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tam);
		matriz = tab.introducirBombas(bomb, tam);
		matriz = tab.pistas(matriz, tam);
		
		TableroUsuario t_u = new TableroUsuario();		
		Casilla[][] m_usuario = t_u.inicializacion(tam, matriz);
		
		//case -1
		m_usuario = t_u.Expandir(-1);
		
		//case 5 // A=0, B=T
		t_u.DestaparCasilla(0, 0);
		m_usuario = t_u.Expandir(tam);
		
		for(int i=0;i<tam;i++) {
			for(int j = 0;j<tam;j++) {
				assertEquals(true, m_usuario[i][j].getDestapado());
			}
		}
		
		//case A=0, B=F
		m_usuario[0][0].setDestapado(false);
		m_usuario = t_u.Expandir(tam);
				
		//case A!=0, B=F
		m_usuario[0][0].setId(1);
		m_usuario = t_u.Expandir(tam);
		
		//case A!=0, B=T
		t_u.DestaparCasilla(0,0);
		m_usuario = t_u.Expandir(tam);
		
		t_u.PrintarTablero(tam);
	}

	@Test
	public void testDestaparCasilla() {
		int tam = 5;
		int bomb = 0;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tam);
		matriz = tab.introducirBombas(bomb, tam);
		matriz = tab.pistas(matriz, tam);
		
		TableroUsuario t_u = new TableroUsuario();		
		Casilla[][] m_usuario = t_u.inicializacion(tam, matriz);
		
		t_u.DestaparCasilla(3, 3);
		assertEquals(true,m_usuario[3][3].getDestapado());
		
		//case -1
		t_u.DestaparCasilla(-1, -1);
		t_u.DestaparCasilla(-1, 1);
		t_u.DestaparCasilla(-1, 9);
		
		//case 0
		t_u.DestaparCasilla(0, 0);
		assertEquals(true,m_usuario[0][0].getDestapado());
		t_u.DestaparCasilla(0, -1);
		t_u.DestaparCasilla(0, 1);
		t_u.DestaparCasilla(0, 9);
		
		//case 1
		t_u.DestaparCasilla(1, 1);
		assertEquals(true,m_usuario[1][1].getDestapado());
		t_u.DestaparCasilla(1, -1);
		t_u.DestaparCasilla(1, 9);
		
		//case 2
		t_u.DestaparCasilla(2,2);
		assertEquals(true,m_usuario[2][2].getDestapado());
		t_u.DestaparCasilla(2,-1);
		t_u.DestaparCasilla(2,9);
		
		
		//case 5
		t_u.DestaparCasilla(5,5);
		t_u.DestaparCasilla(5,-1);
		t_u.DestaparCasilla(5,1);
		t_u.DestaparCasilla(5,9);
		
		//case 9
		t_u.DestaparCasilla(9,9);
		t_u.DestaparCasilla(9,-1);
		t_u.DestaparCasilla(9,1);

		
		//case 10
		t_u.DestaparCasilla(10,10);
		t_u.DestaparCasilla(10,-1);
		t_u.DestaparCasilla(10,1);
		
		//case 11
		t_u.DestaparCasilla(11,11);
		t_u.DestaparCasilla(11,-1);
		t_u.DestaparCasilla(11,1);
	}
	
	
	
	@Test
	public void testPrintarTablero() {
		int tam = 5;
		int bomb = 5;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tam);
		matriz = tab.introducirBombas(bomb, tam);
		matriz[0][0] = -1;
		matriz = tab.pistas(matriz, tam);
		
		TableroUsuario t_u = new TableroUsuario();		
		t_u.inicializacion(tam, matriz);
		t_u.DestaparCasilla(0, 0);
		
		//case -1
		t_u.PrintarTablero(-1);
		
		//case 5
		t_u.PrintarTablero(5);


	}

}