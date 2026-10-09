class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int minBuy=prices[0];
        for(int i=0;i<prices.length;i++){

            if(prices[i]-minBuy>profit){
                profit=prices[i]-minBuy;
            }
            if(prices[i]<minBuy){
                minBuy=prices[i];
            }

            
        }
       return profit;
    }
}
