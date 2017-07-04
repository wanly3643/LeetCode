public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> all = new LinkedList<List<Integer>>();
        if (k > 0) {
            doCombine(1, n, 1, k, new LinkedList<Integer>(), all);
        } else {
            all.add(new LinkedList<Integer>());
        }

        return all;
    }

    public void doCombine(int start, int end, int c, int k, List<Integer> cache, List<List<Integer>> all) {
        if (c >= k) {
            for (int i = start; i <= end; i ++) {
                List<Integer> list = new LinkedList<Integer>(cache);
                list.add(i);
                all.add(list);
            }
        } else {
            for (int i = start; i <= end - (k - c); i ++) {
                List<Integer> list = new LinkedList<Integer>(cache);
                list.add(i);
                doCombine(i + 1, end, c + 1, k, list, all);
            }
        }
    }
}