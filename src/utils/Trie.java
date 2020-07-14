package utils;

import java.util.HashMap;
import java.util.Map;

public class Trie
{
    class TrieNode
    {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode()
        {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Trie insert
    // iterative

    public void insert(String word){

        TrieNode current = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    // recursive
    public void insertRecursive(String word){
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int i)
    {
        if(i==word.length()){
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(i);
        TrieNode node = current.children.get(ch);
        if(node ==null)
        {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node,word,i++);
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node==null)
                return false;
            current = node;
        }
      return   current.endOfWord;
    }


    // Delete
    public void delete(String word){
        delete(root, word,0);
    }

    private boolean delete(TrieNode current, String word, int i)
    {
        if(i==word.length()){
            if(!current.endOfWord){
                return false;
            }
            current.endOfWord = false;
            return current.children.size()==0;
        }
        char ch = word.charAt(i);
        TrieNode node = current.children.get(ch);
        if(node==null)
            return false;
        boolean shouldDeleteCurrentNode = delete(node, word, i+1);

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

}
