import java.io.*;
import java.util.StringTokenizer;

public class SpellChecker {
	private HashTableLinear<String> tabel = new HashTableLinear<String>(), notabel = new HashTableLinear<String>(), sugestao = new HashTableLinear<String>();
	private String t, delimiter = " .!,?;:_()[]$-@~/*#&\"";
	private String dictFile, errorFile, docFile;
	
	
	public SpellChecker(String dictFile, String errorFile, String docFile){
		this.dictFile = dictFile;
		this.errorFile = errorFile;
		this.docFile  = docFile;
	}
	
	public void spellChecker(String DocFile){
		try{
			BufferedReader br = new BufferedReader(new FileReader("resources\\"+DocFile));
			StringTokenizer token;
			for(String line; (line = br.readLine()) != null; ){
				token = new StringTokenizer(line, delimiter);
				while (token.hasMoreTokens()){
			        t = token.nextToken();
			        System.out.println("token:   "+t);
			        int a = tabel.procurar(t);
			        if(a==-1){
			        	boolean Q = true;
			        	for(int u=0; u<notabel.getSize(); u++){
			        		if(notabel.hash[u].compareTo(t)==0){
			        			Q=false;
			        			break;
			        		}
			        	}
			        	if(Q){
			        		insertA(notabel, t);// erro na tabela
			        		insertA(notabel, "-1");//separador de erros
			        		addCharacter(t);
			        		removeCharacter(t);
			        		switchCharacter(t);
			        		insertA(sugestao,"-1");// diz o fim das sugestoes
			        	}
			        }
			      }
			}
		}catch(Exception e){
			System.out.println("Erro");
		}
	}
	public void insertA(HashTableLinear<String> a, String x){
		for(int j=0; true; j++){
			if(a.hash[j]!=null){
				a.hash[j] = x;
				break;
			}
		}
	}
	
	public void addCharacter(String a){
		for(int i=0; i<a.length()+1; i++){
			String b = a.substring(0, i);
			String c = a.substring(i, a.length());
			for(char av='a'; av<='z'; av++){
				String g =b+av+c;
				System.out.println(g);
				int z = tabel.procurar(g);
				if(z!=-1){
					insertA(sugestao,g);
				}
			}
			for(char ax='A'; ax<='Z'; ax++){
				String g =b+ax+c;
				int z = tabel.procurar(g);
				if(z!=-1){
					insertA(sugestao,g);
				}
			}
		}
	}
	
	public void removeCharacter(String a){
		for(int i=0; i<a.length(); i++){
			String b = a.substring(0, i);
			String c = a.substring(i+1, a.length());
			int z = tabel.procurar(b+c);
			if(z!=-1){
				insertA(sugestao,b+c);
			}
		}
	}
	
	public void switchCharacter(String a){
		for(int i=0; i<a.length()-1; i++){
			char b = a.charAt(i);
			char c = a.charAt(i+1);
			String b1="";
			if(i!=0){
				b1 = a.substring(0, i);
			}
			String c1 = a.substring(i+2, a.length());
			
			int z = tabel.procurar(b1+c+b+c1);
			if(z!=-1){
				insertA(sugestao,b1+c+b+c1);
			}
		}
	}
	
	public void read(String dictFile){
		try{
			BufferedReader br = new BufferedReader(new FileReader("resources\\"+dictFile));
			for(String line; (line = br.readLine()) != null; ) {
		       tabel.inserir(line);
		    }
		}catch(Exception e){
			System.out.println("Not foud");
		}
	}
	
	public void geraFcheiro(HashTableLinear<String> sug, String errorFile){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\"+errorFile));
			int i=0;
			while(notabel.hash[i]!=null){
				bw.write(notabel.hash[i]+":  ");
				while(sugestao.hash[i]!="-1"){
					bw.write(sugestao.hash[i]+ "; ");
				}
				i+=2;
				bw.newLine();
			}
			bw.flush();
			bw.close();

		} catch (Exception e) {

			System.out.println("Erro");

		}
	}
	
}
