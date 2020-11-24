package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		Integer value = null;
		HeapImpl<Integer> heap = new HeapImpl<Integer>(super.comparator);


		if (array != null && array.length > 0) {

			int aux = array[0];

			for (Integer element : array) {
				
				heap.insert(element);

				if (element < aux) {
					aux = element;
				}
			}

			int iterator = 0;
			
			while (iterator < array.length) {

				Integer currentRoot = heap.extractRootElement();

				if (currentRoot == numero) {
					aux = currentRoot;
					break;
				} else if (currentRoot < numero && currentRoot > aux) {
					aux = currentRoot;
				}

				iterator++;
			}

			if (aux <= numero) {
				value = aux;
			}
		}

		return value;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		
		Integer value = null;
		HeapImpl<Integer> heap = new HeapImpl<Integer>(super.comparator);


		if (array != null && array.length > 0) {

			int aux = array[0];

			for (Integer element : array) {
				
				heap.insert(element);

				if (element > aux) {
					aux = element;
				}
			}

			int iterator = 0;
			
			while (iterator < array.length) {

				Integer currentRoot = heap.extractRootElement();

				if (currentRoot == numero) {
					aux = currentRoot;
					break;
				} else if (currentRoot > numero && currentRoot < aux) {
					aux = currentRoot;
				}

				iterator++;
			}

			if (aux >= numero) {
				value = aux;
			}
		}

		return value;
	}

}
