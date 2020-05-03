package Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;
        if(n == 0 || target < 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[n];
        calculate(candidates,tmp, result, target, n-1, visited);
        return result;
    }

    private void calculate(int[] candidates, List<Integer> tmp, List<List<Integer>> result, int remain, int lev, boolean[] visited){
        if(remain == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }
        // 可行性剪枝
        if (remain < candidates[0]) {
            return;
        }
        for(int i = lev; i >= 0; i--){
            // 可行性剪枝
            if (remain < candidates[i]) {
                continue;
            }
            // 最优化剪枝
            if(i < lev && candidates[i] == candidates[i+1] && !visited[i+1]) {
                continue;
            }
            visited[i] = true;
            tmp.add(candidates[i]);
            calculate(candidates,tmp, result, remain-candidates[i], i-1, visited);
            tmp.remove(tmp.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] cand = new int[]{5,2,1,2,2};
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> ret = combinationSumII.combinationSum2(cand, 5);
        for (List<Integer> list : ret) {
            for (Integer num : list) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
