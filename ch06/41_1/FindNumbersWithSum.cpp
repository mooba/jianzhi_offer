class Solution {
public:
    vector<int> FindNumbersWithSum(vector<int> array,int sum) {
        ///////a+b = sum, 那么有个结论就是a和b相差越远，成绩越小，刚好就是夹逼法的第一对
        vector<int> reVec;//用于返回的向量
       
        int len = array.size();//返回元素的个数
        if(len<2)
            return reVec;
        
        int begin = 0;
        int end = len - 1;
        while(begin < end){
            if(array[begin] + array[end] == sum){
                reVec.push_back(array[begin]);
                reVec.push_back(array[end]);
                break;
               // return reVec;
            }
            
            while(array[begin] + array[end] < sum){
                begin ++;
            }
            
            while(array[begin] + array[end] > sum){
                end --;                
            }
        }
        
        return reVec;
    }
};