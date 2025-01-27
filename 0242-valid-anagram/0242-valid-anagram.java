class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
         boolean valid = true;
        for(int i=0; i<m; i++){
            char c = t.charAt(i);
                if(!map.containsKey(c)){
                     valid=false;
                }else{
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0) map.remove(c);
                }
            }
            if(map.size()>0) valid=false;
               return valid;
        }
    }