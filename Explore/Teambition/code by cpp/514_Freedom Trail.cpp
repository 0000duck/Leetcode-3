#include<iostream>
#include<vector>
#include<limits.h>
#include<unordered_map>
using namespace std;
/*
514. 自由之路

视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
旋转 ring 拼出 key 字符 key[i] 的阶段中：
您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
示例：
输入: ring = "godding", key = "gd"
输出: 4
解释:
 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 当然, 我们还需要1步进行拼写。
 因此最终的输出是 4。
提示：
ring 和 key 的字符串长度取值范围均为 1 至 100；
两个字符串中都只有小写字符，并且均可能存在重复字符；
字符串 key 一定可以由字符串 ring 旋转拼出。
*/

class Solution {
public:
    int findRotateSteps(string ring, string key) {
        int n = ring.size(),m = key.size();
        if(!m)return 0;
        int dp[m+1][n]={0};
        for(int i = m-1;i >= 0; i--)
            for(int j = 0;j < n;j++){
                dp[i][j] = INT_MAX;
                for(int k = 0;k < n;k++)
                    if(ring[k]==key[i]){
                        // 当前位置为j,到达目的地k的距离
                        int step = min(abs(j-k),n-abs(j-k));
                        dp[i][j] = min(dp[i][j],step+dp[i+1][k]);
                    }
            }
        return dp[0][0]+m;
        /*
        if(!key.size())return 0;
        // 存储每个字符的对应位置
        unordered_map<char,vector<int>>hash;
        // 存储可能出现的结果，前者为当前位置，后者为当前所用步数
        vector<pair<int,int>> res({{0,0}});
        int len = ring.size();
        for(int i=0;i<len;++i)
            hash[ring[i]].push_back(i);
        for(int i=0;i<key.size();++i){
            vector<pair<int,int>> tem(res);
            res.clear();
            for(int j=0;j<hash[key[i]].size();++j){
                // 下一个所在的位置
                int next_p = hash[key[i]][j];
                // 转到下一步所需要的时间
                int cur_to_next = tem[0].second + min((tem[0].first-next_p+len)%len,(next_p-tem[0].first+len)%len);
                // 之前可能在的位置逐个去试
                for(int k=1;k<tem.size();++k)
                    cur_to_next = min(cur_to_next,tem[k].second+min((tem[k].first-next_p+len)%len,(next_p-tem[k].first+len)%len));
                // 经过操作，res的大小为当前字符的个数
                res.push_back({next_p,cur_to_next});
            }
        }
        int num = res[0].second;
        for(int i=1;i<res.size();++i)
            num = min(num,res[i].second);
        // 加上按按钮的步数
        return num+key.size();
        */
    }
};

int main(){
    Solution* so = new Solution();
    int it = so -> findRotateSteps("godding","gd");
    cout<<it<<endl;
  return 0;
}
