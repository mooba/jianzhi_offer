class Solution
{
public:
    void push(int node) {
        if(stack2.empty()) {
            stack1.push(node);
        }
        else {
            while(!stack2.empty()) {
                stack1.push(stack2.top());
                stack2.pop();
            }
            stack2.push(node);
        }
        
    }

    int pop() {
        while(!stack1.empty()) {
            stack2.push(stack1.top());
            stack1.pop();
        }
        int re = stack2.top();
        stack2.pop();
        return re;
        
    }

private:
    stack<int> stack1;
    stack<int> stack2;
};