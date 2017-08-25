class Solution {
public:
    string LeftRotateString(string str, int n) {
        reverse(str.begin(),str.begin()+n);
        reverse(str.begin()+n,str.end());
        reverse(str.begin(),str.end());
        return str; 
    }
};