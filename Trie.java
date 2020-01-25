// https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary/
import java.util.*;
import java.io.*;

class Trie
{
    Trie[] children;
    boolean isEnd;
    List<String> word;
    public Trie()
    {
        List<String> word = new ArrayList<>();
        this.children = new Trie[26];
        Arrays.fill(children,null);
    }
    public void insert(Trie root,String s)
    {
        Trie pcrawl = root;
        for(char c:s.toCharArray())
        {
            if(Character.isLowerCase(c))
                continue;
            int index = c - 'A';
            if(pcrawl.children[index]==null)
                pcrawl.children[index] = new Trie();
            pcrawl = pcrawl.children[index];
        }
        pcrawl.isEnd = true;
        pcrawl.word.add(s);
    }
    public boolean search(Trie root,String pattern)
    {
        Trie pcrawl = root;
        for(char c:pattern.toCharArray())
        {
            int index = c-'A';
            if(pcrawl.children[index]==null)
                return false;
            pcrawl = pcrawl.children[index];
            
        }
        printAllWords(pcrawl);
        return true;
    }
    public void printAllWords(Trie root)
    {
        if(root.isEnd==true)   
        {
            for(String s:root.word)
                System.out.print(s+" ");
        }
        else
        {
            for(int i=0;i<26;i++)
            {
                Trie child = root.children[i];
                if(child!=null)
                    printAllWords(child);
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
		    "Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"
		};
		String pattern = "HT";
		findAllWords(dictionary,pattern);
	}
}