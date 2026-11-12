class Twitter {

    public Twitter() {
        
    }
       
    Map<Integer, Set<Integer>> userFollows = new HashMap<>();
    Map<Integer,List<int[]>> userPosts=new HashMap<>();
    int nr=0;

    
    
    public void postTweet(int userId, int tweetId) {
            nr++;
            userPosts.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{nr, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
    Set<Integer> sources = userFollows.getOrDefault(userId, Set.of(userId));
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p, q) -> Integer.compare(q[0], p[0]));

    for (int source : sources) {
        List<int[]> posts = userPosts.get(source);
        if (posts != null && !posts.isEmpty()) {
            int last = posts.size() - 1;
            int[] post = posts.get(last);
            maxHeap.add(new int[]{post[0], post[1], source, last});
        }
    }

    List<Integer> feed = new ArrayList<>();
    while (feed.size() < 10 && !maxHeap.isEmpty()) {
        int[] top = maxHeap.poll();
        feed.add(top[1]);
        int author = top[2];
        int index = top[3];
        if (index > 0) {
            int[] previous = userPosts.get(author).get(index - 1);
            maxHeap.add(new int[]{previous[0], previous[1], author, index - 1});
        }
    }
    return feed;
}
 

    public void follow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>(
            Set.of(followerId))).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> follows = userFollows.get(followerId);
        if (follows != null) {
            follows.remove(followeeId);
        }
    }
}
