import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ipes;
    private int l;

    public List<String> restoreIpAddresses(String s) {
        ipes = new ArrayList<>();
        l = s.length();
        // Prevent IndexOutOfBoundsException for empty or massive strings
        if (l < 4 || l > 12) return ipes; 
        f(s, 0, "", 0);
        return ipes;
    }

    private boolean isIp(String ip) {
        if (ip.length() > 3 || ip.length() == 0) return false;
        if (ip.length() > 1 && ip.charAt(0) == '0') return false;
        if (Integer.parseInt(ip) > 255) return false;
        return true;
    }

    private void f(String s, int index, String ip, int dot) {
        // Base case
        if (dot == 3) {
            String remaining = s.substring(index);
            if (isIp(remaining)) {
                ipes.add(ip + remaining);
            }
            return;
        }

        // Loop through valid segment lengths (1 to 3 characters)
        for (int i = index; i < l && i < index + 3; i++) {
            String segment = s.substring(index, i + 1);
            if (isIp(segment)) {
                // Pass the new string directly to avoid manual backtracking bugs
                f(s, i + 1, ip + segment + ".", dot + 1);
            }
        }
    }
}

