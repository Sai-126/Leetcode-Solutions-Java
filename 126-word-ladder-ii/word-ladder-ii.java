class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        
        if (!wordSet.contains(endWord)) {
            return result;
        }

        // Graph to store parent relationships
        Map<String, List<String>> parents = new HashMap<>();
        
        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();

            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;

                        String nextWord = new String(arr);

                        if (!wordSet.contains(nextWord)) {
                            continue;
                        }

                        if (!visited.contains(nextWord)) {

                            if (!levelVisited.contains(nextWord)) {
                                queue.offer(nextWord);
                                levelVisited.add(nextWord);
                            }

                            parents.putIfAbsent(nextWord, new ArrayList<>());
                            parents.get(nextWord).add(word);

                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (!found) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(endWord, beginWord, parents, path, result);

        return result;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parents,
                           List<String> path,
                           List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}