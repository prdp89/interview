package com.interview.hackerrank.basicPractice;

public class DivisibleSumPairs {

    //https://www.hackerrank.com/challenges/divisible-sum-pairs/
    private static void solve() {
        int ar[] = {1, 3, 2, 6, 1, 2};
        int k = 3, countPairs = 0;

        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0)
                    countPairs++;
            }
        }

        System.out.println(countPairs);
    }

    /* https://github.com/ozan/solutions/blob/master/hackerrank/divisible-sum-pairs.c
    int main() {
  int n, k;
  scanf("%d %d", &n, &k);
  int count = 0;
  int nums[n];
  for (int i = 0; i < n; i++) {
    scanf("%d", &nums[i]);
    for (int j = 0; j < i; j++)
      count += (nums[i] + nums[j]) % k == 0;
  }
  printf("%d", count);
  return 0;
}
     */

    /*
    //optimal solution
    https://www.hackerrank.com/challenges/divisible-sum-pairs/forum

     The idea is that you separate elements into buckets depending on their mod k. For example,
     you have the elements: 1 3 2 6 4 5 9 and k = 3

    mod 3 == 0 : 3 6 9
    mod 3 == 1 : 1 4
    mod 3 == 2 : 2 5
    Now, you can make pairs like so: Elements with mod 3 == 0 will match with elements with (3 - 0) mod k = 0,
    so other elements in the mod 3 == 0 list, like so:

            (3, 6) (3, 9) (6, 9)
    There will be n * (n - 1) / 2 such pairs, where n is length of the list,
    because the list is the same and i != j. Elements with mod 3 == 1 will match with elements with (3 - 1) mod k = 2,
    so elements in the mod 3 == 2 list, like so:

            (1, 2) (1, 5) (4, 2) (4, 5)
    There will be n * k such elements, where n is the length of the first list, and k of the second.

    Because you don't need to print the actual pairs, you need to store only the number of elements in each list.

    int n;
   int k;
   cin >> n >> k;
   int a[n];
   int m[k];

   for(int i=0; i<k; i++)
       m[i]=0;
    for(int i = 0; i < n; i++){
       cin >> a[i];
        m[a[i]%k]++;
    }

    int sum=0;

    sum+=(m[0]*(m[0]-1))/2;

     for(int i=1; i<=k/2 && i!=k-i; i++){
         sum+=m[i]*m[k-i];
     }

    if(k%2==0)
        sum+=(m[k/2]*(m[k/2]-1))/2;

    cout<<sum;

     */

    public static void main( String[] args ) {
        solve();
    }
}
