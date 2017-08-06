class Solution {
public:
    void reOrderArray(vector<int> &array) {
        int len = array.size();
        if (0 == len || 1 == len) 
            return;
        int point1 = 0, point2;
        while (point1 < len) {
            while (array[point1] % 2 == 1) //point1指向第一个偶数
                point1 ++;
            point2 = point1 + 1;
            if (point2 == len)
                break;
            
            while (array[point2] %2 == 0){ //point2 指向point1之后的第一个奇数
                point2 ++;
                if (point2 == len)
                    return;
            }
            int j = point2;
            int point2_val = array[point2];
            while (j > point1) {
                array[j] = array[j - 1];
            	j--;
            }
            array[point1] = point2_val;
            point1 ++;
        }
    }
};