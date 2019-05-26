#include<iostream>
#include<vector>
#include<algorithm>
#include<stack>
using namespace std;
/*
1053. 交换一次的先前排列

给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）
后得到的、按字典序排列小于 A 的最大可能排列。 如果无法这么操作，就请返回原数组。

示例 1：  输入：[3,2,1]      输出：[3,1,2]      解释： 交换 2 和 1
示例 2：  输入：[1,1,5]      输出：[1,1,5]      解释： 这已经是最小排列
示例 3：  输入：[1,9,4,6,7]  输出：[1,7,4,6,9]  解释： 交换 9 和 7
示例 4：  输入：[3,1,1,3]    输出：[1,1,3,3]        

提示： 1 <= A.length <= 10000      1 <= A[i] <= 10000
*/

class Solution {
public:
    vector<int> prevPermOpt1(vector<int>& A) {
        // 维护一个单调递减的栈
        stack<pair<int,int>> sta;
        for(int i=A.size()-1; i>=0; i--){
            // 存放值的时候，再存放下标
            if(sta.empty() || A[i] <= sta.top().first)sta.push({A[i],i});
            else {
                pair<int,int> tem;
                while( !sta.empty() && A[i] > sta.top().first ){
                    tem = sta.top();
                    sta.pop();
                }
                swap(A[i], A[tem.second]);
                return A;
            }
        }
        return A;
    }
};

int main(){
    vector<int> arr = {3,1,1,3};
    vector<int> num = Solution().prevPermOpt1(arr);
    for(auto it:num) cout<<it<<' ';
    cout<<endl;
    return 0;
}