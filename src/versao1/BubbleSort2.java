package versao1;

public class BubbleSort2 {

	  public static void main(String args[]) {
		    int[] v = {4, 1, 2, 3};
		    BubbleSort2 bs = new BubbleSort2();
		    bs.ordenar(v);
		    for(int num : v) {
		      System.out.print(num + " ");
		    }
		  }
		  
		  /**
		   * M?todo que ordena um vetor de inteiros utilizando o algoritmo
		   * de Bubble Sort.
		   * 
		   * @param v - Vetor que ser? ordenado.
		   */
		  public void ordenar(int[] v) {
		    /* for utilizado para controlar a quantidade de vezes que o vetor ser?
			   ordenado. */
		    for(int i = 0; i < v.length - 1; i++) {
		      // Variavel utilizada para controlar se o vetor ja est? ordenado.
		      boolean estaOrdenado = true;
		      // for utilizado para ordenar o vetor.
		      for(int j = 0; j < v.length - 1 - i; j++) {
		        /* Se o valor da posi??o atual do vetor for maior que o proximo valor,
		          ent?o troca os valores de lugar no vetor. */
		        if(v[j] > v[j + 1]) {
		          int aux = v[j];
		          v[j] = v[j + 1];
		          v[j + 1] = aux;
		          estaOrdenado = false;
		        }
		      }
		      // Se o vetor est? ordenado ent?o para as itera??es sobre ele.
		      if(estaOrdenado)
		        break;
		    }
		  }
		}
	

