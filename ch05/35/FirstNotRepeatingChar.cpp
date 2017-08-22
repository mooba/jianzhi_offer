class Solution {
public:
    /*
    int solu1(string str){//第一种解法，时间复杂度为n^2
        int len = str.length();
        if(len == 0)
            return -1;
        int i = 0;
        vector<char> exist;
        for(i; i< len; i++){
            char current = str[i];
            int j;
            for(j = 0; j < len; j++){
                if(j==i)
                    continue;
                if(str[j] == current)
                    break;
            }
            if(j == len)
                break;
        }
        return i;
    }
    */
     
    int solu2(string str){//第二种解法，用哈希表，需要n的辅助空间，但是时间复杂度是n
        if(str.length() == 0)
            return -1;
        const int hashTableLen = 256;
        int hashTable[hashTableLen] = {0};
        for(int i = 0; i<str.length(); i++){
            hashTable[str[i]] ++;
        }
         
        for(int j = 0; j < str.length(); j++){
            if(hashTable[str[j]] == 1 )
                return j;
        }
        return -1;
    }
     
    int FirstNotRepeatingChar(string str) {
         
        return solu2(str);
    }
     
     
}