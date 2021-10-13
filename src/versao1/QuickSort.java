package versao1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	private static Scanner sc = new Scanner(System.in);
	private static Random random = new Random();
	private static Long contadorOrdenacao = 0l;
	private static final int QTD_EXPERIMENTOS = 10;
	private static final int VETOR_TAMANHO_MAXIMO = 2000;
	private static final int PRIMEIRA_PASSAGEM = 1;
	private static int qtdBuscasSequenciais = 0;
	private static Long tempoTotal = 0l;
	private static Long memoriaTotal = 0l;
	private static Runtime runtime = Runtime.getRuntime();
	private static int[] vetor;
	private static Long resultadoSomaContadoresOrdenacao = 0l;
	private static Long resultadoMediaOrdenacao;
	private static ArrayList<Long> listaResultadosOrdenacao = new ArrayList<>();
	private static ArrayList<Long> listaResultadosBusca = new ArrayList<>();
	private static ArrayList<Long> listaResultadosTempoExecucao = new ArrayList<>();
	private static ArrayList<Long> listaResultadosMemoriaUtilizada = new ArrayList<>();


	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		while (true) {
			sc = new Scanner(System.in);
			int escolha = sc.nextInt();
			switch (escolha) {
			case 0:
				iniciarComando0();
				imprimirResultadoSimplificadoOrdenacao();
				System.out.println(
						"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				imprimirResultadoSimplificadoTempoExecucao();
				System.out.println(
						"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				imprimirResultadoSimplificadoMemoriaUtilizada();
				System.out.println(
						"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
				resetarValores();
				break;
			case 1:
				iniciarComando1();
				resetarValores();
				sc.close();
				System.exit(0);
				break;
			case 2:
				sc.close();
				System.out.println("Finalizado.");
				System.exit(0);
				break;
			default:
				System.err.println("Comando Inválido. Digite um comando válido:");
				continue;
			}
		}
	}

	private static void iniciarComando0() {
		for (int i = PRIMEIRA_PASSAGEM; i <= QTD_EXPERIMENTOS; i++) {
			System.out.println("\t\t\t\t\t\t\t\t" + i + "º Experimento utilizando \"QuickSort\" (Vetor com tamanho = "+ VETOR_TAMANHO_MAXIMO +"):\n");
			iniciarBuscaBinariaComando0(1, i);
			iniciarBuscaBinariaComando0(10, i);
			iniciarBuscaBinariaComando0(100, i);
			iniciarBuscaBinariaComando0(1000, i);
			iniciarBuscaBinariaComando0(10000, i);
			System.out.println(
					"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		}
	}

	private static void iniciarComando1() {
		iniciarBuscaBinariaComando1(1);
	}

	private static void iniciarBuscaBinariaComando0(int qtdElementosMedia, int indiceInicial) {
		resultadoSomaContadoresOrdenacao = 0l;
		resultadoMediaOrdenacao = 0l;

		if (indiceInicial == PRIMEIRA_PASSAGEM) {
			qtdBuscasSequenciais++;
		}

		int elementoAtual = 0;
		Long tempoInicial = System.nanoTime();
		Long tempoFinal;
		tempoTotal = 0l;

		Long memoriaLivre = runtime.freeMemory();
		Long memoriaAlocada;
		memoriaTotal = 0l;
		long[] contadores = new long[qtdElementosMedia];
		while (elementoAtual < qtdElementosMedia) {
			vetor = new int[VETOR_TAMANHO_MAXIMO];
			preencherVetorComando0();
			Integer superior = vetor.length - 1;
			Integer inferior = 0;
			ordenarQuickSort(vetor, inferior, superior);
			tempoFinal = System.nanoTime();
			tempoTotal = tempoFinal - tempoInicial;
			memoriaAlocada = runtime.totalMemory();
			memoriaTotal = memoriaAlocada - memoriaLivre;
			contadores[elementoAtual] = contadorOrdenacao;

			elementoAtual++;
			contadorOrdenacao = 0l;
		}
		resultadoMediaOrdenacao = calcularMediaOrdenacao(contadores, qtdElementosMedia);

		imprimirResultadoMediaOrdenacao(qtdElementosMedia);
		listaResultadosOrdenacao.add(resultadoMediaOrdenacao);
		listaResultadosTempoExecucao.add(tempoTotal);
		listaResultadosMemoriaUtilizada.add(memoriaTotal);
		resultadoSomaContadoresOrdenacao = 0l;
		resultadoMediaOrdenacao = 0l;
	}

	private static void iniciarBuscaBinariaComando1(int qtdElementosMedia) {
		resultadoSomaContadoresOrdenacao = 0l;
		resultadoMediaOrdenacao = 0l;

		if (qtdElementosMedia == 1) {
			while (true) {
				try {
					sc = new Scanner(System.in);
				} catch (Exception e) {
					System.err.println("Causa do erro: " + e.getMessage() + ". Digite novamente o valor de \"x\":");
					continue;
				}

				break;
			}
			vetor = new int[VETOR_TAMANHO_MAXIMO];
			preencherVetorComando1();
			Integer inferior = 0;
			Integer superior = vetor.length - 1;
			ordenarQuickSort(vetor, inferior, superior);

			resultadoSomaContadoresOrdenacao = contadorOrdenacao;
			contadorOrdenacao = 0l;
		} else {
			int elementoAtual = 0;
			vetor = new int[VETOR_TAMANHO_MAXIMO];
			preencherVetorComando1();
			Integer inferior = 0;
			Integer superior = vetor.length - 1;
			ordenarQuickSort(vetor, inferior, superior);
			while (elementoAtual < qtdElementosMedia) {
				while (true) {
					sc = new Scanner(System.in);
					try {
					} catch (Exception e) {
						System.err.println("Causa do erro: " + e.getMessage() + ". Digite novamente o valor de \"x\":");
						continue;
					}
					break;
				}
				resultadoSomaContadoresOrdenacao += contadorOrdenacao;
				contadorOrdenacao = 0l;
				elementoAtual++;
			}
		}

//		resultadoMediaOrdenacao = calcularMediaOrdenacao(qtdElementosMedia);
		imprimirResultadoMediaOrdenacao(qtdElementosMedia);
		listaResultadosOrdenacao.add(resultadoMediaOrdenacao);
	}

	private static int aleatorizarNumero() {
		int numeroAleatorio = random.nextInt(VETOR_TAMANHO_MAXIMO);
		return numeroAleatorio;
	}

	private static void preencherVetorComando0() {

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = aleatorizarNumero();
		}
	}

	private static void preencherVetorComando1() {
		for (int i = 0; i < vetor.length; i++) {
			while (true) {
				sc = new Scanner(System.in);
				try {
					int novoValor = sc.nextInt();
					vetor[i] = novoValor;
				} catch (Exception e) {
					System.err.println("Causa do erro: " + e.getMessage() + ". Digite novamente o elemento do vetor:");
					continue;
				}
				break;
			}
		}
	}

	private static void ordenarQuickSort(int[] vetor, int inferior, int superior) {
		contadorOrdenacao++;
		if (inferior < superior) {
			contadorOrdenacao++;
			int posicaoPivo = trocarElementos(vetor, inferior, superior);
			ordenarQuickSort(vetor, inferior, posicaoPivo - 1);
			ordenarQuickSort(vetor, posicaoPivo + 1, superior);
		}

	}

	public static int trocarElementos(int[] vetor, int esquerda, int direita) {
		contadorOrdenacao++;
		int pivot = vetor[direita];
		int i = (esquerda - 1);

		for (int j = esquerda; j < direita; j++) {
			contadorOrdenacao++;
			if (vetor[j] <= pivot) {
				contadorOrdenacao++;
				i++;

				int swapTemp = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = swapTemp;
			}
		}

		int swapTemp = vetor[i + 1];
		vetor[i + 1] = vetor[direita];
		vetor[direita] = swapTemp;

		return i + 1;
	}

	private static Long calcularMediaOrdenacao(long[] contadores, int qtdElementosMedia) {
		long var = 0;
		for (int i = 0; i < contadores.length; i++) {
			var += contadores[i];
		}
		return var / qtdElementosMedia;
	}

//	private static Long calcularMediaOrdenacao(long[] contadores, int qtdElementosMedia) {
//		return (resultadoSomaContadoresOrdenacao / qtdElementosMedia);
//	}

	private static void imprimirResultadoMediaOrdenacao(int qtdElementosMedia) {
		if (qtdElementosMedia == 1) {
			System.out.println(" A média entre " + qtdElementosMedia + "\trepetição  da ordenação calculada foi: "
					+ resultadoMediaOrdenacao + "\t(Tempo total de execução = " + tempoTotal
					+ " nanos segundos   |\t Memória utilizada para execução = " + memoriaTotal + " Bytes)");
		} else {
			System.out.println(" A média entre " + qtdElementosMedia + "\trepetições da ordenação calculada foi: "
					+ resultadoMediaOrdenacao + "\t(Tempo total de execução = " + tempoTotal
					+ " nanos segundos   |\t Memória utilizada para execução = " + memoriaTotal + " Bytes)");
		}

	}

	private static void imprimirResultadoSimplificadoOrdenacao() {
		int m[][] = new int[QTD_EXPERIMENTOS][qtdBuscasSequenciais];
		int linha = 0;
		int coluna = 0;
		for (int i = 0; i < listaResultadosOrdenacao.size(); i++) {
			if (coluna == qtdBuscasSequenciais) {
				coluna = 0;
				linha++;
			}

			m[linha][coluna] = listaResultadosOrdenacao.get(i).intValue();

			coluna++;
		}

		System.out.println(" Para copiar e colar os resultados das Ordenações respectivamente na planilha: \n");
		for (int c = 0; c < qtdBuscasSequenciais; c++) {
			for (int l = 0; l < QTD_EXPERIMENTOS; l++) {
				if (l == QTD_EXPERIMENTOS - 1) {
					System.out.println(m[l][c]);
				} else {
					System.out.print(m[l][c] + "\t");
				}
			}
		}

	}

	private static void imprimirResultadoSimplificadoTempoExecucao() {
		Long m[][] = new Long[QTD_EXPERIMENTOS][qtdBuscasSequenciais];
		int linha = 0;
		int coluna = 0;
		for (int i = 0; i < listaResultadosTempoExecucao.size(); i++) {
			if (coluna == qtdBuscasSequenciais) {
				coluna = 0;
				linha++;
			}

			m[linha][coluna] = listaResultadosTempoExecucao.get(i);

			coluna++;
		}

		System.out.println(" Para copiar e colar os resultados dos TEMPOS DE EXECUÇÃO respectivamente na planilha: \n");
		for (int c = 0; c < qtdBuscasSequenciais; c++) {
			for (int l = 0; l < QTD_EXPERIMENTOS; l++) {
				if (l == QTD_EXPERIMENTOS - 1) {
					System.out.println(m[l][c]);
				} else {
					System.out.print(m[l][c] + "\t");
				}
			}
		}

	}

	private static void imprimirResultadoSimplificadoMemoriaUtilizada() {
		int m[][] = new int[QTD_EXPERIMENTOS][qtdBuscasSequenciais];
		int linha = 0;
		int coluna = 0;
		for (int i = 0; i < listaResultadosMemoriaUtilizada.size(); i++) {
			if (coluna == qtdBuscasSequenciais) {
				coluna = 0;
				linha++;
			}

			m[linha][coluna] = listaResultadosMemoriaUtilizada.get(i).intValue();

			coluna++;
		}

		System.out.println(
				" Para copiar e colar os resultados das MEMÓRIAS TOTAIS UTILIZADAS respectivamente na planilha: \n");
		for (int c = 0; c < qtdBuscasSequenciais; c++) {
			for (int l = 0; l < QTD_EXPERIMENTOS; l++) {
				if (l == QTD_EXPERIMENTOS - 1) {
					System.out.println(m[l][c]);
				} else {
					System.out.print(m[l][c] + "\t");
				}
			}
		}

	}

	private static void resetarValores() {
		qtdBuscasSequenciais = 0;
		resultadoSomaContadoresOrdenacao = 0l;
		listaResultadosOrdenacao.clear();
		listaResultadosBusca.clear();
		listaResultadosTempoExecucao.clear();
		listaResultadosMemoriaUtilizada.clear();
	}
}
