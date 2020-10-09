package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			for(int i = leftIndex;  i < rightIndex; i++){
				
				boolean houveTroca = false;
				
				for(int j = leftIndex; j < rightIndex - i; j++){
					
					if(array[j+1].compareTo(array[j]) < 0) {
						
						Util.swap(array, j, j+1);
						
						houveTroca = true;
						
					}
				}
				
				if(!(houveTroca)) {              // se não houve troca, retorne. pois já está ordenado
					return;
					
				}
			}
		}else {
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
	

