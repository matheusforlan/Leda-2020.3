package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		boolean answer = true;

		if (!bst.isEmpty()) {
			answer = this.isBST(bst.getRoot());
		}

		return answer;
	}
	
	
	private boolean isBST(BSTNode<T> currentNode) {
		boolean answer = true;

		if (currentNode.getLeft() != null && currentNode.getRight() != null) {

			BSTNode<T> left = (BSTNode<T>) currentNode.getLeft();
			BSTNode<T> right = (BSTNode<T>) currentNode.getRight();

			if (!left.isEmpty() && !right.isEmpty()) {

				if (currentNode.getData().compareTo(left.getData()) < 0 || currentNode.getData().compareTo(right.getData()) > 0) {
					answer = false;
				} else {
					answer = isBST(left);
					if(answer != false) {
						answer = isBST(right);
					}
					
				}

			} else if (!left.isEmpty() && right.isEmpty()) {

				if (currentNode.getData().compareTo(left.getData()) < 0) {
					answer = false;
				} else {
					answer = isBST(left);
				}

			} else if (left.isEmpty() && !right.isEmpty()) {

				if (currentNode.getData().compareTo(right.getData()) > 0) {
					answer = false;
				} else {
					answer = isBST(right);
				}
			}
		}

		return answer;
	}
	
}
