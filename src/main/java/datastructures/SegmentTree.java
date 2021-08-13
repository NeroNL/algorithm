package datastructures;

public class SegmentTree {

    private int N = 100000;
    private int n;

    private int[] tree = new int[2*N];

    public void build(int[] arr, int len) {
        n = len;
        tree = new int[2*n];

        for (int i = 0; i < n; ++i) {
            tree[n+i] = arr[i];
        }

        for (int i = n - 1; i > 0; --i) {
            System.out.println("i: " + i + ", left: " + (i << 1) + ", right: " + (i << 1 | 1));
            //tree[i] = tree[i << 1] + tree[i << 1 | 1];
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    public void updateTreeNode(int p, int value) {
        p += n;
        tree[p] = value;

        while (p > 0) {
            p /= 2;
            tree[p] = tree[2*p] + tree[2*p+1];
        }
    }

    public int query(int i, int j) {
        int res = 0, l = i + n, r = j + n;
        while(l <= r) {
            if ((l % 2) == 1) {
                res += tree[l++];
            }

            if ((r % 2) == 0) {
                res += tree[r--];
            }

            l /= 2;
            r /= 2;
        }

        return res;
    }

    public int[] getTree() {
        return tree;
    }

    static public void main (String[] args)
    {
        int []a = {1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12};

        SegmentTree segmentTree = new SegmentTree();
        // n is global
        //n = a.length;

        // build tree
        segmentTree.build(a, a.length);

        // print the sum in range(1,2)
        // index-based
        System.out.println(segmentTree.query(1, 3));

        // modify element at 2nd index
        segmentTree.updateTreeNode(2, 1);

        // print the sum in range(1,2)
        // index-based
        System.out.println(segmentTree.query(1, 3));

        System.out.println(segmentTree.getTree()[1]);
    }
}
