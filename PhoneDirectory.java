
import java.util.*;
import java.lang.*;
import java.io.*;
class node{
    boolean endOfWord;
    Map<Character,node> map= new HashMap<Character,node>();
    public node(){
        endOfWord = false;
    }
}

class Trie {
     node head;
 
    public void insert_in_trie(String s){
    node curr = head;
       char ch[] = new char[s.length()];
        ch = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            node temp = curr.map.get(ch[i]);
            if(temp == null){
                temp = new node();
                curr.map.put(ch[i],temp);
            }
            curr = temp;
        } 
        curr.endOfWord = true;
    }
    public void search1(String s,node curr){
        if (curr.endOfWord == true) 
            System.out.print(s+" "); 
        
        for (char i = 'a'; i <= 'z'; i++) 
        { 
            node temp = curr.map.get(i); 
            if (temp != null) 
            { 
                search1(s + i,temp); 
            } 
        } 
    }
    public void search(String s){
        node prev = head;
        String pre = "";
        char ch[] = new char[s.length()];
        ch = s.toCharArray();
        int i=0;
        for( i=0; i<s.length(); i++){
            pre = pre+ch[i];
            node curr = prev.map.get(pre.charAt(i));
            if(curr == null){
            i++;
            System.out.println("0");
            break;
            }
            search1(pre,curr);
            System.out.println();
            prev = curr;
        }
        for(;i<s.length();i++)
                System.out.println("0");
    }

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0){
		    int n = sc.nextInt();
            sc.nextLine();
		    String s = sc.nextLine();
		    String[] arr = s.split(" ");
		    String query = sc.nextLine();
		    Trie obj = new Trie();
		    obj.head = new node();
		    for(int i=0; i<n; i++)
		    obj.insert_in_trie(arr[i]);
		    obj.search(query);
		    t--;
		}
	}
}