package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element){
		
		if (element != null) {
			if(this.isEmpty()) {
				DoubleLinkedListNode<T> newNode = 
						new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
			this.setLast(newNode);
			this.setHead(newNode);
			
			} else {
				
				DoubleLinkedListNode<T> oldHead = new DoubleLinkedListNode<>();

				oldHead.setData(this.getHead().getData());
				oldHead.setNext(this.getHead().getNext());
				
				DoubleLinkedListNode<T> newNode = 
				new DoubleLinkedListNode<T>(element, oldHead, new DoubleLinkedListNode<T>());
				this.setHead(newNode);
			}
			
		}
	}
	
	@Override
	public void insert(T element) {
		if (this.isEmpty()) {

			this.insertFirst(element);

		} else {

			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();

			newNode.setData(element);
			newNode.setNext(new DoubleLinkedListNode<>());
			newNode.setPrevious(this.getLast());

			this.getLast().setNext(newNode);
			this.setLast(newNode);
			
		}
	}

	@Override
	public void removeFirst() {
	
		if(! this.isEmpty()){
			
			if(this.size() == 1) {
				
				this.setHead(this.getHead().getNext());
			
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
					this.setLast((DoubleLinkedListNode<T>) this.getHead());
				}

			} else {

			this.setHead(this.getHead().getNext());
		
			}
		}
	}

	@Override
	public void removeLast() {
		
		if (!this.isEmpty()) {

			if (this.size()==1) {

				this.setLast(new DoubleLinkedListNode<T>());
				this.setHead(this.last);

			} else {

				setLast(this.last.getPrevious());
				this.last.setNext(new DoubleLinkedListNode<>());
			}
		}
	}
	
	
	@Override
	public void remove(T element) {
		
		if (this.getHead().getData().equals(element)) {

			this.removeFirst();

		} else if (this.last.getData().equals(element)) {

			this.removeLast();

		} else {

			DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) this.getHead();

			while ((!node.getData().equals(element)) && (!node.isNIL())) {
				node = (DoubleLinkedListNode<T>) node.getNext();
			}

			if (!node.isNIL()) {
				node.getPrevious().setNext(node.getNext());
				((DoubleLinkedListNode<T>) node.getNext()).setPrevious(node.getPrevious());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
