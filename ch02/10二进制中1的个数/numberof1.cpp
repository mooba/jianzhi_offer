#include <iostream>
using namespace std;

//这种解法不用对n的位数进行移动
int numberOf1(int n) 
{
	if (0 == n)
		return 0;
	int cnt = 0;
	unsigned int flag = 1;
	while (flag) {
		if (flag & n)
			cnt ++;
		flag = flag<<1;
	}

	return cnt;
}

//一个整数减去1的值和它本身作与运算的
//结果相当于把它二进制表示中最后一位变成0
int numberOf2(int n)
{
	if (0 == n)
		return 0;
	int cnt = 0;
	while (n) {
		++ cnt;
		n = (n-1) & n;
	}

	return cnt;
}

// 这种解法是对传入的数据进行移位，但是这种解法输入为负数的时候可能导致死循环，所以这里做了这个整数只有32位的假设
int numberOf3(int n){
	if (0 == n)
		return 0;
	int tmp = n;
	int i = 0;
	int cnt = 0;
	while (i < 32){
		if (tmp & 1 == 1)
			cnt ++;
		tmp = tmp >> 1;
		i ++; 
	}
	return cnt
}

int main(){
	int a = 1;
	int b = 0x7FFFFFFF;
	int c = 0x80000000;
	int d = 0xFFFFFFFF;
	int e = 0;

	cout<<numberOf2(a)<<endl; //1
	cout<<numberOf2(b)<<endl; //31
	cout<<numberOf2(c)<<endl; //1
	cout<<numberOf2(d)<<endl; //32
	cout<<numberOf2(e)<<endl; //0

    return 0;
}