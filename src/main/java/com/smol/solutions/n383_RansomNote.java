package com.smol.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>383. Ransom Note
 * </h1>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class n383_RansomNote {

    /**
     * Hashmap solution
     * 14 ms runtime 44 MB memory
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        //  - check if magazine has enough chars
        if (ransomNote.length() > magazine.length()) return false;
        // count cars with hashmap , char = key, count = value
        Map<Character, Integer> mapCharCount = new HashMap<>();
        //  - count individual chars in magazine e.g. for aab => (a, 2), (b, 1)
        for (char c : magazine.toCharArray()) {
            //gets the value of the key aka character if it exists in map or 0 if it doesn't, then it increments the value by 1.
            mapCharCount.put(c, mapCharCount.getOrDefault(c, 0) + 1);
        }
        //  - subtract individual chars their counts
        for (char c : ransomNote.toCharArray()) {
            //if the value of the key aka character is greater than 0, then it decrements the value by 1.
            if (mapCharCount.getOrDefault(c, 0) > 0) {
                mapCharCount.put(c, mapCharCount.get(c) - 1);
            } else return false;
        }
        return true;
    }


    /**
     * By using Ascii English Alphabets
     * 1 ms runtime 44 MB memory
     */
    public boolean canConstructASCII(String ransomNote, String magazine) {
        // check if magazine has enough chars
        if (ransomNote.length() > magazine.length()) return false;
        // count individual chars in magazine.
        int[] alphabetsCounter = new int[26];

        for (char c : magazine.toCharArray())
            alphabetsCounter[c - 'a']++; // `a` = 97 in ASCII so e.g. b= 98, b - a = 98 - 97 = 1

        for (char c : ransomNote.toCharArray()) {
            if (alphabetsCounter[c - 'a'] == 0) return false;
            alphabetsCounter[c - 'a']--;
        }
        return true;
    }
}

/*
* So, What we doing here is... First we will initialize an array of alphabets counter.
Let's initialize with the size 24. noo... Its 26, you forgot the number of alphabets in English?
Jokes Apart..
<p>
Now we loop through the entire String of magazine where char c stores the char at the index of magazine..
<p>
You might think why I typed c-'a'
It is because in ascii if you subtract any char with 'a' , it gives you index of that alphabet.
Still confused?<p>
Let us assume a = 0 and z = 25. Now subtract a - a. You got 0 in ASCII, right?
now subtract d-a, in ASCII it is 100-97, it leaves you with 3. Isn't that the index of that character in our alphabet counter and isn't that the fact the a=0, b=1, c=2 and d=3. Got it?
<p>
Now we increment the counter for that character of its own index according to English Alphabets (Obviously)
<p>
We have our counter ready!
<p>
Now we run another for loop for ransomNote.<p>
Remember: if the charachter doesn't exists in magazine for ransomNote, we return false;
or if it does exists, we decrement the counter of that charachter from its own index.
<p>
lastly if nothing goes wrong (we have sufficient amount of charachters to make ransomNote)
<p>
Return true :)
* */