package adt.avltree;

import static adt.bt.Util.leftRotation;
import static adt.bt.Util.rightRotation;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int balance = 0;

		if (node != null && !node.isEmpty()) {
			balance = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}

		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node){
		int balance = calculateBalance(node);
		BSTNode<T> subtreeRoot;

		if (balance > 1) {

			if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
				subtreeRoot = rightRotation(node);
			} else {
				leftRotation((BSTNode<T>) node.getLeft());
				subtreeRoot = rightRotation(node);
			}

			if (subtreeRoot.getParent() == null) {
				super.root = subtreeRoot;
			}

		} else if (balance < -1) {

			if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
				subtreeRoot = leftRotation(node);
			} else {
				rightRotation((BSTNode<T>) node.getRight());
				subtreeRoot = leftRotation(node);
			}

			if (subtreeRoot.getParent() == null){
				super.root = subtreeRoot;
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		while (parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}
	
	@Override
	public void insert(T element) {
		if (element!=null) {
			insert(this.getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());
			node.setRight(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());

		} else {

			if (node.getData().compareTo(element)>0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}

			this.rebalance(node);
		}
	}
	
	public BSTNode<T> getRoot() {
		return super.getRoot();
	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> node = super.search(element);
		super.remove(element);
		this.rebalanceUp(node);
	}
	
	
}
