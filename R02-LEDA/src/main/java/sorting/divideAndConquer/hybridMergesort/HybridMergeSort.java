package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex){
		
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		
		if( (leftIndex < rightIndex) && (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
		
			hybridMergeSort(array, leftIndex, rightIndex);
			
		}
		
		else {
			return;
		}
		
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
		
	
	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {
		
		if((rightIndex - leftIndex + 1) <= SIZE_LIMIT) {
			
			insertionSort(array,leftIndex,rightIndex);			
		}
		
		else {						
			int middle = (leftIndex + rightIndex)/2;			
			hybridMergeSort(array, leftIndex, middle);
			hybridMergeSort(array, middle+1, rightIndex);			
			merge(array, leftIndex, middle, rightIndex);
		}
		
	}


	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
			
		INSERTIONSORT_APPLICATIONS ++;
			
			for(int i = leftIndex + 1 ; i <= rightIndex; i++) {
				
				int j = i;
				
				while( (j > leftIndex) && (array[j].compareTo(array[j-1]) < 0 )) {
					
					Util.swap(array, j, j-1);
					j--;
					
				}
			}
			
	}
		


	
	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		
		MERGESORT_APPLICATIONS ++;
		T[] auxArray = (T[]) new Comparable[array.length];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			auxArray[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
						
		while( (i <= middle) && (j <= rightIndex)) {
			
			if(auxArray[i].compareTo(auxArray[j]) < 0){
				array[k] = auxArray[i];
				i++;
				
			} else { // (auxArray[i].compareTo(auxArray[j]) >= 0) o elemento de j é menor
				array[k] = auxArray[j];
				j++;				
			}			
			k++;			
		}		
		while( i <= middle) {
			array[k] = auxArray[i];
			k++;
			i++;
		}
		
		while(j <= rightIndex){
			array[k] = auxArray[j];
			k++;
			j++;
		}		
	}
}
