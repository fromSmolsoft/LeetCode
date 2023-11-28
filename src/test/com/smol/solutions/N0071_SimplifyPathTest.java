package com.smol.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class N0071_SimplifyPathTest {

    private N0071_SimplifyPath obj;

    @BeforeEach
    void setUp() {
        obj = new N0071_SimplifyPath();
    }

    /**
     * <pre>
     * Example 1:
     * Input: path = "/home/"
     * Output: "/home"
     * Explanation:
     * Note that there is no trailing slash after the last
     * directory name.
     *
     * Example 2:
     * Input: path = "/../"
     * Output: "/"
     * Explanation:
     * Going one level up from the root directory is a no-op,
     * as the root level is the highest level you can go.
     *
     * Example 3:
     * Input: path = "/home//foo/"
     * Output: "/home/foo"
     * Explanation:
     * In the canonical path, multiple consecutive slashes are
     * replaced by a single one.
     *
     * Constraints:
     *     1 <= path.length <= 3000
     *     path consists of English letters, digits, period '.', slash '/' or '_'.
     *     path is a valid absolute Unix path.
     * </pre>
     */
    @ParameterizedTest
    @CsvSource(value = {
            "/home,     /home/",
            "/,         /home/..",
            "/,         /../",
            "/,         //",
            "/,         /.",
            "/...,      /...",

            "/home/foo,             /home//foo/",
            "/home/user/Pictures,   /home/user/Documents/../Pictures",
            "/home/user/Documents,  /../home/user/Documents",
            "/usr/local/bin,        /home/user/../../usr/local/bin",
            "/home/user/Pictures,   /home/user/./Downloads/../Pictures/././",
            "/home/usr/local/bin,   /home/user/Documents/../../usr/local/bin",
            "/usr/local/bin,        /home/user/Documents/../../../usr/local/bin",

            "/a/b/c,                /a//b////c/d//././/..",
            "/c,                    /a/./b/../../c/",
            "/,                     /a/..",
            "/,                     /a/../",
            "/a,                    /../../../../../a",
            "/a/b/c/d,              /a/./b/./c/./d/",
            "/,                     /a/../.././../../.",
            "/a/b/c/d,              /a//b//c//////d",

            "/abc/...,              /abc/..."
    })
    void simplifyPath(String expected, String path) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = N0071_SimplifyPath.class.getMethods();

        for (Method m : methods) {
            if (m.getName().contains("simplifyPath")) {
                String actual = (String) m.invoke(obj, path);
                Assertions.assertEquals(expected, actual,
                        "\nmethod: " + m.getName() +
                        "\n" + path);
            }
        }

    }
}