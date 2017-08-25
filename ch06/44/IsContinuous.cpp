class Solution {
public:
    bool IsContinuous( vector<int> numbers ) {
        if (numbers.size() == 0)
            return false;
        
        sort(numbers.begin(), numbers.end());
        int hashTable[13] = {0};
        int zeroNum = 0;
        int padNum = 0;
        for (int i = 0; i < numbers.size(); i++){
            if (numbers[i] == 0)
                zeroNum ++;
            else
                hashTable[numbers[i]] ++;
            if (i + 1 < numbers.size() && numbers[i] != 0) {
                padNum = padNum + (numbers[i + 1] - numbers[i] - 1);
            }
        }
        
        for (auto c: hashTable) {
            if (c > 1)
                return false;
        }
        if (zeroNum >= padNum)
            return true;
        else
            return false;
    }
};