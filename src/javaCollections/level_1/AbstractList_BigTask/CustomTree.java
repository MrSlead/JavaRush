package javaCollections.level_1.AbstractList_BigTask;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*                                                   
Построй дерево(1)                                                  
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	Entry<String> root;

	public CustomTree() {
		root = new Entry<String>("0");
	}

	static class Entry<T> implements Serializable {
		private static final long serialVersionUID = 1L;

		String elementName;
		boolean availableToAddLeftChildren;
		boolean availableToAddRightChildren;

		Entry<T> parent, leftChild, rightChild;

		public Entry(String elementName) {
			this.elementName = elementName;
			availableToAddLeftChildren = true;
			availableToAddRightChildren = true;
		}

		public boolean isAvailableToAddChildren() {
			return availableToAddLeftChildren || availableToAddRightChildren;
		}

		public String getElementName() {
			return elementName;
		}
	}

	public String getParent(String s) {
		Entry<String> entry = root;
		Queue<Entry<String>> queue = new ArrayDeque<>();
		
		queue.add(entry);
		while(!queue.isEmpty()) {
			entry = queue.poll();
			if(entry.getElementName().equals(s)) {
				return entry.parent.getElementName();
			}
			if(entry.availableToAddLeftChildren == false || entry.availableToAddRightChildren == false){
				if(entry.leftChild != null) {
					queue.add(entry.leftChild);
				}
				if(entry.rightChild != null) {
					queue.add(entry.rightChild);
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean add(String s) {
		Entry<String> entry = root;
		Queue<Entry<String>> queue = new ArrayDeque<>();
		
		queue.add(entry);
		while(!queue.isEmpty()) {
			entry = queue.poll();
			if(entry.isAvailableToAddChildren() == true) {
				if(entry.availableToAddLeftChildren == true) {
					entry.leftChild = new Entry<String>(s);
					entry.leftChild.parent = entry;
					entry.availableToAddLeftChildren = false;
					return true;
				}
				else {
					entry.rightChild = new Entry<String>(s);
					entry.rightChild.parent = entry;
					entry.availableToAddRightChildren = false;
					return true;
				}
			}
			else {
				if(entry.leftChild != null) {
					queue.add(entry.leftChild);
				}
				if(entry.rightChild != null) {
					queue.add(entry.rightChild);
				}
			}
		}
		
		openPossibilityHavingChild(s);
		
		
		return false;
	}
	
	private void openPossibilityHavingChild(String s) {
		Entry<String> entry = root;
		Queue<Entry<String>> queue = new ArrayDeque<>();
		
		queue.add(entry);
		while(!queue.isEmpty()) {
			entry = queue.poll();
			if(entry.isAvailableToAddChildren() == false && entry.leftChild == null && entry.rightChild == null) {
				entry.availableToAddLeftChildren = true;
				entry.availableToAddRightChildren = true;	
			}
			else {
				if(entry.leftChild != null) {
					queue.add(entry.leftChild);
				}
				if(entry.rightChild != null) {
					queue.add(entry.rightChild);
				}
			}
		}
		add(s);
	}
	
	@Override
	public int size() {
		Entry<String> entry = root;
		Queue<Entry<String>> queue = new ArrayDeque<>();
		int count = 0;
		
		queue.add(entry);
		while(!queue.isEmpty()) {
			entry = queue.poll();
			if(!entry.isAvailableToAddChildren()){
				if(entry.leftChild != null) {
					queue.add(entry.leftChild);
					count++;
				}
				if(entry.rightChild != null) {
					queue.add(entry.rightChild);
					count++;
				}
				
			}
			else {
				if(entry.leftChild != null && entry.availableToAddLeftChildren == false) {
					queue.add(entry.leftChild);
					count++;
				}
				else if(entry.rightChild != null && entry.availableToAddRightChildren == false) {
					queue.add(entry.rightChild);
					count++;
				}
			}
		}
		return count;
	}
	
	
	@Override
	public boolean remove(Object o) {
		if(!(o instanceof String)) {
			throw new UnsupportedOperationException();
		}
		
		Entry<String> entry = root;
		
		Queue<Entry<String>> queue = new ArrayDeque<>();
		String s = String.valueOf(o);
		boolean isDeletedElement = false;
		
		queue.add(entry);
		while(!queue.isEmpty()) {
			entry = queue.poll();
			if(entry.getElementName().equals(s)) {
				while(!queue.isEmpty()) {
					queue.remove();
				}
				isDeletedElement = true;
			}
			if(entry.availableToAddLeftChildren == false || entry.availableToAddRightChildren == false){
				if(entry.leftChild != null) {
					queue.add(entry.leftChild);
				}
				if(entry.rightChild != null) {
					queue.add(entry.rightChild);
				}
			}
			if(isDeletedElement) {
				entry.leftChild = null;
				entry.rightChild = null;
				
				if(entry.parent.leftChild != null && entry.parent.leftChild.equals(entry)){
					entry.parent.leftChild = null;
				}
				else if(entry.parent.rightChild != null &&  entry.parent.rightChild.equals(entry)) {
					entry.parent.rightChild = null;
				}
			}
		}
		return isDeletedElement;
	}

	@Override
	public String get(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}


}