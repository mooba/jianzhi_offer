class Solution {
public:
    vector<int> printMatrix(vector<vector<int> > matrix) {
        vector<int> re_vec;
        int rows = matrix.size();
        int cols = matrix[0].size();
        if (0 == rows || 0 == cols)
            return re_vec;

        int start = 0;
        while(rows > 2 * start && cols > 2 * start){
            vector<int> tmp_vec = getNumberInCircle(matrix, rows, cols, start);
            re_vec.insert(re_vec.end(), tmp_vec.begin(), tmp_vec.end());
            start ++;
        }
        return re_vec;
    }

    vector<int> getNumberInCircle(vector<vector<int> > matrix, int rows, int cols, int start) {
        vector<int> re;
        int endX = cols - start - 1; // 每一圈结束的行列坐标
        int endY = rows - start - 1; 

        for (int i = start; i <= endX; i ++)
            re.push_back(matrix[start][i]);
        
        // 从上往下
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++)
                re.push_back(matrix[i][endX]);
        }

        // 从右往左
        if (endX > start && endY > start) {
            for (int i = endX - 1; i >= start; --i)
                re.push_back(matrix[endY][i]);
        }

        // 从下往上
        if (endY > start + 1 && endX > start) {
            for (int i = endY - 1; i > start; --i)
                re.push_back(matrix[i][start]);
        }

        return re;
    }
};