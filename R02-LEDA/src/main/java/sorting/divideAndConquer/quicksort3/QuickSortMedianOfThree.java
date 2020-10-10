package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			int indexPivot = partition(array, leftIndex, rightIndex);
			
			sort(array, leftIndex, indexPivot - 1);
			sort(array, indexPivot + 1, rightIndex);
		}
		else {
			return;
		}
	}
		
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		
		 int medianOfThreePivotIndex = pickPivotIndex(array, leftIndex, rightIndex);
		 
	     Util.swap(array, leftIndex, medianOfThreePivotIndex);
		
		T pivot =   array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rightIndex; j++){
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		
		Util.swap(array, leftIndex, i);
		
		
		return i;
	}



	private int pickPivotIndex(T[] array, int leftIndex, int rightIndex) {
		
		int middleIndex = (leftIndex + rightIndex) / 2;
	    
		if(array[leftIndex].compareTo(array[middleIndex]) > 0) {
			Util.swap(array, leftIndex, middleIndex);
		}
		
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		
		if(array[middleIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, middleIndex, rightIndex);
		}
	    
		return middleIndex;
	}


	private boolean validIndexes(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		
		
		 if( leftIndex >= array.length || leftIndex > rightIndex || leftIndex < 0) {
			result = false;
		}
		
		else if(rightIndex >= array.length || rightIndex < 0) {
			result = false;
		}
				
		return result;
	}
}
