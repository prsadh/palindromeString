package com.example.palindromeString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Calculator {

    public void calculatePalindromeThroughTree(int cuts, String input){
        long startTime = System.currentTimeMillis();
        Tree<List<String>> tree = createTree(Arrays.asList(input), "0", cuts, null);
        List<List<String>> leafNodes = Util.getLeafNodes(tree, null);
        int countPalindrome = Util.getCountPalindrome(leafNodes);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Number of palindromes with %d cuts is %d in string %s taking %d ms",
                cuts,countPalindrome,input, endTime - startTime));

    }



    public void calculatePalindromeThroughList(int cuts, String input) {
        long startTime = System.currentTimeMillis();
        List<List<String>> leafNodes = getCombinationArray(Arrays.asList(input), cuts, null);
        int countPalindrome = Util.getCountPalindrome(leafNodes);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Number of palindromes with %d cuts is %d in string %s taking %d ms",
                cuts,countPalindrome,input, endTime - startTime));
    }

    public Tree<List<String>> createTree(List<String> input, String key, int cuts, HashMap<String, Tree<List<String>>> tree) {
        // Default value:
        //              key = 0
        //              tree = null
        Tree<List<String>> root = null;
        int lastIndex = input.size() - 1;
        if(tree == null) {
            root = new Tree<>();
            tree = new HashMap<>();
            root.setData(Arrays.asList(input.get(lastIndex)));
            tree.put(key,root);
        } else {
            root = tree.get(key);
        }
        for(int i = 1; i <= input.get(lastIndex).length() - cuts ; i++ ) {
            List<String> newArr = new ArrayList<>();
            for(int j = 0; j < input.size()-1; j++) {
                newArr.add(input.get(j));
            }
            newArr.add(input.get(lastIndex).substring(0,i));
            newArr.add(input.get(lastIndex).substring(i));
            Tree<List<String>> newNode = new Tree<>(newArr);
            root.addChild(newNode);
            String newKey = key + String.valueOf(i);
            tree.put(newKey,newNode);
            if(cuts - 1 > 0 ) {
                createTree(newArr, newKey,cuts - 1, tree);
            }
        }

        return root;
    }


    public List<List<String>> getCombinationArray(List<String> input, int cuts,
                                                   List<List<String>> outputList) {

        int lastIndex = input.size() - 1;
        if(outputList == null) {
            outputList = new ArrayList<>();
        }
        for(int i = 1; i <= input.get(lastIndex).length() - cuts ; i++ ) {
            List<String> newArr = new ArrayList<>();
            for(int j = 0; j < input.size()-1; j++) {
                newArr.add(input.get(j));
            }
            newArr.add(input.get(lastIndex).substring(0,i));
            newArr.add(input.get(lastIndex).substring(i));
            if(cuts - 1 > 0 ) {
                getCombinationArray(newArr,cuts - 1, outputList);
            } else {
                outputList.add(newArr);
            }
        }

        return outputList;
    }

}
