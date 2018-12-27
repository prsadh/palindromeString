package com.example.palindromeString;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static int isPalindrome(String input) {
        int n = input.length();
        for (int i=0;i<(n / 2) + 1;++i) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                return 0;
            }
        }
        return 1;
    }

    public static List<List<String>> getLeafNodes(Tree<List<String>> tree, List<List<String>> output) {
        if(output == null) {
            output = new ArrayList<>();
        }

        if(tree == null) {
            output = null;
        } else if (tree.getChildren().size() == 0) {
            output.add(tree.getData());
        } else {
            for(Tree<List<String>> item : tree.getChildren()) {
                getLeafNodes(item,output);
            }
        }

        return output;
    }

    public static int getCountPalindrome(List<List<String>> leafNodes) {
        int countPalindrome = 0;
        for(List<String> item : leafNodes) {
            for(String str : item) {
                countPalindrome += Util.isPalindrome(str);
            }
        }
        return countPalindrome;
    }
}
