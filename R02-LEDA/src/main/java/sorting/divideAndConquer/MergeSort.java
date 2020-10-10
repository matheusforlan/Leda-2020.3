package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			int middle = (leftIndex + rightIndex)/2;
			
			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			
			merge(array, leftIndex, middle, rightIndex);
		}
		
		else {			
			return;			
		}		
	}


	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		
		T[] auxArray = (T[]) new Comparable[array.length];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			auxArray[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		
		
		while( (i <= middle)  && (j <= rightIndex)) {
			
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
