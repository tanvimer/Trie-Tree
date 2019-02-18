public class Solution {
    public class TrieNode{
        Map<Character,TrieNode> child;
        boolean endOfWord;
        TrieNode(){
            endOfWord = false;
            child = new HashMap<>();
        }
    }
    public class pair{
        int x;
        int y;
     pair(int x,int y){
         this.x=x;
         this.y=y;
     }   
    }
    TrieNode root;
    public void insert(String s){
        char ch[] = new char[s.length()];
        ch=s.toCharArray();
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            TrieNode temp = curr.child.get(ch[i]);
            if(temp == null){
                temp = new TrieNode();
                curr.child.put(ch[i],temp);
            }
            curr = temp;
        }
        curr.endOfWord = true;
    }
    public boolean search(String s){
        char ch[] = new char[s.length()];
        ch=s.toCharArray();
        TrieNode curr = root;
        for(int i=0 ; i<s.length() ; i++){
            TrieNode temp = curr.child.get(ch[i]);
            if(temp == null)
            return false;
            curr =  temp;
        }
        return curr.endOfWord;
    }
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        String search[]=A.split("_");
        root = new TrieNode();
        for(int i = 0; i<search.length ; i++)
        insert(search[i]);
    ArrayList<pair> result = new ArrayList<pair>();
    ArrayList<Integer> result1 = new ArrayList<Integer>();
        for(int i=0;i<B.size();i++){
            String s = B.get(i);
            String  arr[] = s.split("_");
            int match = 0;
            for(int j=0;j<arr.length;j++){
                boolean res = search(arr[j]);
                if(res == true)
                match++;
            }
            result.add(new pair(i,match));
           // result1.put(i,match);
        }
        Collections.sort(result,new Comparator<pair>(){ public int  compare (pair l, pair r) {
   return -1*((Integer)l.y).compareTo((Integer)r.y);
}
});
        for(int i=0;i<result.size();i++)
        result1.add(result.get(i).x);
        return result1;
    }
}