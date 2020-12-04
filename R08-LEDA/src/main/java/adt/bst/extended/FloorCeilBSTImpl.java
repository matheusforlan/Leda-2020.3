package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		Integer value = null;
		BSTImpl<Integer> bST = new BSTImpl<Integer>();

		if (array.length>0){
			
			int minorElement = -1;

			for (Integer element : array) {
				if (element <= minorElement) {
					minorElement = element;
				}
				bST.insert(element);
			}

			value = floor(bST.getRoot(), numero, minorElement);
		}
		return value;
	}
	
	private Integer floor(BSTNode<Integer> node, double numero, int minorElement) {
		
		Integer value = null;

		if (node!=null && !node.isEmpty()) {
			if (node.getData()==numero) {
				value = node.getData();
				
			} else if (node.getData()>numero) {
				value = floor((BSTNode<Integer>) node.getLeft(), numero, minorElement);
				
			} else {

				Integer floor = floor((BSTNode<Integer>) node.getRight(), numero, minorElement);

				if (floor==null){
					
					if (node.getData()>=minorElement) {
						value = node.getData();
					} else {
						value = floor;
					}
					
				} else {
					value = floor;
				}
			}
		}
		return value;
	}

	
	@Override
	public Integer ceil(Integer[] array, double numero) {
		
		Integer value = null;
		BSTImpl<Integer> bST = new BSTImpl<Integer>();

		if (array.length>0) {

			for (Integer element : array) {
				bST.insert(element);
			}

			value = ceil(bST.getRoot(), numero);
		}

		return value;
	}
	
	private Integer ceil(BSTNode<Integer> node, double numero) {
		Integer value = null;

		if (node!=null && !node.isEmpty()) {

			if (node.getData()==numero) {
				
				value = node.getData();
				
			} else if (node.getData() < numero) {
				
				value = ceil((BSTNode<Integer>) node.getRight(), numero);
				
			} else {
				
				Integer ceil = ceil((BSTNode<Integer>) node.getLeft(), numero);

				if (ceil != null) {

					if (ceil >= numero) {
						value = ceil;
						
					} else {
						value = node.getData();
					}

				} else {
					value = node.getData();
				}
			}
		}
		return value;
	}

	

}
