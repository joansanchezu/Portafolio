import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {


	@Test
	public void testinicializarTablero() {
		// Test de inicializaci�n de la matriz que guardar� los elementos del juego
		int n = 1;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(n);

		for(int i=0;i<n;i++) {
			for(int j = 0;j<n;j++) {
			assertEquals(0,matriz[i][j]);
			}
		}
		
		int n2 = 10;
		Tablero tab2 = new Tablero();
		int[][] matriz2 = tab2.inicializarTablero(n2);

		for(int i=0;i<n2;i++) {
			for(int j = 0;j<n2;j++) {
			assertEquals(0,matriz2[i][j]);
			}
		}
	}
	
	@Test
	public void testInput() {
		// Testeamos el input por parte del usuario usando el
		// mock object Scann
		MockScann mockScann = new MockScann();
		int n_bombas=mockScann.defineBomba();
		int tama�o=mockScann.defineTama�o();
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tama�o);
		matriz = tab.introducirBombas(n_bombas, tama�o);
		int aux = 0;
		for(int i=0;i<tama�o;i++) {
			for(int j = 0;j<tama�o;j++) {
			
				assertEquals(-1,matriz[i][j]);
				aux += matriz[i][j];
			
			}
		}
		assertEquals(n_bombas*-1,aux);
	}
	
	@Test
	public void testRandom() {
		//Testeamos la colocaci�n de bombas de forma aleatoria
		//utilizando el mock object Rand
		//El mock object coloca una bomba en la casilla [0][0]
		MockRand rand = new MockRand();
		int n_bombas=1;
		int tama�o=5;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tama�o);
		
		matriz = rand.introducirBomba(n_bombas, matriz, tama�o);
		//Solo la casilla [0][0] tiene bomba
		assertEquals(-1,matriz[0][0]);
		assertEquals(0,matriz[1][0]);
		assertEquals(0,matriz[2][0]);
		assertEquals(0,matriz[3][0]);
		assertEquals(0,matriz[4][0]);
		assertEquals(0,matriz[1][4]);
		assertEquals(0,matriz[2][4]);
		assertEquals(0,matriz[3][4]);
		assertEquals(0,matriz[4][4]);		
	}

	@Test
	public void testintroducirBombas() {
		//Aqui tendremos que testear al mock de random introducir bombas
		//Introducir todas las bombas posibles
		int n_bombas=25;
		int tama�o=5;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tama�o);
		
		matriz = tab.introducirBombas(n_bombas, tama�o);
		int aux=0;
		
		for(int i=0;i<tama�o;i++) {
			for(int j = 0;j<tama�o;j++) {
			
				assertEquals(-1,matriz[i][j]);
				aux += matriz[i][j];
			
			}
		}
		
		assertEquals(n_bombas*-1,aux);
		
		// Introducir 0 bombas
		
		int n_bombas2=10;
		int tama�o2=5;
		Tablero tab2 = new Tablero();
		int[][] matriz2 = tab2.inicializarTablero(tama�o2);
		
		matriz2 = tab2.introducirBombas(n_bombas2, tama�o2);
		int aux2=0;
		
		for(int i=0;i<tama�o2;i++) {
			for(int j = 0;j<tama�o2;j++) {
				aux2 += matriz2[i][j];
			}
		}
		
		assertEquals(-1*n_bombas2,aux2);
		
		// Introducir x bombas donde 0<x<N_MAX_BOMBAS
		
		int n_bombas3=15;
		int tama�o3=7;
		Tablero tab3 = new Tablero();
		int[][] matriz3 = tab3.inicializarTablero(tama�o3);
		
		matriz3 = tab3.introducirBombas(n_bombas3, tama�o3);
		int aux3=0;
		
		for(int i=0;i<tama�o3;i++) {
			for(int j = 0;j<tama�o3;j++) {
				aux3 += matriz3[i][j];
			}
		}
		
		assertEquals(-1*n_bombas3,aux3);
		
		// Introducir un n�mero de bombas negativo.
		
		int n_bombas4=-13;
		int tama�o4=7;
		Tablero tab4 = new Tablero();
		int[][] matriz4 = tab4.inicializarTablero(tama�o4);
				
		matriz4 = tab4.introducirBombas(n_bombas4, tama�o4);
		int aux4=0;
			
		for(int i=0;i<tama�o4;i++) {
			for(int j = 0;j<tama�o4;j++) {
				aux4 += matriz4[i][j];
			}
		}
		assertEquals(0,aux4);
				
	}
	
	@Test
	public void testpistas() {
		//Testeamos que no se colocan pistas si todo el tablero est� lleno de bombas.
		int n_bombas=25;
		int tama�o=5;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tama�o);
		matriz = tab.introducirBombas(n_bombas, tama�o);
		matriz = tab.pistas(matriz, tama�o);
		int id = -1;

		for(int i=0;i<tama�o;i++) {
			for(int j = 0;j<tama�o;j++) {
				if (matriz[i][j] >=0) {
					id = matriz[i][j];					
				}
				int n_b = 0;
				if (i == 0) {
					if(j==0) {
						
						if (matriz[i+1][j] == -1) {n_b++;};
						if (matriz[i+1][j+1] == -1) {n_b++;};
						if (matriz[i][j+1] == -1) {n_b++;};
						
						if (matriz[i][j] != -1) {
							assertEquals(n_b,id);
							
						}else {
							assertEquals(-1,id);
						}

					}else {if (j==tama�o-1) {
						
						if (matriz[i][j-1] == -1) {n_b++;};
						if (matriz[i+1][j-1] == -1) {n_b++;};
						if (matriz[i+1][j] == -1) {n_b++;};
						
						if (matriz[i][j] != -1) {
							assertEquals(n_b,id);
						}else {
							assertEquals(-1,id);
						}
					}else {
						//normales j=1,etc
						if (matriz[i][j-1] == -1) {n_b++;};
						if (matriz[i][j+1] == -1) {n_b++;};
						if (matriz[i+1][j-1] == -1) {n_b++;};
						if (matriz[i+1][j] == -1) {n_b++;};
						if (matriz[i+1][j+1] == -1) {n_b++;};
						
						if (matriz[i][j] != -1) {
							assertEquals(n_b,id);
						}else {
							assertEquals(-1,id);
						}
						
					}
						}
				}else {
					if(i==tama�o-1) {
						if(j==0) {
							
							if (matriz[i-1][j] == -1) {n_b++;};
							if (matriz[i-1][j+1] == -1) {n_b++;};
							if (matriz[i][j+1] == -1) {n_b++;};
							
							if (matriz[i][j] != -1) {
								assertEquals(n_b,id);
							}else {
								assertEquals(-1,id);
							}
							
						}else {if (j==tama�o-1) {
							
							if (matriz[i][j-1] == -1) {n_b++;};
							if (matriz[i-1][j-1] == -1) {n_b++;};
							if (matriz[i-1][j] == -1) {n_b++;};
							
							if (matriz[i][j] != -1) {
								assertEquals(n_b,id);
							}else {
								assertEquals(-1,id);
							}
						}else {
							//normales j=1,etc
							if (matriz[i][j-1] == -1) {n_b++;};
							if (matriz[i][j+1] == -1) {n_b++;};
							if (matriz[i-1][j-1] == -1) {n_b++;};
							if (matriz[i-1][j] == -1) {n_b++;};
							if (matriz[i-1][j+1] == -1) {n_b++;};
							
							if (matriz[i][j] != -1) {
								assertEquals(n_b,id);
							}else {
								assertEquals(-1,id);
							}
						}
					}
				}else {
					if(j==0) {
						
						if (matriz[i-1][j] == -1) {n_b++;};
						if (matriz[i+1][j] == -1) {n_b++;};
						if (matriz[i-1][j+1] == -1) {n_b++;};
						if (matriz[i][j+1] == -1) {n_b++;};
						if (matriz[i+1][j+1] == -1) {n_b++;};
						if (matriz[i][j] != -1) {
							assertEquals(n_b,id);
						}else {
							assertEquals(-1,id);
						}
						
					}else {if (j==tama�o-1) {
						
						if (matriz[i-1][j] == -1) {n_b++;};
						if (matriz[i+1][j] == -1) {n_b++;};
						if (matriz[i-1][j-1] == -1) {n_b++;};
						if (matriz[i][j-1] == -1) {n_b++;};
						if (matriz[i+1][j-1] == -1) {n_b++;};
						if (matriz[i][j] != -1) {
							assertEquals(n_b,id);
						}else {
							assertEquals(-1,id);
						}
					}else {
						//normales j=1,etc
						if (matriz[i-1][j-1] == -1) {n_b++;};
						if (matriz[i-1][j] == -1) {n_b++;};
						if (matriz[i-1][j+1] == -1) {n_b++;};
						if (matriz[i][j-1] == -1) {n_b++;};
						if (matriz[i][j+1] == -1) {n_b++;};
						if (matriz[i+1][j-1] == -1) {n_b++;};
						if (matriz[i+1][j] == -1) {n_b++;};
						if (matriz[i+1][j+1] == -1) {n_b++;};
						
						
						if (matriz[i][j] != -1) {
							assertEquals(n_b,id);
						}else {
							assertEquals(-1,id);
						}
					}
				}
				
			}
		}
		
	}
	}
		
	//Test de colocar pistas sin bombas en el tablero
	int n_bombas4=0;
	int tama�o4=5;
	Tablero tab4 = new Tablero();
	int[][] matriz4 = tab4.inicializarTablero(tama�o4);
	matriz4 = tab4.introducirBombas(n_bombas4, tama�o4);
	matriz4 = tab4.pistas(matriz4, tama�o4);
	int id4 = -1;

	for(int i=0;i<tama�o4;i++) {
		for(int j = 0;j<tama�o4;j++) {
			if (matriz4[i][j] >=0) {
				id4 = matriz[i][j];					
			}
			int n_b4 = -1;
			if (i == 0) {
				if(j==0) {
						
					if (matriz4[i+1][j] == -1) {n_b4++;};
					if (matriz4[i+1][j+1] == -1) {n_b4++;};
					if (matriz4[i][j+1] == -1) {n_b4++;};
					
					if (matriz4[i][j] != -1) {
						assertEquals(n_b4,id4);
						
					}else {
						assertEquals(-1,id4);
					}

					}else {if (j==tama�o4-1) {
						
					if (matriz4[i][j-1] == -1) {n_b4++;};
					if (matriz4[i+1][j-1] == -1) {n_b4++;};
					if (matriz4[i+1][j] == -1) {n_b4++;};
					
					if (matriz4[i][j] != -1) {
						assertEquals(n_b4,id4);
					}else {
						assertEquals(-1,id4);
					}
				}else {
					//normales j=1,etc
					if (matriz4[i][j-1] == -1) {n_b4++;};
					if (matriz4[i][j+1] == -1) {n_b4++;};
					if (matriz4[i+1][j-1] == -1) {n_b4++;};
					if (matriz4[i+1][j] == -1) {n_b4++;};
					if (matriz4[i+1][j+1] == -1) {n_b4++;};
					
					if (matriz4[i][j] != -1) {
						assertEquals(n_b4,id4);
					}else {
						assertEquals(-1,id4);
					}
						
				}
					}
			}else {
				if(i==tama�o4-1) {
					if(j==0) {
							
						if (matriz4[i-1][j] == -1) {n_b4++;};
						if (matriz4[i-1][j+1] == -1) {n_b4++;};
						if (matriz4[i][j+1] == -1) {n_b4++;};
							
						if (matriz4[i][j] != -1) {
							assertEquals(n_b4,id4);
						}else {
							assertEquals(-1,id4);
						}
						
						}else {if (j==tama�o4-1) {
							
						if (matriz4[i][j-1] == -1) {n_b4++;};
						if (matriz4[i-1][j-1] == -1) {n_b4++;};
						if (matriz4[i-1][j] == -1) {n_b4++;};
						
						if (matriz[i][j] != -1) {
							assertEquals(n_b4,id4);
						}else {
							assertEquals(-1,id4);
						}
					}else {
						//normales j=1,etc
						if (matriz4[i][j-1] == -1) {n_b4++;};
						if (matriz4[i][j+1] == -1) {n_b4++;};
						if (matriz4[i-1][j-1] == -1) {n_b4++;};
						if (matriz4[i-1][j] == -1) {n_b4++;};
						if (matriz4[i-1][j+1] == -1) {n_b4++;};
						
						if (matriz4[i][j] != -1) {
							assertEquals(n_b4,id4);
						}else {
							assertEquals(-1,id4);
						}
					}
				}
			}else {
				if(j==0) {
						
					if (matriz4[i-1][j] == -1) {n_b4++;};
					if (matriz4[i+1][j] == -1) {n_b4++;};
					if (matriz4[i-1][j+1] == -1) {n_b4++;};
					if (matriz4[i][j+1] == -1) {n_b4++;};
					if (matriz4[i+1][j+1] == -1) {n_b4++;};
					if (matriz4[i][j] != -1) {
						assertEquals(n_b4,id4);
					}else {
						assertEquals(-1,id4);
					}
					
				}else {if (j==tama�o4-1) {
						
					if (matriz4[i-1][j] == -1) {n_b4++;};
					if (matriz4[i+1][j] == -1) {n_b4++;};
					if (matriz4[i-1][j-1] == -1) {n_b4++;};
					if (matriz4[i][j-1] == -1) {n_b4++;};
					if (matriz4[i+1][j-1] == -1) {n_b4++;};
					if (matriz4[i][j] != -1) {
						assertEquals(n_b4,id4);
					}else {
						assertEquals(-1,id4);
					}
				}else {
					//normales j=1,etc
					if (matriz4[i-1][j-1] == -1) {n_b4++;};
					if (matriz4[i-1][j] == -1) {n_b4++;};
					if (matriz4[i-1][j+1] == -1) {n_b4++;};
					if (matriz4[i][j-1] == -1) {n_b4++;};
					if (matriz4[i][j+1] == -1) {n_b4++;};
					if (matriz4[i+1][j-1] == -1) {n_b4++;};
					if (matriz4[i+1][j] == -1) {n_b4++;};
					if (matriz4[i+1][j+1] == -1) {n_b4++;};
						
						
					if (matriz4[i][j] != -1) {
						assertEquals(n_b4,id4);
					}else {
						assertEquals(-1,id4);
					}
				}
			}
				
		}
	}
		
	}
	}
		
	//A continuacion realizamos varios test cases para forzar bombas
	//en distintos lugares para completar el decision y condition coverage
	int n_bombas2=0;
	int tama�o2=5;
	Tablero tab2 = new Tablero();
	int[][] matriz2 = tab2.inicializarTablero(tama�o2);
	matriz2 = tab2.introducirBombas(n_bombas2, tama�o2);
	matriz2[0][0]=-1;
	matriz2[1][0]=-1;
	matriz2[1][1]=-1;
	
	matriz2[0][4]=0;
	matriz2[0][3]=0;
	
	
	matriz2[4][0]=-1;
	matriz2[4][1]=-1;
	
	matriz2[3][4]=-1;
	matriz2[3][3]=-1;

	matriz2 = tab2.pistas(matriz2, tama�o2);
	
	assertEquals(-1,matriz2[0][0]);
	assertEquals(-1,matriz2[1][0]);
	assertEquals(-1,matriz2[1][1]);
	assertEquals(3,matriz2[0][1]);
	
	assertEquals(0,matriz2[0][4]);
	assertEquals(0,matriz2[0][3]);
	assertEquals(0,matriz2[1][4]);
	
	assertEquals(-1,matriz2[4][0]);
	assertEquals(-1,matriz2[4][1]);
	assertEquals(2,matriz2[3][0]);
	
	assertEquals(-1,matriz2[3][4]);
	assertEquals(-1,matriz2[3][3]);
	assertEquals(2,matriz2[4][4]);
	
	//Test case 3, para forzar bombas en ciertas posiciones
	int n_bombas3=0;
	int tama�o3=5;
	Tablero tab3 = new Tablero();
	int[][] matriz3 = tab3.inicializarTablero(tama�o3);
	matriz3 = tab3.introducirBombas(n_bombas3, tama�o3);
	
	matriz3[0][4]=-1;
	matriz3[0][3] = -1;
	
	matriz3[0][0]=-1;
	matriz3[1][1]=-1;
	
	matriz3[4][0]=0;
	matriz3[4][1]=0;
	
	
	matriz3[4][4]=-1;
	matriz3[4][3]=-1;
	matriz3[3][3]=-1;
	matriz3[3][4]=-1;
	
	matriz3 = tab3.pistas(matriz3, tama�o3);
	//Comprobamos que las pistas (y las bombas) se han colocado adecuadamente
	assertEquals(-1,matriz3[0][4]);
	assertEquals(-1,matriz3[0][3]);
	assertEquals(2,matriz3[1][4]);
	
	assertEquals(-1,matriz3[0][0]);
	assertEquals(-1,matriz3[1][1]);
	assertEquals(2,matriz3[1][0]);
	
	assertEquals(0,matriz3[4][0]);
	assertEquals(0,matriz3[4][1]);
	assertEquals(0,matriz3[3][0]);
	
	assertEquals(-1,matriz3[4][4]);
	assertEquals(-1,matriz3[4][3]);
	assertEquals(-1,matriz3[3][3]);
	assertEquals(-1,matriz3[3][4]);
	assertEquals(2,matriz3[2][4]);
	assertEquals(2,matriz3[4][2]);

	
	//Test case 5, forzando valores para completar el coverage.
	int n_bombas5=0;
	int tama�o5=5;
	Tablero tab5 = new Tablero();
	int[][] matriz5 = tab5.inicializarTablero(tama�o5);
	matriz5 = tab5.introducirBombas(n_bombas5, tama�o5);
		
	matriz5[4][4]=0;
	matriz5[4][3]=0;
	matriz5[3][3]=0;
	
	matriz5[4][1]=0;
	matriz5[4][0]=0;
	
	matriz5[0][4]=-1;
	matriz5[0][3]=-1;
	
	matriz5 = tab5.pistas(matriz5, tama�o5);
	
	assertEquals(0,matriz5[4][4]);
	assertEquals(0,matriz5[4][3]);
	assertEquals(0,matriz5[3][4]);
	assertEquals(0,matriz5[3][3]);

	
	assertEquals(0,matriz5[4][0]);
	assertEquals(0,matriz5[4][1]);
	assertEquals(0,matriz5[3][0]);
	
	assertEquals(-1,matriz5[0][4]);
	assertEquals(-1,matriz5[0][3]);
	assertEquals(2,matriz5[1][4]);
	

	//Test case 6, forzando valores para completar el coverage.
	int n_bombas6=0;
	int tama�o6=5;
	Tablero tab6 = new Tablero();
	int[][] matriz6 = tab5.inicializarTablero(tama�o6);
	matriz5 = tab6.introducirBombas(n_bombas6, tama�o6);
		
	matriz6[4][4]=0;
	matriz6[4][3]=0;
	matriz6[3][3]=0;
	
	matriz6[0][0]=-1;
	matriz6[1][1]=-1;
	
	matriz6[4][1]=0;
	matriz6[4][0]=0;
	
	matriz6[0][4]=-1;
	matriz6[0][3]=-1;
	
	matriz6 = tab6.pistas(matriz6, tama�o6);
	
	assertEquals(0,matriz6[4][4]);
	assertEquals(0,matriz6[4][3]);
	assertEquals(0,matriz6[3][4]);
	assertEquals(0,matriz6[3][3]);

	assertEquals(-1,matriz6[0][0]);
	assertEquals(2,matriz6[0][1]);
	
	assertEquals(0,matriz6[4][0]);
	assertEquals(0,matriz6[4][1]);
	assertEquals(0,matriz6[3][0]);
	
	assertEquals(-1,matriz6[0][4]);
	assertEquals(-1,matriz6[0][3]);
	assertEquals(2,matriz6[1][4]);
	
	
	
	}
	
	//Looptesting
	//Se testea el loop "while" de introducir bombas, de la clase Rand()
	@Test
	public void Looptesting() {
		//El bucle no se ejecuta ninguna vez. n_bomba = 0.
		int n_bombas=0;
		int tama�o=5;
		Tablero tab = new Tablero();
		int[][] matriz = tab.inicializarTablero(tama�o);
		
		matriz = tab.introducirBombas(n_bombas, tama�o);
		int aux =  0;
		for (int i=0;i<tama�o;i++) {
			for(int j=0;j<tama�o;j++) {
				aux += matriz[i][j];
			}
		}
		assertEquals(0,aux);
		
		//El bucle se ejecuta una vez. n_bomba=1
		int n_bombas2=1;
		int tama�o2=5;
		Tablero tab2 = new Tablero();
		int[][] matriz2 = tab2.inicializarTablero(tama�o2);
		
		matriz2 = tab2.introducirBombas(n_bombas2, tama�o2);
		int aux2 =  0;
		for (int i=0;i<tama�o2;i++) {
			for(int j=0;j<tama�o2;j++) {
				aux2 += matriz2[i][j];
			}
		}
		assertEquals(-1,aux2);
		
		//El bucle se ejecuta dos veces. n_bomba=2
		int n_bombas3=2;
		int tama�o3=5;
		Tablero tab3 = new Tablero();
		int[][] matriz3 = tab3.inicializarTablero(tama�o3);
				
		matriz3 = tab3.introducirBombas(n_bombas3, tama�o3);
		int aux3 =  0;
		for (int i=0;i<tama�o3;i++) {
			for(int j=0;j<tama�o3;j++) {
				aux3 += matriz3[i][j];
			}
		}
		assertEquals(-2,aux3);
		
		//El bucle se ejecuta m=5 veces, donde 2<m=5<MAX_BOMBAS-1. n_bomba=5
		//MAX_BOMBAS = tama�o*tama�o
		int n_bombas4=5;
		int tama�o4=5;
		Tablero tab4 = new Tablero();
		int[][] matriz4 = tab4.inicializarTablero(tama�o4);
						
		matriz4 = tab4.introducirBombas(n_bombas4, tama�o4);
		int aux4 =  0;
		for (int i=0;i<tama�o4;i++) {
			for(int j=0;j<tama�o4;j++) {
				aux4 += matriz4[i][j];
			}
		}
		assertEquals(-5,aux4);
		
		//El bucle se ejecuta m=5 veces, donde 2<m=5<MAX_BOMBAS-1. n_bomba=5
		//MAX_BOMBAS = tama�o*tama�o
		int n_bombas5=5;
		int tama�o5=5;
		Tablero tab5 = new Tablero();
		int[][] matriz5 = tab5.inicializarTablero(tama�o5);
								
		matriz5 = tab5.introducirBombas(n_bombas5, tama�o5);
		int aux5 =  0;
		for (int i=0;i<tama�o5;i++) {
			for(int j=0;j<tama�o5;j++) {
				aux5 += matriz5[i][j];
			}
		}
		assertEquals(-5,aux5);
		
		//El bucle se ejecuta MAX-1 veces, n_bomba=tama�o*tama�o-1
		//MAX_BOMBAS = tama�o*tama�o
		int n_bombas6=24;
		int tama�o6=5;
		Tablero tab6 = new Tablero();
		int[][] matriz6 = tab6.inicializarTablero(tama�o6);
										
		matriz6 = tab6.introducirBombas(n_bombas6, tama�o6);
		int aux6 =  0;
		for (int i=0;i<tama�o6;i++) {
			for(int j=0;j<tama�o6;j++) {
				aux6 += matriz6[i][j];
			}
		}
		assertEquals(-24,aux6);
		
		//El bucle se ejecuta MAX veces, n_bomba=tama�o*tama�o
		int n_bombas7=25;
		int tama�o7=5;
		Tablero tab7 = new Tablero();
		int[][] matriz7 = tab7.inicializarTablero(tama�o7);
												
		matriz7 = tab7.introducirBombas(n_bombas7, tama�o7);
		int aux7 =  0;
		for (int i=0;i<tama�o7;i++) {
			for(int j=0;j<tama�o7;j++) {
				aux7 += matriz7[i][j];
			}
		}
		assertEquals(-25,aux7);			
	}
	
}

	

	

