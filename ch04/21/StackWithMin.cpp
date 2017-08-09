// 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
class Solution {
public:
    void push(int value) {
        dataS.push(value);
        if (minS.empty() || value <= minS.top())
            minS.push(value);
        else
            minS.push(minS.top());
    }

    void pop() {
        dataS.pop();
        minS.pop();
    }

    int top() {
        return dataS.top();
    }

    int min() {
        return minS.top();
    }
private:
     stack<int> dataS, minS;  // 一个用来保存原始数据，另一用来保存当前最小
};