// https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary/
import java.util.*;
import java.io.*;

class Trie
{
    Trie[] children;
    List<String> word;
    boolean isEnd;
    public Trie()
    {
        this.word = new ArrayList<>();
        this.children = new Trie[26];
        isEnd = false;
        Arrays.fill(children,null);
    }
    public void insert(Trie root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isLowerCase(c))
                continue;
            int index = c - 'A';
            if(root.children[index]==null)
                root.children[index] = new Trie();
            root = root.children[index];
            root.word.add(s);
        }
        root.isEnd = true;
    }
    public boolean search(Trie root,String pattern)
    {
        for(int i=0;i<pattern.length();i++)
        {
            char c = pattern.charAt(i);
            int index = c - 'A';
            if(root.children[index]==null)
                return false;
            root = root.children[index];
        }
        printAllWords(root);
        return true;
      
       
    }
    public void printAllWords(Trie root)
    {
        if(root.isEnd)   
        {
           for(String s:root.word)
            System.out.println(s);
        }
        else
        {
            for(int i=0;i<26;i++)
            {
                if(root.children[i]!=null)
                    printAllWords(root.children[i]);
            }
        }
    }
}
class GFG {
    public static void findAllWords(String[] dictionary,String pattern)
    {
        Trie root = new Trie();
        for(String s:dictionary)
            root.insert(root,s);
        if(!root.search(root,pattern))
            System.out.println("Not Found");
    }
	public static void main (String[] args) {
	    
		String[] dictionary = {
		    "Hi", "Hello", "HelloWorld", "HiTech", "HighTea", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"
		};
		String pattern = "HTL";
// 		String pattern = "HT";
// 		String pattern = "H";
// 		String pattern = "HW";
		findAllWords(dictionary,pattern);
	}
}