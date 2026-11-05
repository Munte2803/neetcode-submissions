class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
        );
        List<String> combinations=new ArrayList<>();
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        dfs(0,digits,combinations,new StringBuilder(),map);
        return combinations;

    }
    public void dfs(int i, String digits,List<String> combinations, StringBuilder combination,Map<Character,List<Character>> map){
        if(combination.length()==digits.length()){
            combinations.add(combination.toString());
            return;
        }
        
        List<Character> possible = map.get(digits.charAt(i));
        for(Character c : possible){
            combination.append(c);
            dfs(i+1,digits,combinations,combination,map);
            combination.deleteCharAt(combination.length()-1);
        }

    }
}
