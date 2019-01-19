import java.util.Arrays;

public class HashTable<T extends Comparable<T>> {
	public int size = 0;
	public T[] hash;
	
	public HashTable(){
		hash = (T[])  new Comparable[691173];
		Arrays.fill(hash, "-1");
	}

	public HashTable(int n){
		hash = (T[]) new Comparable[n];
		Arrays.fill(hash, "-1");
	}
	
	public int getSize(){	return size;	}
	
	public boolean isEmpty(){	return size==0;	}
	
	public boolean isFull(){	return size==hash.length;	}
	
	public float factorCarga(){	return size/hash.length;	}
	
	public int procPos(T i){	return Math.abs(i.hashCode()) % hash.length;	}
	public int procPos(int i){	return i % hash.length;	}

	public int getFullSize(){	return hash.length;	}
	
	
	public void makeEmpty(){
		for(int i=0; i<hash.length; i++){
			hash[i]=null;
		}
	}
		
	public String toString(){
		String abc = "";
		for(int i=0; i<hash.length; i++){
			if(hash[i]=="-1"){
				abc+= i+" | \n";
			}else{
				abc+= i+" | " + hash[i] + "\n";
			}
		}
		return abc;
	}
	
}
