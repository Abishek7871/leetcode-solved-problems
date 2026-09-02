class Solution {
public:
    bool isPalindrome(string str) {
        if(!str.size()) return false;
        int i=0, j=str.size()-1;
        while(i<j) {
            if(str[i]!=str[j]) return false;
            i++; j--;
        } return true;
    }
    void generate(int i, string s, vector<string>& res, vector<vector<string>>& ans) {
        if(i==s.size()) {
            ans.push_back(res);
            return;
        } string str;
        for(int j=i; j<s.size(); j++) {
            str.push_back(s[j]);
            if(isPalindrome(str)) {
                res.push_back(str);
                generate(j+1,s,res,ans);
                res.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<string> res;
        vector<vector<string>> ans;
        generate(0,s,res,ans);
        return ans;
    }
};
