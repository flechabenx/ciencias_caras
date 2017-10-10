import java.util.Scanner;

public class Caras {
	
	static int[][] matriz;
	static int columnas;
	static int filas;
	static int caras;
	static int carasSuperiores;
	static int carasColindantes;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de columnas");
		columnas = s.nextInt();
		System.out.println("Ingrese la cantidad de filas");
		filas = s.nextInt();
		matriz = new int[filas][columnas];
		for(int f=0;f<filas;f++){
			for(int c=0;c<columnas;c++){			
				System.out.println("Escriba el valor de la posicion: ["+f+"]["+c+"]");
				matriz[f][c] = s.nextInt(); 
			}
		}
		for(int f=0;f<filas;f++){
			for(int c=0;c<columnas;c++){
			
				System.out.print(matriz[f][c]+"\t");
				
			}
			System.out.println("\n");
		}
		//caras = 5;
		carasSuperiores();
		//System.out.println("Caras Totales: "+caras);
	}
	
	public void carasColindantes(){

	}
	
	public static void carasSuperiores(){
		carasSuperiores = 0;
		for(int f=0;f<filas;f++){
			carasSuperiores++;
			for(int c=0;c+1<columnas;c++){	
				if(matriz[f][c] != matriz[f][c+1]){
					carasSuperiores++;
				}
			}
		}
		int cont=0;
		for(int f=0;f+1<filas;f++){
			for(int c=0;c<columnas;c++){
				cont++;
				if(matriz[f][c] == matriz[f+1][c]){
					int numeroRepetido = matriz[f][c];
					for(int i=c+1;i<columnas;i++){
						if((matriz[f][i] == numeroRepetido) && (matriz[f][i] == matriz[f+1][i])){
							c++;
						}else{
							break;
						}
						//Para que esta columna ya no sea contada, ya que se repiten los numeros
					}
					carasSuperiores--;
				}
			}
		}
		System.out.println("Caras Superiores: "+carasSuperiores);
	}
}
