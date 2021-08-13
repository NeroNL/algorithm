package Airbnb;

import java.util.*;

public class StringPyramidTransitionMatrix {

    Map<String, Boolean> memo;
    Map<String, Set<Character>> cache;
    String SEP = "###";

    public StringPyramidTransitionMatrix(String[] lines) {
        memo = new HashMap<>();
        cache = new HashMap<>();
        for (String line : lines) {
            String[] strs = line.split(",");
            String cur = strs[0] + SEP + strs[1];
            Set<Character> set = cache.getOrDefault(cur, new HashSet<>());
            for (char c : strs[2].toCharArray()) {
                set.add(c);
            }
            cache.put(cur, set);
        }
    }

    public boolean solve(String input) {
        memo.clear();
        return search(input, input);
    }

    public boolean search(String input, String cur) {
        if (memo.containsKey(cur)) return memo.get(cur);
        if (cur.length() == 1) {
            memo.put(cur, input.contains(cur));
            return memo.get(cur);
        }

        List<String> cands = new ArrayList<>();
        getNextLevel(cands, cur, 0, new StringBuilder());
        for (String cand : cands) {
            if (memo.containsKey(cand)) return memo.get(cand);
            boolean res = search(input, cand);
            if (res) {
                memo.put(cand, true);
                return true;
            }
        }
        memo.put(cur, false);
        return false;
    }

    public void getNextLevel(List<String> res, String cur, int start, StringBuilder sb) {
        if (start == cur.length()-1) {
            res.add(new String(sb));
            return;
        }
        for (int i = start; i < cur.length()-1; ++i) {
            String key = cur.charAt(i) + SEP + cur.charAt(i+1);
            if (!cache.containsKey(key)) continue;
            for (char c : cache.get(key)) {
                sb.append(c);
                getNextLevel(res, cur, start+1, sb);
                sb.setLength(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] lines = {"a,a,b", "a,b,ac", "a,c,d", "a,d,a", "b,a,d", "b,b,bc", "b,c,a", "c,d,b"};
        StringPyramidTransitionMatrix s = new StringPyramidTransitionMatrix(lines);
        System.out.println(s.solve("abcc"));
    }
}
