class Solution {
public:
    vector<vector<int> > FindContinuousSequence(int sum) {
        vector<vector<int> > reVec;//用于返回的向量
        
        if(sum<=2)
            return reVec;
        
        int small = 1;
        int big = 2;
        int middle = (sum + 1)/2;
        int curSum = small + big;  //当前序列的和
        
        while(small <　middle){
            if(curSum == sum){
                vector<int> subVec;//每个子向量存一个满足的序列
                for(int i = small; i <= big; i++){
                    subVec.push_back(i);
                }
                reVec.push_back(subVec);
            }
            
            while(curSum > sum && small < middle){
                curSum -= small;
                small += 1;
                
                if(curSum == sum){
                    vector<int> subVec;//每个子向量存一个满足的序列
                	for(int i = small; i <= big; i++){
                    	subVec.push_back(i);
                	}
              	    reVec.push_back(subVec);
                }
            }
            
            big ++;
            curSum += big;
        }
        
        return reVec;
    }
};