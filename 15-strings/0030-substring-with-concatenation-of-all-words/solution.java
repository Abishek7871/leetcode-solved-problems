class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s.length()==0 || words.length==0) return ans;
        int wl = words[0].length();
        int wc = words.length;
        HashMap<String,Integer> mp = new HashMap<>();
        for(String w: words) mp.put(w, mp.getOrDefault(w,0)+1);
        for(int i=0;i<wl;i++){
            int l=i, c=0;
            HashMap<String,Integer> cur = new HashMap<>();
            for(int r=i;r+wl<=s.length();r+=wl){
                String w = s.substring(r,r+wl);
                if(mp.containsKey(w)){
                    cur.put(w, cur.getOrDefault(w,0)+1);
                    c++;
                    while(cur.get(w) > mp.get(w)){
                        String lw = s.substring(l,l+wl);
                        cur.put(lw, cur.get(lw)-1);
                        l+=wl;
                        c--;
                    }

                    if(c==wc){
                        ans.add(l);
                    }

                } else {
                    cur.clear();
                    c=0;
                    l=r+wl;
                }
            }
        }
        return ans;
    }
}
