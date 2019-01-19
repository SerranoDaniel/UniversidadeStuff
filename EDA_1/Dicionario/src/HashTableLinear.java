import java.util.Arrays;

public class HashTableLinear<T extends Comparable<T>> extends HashTable<T> {

	public HashTableLinear(){
		super();
	}
	
	public HashTableLinear(int x){
		super(x);
	}
	
	public void inserir(T valor){
		if(isFull()){
			rehash();
		}
		int index = procPos(valor);
		while(hash[index] != "-1"){
			index++;
			index %= getFullSize();
		}
		hash[index] = valor;
		size++;
	}
	
	public int procurar(T key){
		if(isEmpty()){
			return -1;
		}
		int index = procPos(key);
		while(hash[index] != "-1"){
			
			int a = hash[index].compareTo(key);
			if(a==0){
				return index;
			}
			++index;
			index %= getFullSize();
		}
		return -1;
	}
	
	public void rehash(){
		T[] newHash = (T[]) new Comparable[getFullSize()*2];
		T[] oldHash = hash;
		hash = newHash;
		Arrays.fill(hash, "-1");
		T obj;
		for(int i=0; i<getFullSize(); i++){
			obj=oldHash[i];
			if(obj != "-1"){
				inserir(obj);
			}
		}		
	}
}
