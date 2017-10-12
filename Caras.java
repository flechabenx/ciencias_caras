import java.util.Scanner;

public class Caras {
	
    static int[][] matriz;
    static int columnas;
    static int filas;
    static int caras;
    static int carasSuperiores;
    static int carasColindantes;

    public static void main(String[] args) {
        leerValores();   
        caras = 5;
        carasSuperiores();
        carasColindantes();
        int totales = caras+carasSuperiores+carasColindantes;
        System.out.println("Caras Totales: "+totales);
    }
    
    public static void leerValores(){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de columnas");
        columnas = s.nextInt();
        System.out.println("Ingrese la cantidad de filas");
        filas = s.nextInt();
        matriz = new int[filas][columnas];
        for(int f=0;f<filas;f++){
            for(int c=0;c<columnas;c++){			
                System.out.println("Escriba el valor de la posicion: ["+(f+1)+"]["+(c+1)+"]");
                matriz[f][c] = s.nextInt(); 
            }
        }
        for(int f=0;f<filas;f++){
            for(int c=0;c<columnas;c++){		
                System.out.print(matriz[f][c]+"\t");
            }
            System.out.println("\n");
        }
    }
    
    public static void carasColindantes(){
    	carasColindantes = 0;
    	for(int f=0;f<filas;f++){
            for(int c=0;c+1<columnas;c++){	
                if(matriz[f][c] != matriz[f][c+1]){
                    carasColindantes++;
                }
            }
        }
    	
    	for(int c=0;c<columnas;c++){
    		for(int f=0;f+1<filas;f++){
    			if(matriz[f][c] != matriz[f+1][c]){
    				carasColindantes++;
    			}
    		}
    	}
    	System.out.println("Caras Colindantes: "+carasColindantes);
    }
    
    public static void carasSuperiores(){
        compararValoresFila();
        compararValoresColumna();
        System.out.println("Caras Superiores: "+carasSuperiores);
    }
    
    public static void compararValoresFila(){
    	//Comparar valores de una fila
        carasSuperiores = 0;
        for(int f=0;f<filas;f++){
            carasSuperiores++;
            for(int c=0;c+1<columnas;c++){	
                if(matriz[f][c] != matriz[f][c+1]){
                    carasSuperiores++;
                }
            }
        }
    }
    
    public static void compararValoresColumna(){
        //Comparar valores de una columna entre 2 filas
    	//int cont=0; para que es esto??
        for(int f=0;f+1<filas;f++){
            for(int c=0;c<columnas;c++){
                //5cont++;
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
    }
}