package Airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Implement an iterator to flatten a 2d vector.
 *
 * Example:
 *
 * Input: 2d vector =
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * Output: [1,2,3,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,2,3,4,5,6].
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Vector2D implements Iterator<Integer> {

    List<Iterator<Integer>> lists;
    int i = 0;
    Iterator<Integer> cur;

    public Vector2D(List<List<Integer>> vec2d) {
        lists = new ArrayList<>();
        for (List<Integer> list : vec2d) {
            lists.add(list.iterator());
        }
        cur = lists.get(i++);
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        while (i < lists.size() && !cur.hasNext()) {
            cur = lists.get(i++);
        }
        return cur.hasNext();
    }

    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        lists.add(new ArrayList<>(list));
        list.add(3);
        lists.add(new ArrayList<>(list));
        list.add(4);
        list.add(5);
        list.add(6);
        lists.add(new ArrayList<>(list));

        Vector2D vector2D = new Vector2D(lists);
        while(vector2D.hasNext()) {
            System.out.println(vector2D.next());
        }
    }
}
