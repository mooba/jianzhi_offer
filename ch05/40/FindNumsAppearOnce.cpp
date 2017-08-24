class Solution {
public:
    unsigned int FindFirstBitIs1(int num){//找到异或的结果的第几位是1
    	int index = 1;
        while(num){
            if((num & 1) == 1)
                return index;
            else{
                num >> 1;
                index ++;
            }                
        }
    }
    
    void FindNumsAppearOnce(vector<int> data,int* num1,int *num2) {
        
        int xor = data[0];
        for(int i = 1; i<data.size(); i++){//把数组中所有数字异或
        	xor ^= data[i];    
        }
        
        int index1 = FindFirstBitIs1(xor);
        
        vector v1, v2;//两个子数组
        for(int j = 0; j < data.size(); j++){
            if(FindFirstBitIs1(data[j]) == index1)
                v1.push_back(data[j]);
            else 
                v2.push_back(data[j]);
        }
        
        //现在每个子数组中有一个只出现一次的数字
        int tmp1 = v1[0], tmp2 = v2[0];
        for(int m = 1; m < v1.size(); m++){
            tmp1 ^= v1[m];
        }
        for(int n = 1; n < v2.size(); n++){
            tmp2 ^= v2[n];
        }
        
        *num1 = tmp1;
        *num2 = tmp2;
         
        
    }
};