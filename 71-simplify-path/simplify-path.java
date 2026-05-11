import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        // Split path by "/"
        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty and current directory "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            else if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Valid directory name
            else {
                stack.push(part);
            }
        }

        // Build canonical path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If empty, return root "/"
        return result.length() == 0 ? "/" : result.toString();
    }
}