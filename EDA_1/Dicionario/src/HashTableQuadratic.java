import java.util.Arrays;

public class HashTableQuadratic<T extends Comparable<T>> extends HashTable<T> {
	
	public HashTableQuadratic(){
		super();
	}
	
	public HashTableQuadratic(int n) {
		super(n);
	}
	
	
	public void inserir(T x){
		if(isFull()){
			rehash();
		}
		int index=procPos(x), b=1;
		if(hash[index] == null){
			hash[index] = x;
			size++;
		} else {
			int a = (Math.abs((index + 1) % hash.length));
			while(hash[a] != "-1" && a != index){
				b++;
				a = Math.abs((index + b*b) % hash.length);
			};
			if(a != index){
				hash[a] = x;
				size++;
			}
		}
	}
	
	public int procurar(T key){
		if(isEmpty()){
			return -1;
		}
		int index = procPos(key), b=1;
		while(hash[index] != "-1"){
			if(hash[index]==key){
				return index;
			}
			int a = (Math.abs((index + 1) % hash.length));
			while(hash[a] != "-1" && a != index){
				b++;
				a = Math.abs((index + b*b) % hash.length);
			};
			if(key == hash[a]){
				return a;
				}
			break;
		}
		return -1;
	}
	
	public void rehash(){
		T[] newHash = (T[]) new Object[getFullSize()*2];
		T[] oldHash = hash;
		hash = newHash;
		Arrays.fill(newHash, "-1");
		T obj;
		for(int i=0; i<getFullSize(); i++){
			obj=oldHash[i];
			if(obj != "-1"){
				inserir(obj);
			}
		}		
	}
	
	
}
