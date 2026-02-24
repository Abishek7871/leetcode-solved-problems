class Solution {
public:
    int myAtoi(string s) {
        long long ans = 0;
        int sign = 1;
        int i=0;

        while(i<s.size() && s[i] == ' ') {++i;}

        if(i<s.size() && (s[i]=='-' || s[i]=='+')) {
            if(s[i] == '-') {sign = -1;}
            ++i;
        }

        while(i<s.size() && (s[i]>='0' && s[i]<='9')) {
            if(ans > (INT_MAX - (s[i]-'0'))/10) {
                if(sign == -1) return INT_MIN;
                else return INT_MAX;
            }
            ans = ans*10 + (s[i]-'0');
            ++i;
        }
        
        return sign * ans;
    }
};
