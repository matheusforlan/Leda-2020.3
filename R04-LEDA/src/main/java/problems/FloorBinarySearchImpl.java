package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor{
	

	@Override
	public Integer floor(Integer[] array, Integer x){
		
		Integer number = null;
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		quickSort(array, leftIndex, rightIndex);
		
		if(arrayIsValid(array)){
			
			Integer indexFloor = binarySearch(x , array, leftIndex, rightIndex);
			
			if(indexFloor != -1){
				
				number = array[indexFloor];
			}
		}
		
		return number;
	}
	
	
	private boolean arrayIsValid(Integer[] array) {
		boolean valid = true;
		
		if(array.length < 1 || array == null){
			
			valid = false;
			
		}
		return valid;
	}


	private static Integer binarySearch(Integer x, Integer[] array, int leftIndex, int rightIndex) {
		
		Integer result = -1;
		
		int middle = (leftIndex + rightIndex) / 2 ;
		
			if(leftIndex <= rightIndex) {
				
				if(x != array[middle]) {
					if(x < array[middle]){
						result = binarySearch(x, array, leftIndex, middle - 1);
					} else {
						result = binarySearch(x, array, middle + 1, rightIndex);
					}
				}
				else {
					result = middle;
				}
			
			} else {
					
				if(middle >= 0 && middle == rightIndex){
					result = middle;
				}								
			}
			
		return result;
	}


	public void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			int indexPivot = partition(array, leftIndex, rightIndex);
			
			quickSort(array, leftIndex, indexPivot - 1);
			quickSort(array, indexPivot + 1, rightIndex);
		}
		else{
			
			return;
			
		}
	}
		
	
	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		
		
		 int medianOfThreePivotIndex = pickPivotIndex(array, leftIndex, rightIndex);
		 
	     Util.swap(array, leftIndex, medianOfThreePivotIndex);
		
		Integer pivot =   array[leftIndex];
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



	private int pickPivotIndex(Integer[] array, int leftIndex, int rightIndex) {
		
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


	private boolean validIndexes(Integer[] array, int leftIndex, int rightIndex){
		
		boolean result = true;
		
		
		 if( leftIndex >= array.length || leftIndex > rightIndex || leftIndex < 0){
			result = false;
		}
		 
		else if(rightIndex >= array.length || rightIndex < 0) {
			result = false;
		}
				
		return result;
	}

}
