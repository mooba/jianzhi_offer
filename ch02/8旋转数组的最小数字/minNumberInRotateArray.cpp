class Solution {
public:
    //当中间的元素和两头的元素相等的时候，没办法用二分查找，只能用顺序查找
    int minInOrder(vector<int> vec, int left, int right) {
        int re = vec[left];
        for (int i = left + 1; i <= right; i++) {
            if (vec[i] < re) 
                re = vec[i];
        }
        return re;
    }
    
    int minNumberInRotateArray(vector<int> rotateArray) {
        
        int len = rotateArray.size();
        if (0 == len)
            return 0;
        if (1 == len)
            return rotateArray[0];  
        
        //O(logn)的算法，用二分查找
        int start = 0;
        int end = len - 1;
        int mid = 0;//初始化为0可以使旋转长度为0的时候代码同样work
        
        //rotateArray[start] >= rotateArray[end]保证旋转，重要!!!
        //之前用的start<end会导致死循环
        while(rotateArray[start] >= rotateArray[end]) {
            if (end - start  == 1) {
                mid = end;
                break;
            }
            
            mid =  (start + end) / 2;
            if (rotateArray[mid] == rotateArray[start]
               && rotateArray[start] == rotateArray[end])
                return minInOrder(rotateArray, start, end); 
            
            if (rotateArray[mid] >= rotateArray[end])
                start = mid;
            else
                end = mid;
        }
        
        return rotateArray[mid];
    }
};