package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		
		boolean value = false;
		if(this.head.isNIL()) {
			value = true;
		}		
		return value;
	}

	@Override
	public int size() {
		int elements = 0;
		
		if(!this.head.isNIL()) {
			SingleLinkedListNode<T> node = this.head;
			
			while(!node.isNIL()) {
				elements += 1;
				node = node.getNext();
			}
		}
		
		return elements;
	}

	@Override
	public T search(T element) {
		T answer = null;
		
		if(element != null){
			SingleLinkedListNode<T> node = this.head;
			
			while(!node.isNIL()) {
				if(node.getData().equals(element)) {
					answer = node.getData();
					break;
				}
				else {
					node = node.getNext();
				}
			}
		}
		
		return answer;
	}

	@Override
	public void insert(T element) {
		
		if(element != null) {
			
			SingleLinkedListNode<T> node = this.head;
			
			if(isEmpty()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
				this.setHead(newHead);
			}
			else {
				
				while (!node.isNIL()) {
					node = node.getNext();
				}

				node.setData(element);
				node.setNext(new SingleLinkedListNode<>());
			}
		}
		
	}

	@Override
	public void remove(T element) {
		
		if(element != null) {
			
			if (this.getHead().getData().equals(element)) {

				this.head = this.head.getNext();

			} else {

				SingleLinkedListNode<T> nextNode = this.head;
				SingleLinkedListNode<T> prevNode = this.head;

				while (( (!nextNode.getData().equals(element) && !nextNode.isNIL()) )) {
					prevNode = nextNode;
					nextNode = nextNode.getNext();
				}

				if (!nextNode.isNIL()) {
					prevNode.setNext(nextNode.getNext());
				}

			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		SingleLinkedListNode<T> node = this.head;
		
		while (!node.isNIL()){
			array.add(node.getData());
			node = node.getNext();
		}
		
		return (T[]) array.toArray();
		
	}

	public SingleLinkedListNode<T> getHead(){
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
