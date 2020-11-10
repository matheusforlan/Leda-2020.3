package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size){
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		
		if(element != null) {
			
			if (this.isFull()) {
				throw new StackOverflowException();
			} else {
				this.top.insertFirst(element);
			}			
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}

		T value = this.top();

		this.top.removeFirst();

		return value;
	}

	@Override
	public T top() {
		T result = null;

		if (!this.isEmpty()) {

			T[] array = this.top.toArray();

			result = array[0];

		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean answer = false;

		if (this.top.isEmpty()) {
			answer = true;
		}

		return answer;
	}

	@Override
	public boolean isFull(){
		
		boolean answer = false;

		if (this.top.size()==this.size) {
			answer = true;
		}

		return answer;
	}

}
