package algorithms.string;

import java.util.Objects;

public class ZAlgorithms {

    public static int[] solve(String str) {
        if (Objects.isNull(str)) return new int[0];
        int n = str.length();
        int[] z = new int[n];
        int l, r, k;
        l = r = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0) z[i] = n;
            else if (i > r) {
                l = r = i;
                while (r < n && str.charAt(r - l) == str.charAt(r)) ++r;
                z[i] = r-l;
                r--;
            } else {
                k = i - l;
                if (z[k] < r-i+1) z[i] = z[k];
                else {
                    l = i;
                    while(r < n && str.charAt(r - l) == str.charAt(r)) ++r;
                    z[i] = r-l;
                    --r;
                }
            }
        }
        return z;
    }
}
