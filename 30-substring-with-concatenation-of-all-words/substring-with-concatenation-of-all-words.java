class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;
        int wordLen = words[0].length();
        int totalWords = words.length;
        int window = wordLen * totalWords;
        if (s.length() < window) return result;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words)
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        for (int offset = 0; offset < wordLen; offset++) {
            int start = offset;  
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();
            for (int end = offset; end + wordLen <= s.length(); end += wordLen) {

                String word = s.substring(end, end + wordLen);
                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(start, start + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        start += wordLen;
                        count--;
                    }
                    if (count == totalWords) {
                        result.add(start);
                        String leftWord = s.substring(start, start + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        start += wordLen;
                        count--;
                    }
                } else {  
                    seen.clear();
                    count = 0;
                    start = end + wordLen;
                }
            }
        }
        return result;
    }
}
    
