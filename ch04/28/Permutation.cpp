class Solution {
public:
    vector<string> rev;
    vector<string> Permutation(string str) {
        if(str.length() == 0)
            return rev;
        
        Permutation(str, 0);
        sort(rev.begin(), rev.end());//网站要求按字典序输出
        return rev;
    }
    
    void Permutation(string str, int begin){
        if(begin > str.length() - 1){ // 终止条件
            rev.push_back(str);
        }
        else{
            unordered_set<char> us;  //记录出现过的字符,C++11中出现的容器，里面的元素无序、不重复
            for(int i = begin; i<str.length(); i++ ){
                if(us.find(str[i]) == us.end()){//如果没出现过，就加入集合中，只和没出现过的换
                    us.insert(str[i]);
                        
                    //交换两个字符的位置
                	//char tempChar = str[begin];
                	//str[begin] = str[i];
                	//str[i] = tempChar;
                    swap(str[i], str[begin]);
                
                	Permutation(str, begin+1);
                
                	//换回来
                	//tempChar = str[begin];
                	//str[begin] = str[i];
                	//str[i] = tempChar;
                    swap(str[i], str[begin]);
                }
                
            }
        }
    }
};