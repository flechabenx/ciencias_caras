import java.util.Scanner;

public class Caras {
	
    static int[][] matriz;
    static int columnas;
    static int filas;
    static int caras;
    static int carasSuperiores;
    static int carasColindantes;
    static int[][] rotMatriz;
    static int rotFilas;
    static int rotColumnas;

    public static void main(String[] args) {
        leerValores();//Entrada  
        caras = 5;
        carasSuperiores();//Procesos
        calculoCarasColindantes();
        carasTotales();//Salida
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
        for(int f=0;f<filas;f++){ //confirmacion visual de la matriz
            for(int c=0;c<columnas;c++){		
                System.out.print(matriz[f][c]+"\t");
            }
            System.out.println("\n");
        }
    }
    public static void calculoCarasColindantes(){
        carasColindantes=0;
        for (int i = 1; i<=4 ; i++){
            rotarMatriz(i);
            carasColindantes();
        }
        System.out.println("Caras colindantes: "+carasColindantes);
    }
    public static void carasColindantes(){
        for (int c=0;c<rotColumnas;c++){
            for (int f=0;f<rotFilas;f++){
                if (f==0){
                    //No hacer nada, ya que este valor no tiene para comparar.
                }else{
                    if(rotMatriz[f][c]>rotMatriz[f-1][c]){
                        if (c==0){
                            carasColindantes++;
                        }else{
                            int min = minimo(rotMatriz[f][c],rotMatriz[f][c-1]);
                            int max = maximo(rotMatriz[f-1][c],rotMatriz[f-1][c-1]);
                            if (!(min>max)){
                                carasColindantes++;
                            }
                        }
                    }
                    
                }
            }
        }
        
    }
    //Para verificar que se roto la matriz
    public static void printRotM(){
        for(int f=0;f<rotFilas;f++){
            for(int c=0;c<rotColumnas;c++){		
                System.out.print(rotMatriz[f][c]+"\t");
            }
            System.out.println("\n");
        }
    }
    public static void rotarMatriz(int etapa){
        switch (etapa){
            case 1: // 0 grados
                rotFilas = filas;
                rotColumnas = columnas;
                rotMatriz = matriz;
                break;
            case 2: //90 grados
                rotFilas = columnas;
                rotColumnas = filas;
                rotMatriz = new int[rotFilas][rotColumnas];
                for (int f = 0; f<rotFilas;f++){
                    for (int c = 0; c<rotColumnas ; c++){
                        rotMatriz[f][c] = matriz[c][rotFilas-1-f];
                    }
                }
                break;
            case 3: //180 grados
                rotFilas = filas;
                rotColumnas = columnas;
                rotMatriz = new int[rotFilas][rotColumnas];
                for (int f = 0; f<rotFilas ; f++){
                    for (int c=0; c<rotColumnas; c++){
                        rotMatriz[f][c] = matriz[rotFilas-1-f][rotColumnas-1-c];
                    }
                }
                break;
            case 4: //270 grados
                rotFilas = columnas;
                rotColumnas = filas;
                rotMatriz = new int[rotFilas][rotColumnas];
                for (int f = 0; f<rotFilas;f++){
                    for (int c = 0; c<rotColumnas ; c++){
                        rotMatriz[f][c] = matriz[rotColumnas-1-c][f];
                    }
                }
                break;
        }
    }
    
    public static int minimo(int a, int b){
            if (a<b){
                return a;
            } else {
                return b;
            }
    }
    public static int maximo(int a, int b){
        if (a<b){
            return b;
        }else{
            return a;
        }
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
        //comparar valores de una columna entre 2 filas
        for(int f=0;f+1<filas;f++){
            for(int c=0;c<columnas;c++){
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
    public static void carasTotales(){
        System.out.println(caras+carasSuperiores+carasColindantes);
    }
}
