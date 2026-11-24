class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> adjMap=new HashMap<>();
        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String pre=word.substring(0,i);
                String after=word.substring(i+1);
                adjMap.computeIfAbsent(pre+'*'+after, k -> new ArrayList<>()).add(word);
            }
        }
        for(int i=0;i<beginWord.length();i++){
                String pre=beginWord.substring(0,i);
                String after=beginWord.substring(i+1);
                adjMap.computeIfAbsent(pre+'*'+after, k -> new ArrayList<>()).add(beginWord);
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue= new ArrayDeque<>();
        Set<String> visited=new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int nr=1;
        int n=0;

        while(!queue.isEmpty()){
            nr++;
            n=queue.size();
            for(int j=0;j<n;j++){
                String word = queue.poll();
                for(int i=0;i<word.length();i++){
                    String pre=word.substring(0,i);
                    String after=word.substring(i+1);
                    List<String> children=adjMap.get(pre+'*'+after);              
                    for(String s: children){
                        if(visited.add(s)){
                            queue.add(s);
                        }
                        if(s.equals(endWord)){
                            return nr;
                        }
                    }
                }
            }



        }
        return 0;


    }
}
