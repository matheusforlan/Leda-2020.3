package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	
	

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			boolean houveTroca = true;
			
			int left = leftIndex;
			int  right = rightIndex;
			
			while(houveTroca) {
				
				houveTroca = false;
				
				for( int i = left; i < rightIndex; i++ ) {
					
					if(array[i+1].compareTo(array[i]) < 0) {
						Util.swap(array, i, i+1);
						houveTroca = true;
					}
					
				}
				
				right --;
				
				for(int j = right; j > left ; j --) {
					
					if(array[j-1].compareTo(array[j]) > 0) {
						Util.swap(array, j-1, j);
						houveTroca = true;
					}
				}
				
				
				left ++;
				
				
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
