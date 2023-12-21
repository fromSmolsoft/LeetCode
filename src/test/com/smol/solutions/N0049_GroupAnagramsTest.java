package com.smol.solutions;

import com.smol.solutions.utils.TUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class N0049_GroupAnagramsTest {

    private N0049_GroupAnagrams obj = new N0049_GroupAnagrams();
    private Method[] methods = obj.getClass().getDeclaredMethods();

    /**
     * <pre>
     * Example 1:
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Example 2:
     * Input: strs = [""]
     * Output: [[""]]
     *
     * Example 3:
     * Input: strs = ["a"]
     * Output: [["a"]]
     *
     * Constraints:
     *     1 <= strs.length <= 104
     *     0 <= strs[i].length <= 100
     *     strs[i] consists of lowercase English letters.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]; [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]",
            ";",
            "a;a"

    })
    void groupAnagrams(String expected, String input) throws InvocationTargetException, IllegalAccessException {

        //transform CSV string to data
        String[] exp0 = TUtils.StringToStringArray(expected, "],\\[");

        List<List<String>> exp = new ArrayList<>();
        for (String s : exp0) {
            List<String> expSubList;

            String[] temp = TUtils.StringToStringArray(s, ",");
            TUtils.trimStrings(temp, "[", "\"", "]", "\"");
            expSubList = Arrays.stream(temp).toList();
            exp.add(expSubList);
        }

        String[] inp = TUtils.StringToStringArray(input, ",");
        TUtils.trimStrings(inp, "[", "\"", "]", "\"");


        for (Method m : methods) {
            if (m.getName().contains("groupAnagrams")) {
                //Actual data
//            List<List<String>> act = obj.groupAnagrams(inp);
                List<List<String>> act = (List<List<String>>) m.invoke(obj, new Object[]{inp});


                //Assertions
                String message = "\nM:" + m.getName() + "\nexp:" + exp + "\nact:" + act + "\n";
                Assertions.assertEquals(exp.size(), act.size(), "List's sizes differ. " + message);

                List<List<String>> act2 = new ArrayList<>(List.copyOf(act));
                List<List<String>> exp3 = new ArrayList<>(List.copyOf(exp));
                Comparator<List<String>> comparator = lexicographicalComparator();
                act2.sort(comparator);
                exp3.sort(comparator);

                for (int i = 0; i < act2.size(); i++) {

                    ArrayList<String> l1 = new ArrayList<>(List.copyOf(act2.get(i)));
                    ArrayList<String> l2 = new ArrayList<>(List.copyOf(exp3.get(i)));

                    if (l1.size() == l2.size()) {
                        Collections.sort(l1);
                        Collections.sort(l2);
                    } else Assertions.fail("\nString lists size differs at " + i + ". ");

                    String message2 = "\nexp-" + i + ": " + exp3 + "\nact-" + i + ": " + act2 + "\n";

                    Assertions.assertTrue(compareListContent(l1, l2), "Lists' contents differ here.\n "
                                                                      + "sorted:\n"
                                                                      + message2
                                                                      + "\nunsorted"
                                                                      + message);
                }
            }
        }

    }


    private boolean compareListContent(List<String> list1, List<String> list2) {
        for (String s : list1) {
            if (!list2.contains(s)) return false;
        }
        return true;
    }

    private static <T extends Comparable<? super T>> Comparator<List<T>>
    lexicographicalComparator() {
        return (list0, list1) ->
                compareLexicographically(list0, list1, Comparator.naturalOrder());
    }

    private static <T> int compareLexicographically(
            List<? extends T> list0,
            List<? extends T> list1,
            Comparator<? super T> comparator) {
        if (list0.size() < list1.size()) {
            return -1;
        }
        if (list0.size() > list1.size()) {
            return 1;
        }
        for (int i = 0; i < list0.size(); i++) {
            T t0 = list0.get(i);
            T t1 = list1.get(i);
            int value = comparator.compare(t0, t1);
            if (value != 0) {
                return value;
            }
        }
        return 0;
    }

    private static <T> Comparator<List<T>> lexicographicalComparator(
            Comparator<? super T> comparator) {
        return (list0, list1) ->
                compareLexicographically(list0, list1, comparator);
    }

}