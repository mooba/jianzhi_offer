class Solution {
public:
    int min(int data2, int data3, int data5){
    	int m = data2;
        if(data3 < m)
            m = data3;
        if(data5 < m)
            m = data5;
        return m;
    }
    
    int GetUglyNumber_Solution(int index) {
        if(index <=0)
            return 0;
        int uglyNum[index];
        uglyNum[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, data2, data3, data5;
        for(int i = 1; i<index; i++){
            int j2, j3, j5;
            for(j2 = t2; j2<i; j2++){
                data2 = uglyNum[j2]*2;
                if(data2 > uglyNum[i-1])
                    break;
            }
            
            for(j3 = t3; j3<i; j3++){
                data3 = uglyNum[j3]*3;
                if(data3 > uglyNum[i-1])
                    break;
            }
            
            for(j5 = t5; j5<i; j5++){
                data5 = uglyNum[j5]*5;
                if(data5 > uglyNum[i-1])
                    break;
            }
            
            int minOf235 = min(data2, data3, data5);
            if(minOf235 == data2)
            	t2 = j2;
            if(minOf235 == data3)
            	t3 = j3;
            if(minOf235 == data5)
            	t5 = j5;
            
            uglyNum[i] = minOf235;
        }
        return uglyNum[index - 1];
    }
};