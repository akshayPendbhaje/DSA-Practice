/**Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 Output: [1,2,2,3,5,6]
 Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
*/

 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int ans[] = new int[m+n];
        int walker1=0;
        int walker2=0;
        int index=0;
        while(walker1<m && walker2<n)
        {
            if(nums1[walker1]<nums2[walker2])
            {
                ans[index++] = nums1[walker1];
                walker1++;
            }
            else
            {
                ans[index++]=nums2[walker2];
                walker2++;
            }
        }

        while(walker1<m)
        {
            ans[index++] = nums1[walker1];
            walker1++;
        }

        while(walker2<n)
        {
            ans[index++]=nums2[walker2];
            walker2++;
        }

        for(int x =0 ;x<ans.length;x++){
            nums1[x]=ans[x];
        }

        //  return ans;
    }
}

