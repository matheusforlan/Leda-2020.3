package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) && (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			int max = findHighestValue(array, leftIndex, rightIndex);
			int min = findSmallestValue(array, leftIndex, rightIndex);
			extendCountingSort(array, max, min,  leftIndex, rightIndex);			
		}
		
		else {
			
			return;
			
		}
	}
		
	
	private boolean validIndexes(Integer[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		
		
		 if( leftIndex >= array.length || leftIndex > rightIndex || leftIndex < 0) {
			result = false;
		}
		
		else if(rightIndex >= array.length || rightIndex < 0) {
			result = false;
		}
				
		return result;
	}



	private int findSmallestValue(Integer[] array, int leftIndex, int rightIndex) {
		
		int min = array[leftIndex];
		
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			
			if(array[i] < min){
				min = array[i];
			}
		}
		
		return min;
	}
		
	
	private int findHighestValue(Integer[] array, int leftIndex, int rightIndex) {
		
		int max = array[leftIndex];
		
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			
			if(array[i] > max){
				max = array[i];
			}
		}		
		return max;
	}
	


	private void extendCountingSort(Integer[] initialArray, int max, int min, int leftIndex, int rightIndex) {
		
		Integer[] countingArray = new Integer[max - min + 1];
		Arrays.fill(countingArray, 0);
		
		
		// frequencia
		for(int i = leftIndex; i <= rightIndex; i++) {
			countingArray[initialArray[i] - min] += 1;
		}
		
		// cumulativa

		for(int i = 0; i < countingArray.length - 1; i++) {
					
			countingArray[i+1] += countingArray[i];
					
		}
		
		Integer[] orderedArray = new Integer[rightIndex - leftIndex + 1];
		
		for(int i = rightIndex; i >= leftIndex; i--){
			
			countingArray[initialArray[i] - min] -= 1;
			
			orderedArray[ countingArray[initialArray[i] - min]] = initialArray[i];
			
		}
		
		for(int i = leftIndex; i <= rightIndex; i++){
			initialArray[i] = orderedArray[i-leftIndex];
			
		}				
		
	}

}
