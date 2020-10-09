package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex)) ) {
			
			int menorIndice = leftIndex;
			
			for(int j = leftIndex + 1; j <=  rightIndex; j++) {
				
				if(array[j].compareTo(array[menorIndice])< 0) {
					
					menorIndice = j;
				}
			}
			
			Util.swap(array, leftIndex, menorIndice);
			
			sort(array, leftIndex + 1, rightIndex);
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

}
