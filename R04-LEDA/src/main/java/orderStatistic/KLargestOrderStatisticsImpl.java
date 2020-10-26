package orderStatistic;

import static util.Util.swap;

import java.io.ObjectInputStream.GetField;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */

public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{
	
	@Override
	public T[] getKLargest(T[] array, int k) {
		T[] result = null;

		if (kAndArrayAreValid(array, k)){
			
			quickSort(array, 0, array.length-1);

			T[] newArray = (T[]) new Comparable[k];

			int indexNewArray = 0;
			
			while(k > 0){				
				newArray[indexNewArray] = orderStatistics(array, array.length - k);
				k --;
				indexNewArray ++;
			}
			
			result = newArray;
			
		}

		return result;
		//este metodo deve obrigatoriamente usar o orderStatistics abaixo.
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		T number = null;
	
		number = array[k];
		
		return number;
	}

	
	private boolean kAndArrayAreValid(T[] array, int k) {
		boolean result = true;

		if (array.length < 1 || array == null) {
			result = false;
			
		} else if (k < 1 || k > array.length) {
			result = false;
		}

		return result;
	}
	
	public void quickSort(T[] array, int leftIndex, int rightIndex) {
			
			if( (leftIndex < rightIndex) &&  (array.length) > 1 && (validIndexes(array, leftIndex,rightIndex))) {
				
				int indexPivot = partition(array, leftIndex, rightIndex);
				
				quickSort(array, leftIndex, indexPivot - 1);
				quickSort(array, indexPivot + 1, rightIndex);
			}
			
			else{				
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


	private boolean validIndexes(T[] array, int leftIndex, int rightIndex){
		
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
