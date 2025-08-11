package com.algos.practice.leetcode.hard;

import com.algos.practice.util.Pair;

import java.util.*;

/**
 * Created by cdeshpande on 12/4/16.
 */
public class TextJustification {


    public static final String SPACE = " ";

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();

        List<String> currentLine = new ArrayList<>();
        int spaceTaken = 0;

        for(String word : words) {

            if( (word.length() + spaceTaken + getNumOfWordsConsidered(currentLine)) > maxWidth ) {
                // max width reached, format the line and create a new one.
                String justifiedLine = justify(currentLine, maxWidth, spaceTaken);
                lines.add(justifiedLine);
                currentLine = new ArrayList<>();
                spaceTaken = 0;
            }

            spaceTaken += word.length();
            currentLine.add(word);

        }

        if( !currentLine.isEmpty() ) {
            String leftAligned = leftAlign(currentLine, maxWidth);
            lines.add(leftAligned);
        }

        return lines;
    }

    private int getNumOfWordsConsidered(List<String> currentLine) {
        return currentLine.size();
    }

    private String justify(List<String> currentLine, int maxWidth, int spaceTaken) {
        int availableSpace = maxWidth - spaceTaken;

        int spacePerSlot = 0;
        if (currentLine.size() > 1) {
            spacePerSlot =  availableSpace / ( currentLine.size() - 1 ) ;
        }

        char [] line = new char[maxWidth];
        int pointer = maxWidth;
        Collections.reverse(currentLine);
        String lastWord = currentLine.remove(currentLine.size() - 1);

        for(String word : currentLine) {
            int wordSize = word.length();
            int start = pointer - wordSize;
            System.arraycopy(word.toCharArray(), 0, line, start, word.length());
            pointer = start;
            int spaceStart = pointer - spacePerSlot;
            addSpaces(line, spacePerSlot, spaceStart);
            pointer = spaceStart;
        }
        int remainingSpaces = pointer - lastWord.length();
        addSpaces(line, remainingSpaces, pointer - remainingSpaces);
        System.arraycopy(lastWord.toCharArray(), 0, line, 0, lastWord.length() );
        return new String(line);
    }

    private void addSpaces(char [] lineArray, int spacesTobeAdded, int startPos) {
        if(startPos > lineArray.length - 1) {
            return;
        }
        for(int i = 0; i < spacesTobeAdded; i++) {
            lineArray[startPos] = ' ';
            startPos++;
        }
    }

    private String leftAlign(List<String> currentLine, int maxWidth) {
        char [] line = new char[maxWidth];
        int pointer = 0;
        for(String word : currentLine) {
            System.arraycopy(word.toCharArray(), 0, line, pointer, word.length() );
            pointer += word.length();
            addSpaces(line, 1, pointer);
            pointer++;
        }
        addSpaces(line, maxWidth - pointer, pointer);
        return new String(line);
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        usecase2(textJustification);
        usecase1(textJustification);
    }

    private static void usecase1(TextJustification textJustification) {
        String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
        List<String> justified = textJustification.justifyBreaks(Arrays.asList(words), 30);
        for(String line : justified) {
            System.out.println(line);
        }
    }

    private static void usecase2(TextJustification textJustification) {
        String[] words = {"it","was","here","first."};
        List<String> justified = textJustification.justifyBreaks(Arrays.asList(words), 6);
        for(String line : justified) {
            System.out.println(line);
        }
    }


    // Code based on MIT lecture: https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-20-dynamic-programming-ii-text-justification-blackjack/

    protected List<String> justifyBreaks(List<String> words, int maxWidth) {
        Map<Integer, Pair<Integer, Integer>> results = new HashMap<>();
        System.out.println("calculating breaks");
        Pair<Integer, Integer> resultFor0 = doJustifyBreak(words, 0, maxWidth, results);
        System.out.println("forming sentences");
        System.out.println(results);
        List<String> sentences = construct(words, results);

        return sentences;
    }

    private List<String> construct(List<String> words,
                                   Map<Integer, Pair<Integer, Integer>> results) {
        int start = 0;
        Integer end = results.get(start).snd;
        List<String> sentences = new ArrayList<>();

        while(end != null) {
            String sentence = parse(words, start, end);
            sentences.add(sentence);
            start = end;
            end = results.get(start).snd;
        }

        String lastSentence = parse(words, start, words.size());
        sentences.add(lastSentence);
        return sentences;
    }

    private String parse(List<String> words, int start, int end) {
        StringBuffer buffer = new StringBuffer();
        for(int i = start; i < end - 1; i++) {
            buffer.append(words.get(i));
            buffer.append(SPACE);
        }
        buffer.append(words.get(end - 1));
        return buffer.toString();
    }

    protected Pair<Integer, Integer> doJustifyBreak(List<String> words,
                                 int i,
                                 int maxWidth,
                                 Map<Integer, Pair<Integer, Integer>> results) {

        if(i == words.size() - 1) {
            Pair<Integer, Integer> result = new Pair<>(0, null);
            results.put(i, result);
            return result;
        }

        if(results.containsKey(i)) {
            return results.get(i);
        }

        int minS = Integer.MAX_VALUE;
        int parentPointer = -10; // some negative value representing invalid value.
        int pathWidth = 0;

        for(int j = i + 1; j < words.size(); j++) {



            //int badness = calculateBadness(pathWidth, words.get(j), maxWidth);
            int badness = calculateBadness(i, j, words, maxWidth);
            if(badness == Integer.MAX_VALUE)
                break;

            Pair<Integer, Integer> subProbResult = doJustifyBreak(words, j, maxWidth, results);
            int score = subProbResult.fst + badness;

            if(score < minS) {
                minS = score;
                parentPointer = j;
            }
        }

        Pair<Integer, Integer> result = new Pair<>(minS, parentPointer);
        results.put(i, result);
        return result;
    }

    protected int calculateBadness(int i, int j, List<String> words, int maxWidth) {
        //Number of gaps
        int gaps = j - i - 1;

        int totalLength = 0;
        // length
        for(int k = i; k < j; k++) {
            totalLength += words.get(k).length();
        }

        totalLength += gaps;

        if(totalLength > maxWidth) {
            return Integer.MAX_VALUE;
        } else {
            return (int) Math.pow((maxWidth - totalLength), 3);
        }


    }
    protected int calculateBadness(int pathWidth, String s, int maxWidth) {
        int newPathWidth = pathWidth + s.length() + 1;
        return newPathWidth > maxWidth ? Integer.MAX_VALUE : newPathWidth;
    }

}
