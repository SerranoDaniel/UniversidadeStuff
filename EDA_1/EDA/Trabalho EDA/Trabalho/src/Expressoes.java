import java.util.Scanner;

public class Expressoes {
	private DoublyLinkedList<String> list = new DoublyLinkedList<String>();
	private Scanner scan = new Scanner(System.in);
	private Stack<String> operator = new Stack<String>(100);
	private DoublyLinkedList<String> postfix = new DoublyLinkedList<String>();
	private DoublyLinkedList<Integer> num = new DoublyLinkedList<Integer>();
	private DoublyLinkedList<String> op = new DoublyLinkedList<String>();
	private BinaryTree<String> abp = new BinaryTree<String>();
	
	private String scanExp(){
		System.out.println("Insira a expressão:");
		return scan.nextLine()+";";
	}
	private void insertIntoDoubleLinkedList(String abc){
		for(int i=0; i<abc.length()-1; i++){
			try{
				Integer.parseInt(""+abc.charAt(i));
				int b=i;
				for(int j=b; j<abc.length(); j++){
					if(abc.charAt(j)=='+'||abc.charAt(j)=='-'||abc.charAt(j)=='/'||abc.charAt(j)=='*'||abc.charAt(j)=='('||abc.charAt(j)==')'||abc.charAt(j)==';'){
						b=j;
						break;
					}					
				}
				list.add(abc.substring(i, b));
				i=b-1; 
			}catch (Exception e) {
				list.add("" + abc.charAt(i));
			}
		}
	}
	private int prioridade(String s){
		if(s.equals("*")||s.equals("/")){
			return 2;
		}else if(s.equals("-")||s.equals("+")){
			return 1;
		}else{
			return 0;
		}
	}
	private void convert(){
		for(int i=0;i<list.size();i++){
			try{
				Integer.parseInt(list.get(i));
				postfix.add(list.get(i));
			}catch(Exception e){
				if(list.get(i).equals("(")){
					operator.push("(");
				}else if (list.get(i).equals(")")){
					while (!operator.top().equals("(")){
						postfix.add(operator.pop());
					}
					operator.pop();
				}else{
					if(operator.empty() || prioridade(list.get(i))>prioridade(operator.top())){
						 operator.push(list.get(i));
					}else{
						while(operator.empty()==false && prioridade(operator.top())>=prioridade(list.get(i))){
							postfix.add(operator.pop());
						}
						operator.push(list.get(i));
					}			 
				}
			}
		}
		while (!operator.empty()){
			postfix.add(operator.pop());
		}
	}
	
	private void insertTree(){
		for(int i=0; i<postfix.size(); i++){
			abp.insert(postfix.get(i));
		}
	}

	private float count(float a, String b, float c){
		if(b.equals("+")){
			return a+c;
		}else if(b.equals("-")){
			return a-c;
		}else if(b.equals("*")){
			return a*c;
		}else if(b.equals("/")){
			return a/c;
		}
		return 0;
	}
	private float getResult(Node<String> n){
		if (n.left!=null && n.right!=null){
			op.add(n.data);
			
			float esq = (getResult(n.left));
			float dir = (getResult(n.right));
			float val = 0;
			val = count(esq, n.data, dir);
			return val;
		}
		num.add(Integer.parseInt(n.data));
		return Integer.parseInt(n.data);
	}
	public DoublyLinkedList<Integer> getOperandos(){
		return num;
	}
	public DoublyLinkedList<String> getOperadores(){
		return op;
	}

	public static void main(String[] args) {
		Expressoes m = new Expressoes();
				
		m.insertIntoDoubleLinkedList(m.scanExp());	
		
		m.convert();
		m.insertTree();
		System.out.println("Postfiix: "+m.postfix);
		System.out.println("Resultado: "+m.getResult(m.abp.getRaiz()));

		System.out.println("Operandos:" + m.getOperandos());
		System.out.println("Operadores: "+m.getOperadores());
		
		m.abp.draw("A");
	}
}
