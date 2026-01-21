public class Main
{
        // O(n) Time and O(1) Space 
        static int maxProfit(int[] prices) 
        {
            int res = 0;
            
            for(int i = 1; i < prices.length ;i++)
            {
                if(prices[i] > prices[i-1])
                    res += prices[i] - prices[i-1];
            }
        
            return res;
        }       
  
        // The idea is to traverse the array from left to right and Find local minima (where price starts rising) and 
        // then a local maxima (where price stops rising). Compute the difference between two and add to the result. 
        // O(n) Time and O(1) Space
        static int maxProfit_2(int[] prices) 
        {
            int n = prices.length;
            int lMin = prices[0];  
            int lMax = prices[0];  
            int res = 0;
    
            int i = 0;
            while (i < n - 1) 
            {
                // Find local minima
                while (i < n - 1 && prices[i] >= prices[i + 1])  
                    { i++; }
                lMin = prices[i];
               
                // Local Maxima
                while (i < n - 1 && prices[i] <= prices[i + 1]) 
                    { i++; }
                lMax = prices[i];
              
                // Add current profit
                res += (lMax - lMin);
             }
       
             return res;
         }

   
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit_2(prices));
    }
}
