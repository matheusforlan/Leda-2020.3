package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		}

		try {
			this.stack1.push(element);
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T value = null;

		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty()) {
				stackUp(this.stack1, this.stack2);
			}

			try {
				value = this.stack2.pop();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
			
			if (this.stack1.isEmpty()) {
				while (!this.stack2.isEmpty()) {
					unstack(this.stack1, this.stack2); // desempilhe
				}
			}

			
		}
		
		
		return value;
	}

	@Override
	public T head() {
		
		T result = null;

		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty()) {				
				stackUp(this.stack1, this.stack2);  // empilhe						
			}

			result = this.stack2.top();

		}

		if (this.stack1.isEmpty()) {
			while (!this.stack2.isEmpty()) {			
				unstack(this.stack1, this.stack2);  // desempilhe
			}
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;

		if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
			result = true;
		}

		return result;
	
	}

	@Override
	public boolean isFull() {
		
		boolean result = false;

		if (this.stack1.isFull() || this.stack2.isFull()) {
			result = true;
		}

		return result;
	}
	
	// metodo que empilha o stack 1 no stack 2
	private void stackUp(Stack<T> stack1, Stack<T> stack2) {
		
		try {
			stack2.push(stack1.pop());
		} catch (StackOverflowException e) {
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
	}
	
	// metodo que desempilha o stack 2 no stack 1 de volta
	private void unstack(Stack<T> stack1, Stack<T> stack2) {
		
		try {
			stack1.push(stack2.pop());
		} catch (StackOverflowException e) {
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
	
	}
		
	

}
