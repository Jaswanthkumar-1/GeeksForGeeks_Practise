package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> {

	private Object[] a1;
	private static final int DEFAULT_CAPACITY =10;
	private int currentIndex = 0;
	private int size = 0;
	public int ti;
	
	public MyArrayList(){
		this(DEFAULT_CAPACITY);
	}
	public MyArrayList(int intialCapacity){
		a1 = new Object[intialCapacity];
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer("["+a1[0]);
		for(int i=1;i<=size-1;i++){
			sb.append(","+a1[i]);
		}
		return sb+"]";
	}
	public void add(E element){
		
		ensureCapacity();
		a1[currentIndex] = element;
		currentIndex++;
		size++;
	}
	
	private void ensureCapacity(){
		if(currentIndex == a1.length){
			grow();
		}
	}
	
	private void grow(){
		a1 = Arrays.copyOf(a1, newCapacity());
	}
	
	private int newCapacity(){
		return a1.length + (a1.length >> 1);
	}
	public boolean remove(int index){
		if(index >= currentIndex && index < 0){
			return false;
		}
		System.arraycopy(a1, index+1 , a1 , index , (size-index)-1);
		size--;
		currentIndex--;
		return true;
	}
	public <Elements> void add(int index,Elements e){     
		if(index > currentIndex || index < 0){
			try {
				throw new Exception("Array Index Out of bound Exception");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		System.arraycopy(a1, index, a1, index+1, (size-index));
		a1[index]=e;
		size++;
		currentIndex++;
	}
	public <Element> void set(int index,Element e){ 	
		a1[index]=e;
	} 
	public boolean delete(E element){			
		
		for(int i=0;i<size;i++)
		{			
			if(a1[i].equals(element)){
				return remove(i);
			}
		}
		return false;
	}
	public int size(){
		int size=a1.length;
		return size;
	}
	public Object get(int index){	
		return a1[index];
	}
	public void clear(){
		a1=null;
		currentIndex=0;
		size=0;
		a1 = new Object[DEFAULT_CAPACITY];
	}
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean contains(Object element){
		for(int i=0;i<=size-1;i++){
			if(a1[i].equals(element)){
				return true;
			}
		}
		return false;
	}
	
	public Iterator<E> iterator(){ 
		return new Itr<E>();
	}
	public class Itr<E> implements Iterator<E>{
		
		public E next(){
			E e =(E)a1[ti++];
			if(e==null){
				throw new NoSuchElementException();
			
			}
			return e;
		}
		public void remove(){
			MyArrayList.this.remove(--ti);
		}
		public boolean hasNext(){
			return (ti<size)? true:false;
		}
	}
	private class LItr<E> implements ListIterator<E>{
		private int ti =0;	
		public E next(){
			E e =(E)a1[ti++];
			if(e==null){
				throw new NoSuchElementException();	
			}
			return null;
		}
		public boolean hasNext() {
			return (ti<size)? true:false;
	
		}
		public boolean hasPrevious() {
			return (ti<size)? true:false;
				}
		public E previous() {
			E e =(E)a1[--ti];
			if(e==null){
				throw new NoSuchElementException();	
			}
			return e;
		}
		public int nextIndex() {
			if(ti>=size){
				return -1;
			}
			else{
			return ti;
				}
			}
		public int previousIndex() {
			if(ti<0){
				return -1;
			}
			else{
				return ti-1;
			}
		}
		public void remove() {
			MyArrayList.this.remove(--ti);
		}
		public void set(E e) {
			if(ti>size || ti<0)
			{
				throw new IndexOutOfBoundsException();
			}
			MyArrayList.this.set(ti, e);
			
		}
		public void add(E e) {
			
			MyArrayList.this.add(ti, e);
		}
	}
}
