import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Direct validation for length mismatch and endWord existence
        if (beginWord.length() != endWord.length()) return 0;
        
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        // Counter starts at 1 because the starting word counts as the first node
        int ctr = 1; 
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                
                // If we reached the target word, return the current step count
                if (temp.equals(endWord)) return ctr;
                
                char[] chars = temp.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originalChar) continue;
                        
                        chars[j] = k;
                        String newt = new String(chars);
                        
                        if (words.contains(newt)) {
                            q.offer(newt);
                            words.remove(newt); // Mark as visited to prevent cycles
                        }
                    }
                    chars[j] = originalChar; // Restore character for next positions
                }
            }
            ctr++; // Increment levels/steps after processing current layer
        }
        return 0;
    }
}

