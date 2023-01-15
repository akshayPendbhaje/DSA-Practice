/*
**************** Problem Description ****************
Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i] frequency.
Your task is to build the Huffman tree print all the huffman codes in preorder traversal of the tree.
Note: If two elements have same frequency, then the element which occur at first will be taken on the left of Binary Tree and other one to the right.


    Example : 1

    S = "abcdef"
    f[] = {5, 9, 12, 13, 16, 45}

    Output:
    0 100 101 1100 1101 111

    Explanation:
    HuffmanCodes will be:
    f : 0
    c : 100
    d : 101
    a : 1100
    b : 1101
    e : 111
    Hence printing them in the PreOrder of Binary Tree.

*/
class HuffmanTree implements Comparable<HuffmanTree>
{
    char ch;
    int freq;
    HuffmanTree left;
    HuffmanTree right;

    public HuffmanTree(char ch, int freq)
    {
        this.ch=ch;
        this.freq=freq;
        this.left=null;
        this.right=null;
    }

    public int compareTo(HuffmanTree other)
    {
        if(this.freq == other.freq)
        {
            return 1;
        }
        else
        {
            return this.freq-other.freq;
        }
    }
}
class Solution {

    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        ArrayList<String>  ans = new ArrayList<>();

        PriorityQueue<HuffmanTree> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++)
        {
            pq.add(new HuffmanTree(S.charAt(i),f[i]));
        }

        while(pq.size()>1)
        {
            HuffmanTree first = pq.remove();
            HuffmanTree second = pq.remove();

            HuffmanTree newNode = new HuffmanTree('-',first.freq+second.freq);
            newNode.left=first;
            newNode.right=second;
            pq.add(newNode);

        }

        // StringBuilder sb = new StringBuilder();
        String temp = "";
        preOrder(pq.peek(),ans,temp);
        return ans;
    }

    public void preOrder(HuffmanTree root, ArrayList<String> ans, String temp){
        if(root.left == null && root.right == null){
            ans.add(temp);
            return;
        }
        preOrder(root.left,ans,temp+"0");
        preOrder(root.right,ans,temp+"1");
    }
}

**************** Logic ****************
To build the Huffman Tree:
Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue.
The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root)
Extract two nodes with the minimum frequency from the min heap.
Create a new internal node with a frequency equal to the sum of the two nodes frequencies.
Make the first extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.
Repeat steps #2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.
*/
