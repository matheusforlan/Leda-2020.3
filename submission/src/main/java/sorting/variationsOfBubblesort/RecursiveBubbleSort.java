package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
			
		
		if(leftIndex == rightIndex || array.length == 0) {
			return;
		}
		
		else {
			
			for(int j = leftIndex; j < rightIndex; j++) {
				
				if(array[j+1].compareTo(array[j]) < 0) {
					Util.swap(array, j+1, j);
				}
			}
		
		}
		
		sort(array, leftIndex, rightIndex - 1);
	}

}
