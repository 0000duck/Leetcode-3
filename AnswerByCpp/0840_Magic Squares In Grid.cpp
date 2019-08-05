#include<bits\stdc++.h>
using namespace std;
/*
840. 矩阵中的幻方

3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

示例： 输入: [[4,3,8,4],
             [9,5,1,9],
             [2,7,6,2]]
输出: 1
解释: 下面的子矩阵是一个 3 x 3 的幻方：
438
951
276
而这一个不是：
384
519
762
总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。

提示:     1 <= grid.length <= 10      1 <= grid[0].length <= 10       0 <= grid[i][j] <= 15
*/

class Solution {
bool isMagic(vector<vector<int>>& arr, int i, int j){
    vector<bool> used(10, false);
    for(int k=0; k < 3; k++)
        for(int l=0; l < 3; l++){
            if(arr[i+k][j+l] < 1 || arr[i+k][j+l] > 9 || used[arr[i+k][j+l]]) return false;
            used[arr[i+k][j+l]] = true;
        }

    for(int k=i; k<i+2; k++)
        if(arr[k][j] + arr[k][j+1] + arr[k][j+2] != 15)
            return false;
    
    for(int k=j; k<j+2; k++)
        if(arr[i][k] + arr[i+1][k] + arr[i+2][k] != 15)
            return false;
    
    if(arr[i][j] + arr[i+1][j+1] + arr[i+2][j+2] != 15)
        return false;
    if(arr[i+2][j] + arr[i+1][j+1] + arr[i][j+2] != 15)
        return false;
    return true;
}
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int num = 0;
        for(int i=0; i+3 <= grid.size(); i++)
            for(int j=0; j+3 <= grid[0].size(); j++)
                num += isMagic(grid, i, j);
        return num;
    }
};

int main(){
    vector<vector<int>> arr{{4,3,8,4}, {9,5,1,9}, {2,7,6,2}};
    int res = Solution().numMagicSquaresInside(arr);
    cout<<res<<endl;
    return 0;
}