class Solution {
public:
    //length为系统规定字符串输出的最大长度，固定为一个常数
	void replaceSpace(char *str,int length) {
        //非空检查
        if (str == NULL || length <= 0)
            return;
        
        int old_length = 0; //字符串原始长度
        int num_space = 0; //空格的数量
        for (int i = 0; str[i] != '\0'; i++){
            old_length ++;
            if (str[i] == ' ')
                num_space ++;
        }
        
        int new_length = old_length + 2*num_space;//新字符串的长度
        
        if (new_length>length)
            return;
        
        //设置两个指针p1和p2分别指向原字符串和新字符串的末尾位置
        int p1 = old_length;
        int p2 = new_length;
        while (p1 >= 0 && p1 < p2){
            if(str[p1] != ' '){
                str[p2 --] = str[p1];
            }
            else{
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            }
            p1--;
        }

	}
};