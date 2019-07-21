#include<iostream>
#include<vector>
#include<limits.h>
using namespace std;
/*
79. 单词搜索

给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
*/

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.size()==0 || board[0].size()==0 || word.length()>board.size()*board[0].size())
            return false;
        for(int i=0; i<board.size(); i++)
            for(int j=0; j<board[i].size(); j++)
                if(helper(board, word, 0, i, j))
                    return true;
        return false;
    }
    bool helper(vector<vector<char>>& board, string& word, int st, int x, int y){
        if(x < 0 || y < 0 || x >= board.size() || y >= board[0].size() || board[x][y] != word[st])
            return false;
        if(st == word.length()-1) return true;
        board[x][y] ^= 255;
        if(helper(board, word, st+1, x+1, y) || helper(board, word, st+1, x, y+1) || helper(board, word, st+1, x-1, y) || helper(board, word, st+1, x, y-1))
            return true;
        board[x][y] ^= 255;
        return false;
    }
};

int main(){
    char cha[4]={'A','B','C','E'};
    vector<char> a(cha,cha+4);
    char chb[4]={'S','F','C','S'};
    vector<char> b(chb,chb+4);
    char chc[4]={'A','D','E','E'};
    vector<char> c(chc,chc+4);
    vector<vector<char> > grid;
    grid.push_back(a);grid.push_back(b);grid.push_back(c);
    for (int i = 0; i < grid.size(); ++i){
        for (int j = 0; j < grid[i].size(); ++j)
            cout<<grid[i][j]<<' ';
        cout<<endl;
    }

	Solution* so = new Solution();
    bool bl = so->exist(grid,"ABCB");
    cout<<bl<<endl;
    return 0;
}
