package adt.avltree;

import static adt.bt.Util.leftRotation;
import static adt.bt.Util.rightRotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		BSTNode<T> subtreeRoot;

		if (balance > 1) {

			if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
				subtreeRoot = rightRotation(node);
				this.LLcounter++;
			} else {
				leftRotation((BSTNode<T>) node.getLeft());
				subtreeRoot = rightRotation(node);
				this.LRcounter++;
			}

			if (subtreeRoot.getParent() == null) {
				super.root = subtreeRoot;
			}

		} else if (balance < -1) {

			if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
				subtreeRoot = leftRotation(node);
				this.RRcounter++;
			} else {
				rightRotation((BSTNode<T>) node.getRight());
				subtreeRoot = leftRotation(node);
				this.RLcounter++;
			}

			if (subtreeRoot.getParent() == null) {
				super.root = subtreeRoot;
			}
		}
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if (array!=null) {

			Arrays.sort(array);

			Map<Integer, List<T>> mapLevels = new TreeMap<>();

			this.organizesLevelMap(mapLevels, 0, array.length-1, 0, array);

			for (List<T> level : mapLevels.values()) {
				for (T value : level) {
					super.insert(value);
				}
			}
		}
	}
	
	private void organizesLevelMap(Map<Integer, List<T>> mapLevels, int leftIndex, int rightIndex, int level, T[] array) {

		if (leftIndex <= rightIndex) {

			int middleIndex = (leftIndex + rightIndex) / 2;

			if (!mapLevels.containsKey(level)) {
				mapLevels.put(level, new ArrayList<>());
			}

			mapLevels.get(level).add(array[middleIndex]);

			organizesLevelMap(mapLevels, leftIndex, middleIndex-1, level+1, array);
			organizesLevelMap(mapLevels, middleIndex+1, rightIndex, level+1, array);
		}
	}

}
