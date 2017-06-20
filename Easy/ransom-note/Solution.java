import java.util.*;

public class Solution {

    public static class Counter {
        private int count;
        public Counter() {
            this.count = 0;
        }

        public int incAndGet() {
            this.count = this.count + 1;
            return this.count;
        }

        public int decAndGet() {
            this.count = this.count - 1;
            return this.count;
        }
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Counter> charsCount = new HashMap<Character, Counter>();

        if (magazine == null || "".equals(magazine)) {
            return ransomNote == null || "".equals(ransomNote);
        } else {
            if (ransomNote == null || "".equals(ransomNote)) {
                return true;
            }
        }
        
        // Build the characters counter
        Character character = null;
        Counter counter = null;
        for (int i = 0; i < magazine.length(); i ++) {
            character = magazine.charAt(i);
            counter = charsCount.get(character);
            if (counter == null) {
                counter = new Counter();
                charsCount.put(character, counter);
            }

            counter.incAndGet();
        }

        // Check one by one
        for (int i = 0; i < ransomNote.length(); i ++) {
            character = ransomNote.charAt(i);
            counter = charsCount.get(character);
            if (counter == null || counter.decAndGet() < 0) {
                return false;
            }
        }

        return true;
    }
}