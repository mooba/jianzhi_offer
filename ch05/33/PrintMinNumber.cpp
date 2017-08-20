class Solution {
public:
    string PrintMinNumber(vector<int> numbers) {
        string re = "";
        int len = numbers.size();
        if (0 == len)
            return re;

        sort(numbers.begin(), numbers.end(), comp);
        for (int i = 0; i < numbers.size() ; i ++) 
            re += to_string(numbers[i]); //to_string() 可以将int 转化为string
        
        return re;
    }
    
    static bool comp(int a, int b) {
        string str1 = "";
        string str2 = "";
        str1 += to_string(a);
        str1 += to_string(b);
        
        str2 += to_string(b);
        str2 += to_string(a);
        return str1 < str2;
    } 
};