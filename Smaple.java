#Hashing-1
// Approach:
// 1. Create a map to store the sorted word as key and list of anagrams as value.   
// 2. Iterate through the array of strings and sort each word.      
// 3. If the sorted word is not present in the map, add it to the map.
// 4. If the sorted word is present in the map, add the word to the list of anagrams.
// 5. Return the list of anagrams.

##Problem 1:Given an array of strings,group anagrams together.

Example:Input:["eat","tea","tan","ate","nat","bat"],Output:[["ate","eat","tea"],["nat","tan"],["bat"]]

Note:All inputs will be in lowercase.The order of your output does not matter.

class Solution {
    public List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String word : words) {
            char[] wordtochar = word.toCharArray();
            Arrays.sort(wordtochar);
            String sortedword = new String(wordtochar);
            if (!anagram.containsKey(sortedword)) {
                anagram.put(sortedword, new ArrayList<>());
            }
            anagram.get(sortedword).add(word);

        }
        return new ArrayList<>(anagram.values());

    }}

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    ##Problem 2:
    // Approach:
    // 1. Create two maps to store the character mapping from s to t and from t to
    // s.
    // 2. Iterate through the strings and check if the character mapping is
    // consistent.
    // 3. If the character mapping is consistent, return true.
    // 4. If the character mapping is not consistent, return false.

    Given two
    strings s
    and t, determine if
    they are
    isomorphic.
Two strings
    are isomorphic if
    the characters
    in s
    can be
    replaced to
    get t.
    All occurrences
    of a
    character must
    be replaced
    with another character while
    preserving the
    order of
    characters.No two
    characters may
    map to
    the same
    character but
    a character
    may map
    to itself.

    Example 1:Input:s="egg",t="add"Output:true

    Example 2:Input:s="foo",t="bar"Output:false

    Example 3:Input:s="paper",t="title"Output:true Note:
You may
    assume both
    s and
    t have
    the same length.

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Character> stot = new HashMap<>();
            Map<Character, Character> ttos = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sch = s.charAt(i);
                char tch = t.charAt(i);
                if (stot.containsKey(sch)) {
                    if (!stot.get(sch).equals(tch)) {
                        return false;
                    }
                } else {
                    if (ttos.containsKey(tch)) {
                        return false;
                    }
                }

                stot.put(sch, tch);
                ttos.put(tch, sch);

            }

            return true;
        }
}

// Time Complexity: O(n)
// Space Complexity: O(n)

##Problem 3:
// Approach:
// 1. Create a map to store the character as key and word as value.
// 2. Iterate through the pattern and the string.
// 3. If the character is not present in the map, add it to the map.
// 4. If the character is present in the map, check if the word is present in
// the map.
// 5. If the word is present in the map, return false.
// 6. If the word is not present in the map, add it to the map.
// 7. If the pattern and the string are not isomorphic, return false.

Given a
pattern and
a string str,find if
str follows
the same
pattern.Here follow
means a
full match, such
that there
is a
bijection between
a letter
in pattern
and a non-empty word
in str.

Example 1:Input:pattern="abba",str="dog cat cat dog"Output:true

Example 2:Input:pattern="abba",str="dog cat cat fish"Output:false

Example 3:Input:pattern="aaaa",str="dog cat cat dog"Output:false

Example 4:Input:pattern="abba",str="dog dog dog dog"Output:false Notes:
You may
assume pattern
contains only
lowercase letters, and
str contains
lowercase letters
that may
be separated
by a
single space
.

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // If the number of words doesn't match the number of pattern letters, return
        // false
        if (pattern.length() != words.length) {
            return false;
        }

        // Create two HashMaps to store the mappings
        Map<Character, String> letterToWord = new HashMap<>();
        Map<String, Character> wordToLetter = new HashMap<>();

        // Go through each character in pattern and corresponding word in s
        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = words[i];

            // Check if the letter is already mapped to a word
            if (letterToWord.containsKey(letter)) {
                // If yes, it must match the current word
                if (!letterToWord.get(letter).equals(word)) {
                    return false;
                }
            } else {
                // If the word is already mapped to some other letter, return false
                if (wordToLetter.containsKey(word)) {
                    return false;
                }

                // Create new mappings in both maps
                letterToWord.put(letter, word);
                wordToLetter.put(word, letter);
            }
        }

        // If we reached here, pattern matches the string
        return true;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
