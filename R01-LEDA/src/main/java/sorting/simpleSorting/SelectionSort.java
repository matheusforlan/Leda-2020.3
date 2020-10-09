 package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				
				int menorIndice = i;
				
				for(int j = i+1; j <= rightIndex; j++) {
					
					if( array[j].compareTo(array[menorIndice]) < 0){
						
						menorIndice = j;
						
					}
									
				}
				
				Util.swap(array, i, menorIndice);        // troco o número do índice i pelo número de  menor Índice. 
				
			}
			
		} else {
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
}
