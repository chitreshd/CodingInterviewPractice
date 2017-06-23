package com.algos.practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cdeshpande on 12/4/16.
 */
public class TextJustification {


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
        String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
        List<String> justified = textJustification.fullJustify(words, 30);
        for(String line : justified) {
            System.out.println(line);
        }
    }

}
