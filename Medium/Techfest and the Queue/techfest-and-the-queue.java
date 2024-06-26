//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        boolean[] isPrime = new boolean[(int) Math.sqrt(b) + 1];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i * i <= Math.sqrt(b); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= Math.sqrt(b); j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect prime numbers
        ArrayList<Long> primes = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(b); i++) {
            if (isPrime[(int) i]) {
                primes.add(i);
            }
        }

        // Calculate sum of powers for each number in the range
        long sum = 0;
        for (long i = a; i <= b; i++) {
            long num = i;
            for (long prime : primes) {
                if (prime * prime > num) break;
                if (num % prime == 0) {
                    int power = 0;
                    while (num % prime == 0) {
                        num /= prime;
                        power++;
                    }
                    sum += power;
                }
            }
            if (num > 1) {
                sum++; // num itself is a prime
            }
        }

        return sum;
    
    }
}
        
