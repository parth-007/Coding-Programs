import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
    static int m,n;
    static final int MAX_CHAR = 26;
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[MAX_CHAR];
        boolean isEnd;
        TrieNode()
        {
            isEnd = true;
            for(int i=0;i<MAX_CHAR;i++)
            {
                children[i] = null;
            }
        }
    }
    
    public static void insert(TrieNode root,String key)
    {
        int index;
        TrieNode pcrawl = root;
        int length = key.length();
        for(int i=0;i<length;i++)
        {
            index = key.charAt(i) - 'A';
            if(pcrawl.children[index]==null)
                pcrawl.children[index] = new TrieNode();
            pcrawl = pcrawl.children[index];
        }
        pcrawl.isEnd = true;
    }
    // static boolean search(String key)
    // {
    //     int index;
    //     TrieNode pcrawl = root;
    //     int length = key.length();
    //     for(int i=0;i<length;i++)
    //     {
    //         index = key.charAt(i) - 'A';
    //         if(pcrawl.children[index]==null)
    //             return false;
    //         pcrawl = pcrawl.children[index];
    //     }
    //     return (pcrawl.isEnd && pcrawl!=null);
    // }
    
    public static void findWords(char[][] ch,TrieNode root,String[] keys)
    {
        TrieNode pcrawl = root;
        boolean[][] visited = new boolean[m][n];
        String str = "";
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pcrawl.children[ (ch[i][j]) -'A' ] != null)
                {
                    str += ch[i][j];
                    SearchWord(pcrawl.children[(ch[i][j])-'A'],ch,i,j,visited,str,keys);
                    str="";
                }   
            }
        }
    }
    public static boolean isWord(String s,String[] keys)
    {
        for(int i=0;i<keys.length;i++)
        {
            if(keys[i].equals(s))
                return true;
        }
        return false;
    }
    static void SearchWord(TrieNode root,char[][] ch,int i,int j,boolean[][] visited,String s,String[] keys)
    {
        if(root.isEnd == true)
        {
            if(isWord(s,keys))
            System.out.print(s+" ");
        }
        if(isSafe(i,j,visited))
        {
            visited[i][j] = true;
            for(int k=0;k<MAX_CHAR;k++)
            {
                if(root.children[k]!=null)
                {
                    char ch1 = (char)(k+'A');
                    if(isSafe(i,j-1,visited) && ch[i][j-1]==ch1)
                        SearchWord(root.children[k],ch,i,j-1,visited,s+ch1,keys);
                    if(isSafe(i+1,j,visited))
                        SearchWord(root.children[k],ch,i+1,j,visited,s+ch1,keys);
                }
            }
            visited[i][j] = false;
        }
    }   
    public static boolean isSafe(int i,int j,boolean[][] visited)
    {
        return (i>=0 && j>=0 && i<m && j<n && !visited[i][j]);
    }
	public static void main (String[] args) throws Exception
	 {
	     TrieNode root = new TrieNode();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0)
	    {
	        int dwords = Integer.parseInt(br.readLine());
	        String[] keys = new String[dwords];
	        String[] s = br.readLine().trim().split("\\s+");
	        for(int i=0;i<dwords;i++)
	        {
	            keys[i] = s[i];
	            insert(root,keys[i]);
	        }
	        String[] ip = br.readLine().trim().split("\\s+");
	        m = Integer.parseInt(ip[0]);
	        n = Integer.parseInt(ip[1]);
	        char[][] ch = new char[m][n];
	        String[] k = br.readLine().trim().split("\\s+");
	        int c = 0;
	        for(int i=0;i<m;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                ch[i][j] = k[c].charAt(0);
	                c++;
	            }
	        }
	        findWords(ch,root,keys);   
	    }
	    
	 }
}