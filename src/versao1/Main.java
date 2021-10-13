package versao1;
import java.util.Scanner;

class Main {
private static Scanner sc = new Scanner(System.in);
	static long[] vetor;
	static long[]vetorMb;
	static long[]vetorT;
	
	static long[][] matriz;
	static long[][] matrizMb;
	static long[][] matrizT;
	
	static long memoria= 0;
	static long count = 0;
	static long tempo = 0;
	
	public static void main(String[] args) {
		System.out.println("type");
		while (true) {
			int input = sc.nextInt();
			if (input == 0) {
				comando0(100);
			} else if (input == 1) {
				comando1(1000);
				comando1(3000);
				comando1(5000);
				break;
			} else if (input == 2) {
				comando2();
				break;
			}
		}
	}

	public static void comando2() {

		System.out.println("FINALIZADO");

	}

	public static void comando1(int length) {
		vetor = new long[5];
		matriz = new long[5][10];
		vetorMb = new long[5];
		matrizMb = new long[5][10];
		vetorT = new long[5];
		matrizT = new long[5][10];
		System.out.println(media(1, 0, 1, length));

	}

	public static void comando0(int length) {
		vetor = new long[5];
		matriz = new long[5][10];
		vetorMb = new long[5];
		matrizMb = new long[5][10];
		vetorT = new long[5];
		matrizT = new long[5][10];
		
		for (int c = 0; c < matriz[0].length; c++) {
			media(1, 0, 0, length);

			for (int l = 0; l < matriz.length; l++) {

				matriz[l][c] = vetor[l];
				matrizMb[l][c] = vetorMb[l];
				matrizT[l][c] = vetorT[l];
			}
		}
		
		System.out.println("Count ");
		for (int l = 0; l < matriz.length; l++) {

			for (int c = 0; c < matriz[0].length; c++) {

				System.out.print(matriz[l][c] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("  ");
		System.out.println(" Memory ");
		for (int l = 0; l < matrizMb.length; l++) {

			for (int c = 0; c < matrizMb[0].length; c++) {

				System.out.print(matrizMb[l][c] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println("  ");
		
		System.out.println("  ");
		System.out.println(" Time ");
		for (int l = 0; l < matrizT.length; l++) {

			for (int c = 0; c < matrizT[0].length; c++) {

				System.out.print(matrizT[l][c] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println("  ");
	}

	public static long media(int loop, int v, int comando, int length) {
		long soma = 0;
		long somaMb=0;
		long somaTime=0;
		long media = 0;
		long mediaMb=0;
		long mediaTime=0;
        
		if (comando == 0) {
			for (int i = 0; i < loop; i++) {
				gerarVetor(comando, length);
				soma = soma + count;
                somaMb = somaMb + memoria;
                somaTime= somaTime + tempo;
			}
		} else if (comando == 1) {
			gerarVetor(comando, length);
			return count;
		}

		media = soma / loop;
        mediaMb = somaMb / loop;
        mediaTime = somaTime / loop;
        
		vetor[v] = media;
        vetorMb[v]=mediaMb;
        vetorT[v] = mediaTime;
        
		if (loop == 10000) {
			return media;
		}

		return media(loop * 10, v + 1, comando, length);
	}

	public static void gerarVetor(int comando, int length) {

		int[] v = new int[length];

		if (comando == 0) {

			for (int i = 0; i < v.length; i++) {

				v[i] = (int) (Math.random() * length);

			}
		} else if (comando == 1) {

			for (int i = 0; i < v.length; i++) {

				v[i] = sc.nextInt();

			}
		}
		tempo = 0;
		memoria = 0;
		count = 0;
	
		Runtime run = Runtime.getRuntime();
		long TI = System.nanoTime();
		 
		bubbleSort(v);
		
		memoria =run.totalMemory() - run.freeMemory();
		long TF = System.nanoTime();
        tempo = TF - TI;
	}

	public static int[] bubbleSort(int[] arr) {
		count++;
		int n = arr.length;
		int temp = 0;
		boolean swap ;
		for (int i = 0; i < (n-1); i++) {
			swap =false;
			count++;
			for (int j = 0; j < (n -i- 1); j++) {
				count++;
				if (arr[j] > arr[j+1]) {
					count++;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
					swap =true;
				}
			}
			
			
			if(swap !=true) {
				count++;
				break;
			}
		}
		
		return arr;
	}
}