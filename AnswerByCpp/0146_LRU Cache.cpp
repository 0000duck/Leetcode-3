#include<iostream>
#include<vector>
using namespace std;
/*
146. LRU缓存机制

运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶: 你是否可以在 O(1) 时间复杂度内完成这两种操作？
示例:

LRUCache cache = new LRUCache( 2  缓存容量  );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
 */

class LRUCache {
public:
    LRUCache( int capacity ) {
        size = capacity;
    }

    int get( int key ) {
        unordered_map<int, list<pair<int, int>>::iterator>::iterator iter = mmap.find(key);
        if (iter==mmap.end())//不在容器内的默认为0，不然就用find
            return -1;
        // 一个快捷的插入函数，参数分别为  插入位置，开始和结束
        q.splice( q.begin(), q, iter->second );//移到开头,而不是删除再插入，也不是插到末尾
        return iter->second->second;
    }

    void put( int key, int value ) {
        unordered_map<int, list<pair<int, int>>::iterator>::iterator iter = mmap.find( key );
        if (iter!=mmap.end()) {
            iter->second->second = value;
            q.splice( q.begin(), q, iter->second );
            return;
        }
        q.push_front( make_pair( key, value ) );
        mmap[key] = q.begin();
        if (q.size() > size) {
            mmap.erase( q.back().first );
            q.pop_back();
        }
    }

private:
    unordered_map<int, list<pair<int, int>>::iterator> mmap;//value用来存q中的某项迭代器
    list<pair<int,int>> q;//先进先出功能，每次把队头的key的缓存剔除，用的链表，元素是pair<key，value>
    int size;//缓存的给定大小
};

struct Node{
    int key;
    int val;
    Node* pre;
    Node* next;
    Node() : key(0), val(0), pre(nullptr), next(nullptr) {};
    Node(int key, int val) : key(key), val(val), pre(nullptr), next(nullptr) {};
};

class LRUCache {
private:
    int cap;
    // 循环双向链表 解决边界问题
    Node* head;
    Node* tail;
    unordered_map<int, Node*> hash;
    void show(){
        Node* tem = head;
        while(tem->next != head)
            cout<<tem->val<<' ', tem = tem->next;
        cout<<endl;
    }
    // 把当前节点插入到链表的头节点
    void addNode(Node* node){
        if(node->pre == head) return ;
        node->next = head->next;
        node->pre = head;
        head->next->pre = node;
        head->next = node;
    }
    // 把当前节点从原来链表中断开，并插入到头结点处
    void moveToHead(Node* node){
        if(node->pre == head) return ;
        node->next->pre = node->pre;
        node->pre->next = node->next;
        addNode(node);
    }
    // 弹出最后一个节点
    void pop_back(){
        Node* tem = tail->pre;
        hash.erase(tem->key);
        tem->pre->next = tail;
        tail->pre = tem->pre;
        delete tem;
    }
public:
    LRUCache(int capacity) {
        cap = capacity;
        head = new Node();
        tail = new Node();
        head->next = head->pre = tail;
        tail->next = tail->pre = head;
    }
    
    int get(int key) {
        auto it = hash.find(key);
        if(it == hash.end())
            return -1;
        Node* node = it->second;
        moveToHead(node);
        return node->val;
    }
    
    void put(int key, int value) {
        auto it = hash.find(key);
        if( it == hash.end()) {
            Node* node = new Node(key, value);
            addNode(node);
            hash.insert({key, node});
            if(hash.size() > cap) pop_back();
        } else {
            it->second->val = value;
            moveToHead(it->second);
        }
    }
};

/*
class LRUCache {
private:
    vector<int> arr;
    unordered_map<int,int> hash;
    int cap;
public:
    LRUCache(int capacity) {
        cap = capacity;
    }
    int get(int key) {
        if(hash.find(key)!=hash.end()){
            if(arr[0] == key)return hash[key];
            for(vector<int>::iterator it=arr.begin();it!=arr.end();it++){
                if(*it==key){
                    arr.erase(it);
                    arr.insert(arr.begin(),key);
                    return hash[key];
                }
            }
        }
        else return -1;
    }
    void put(int key, int value) {
        if(hash.find(key)!=hash.end()){
            hash[key]=value;
            if(arr[0] == key)return ;
            for(vector<int>::iterator it=arr.begin();it!=arr.end();it++){
                if(*it==key){
                    arr.erase(it);
                    arr.insert(arr.begin(),key);
                    return ;
                }
            }
        }else{
            arr.insert(arr.begin(),key);
            hash[key] = value;
            if(arr.size()>cap){
                hash.erase(arr[cap]);
                arr.pop_back();
            }
        }
    }
};
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
