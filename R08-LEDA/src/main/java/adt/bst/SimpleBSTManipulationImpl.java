package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2){
		
		return  equals(tree1.getRoot(), tree2.getRoot());
		
	}

	private boolean equals(BTNode<T> node1, BTNode<T> node2) {
		
		boolean answer;
		
		if (node1 == null && node2 == null) {
			answer = true;
		} else if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
			answer = false;
		} else {
			if (node1.equals(node2)  && equals(node1.getLeft(), node2.getLeft()) &&
					equals(node1.getRight(), node2.getRight())) {
				answer = true;
			} else {
				answer = false;
			}
		}
		return answer;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		
		return isSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilar(BTNode<T> node1, BTNode<T> node2) {
		boolean answer;

		if (node1==null && node2==null) {
			answer = true;
		} else if ((node1!=null && node2==null) || (node1==null && node2!=null)) {
			answer = false;
		} else {
			if (isSimilar(node1.getLeft(), node2.getLeft()) &&	isSimilar(node1.getRight(), node2.getRight())) {
				answer = true;
			} else {
				answer = false;
			}
		}
		return answer;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		
		T value = null;

		if (!tree.isEmpty() && k > 0 && k <= tree.size()) {
			value = orderStatistic(tree, tree.minimum(), k);
		}

		return value;
	}
	
	private T orderStatistic(BST<T> tree, BSTNode<T> node, int k){
			
		T value = null;
	
		if (node != null && !node.isEmpty()){
	
			k--;
			
			if (k==0) {
				value = node.getData();
			} else {
				BSTNode<T> sucessor = tree.sucessor(node.getData());
				value = orderStatistic(tree, sucessor, k);
			}
		}	
		return value;
	}	
}
