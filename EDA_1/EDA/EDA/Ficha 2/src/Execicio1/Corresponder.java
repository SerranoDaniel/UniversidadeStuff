package Execicio1;

public class Corresponder {
	private int size, i;
	private	ArrayStack<Character> stack = new ArrayStack<Character>(size);
	private String array;
	private boolean corr=true;
	
	public Corresponder(String array){
		this.array = array;
		size = array.length();
	}
	private boolean abrir(char c){
		if(c=='(' || c=='{' || c=='['){
			return true;
		}else{
			return false;
		}
	}	
	private boolean check(char c){
		switch(stack.top()){
		case '(': 
			if(c==')'){
				return true;
			}else{
				return false;
			}
		case '[':
			if(c==']'){
				return true;
			}else{
				return false;
			}
		case '{':
			if(c=='}'){
				return true;
			}else{
				return false;
			}
		default: return false;
		}
	}
	private void addStack(char c){
		if(stack.empty()){
			stack.push(c);
		}else if(abrir(c)){
			stack.push(c);
		}else{
			if(check(c)){
				stack.pop();
			}else{				
				corr = false;
			}
		}
	}
	private void runStack(){
		while(array.charAt(i)!='(' || array.charAt(i)!='{' || array.charAt(i)!='[' || array.charAt(i)!=')'
				|| array.charAt(i)!='}' || array.charAt(i)!=']'){
			
			i++;
		}
		addStack(array.charAt(i));
	}
	private void ruuAll(){
		i = 0;
		while(corr && i!=array.length()){
			runStack();
		}
		if(corr){
			System.out.println("Done");
		}else{
			System.out.println("Não corresponde");
		}
	}
	
	public static void main(String[] args) {
		String str = "(12+6-4)+5{78(f)}";
		Corresponder cor = new Corresponder(str);
		cor.ruuAll();
	}
}
