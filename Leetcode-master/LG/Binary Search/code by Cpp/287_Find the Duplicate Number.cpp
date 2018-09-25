#include<iostream>
#include<vector>
using namespace std;
/*
287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3
*/
int findDuplicate(vector<int>& nums) {
    int slow = 0,fast = 0;
    do{
        slow = nums[slow];
        fast = nums[nums[fast]];
    }while(slow!=fast);
    fast = 0;
    while(slow!=fast){
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}
int main(){
    int x[7] = {1,3,4,2,2,5,6};
    vector<int>nums(x,x+7);
    int n = findDuplicate(nums);
    cout<<n<<endl;
	return 0;
}
