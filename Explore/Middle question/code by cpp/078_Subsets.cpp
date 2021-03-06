#include<iostream>
#include<vector>
using namespace std;
/*
78. 子集

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [1],[2],[3],[1,2],[2,3],[1,3],[1,2,3],[]
]
*/

class Solution {
public:
    vector<vector<int> > subsets(vector<int>& nums) {
        vector<vector<int> > arr;
        // 每个都有空集
        arr.push_back(vector<int>{});

        for(int i = 0;i<nums.size();i++){
            int len = arr.size();
            for(int j=0;j<len;j++){
                // 遍历之前存在每一个数组，分别都加上当前数字
                //vector<int> tem = arr[j];
                //tem.push_back(nums[i]);
                //arr.push_back(tem);

                arr.push_back(arr[j]);
                arr.back().push_back(nums[i]);
            }
        }
        return arr;
    }
};
/*
// 位运算解法，000代表没有选中任何数据，001代表选择最后一个数据，以此类推
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ret;
        ret.push_back({});
        int size=nums.size();
        int subsize=pow(2,size);
        int hash=1;
        while(hash<subsize){
            vector<int> temp;
            for(int k=0;k<size;k++) {
                int a=1<<k;
                if(a&hash) {
                    temp.push_back(nums[k]);
                }
            }
            ret.push_back(temp);
            hash++;
        }
        return ret;
    }
};
*/

int main(){
    int x[6] = {1,2,3,4,5,6};
    vector<int>nums(x,x+3);
    Solution* so = new Solution();
    vector<vector<int> > arr = so->subsets(nums);

    for(int i=0; i<arr.size(); i++){
        for(int j=0; j<arr[i].size(); j++)
            cout<<arr[i][j]<<' ';
        cout<<endl;
    }
    return 0;
}
