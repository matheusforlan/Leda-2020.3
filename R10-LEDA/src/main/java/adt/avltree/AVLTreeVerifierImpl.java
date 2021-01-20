package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {

		boolean answer = true;

		if (!avlTree.isEmpty()) {

			if (super.isBST()) {
				answer = isAVLTree(avlTree.getRoot());
			} else {
				answer = false;
			}
		}

		return answer;

	}
	
	private boolean isAVLTree(BSTNode<T> node) {
		boolean answer = true;

		int balance = avlTree.calculateBalance(node);

		if (balance < -1 || balance > 1) {

			answer = false;

		} else {

			BSTNode<T> left = (BSTNode<T>) node.getLeft();
			BSTNode<T> right = (BSTNode<T>) node.getRight();

			if (left!=null) {
				answer = isAVLTree(left);
			}

			if (right!=null && answer != false) {
				answer = isAVLTree(right);
			}

		}

		return answer;
	}

}
