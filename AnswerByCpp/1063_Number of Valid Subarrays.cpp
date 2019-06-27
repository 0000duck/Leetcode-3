#include<iostream>
#include<vector>
#include<stack>
using namespace std;
/*
1063. 有效子数组的数目

给定一个整数数组 A，返回满足下面条件的 非空、连续 子数组的数目： 子数组中，最左侧的元素不大于其他元素。

示例 1：		输入：[1,4,2,5,3]	输出：11
解释：有 11 个有效子数组，分别是：[1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],
[2,5,3],[1,4,2,5],[1,4,2,5,3] 。
示例 2：		输入：[3,2,1]		输出：3
解释：有 3 个有效子数组，分别是：[3],[2],[1] 。
示例 3：		输入：[2,2,2]		输出：6
解释：有 6 个有效子数组，分别为是：[2],[2],[2],[2,2],[2,2],[2,2,2] 。

提示：	1 <= A.length <= 50000		0 <= A[i] <= 100000
*/

class Solution {
public:
    int validSubarrays(vector<int>& nums) {
    	int res = 0, len = nums.size();
        stack<int> sta;
        for(int i=len-1; i>=0; i--){
        	// 单调栈  存放的是之前数的下标   要是不能组成子数组， 就入栈，  第一个组成不了的数来计算
        	// 能组成就弹出   弹到第一个不能组成的数    通过下标来计算
        	while(!sta.empty() && nums[sta.top()] >= nums[i]) sta.pop();
        	res += sta.empty() ? len-i : sta.top() - i;
        	sta.push(i);
        }
        return res;
    }
};

int main(){
    vector<int> arr{1,4,2,5,3};
    int res = Solution().validSubarrays(arr);
    cout<<res<<endl;
    return 0;
}