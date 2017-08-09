// 给两个序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
class Solution {
public:
    bool IsPopOrder(vector<int> pushV,vector<int> popV) {
        bool result = false;
        int push_len = pushV.size();
        int pop_len = popV.size();
        if (push_len != pop_len)
           return result;

        stack<int> pushS;
        int p1 = 0; 
        int p2 = 0; // 如果这个指针遍历了popV，就说明是弹出序列
        while (true) {
            if ( p1 < push_len) {
                if (pushV[p1] != popV[p2] ) {
                    pushS.push(pushV[p1]);
                    p1 ++;
                }
                else {
                    p2 ++;
                    p1 ++;
                }
            }
            else {
                if (!pushS.empty()) {
                    if (pushS.top() == popV[p2]) {
                        pushS.pop();
                        p2 ++;
                    }else {
                        result = false;
                        break;
                    }
                }else {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
};