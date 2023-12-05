package com.smol.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>71. Simplify Path</h1>
 * Medium, #string, #stack
 * <p>
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:  <p>
 * <p>
 * The path starts with a single slash '/'.  <p>
 * Any two directories are separated by a single slash '/'.  <p>
 * The path does not end with a trailing '/'.  <p>
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')  <p>
 * <p>
 * Return the simplified canonical path.  <p>
 *
 * <pre>
 * Example 1:
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation:
 * Note that there is no trailing slash after the last directory name.
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
public class N0071_SimplifyPath {

    /**
     * <h1> Split & Stack </h1>     *
     * <pre>
     * Runtime 3 ms     Beats 98.66% of users with Java
     * Memory 41.99 MB  Beats 95.44% of users with Java
     * </pre>
     */
    public String simplifyPath(String path) {

        //split by slash "/"
        String[] dirs = path.split("/");

        // restructure path's segments to fit simple canonical path
        Deque<String> cPath = new ArrayDeque<>();
        for (int i = 0; i < dirs.length; i++) {

            // "." and "" => ignore/skip"
            if (dirs[i].equals(".") || dirs[i].isEmpty()) continue;

                // ".." => remove previous path segment, aka go to parent dir
            else if (dirs[i].equals("..")) cPath.pollFirst();

                // anything else => add as path segment
            else cPath.addFirst(dirs[i]);
        }

        // turn elements into returned String
        int l = cPath.size();
        if (l == 0) return "/";
        StringBuilder res = new StringBuilder(l * 2);
        for (int i = 0; i < l; i++) res.append('/').append(cPath.removeLast());
        return res.toString();
    }
}
