package medium;

import java.util.*;

/**
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *
 */
public class AccountsMerge {
    /**
     * 直接使用hash
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> emailToName = new HashMap<>();
        List<String> emailList = new ArrayList<>();
        Map<String,Integer> emailToIdx = new HashMap<>();
        int emailCnt = 0;
        for(List<String> account : accounts){
            int size = account.size();
            String name = account.get(0);
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if(!emailToName.containsKey(email)){
                    emailToName.put(account.get(i) , name);
                    emailToIdx.put(account.get(i), emailCnt++);
                    emailList.add(account.get(i));
                }
            }
        }
        UnionSet unionSet = new UnionSet(emailCnt);
        for(List<String> account : accounts){
            int size = account.size();
            String firstEmail = account.get(1);
            for(int i = 2; i < size; i++){
                unionSet.union(emailToIdx.get(firstEmail) , emailToIdx.get(account.get(i)));
            }
        }
        Map<String,List<String>> rootToEmailList = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToIdx.entrySet()) {
            int rootEmailIdx = unionSet.find(entry.getValue());
            String rootEmail = emailList.get(rootEmailIdx);
            List<String> tmp = rootToEmailList.get(rootEmail);
            if(tmp == null){
                tmp = new ArrayList<>();
                rootToEmailList.put(rootEmail , tmp);
            }
            tmp.add(entry.getKey());
        }
        List<List<String>> rss = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : rootToEmailList.entrySet()){
            List<String> rs = new ArrayList<>();
            rs.add(emailToName.get(entry.getKey()));
            entry.getValue().sort(String::compareTo);
            rs.addAll(entry.getValue());
            rss.add(rs);
        }
        return rss;
    }

    class UnionSet{
        int[] parent;
        int[] rank;
        public UnionSet(int len){
            parent = new int[len];
            rank = new int[len];
            for(int i = 0; i < len; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int i){
            if(parent[i] == i)
                return i;
            parent[i] = find(parent[i]);
            return parent[i];
        }
        public void union(int i , int j){
            int pi = find(i);
            int pj = find(j);
            if(pi != pj){
                if(rank[pi] > rank[pj]){
                    parent[pj] = pi;
                }else if(rank[pi] < rank[pj]){
                    parent[pi] = pj;
                }else {
                    parent[pj] = pi;
                    rank[pi]++;
                }
            }
        }
    }
}
