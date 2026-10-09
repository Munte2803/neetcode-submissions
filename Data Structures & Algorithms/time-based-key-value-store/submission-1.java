class TimeMap {
    
    record Entry(int timestamp, String value) {}
    Map<String,List<Entry>> table=new HashMap<>(); 

    public TimeMap() {
              
    }
   
    
    public void set(String key, String value, int timestamp) {
        table.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list=table.getOrDefault(key,List.of());
        String result="";
        int lo=0;
        int hi=list.size()-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(list.get(mid).timestamp()<=timestamp){
                result=list.get(mid).value();
                lo=mid+1;
            }else{
                hi=mid-1;
            }
           
                 

        }  
        return result;              
    }
}
