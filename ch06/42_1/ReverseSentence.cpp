class Solution {
public:
    //用两步翻转法，第一步先把整个句子逆序翻转，第二步再翻转每个单词中的顺序。
    string ReverseSentence(string str) {
        
        if( str.length() == 0)
            return str;
        
        reverse(str.begin(), str.end());//翻转整个字符串
        
        int begin = 0, end = 0;
        while(end <  (int)str.length()){
            
            if(str[begin] == ' '){
                begin ++;
                end ++;
            }
       		while(end < str.length() && str[end] != ' '){
                end ++;
            }
            reverse(str.begin() + begin, str.begin() + end);
            begin = ++end;
            
        }
        return str;
       
    }
};