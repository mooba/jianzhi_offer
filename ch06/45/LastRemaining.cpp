class Solution {
public:
    int LastRemaining_Solution(int n, int m)
    {
        if (n < 1 || m < 1)
            return -1;

        list<int> numbers;
        for (int i = 0; i < n; i++)
            numbers.push_back(i);
        
        list<int>::iterator current = numbers.begin();
        while (numbers.size() > 1) {
            for (int j = 1; j < m; j ++) {
                current ++;
                if (current == numbers.end()) 
                    current = numbers.begin();
            }

            list<int>::iterator next = ++ current;
            if (next == numbers.end())
                next = numbers.begin();
            
            -- current;
            numbers.erase(current);
            current = next;
        }

        return (*current);
    }
};