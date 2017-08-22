// 统计一个数字在排序数组中出现的次数
//
class Solution {
public:
    int getFirstNumber(vector<int> data, int start, int end, int k){//返回出现第一次的下标
    	if(start > end)
            return -1;
        
        int middle = (end + start)/2;//注意求中间位置的公式
        int middleData = data[middle];
        
        if( middleData == k){
            if(middle == 0 || (middle > 0 && data[middle-1] != k))
            	return middle; 
            else 
                end = middle -1;
        }
        else if(middleData > k)
            end = middle -1;
        else 
            start = middle + 1; 
        return getFirstNumber(data, start, end, k);
    }
    
    int getLastNumber(vector<int> data, int start, int end, int k){
        if(start > end)
            return -1;
        int len = data.size();
        //int result = 0;
        int middle = (end + start)/2;
        int middleData = data[middle];
        
        if(middleData == k){
            if(middle == len - 1 || (data[middle+1] != k && middle < len - 1)) 
                return middle;
            else 
                start = middle + 1;
        }
        else if(middleData < k)
            start = middle + 1;
        else 
            end = middle -1;
    	
        return getLastNumber(data, start, end, k);;
    }
    
    int GetNumberOfK(vector<int> data ,int k) {
        int number = 0;
        int len = data.size();
        if(len == 0)
            return 0;
        
        int first = getFirstNumber(data, 0, len - 1, k);
        int last = getLastNumber(data, 0, len-1, k);
        
        if(first > -1 && last > -1)
            number = last - first + 1;
        
        return number;
    }
};