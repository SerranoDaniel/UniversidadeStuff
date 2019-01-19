	import java.util.Arrays;

public class HashTableDuploHashing<T extends Comparable<T>> extends HashTable<T> {

	public HashTableDuploHashing(){
		super();
	}
	
	public HashTableDuploHashing(int x){
		super(x);
	}
	
	public boolean isPrime(int x){
		if(x%2 == 0){
			return false;
		}
		for(int i=3; i*i<=x; i+=2){
			if(x%i==0){
				return false;
			}
		}
		return true;
	}
	
	public int nextPrime(int x){
		for(int i=x; true; i++){
			if(isPrime(i)){
				return i;
			}
		}
	}
	
	public int hash2(T x){
		return nextPrime(hash.length) - x.hashCode() % nextPrime(hash.length);
	}
	
	public void inserir(T x){
		if(isFull()){
			rehash();
		}
		int index = procPos(x);
		while(hash[index] != "-1"){
			int a, b=1, index2=hash2(x);
			if(hash[index2] == "-1"){
				index=index2;
				break;
			}
			do{
				a = procPos(index + b * index2);
				b++;
			}while(hash[a] != "-1" && a != index && a != index2);
			if(a != index && a != index2){
				index=a;
				break;
			}	
		}
		hash[index] = x;
		size++;	
	}
	
	
	public int procurar(T x){
		if(isEmpty()){
			return -1;
		}
		int index=procPos(x), b=1;
		while(hash[index]!="-1"){
			int y = hash[index].compareTo(x);
			if(y==0){
				return index;
				}
			if(hash[hash2(x)]!="-1"){
				return hash2(x);
				}
			int a = (Math.abs((index + 1) % hash.length));
			while(hash[a] != "-1" && a != index){
				b++;
				a = Math.abs((index + b*b) % hash.length);
			};
			if(x == hash[a]){
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
