package pinterest;

import java.util.*;

/**
 * 找类似的数字
 * A - [B, C, D]
 * B - []
 * C - []
 * D - []
 * E - [D]
 * F - []
 * 输出(A,B,C,D,E) (F)
 */
public class SimilarImage {

    public static List<List<Character>> solve(Map<Character, List<Character>> dict) {
        List<List<Character>> lists = new ArrayList<>();
        Map<Character, Set<Character>> neighbor = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        for (Character key : dict.keySet()) {
            neighbor.put(key, new HashSet<>(dict.get(key)));
            for (Character c : dict.get(key)) {
                Set<Character> set = neighbor.getOrDefault(c, new HashSet<>());
                set.add(key);
                neighbor.put(c, set);
            }
        }

        for (Character key : neighbor.keySet()) {
            if (visited.contains(key)) continue;

            List<Character> list = new ArrayList<>();
            Queue<Character> queue = new LinkedList<>();
            queue.add(key);
            while(!queue.isEmpty()) {
                Character c = queue.poll();
                list.add(c);
                visited.add(c);
                for (Character next : neighbor.get(c)) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                }
            }
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('A', Arrays.asList('B', 'C', 'D'));
        map.put('B', new ArrayList<>());
        map.put('C', new ArrayList<>());
        map.put('D', new ArrayList<>());
        map.put('E', Collections.singletonList('D'));
        map.put('F', Collections.singletonList('G'));

        List<List<Character>> ans = solve(map);
        for (List<Character> list : ans) {
            String str = "";
            for (Character c : list) {
                str += c + ", ";
            }
            System.out.println(str);
        }
    }
}
