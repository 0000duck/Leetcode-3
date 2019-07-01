#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>
#include<numeric>
using namespace std;
/*
1101. 彼此熟识的最早时间

在一个社交圈子当中，有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。 我们有一份日志列表 logs，
其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同 id，logs[i] = [timestamp, id_A, id_B]。
每条日志标识出两个人成为好友的时间，友谊是相互的：如果 A 和 B 是好友，那么 B 和 A 也是好友。
如果 A 是 B 的好友，或者 A 是 B 的好友的好友，那么就可以认为 A 也与 B 熟识。
返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。

示例：     输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],
            [20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
输出：20190301
解释：
第一次结交发生在 timestamp = 20190101，0 和 1 成为好友，社交朋友圈如下 [0,1], [2], [3], [4], [5]。
第二次结交发生在 timestamp = 20190104，3 和 4 成为好友，社交朋友圈如下 [0,1], [2], [3,4], [5].
第三次结交发生在 timestamp = 20190107，2 和 3 成为好友，社交朋友圈如下 [0,1], [2,3,4], [5].
第四次结交发生在 timestamp = 20190211，1 和 5 成为好友，社交朋友圈如下 [0,1,5], [2,3,4].
第五次结交发生在 timestamp = 20190224，2 和 4 已经是好友了。
第六次结交发生在 timestamp = 20190301，0 和 3 成为好友，大家都互相熟识了。

提示：     1 <= N <= 100       1 <= logs.length <= 10^4        0 <= logs[i][0] <= 10^9
0 <= logs[i][1], logs[i][2] <= N - 1        保证 logs[i][0] 中的所有时间戳都不同
Logs 不一定按某一标准排序     logs[i][1] != logs[i][2]
*/

class Solution {
private:
    vector<int> fatherMap;
    vector<int> sizeMap;
    int getFa(int i){
        int fa = fatherMap[i];
        if(fa != i) fa = getFa(fa);
        // 扁平化，都指向最开始的头结点
        fatherMap[i] = fa;
        return fa;
    }
    int join(int a, int b){
        int i = getFa(a), j = getFa(b);
        if(i == j) return sizeMap[i];
        if(sizeMap[j] >= sizeMap[j]) 
            fatherMap[i] = j, sizeMap[j] += sizeMap[i];
        else fatherMap[j] = i, sizeMap[i] += sizeMap[j];
        return max(sizeMap[i], sizeMap[j]);
    }
public:
    int earliestAcq(vector<vector<int>>& logs, int N) {
        sort(logs.begin(), logs.end());
        fatherMap.resize(N);
        sizeMap = vector<int>(N,1);
        // 并查集初始化
        for(int i=0; i<N; i++)fatherMap[i] = i;

        for(int i=0; i<logs.size(); i++){
            int a = logs[i][1], b = logs[i][2];
            if(join(a,b) == N) return logs[i][0];
        }
        return -1;
    }
};

int main(){
    // vector<vector<int>> arr{{3,0,3},{4,1,2},{0,2,0},{2,0,2},{8,0,3},{1,0,1},{5,1,2},{7,3,1},{6,1,0},{9,3,0}};
    vector<vector<int>> arr{{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
    int it = Solution().earliestAcq(arr, 6);
    cout<<it<<endl;
    return 0;
}

// {{3,0,3},{4,1,2},{0,2,0},{2,0,2},{8,0,3},{1,0,1},{5,1,2},{7,3,1},{6,1,0},{9,3,0}}
// 4     3                 19 / 67
// {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}}
// 6   20190301