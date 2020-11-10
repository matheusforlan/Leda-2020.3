package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top(){
		
		T result;
		
		if(isEmpty()) {
			result = null;
		} else {
			result = this.array[this.top];
		}
		
		return result;		
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		
		return this.top == (this.array.length -1);
		
	}

	@Override
	public void push(T element) throws StackOverflowException {
		
		if(this.isFull()){
			throw new StackOverflowException();
		}
		
		this.top ++;
		this.array[top] = element;		
	}

	@Override
	public T pop() throws StackUnderflowException {
		
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		
		T number = this.array[this.top];
		this.top --;
		return number;
	}

}
