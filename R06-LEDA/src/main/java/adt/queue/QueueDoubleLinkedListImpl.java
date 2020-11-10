package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		else {
			
			this.list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}

		T value = this.head();

		this.list.removeFirst();

		return value;
	}

	@Override
	public T head() {
		T value = null;

		if (!this.isEmpty()) {

			T[] array = this.list.toArray();
			value = array[0];

		}

		return value;
	}

	@Override
	public boolean isEmpty() {
		boolean answer = false;

		if (this.list.isEmpty()) {
			answer = true;
		}

		return answer;
	}

	@Override
	public boolean isFull() {
		boolean result = false;

		if (this.list.size()==this.size) {
			result = true;
		}

		return result;
	}

}
