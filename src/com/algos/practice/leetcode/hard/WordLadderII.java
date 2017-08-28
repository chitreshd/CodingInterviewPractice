package com.algos.practice.leetcode.hard;

import java.util.*;
/**
 * Created by cdeshpande on 8/28/17.
 * Problem:
 * Given two words (beginWord and endWord), and a dictionary's word list, <u>find all</u> shortest transformation sequence
 * (s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.

 Solution:
 Create paths by using character iteration
 Use BFS to traverse these paths
 Maintain a map of word: List of "from". ( this helps in generating all lists through
 backtracking)
 In BFS, its important to check if a node is visited before adding it to the "queue"
 (Its different from DFS where we check visit condition after popping item from stack )

 Mistakes:
 Timeout error: One optimization I didn't consider is using Dijisktra's search.
 Although nobody would ask me to code, but it would be worth mentioning.
 https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj


 */
public class WordLadderII {

    /*
    Solution:
    BFS

    getAllTransformations(word)
    check while adding to the queue

     */

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            Set<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Map<String,String> visited = new HashMap<>();
        queue.add(beginWord);

        return null;
        // TODO: Complete this solution
        // Aug 28: Not coding this because it requires more time. Only enlisting
        // important improvements.
    }

}
