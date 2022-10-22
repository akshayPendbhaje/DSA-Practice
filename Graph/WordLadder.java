/*
**************** Problem Description ****************
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

    Example : 1

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5

    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.


    Example : 2

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0

    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if(!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int ans=0;
        while(!q.isEmpty())
        {
            int qSize= q.size();
            for(int i=0;i<qSize;i++)
            {
                String current = q.remove();
                if(endWord.equals(current)) return ans+1;
                for(int j=0;j<current.length();j++)
                {
                    char[] currentWordChar= current.toCharArray();
                    for(char ch= 'a' ; ch <='z' ; ch++)
                    {
                        // if(ch== current.charAt(j)) continue;
                        currentWordChar[j]=ch;

                        String newWord=String.valueOf(currentWordChar);
                        //if(endWord.equalsIgnoreCase(newWord)) return ans+1;
                        if(words.contains(newWord) ) {
                            q.add(newWord);
                            words.remove(newWord);
                        }
                    }
                }

                //wordList.remove(current);
            }

            ans++;
        }

        return 0;
    }

}

/*
**************** Logic ****************
Create a graph considering each word as a node whose neighbours are words that differs by a single letter.
Now we can use BFS to find the shortest transformation(path) from beginWord to endWord.
For further optimization we can use Bidirectional Search.
The idea behind bidirectional search is to run two simultaneous searches—one forward from the initial state and the other backward from the goal—hoping that the two searches meet in the middle.
The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth.
*/