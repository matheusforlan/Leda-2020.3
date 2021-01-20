package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param futureSon
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> futureSon) {
		BSTNode<T> futureFather = (BSTNode<T>) futureSon.getRight();
		BSTNode<T> leftOfFutureFather = (BSTNode<T>) futureFather.getLeft();
		BSTNode<T> parentOfOldFather = (BSTNode<T>) futureSon.getParent();

		if (parentOfOldFather != null) {
			if (parentOfOldFather.getLeft().equals(futureSon)) {
				parentOfOldFather.setLeft(futureFather);
			} else {
				parentOfOldFather.setRight(futureFather);
			}
		}

		futureFather.setParent(parentOfOldFather);
		futureSon.setParent(futureFather);
		futureSon.setRight(leftOfFutureFather);
		futureFather.setLeft(futureSon);

		if (leftOfFutureFather != null) {
			leftOfFutureFather.setParent(futureSon);
		}

		return futureFather;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a escort
	 * @param futureSon
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> futureSon) {
		BSTNode<T> futureFather = (BSTNode<T>) futureSon.getLeft();
		BSTNode<T> rightOfFutureFather = (BSTNode<T>) futureFather.getRight();
		BSTNode<T> parentOfOldFather = (BSTNode<T>) futureSon.getParent();

		if (parentOfOldFather != null) {
			if (parentOfOldFather.getLeft().equals(futureSon)) {
				parentOfOldFather.setLeft(futureFather);
			} else {
				parentOfOldFather.setRight(futureFather);
			}
		}

		futureFather.setParent(parentOfOldFather);
		futureSon.setParent(futureFather);
		futureSon.setLeft(rightOfFutureFather);
		futureFather.setRight(futureSon);

		if (rightOfFutureFather != null) {
			rightOfFutureFather.setParent(futureSon);
		}

		return futureFather;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
