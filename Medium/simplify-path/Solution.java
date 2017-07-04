import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        if (path == null || "".equals(path) || "/".equals(path)) {
            return path;
        }

        String[] dirs = path.split("/");
        List<String> list = new LinkedList<String>();
        for (String dir : dirs) {
            if (".".equals(dir) || "".equals(dir)) {
                // nothing will be done
            } else if ("..".equals(dir)) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(dir);
            }
        }

        // Rebuild
        if (list.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String dir : list) {
                sb.append("/").append(dir);
            }

            return sb.toString();
        }
    }
}