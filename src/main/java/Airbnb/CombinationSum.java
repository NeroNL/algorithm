package Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    // 1
    public List<List<Integer>> getCombination(int[] arr, int target) {
        int n = arr.length;
        List<List<List<Integer>>> dp = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 1; i <= target; ++i) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int j = 0; j < arr.length && arr[j] <= i; ++j) {
                if (i == arr[j]) {
                    lists.add(Collections.singletonList(arr[j]));
                } else{
                    for (List<Integer> l : dp.get(i-arr[j]-1)) {
                        if (arr[j] <= l.get(0)) {
                            List<Integer> cl = new ArrayList<>();
                            cl.add(arr[j]);
                            cl.addAll(l);
                            lists.add(cl);
                        }
                    }
                }
            }
            dp.add(lists);
        }

        return dp.get(target-1);
    }


    // 2
    private void helper(List<List<Integer>> res, List<Integer> list, int[] arr, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return ;
        }
        if (target < 0) return ;

        for (int i = index; i < arr.length; ++i) {
            if (i > index && arr[i-1] == arr[i]) continue;

            list.add(arr[i]);
            helper(res, list, arr, i, target-arr[i]);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;

        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), candidates, 0, target);
        return ans;

    }
}
