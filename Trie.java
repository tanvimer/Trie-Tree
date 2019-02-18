import java.util.*;
import java.lang.*;
import java.io.*;

class Trie {
    class node{
        Map<Character,node> child;
        boolean endOfWord;
        node(){
            child = new HashMap<>();
            endOfWord = false;
        }
    }
    public node root;
    public void insert_in_Trie(String s){
        char ch[] = new char[s.length()];
        ch = s.toCharArray();
        node current = root;
        for(int i=0 ; i<s.length();i++){
            node temp = current.child.get(ch[i]);
            if(temp == null){
                temp = new node();
                current.child.put(ch[i],temp);
            }
               current = temp;
        }
            current.endOfWord = true;
    }
    public boolean search_in_Trie(String search){
         char ch[] = new char[search.length()];
         ch = search.toCharArray();
         node current = root;
         for(int i=0 ; i<search.length(); i++){
             node temp = current.child.get(ch[i]);
             if(temp == null)
             return false;
             current = temp;
         }
         return current.endOfWord;
    }
	public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   while(t != 0){
	       int n = sc.nextInt();
	       sc.nextLine();
	       Trie obj = new Trie();
		   obj.root = obj.new node();
		     String str = sc.nextLine();
		    String[] arr = str.split(" ");
	       for(int i=0 ; i<n ; i++){
	          obj.insert_in_Trie(arr[i]);
	       }
	       String search = sc.nextLine();
	       if(obj.search_in_Trie(search) == true)
	       System.out.println("1");
	       else
	       System.out.println("0");
	       t--;
	   }
	}
}