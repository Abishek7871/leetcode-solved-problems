class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] list = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            list[i] = new StringBuilder();
        }

        int currentLine = 0;
        boolean reachedEdge = true;

        for (int i = 0; i < s.length(); i++) {
            if (currentLine == 0 || currentLine == numRows - 1) {
                reachedEdge = !reachedEdge;
            }

            list[currentLine].append(s.charAt(i));

            if (!reachedEdge) {
                currentLine++;
            } else {
                currentLine--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(list[i]);
        }

        return result.toString();
    }
}