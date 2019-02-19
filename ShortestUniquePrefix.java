public class Solution {
    class node{
        Map<Character,node> child;
        int word;
        node(){
            child = new HashMap<>();
            word = 0;
        }
    }
     //public node root;
    public void insert_in_Trie(String s,node root){
        char ch[] = new char[s.length()];
        ch = s.toCharArray();
        node current = root;
        for(int i=0; i<s.length(); i++){
            current.word=current.word + 1;
            node temp = current.child.get(ch[i]);
            if(temp == null){
                temp = new node();
                current.child.put(ch[i],temp);
            }
               current = temp;
        }
    }
    public String pre(String s,node root){
    int n = s.length();
    char ch[] = new char[n];
    ch = s.toCharArray();
    String prefix = "";
    node curr = root;
    int i = 0;
    curr = curr.child.get(ch[i]);
    prefix += ch[i];
    
    for (i = 1; i<n; ++i)
    {
        if (curr.word == 1)
            return prefix;
         curr = curr.child.get(ch[i]);
       prefix += ch[i];
    }
    return prefix;
    }
    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> res = new ArrayList<String>();
        Vector<String> res1 =new Vector<String>();
        if (A.size() == 0)
        return res;
        node root = new node();
        for(int i = 0; i<A.size(); i++){
            if(A.get(i)!=" ")
        insert_in_Trie(A.get(i),root);
        }
       
        for(int i=0; i<A.size(); i++){
        String x =pre(A.get(i),root);
        res.add(x);
        }
    return res;
    }
}
