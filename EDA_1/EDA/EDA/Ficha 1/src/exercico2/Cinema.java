package exercico2;

import java.util.ArrayList;

public class Cinema<T> implements FilaDeEspera<T>, Comparable<FilaDeEspera<?>>{
	private int maxComp;
	private ArrayList<T> fila = new ArrayList<T>();
	
	
	public Cinema(int maxComp){
		this.maxComp = maxComp;
	}

	public int size(){
		return fila.size();
	}
	public int maxSize(){
		return maxComp;
	}
	public int places(){
		return fila.size()-maxComp;
	}
	
	
	public boolean isFull(){
		return fila.size()>= maxComp;
		
	}
	public boolean isEmpty(){
		return fila.size()==0;
	}
	
	
	public void add(T object){
		fila.add(object);
	}
	
	
	public T front(){
		return fila.get(0);
	}
	public T remove(){
		return fila.remove(0);
	}
	
	public String toString(){
		return fila.toString();
	}
	
	public int compareTo(FilaDeEspera<?> x){
		if(x.size()>fila.size()){
			return 1;
		}else if(x.size()<fila.size()){
			return -1;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Cinema<String> cin = new Cinema<String>(5);
		Cinema<String> fila = new Cinema<String>(8);
		for(char c='a'; c<'e'; c++){
			cin.add(""+c);
		}
		for(char f='g'; f<'n'; f++){
			fila.add(""+f);
		}
		System.out.println(cin);
		System.out.println(fila);
		System.out.println(cin.compareTo(fila));
		
	}
}
