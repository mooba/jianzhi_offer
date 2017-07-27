class Solution {
public:
    bool Find(int target, vector<vector<int> > array) {
        int m = array.size();
        int n = array[0].size();
        int i,j;
        for (i = 0, j = n-1; i <= m-1 && j >=0;)
        {
            int current = array[i][j];
            if (target == current)
                return true;
            if (target < current) {
                j --;
                continue;
            }
            if (target > current) {
                i ++;
                continue;
            }
            
        }
        return false;
    }
};