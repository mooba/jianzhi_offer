class Solution {
public:
     //第二遍刷题
    vector<int> GetLeastNumbers_Solution(vector<int> input, int k) {
        vector<int> re;
        if (input.size() < k || k <= 0)
            return re;
        
        multiset<int, greater<int> > leastNumbers;
        vector<int>::iterator it;
        for (it = input.begin(); it != input.end(); it++) {
        	if (leastNumbers.size() < k)
                leastNumbers.insert(*it);
            else {
                int maxNumber = *leastNumbers.begin();
                if (maxNumber <= *it)
                    continue;
                else {
                    leastNumbers.erase(maxNumber);
                    leastNumbers.insert(*it);
                }
                    
            }
        }
        
        multiset<int, greater<int> >::iterator setIter;
        for (setIter = leastNumbers.begin(); setIter != leastNumbers.end(); ++setIter) {
            re.push_back(*setIter);
        }
        
        return re;
    }
};