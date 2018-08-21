package leetcode_google;

class MedianofTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Boolean isOdd = true;
        if((nums1.length + nums2.length)%2 == 0){
            isOdd = false;
        }
        int current = 0;
        int i1 = 0;
        int i2 = 0;
        while((i1 + i2)< (nums1.length + nums2.length)){
            if(i1 >= nums1.length){
                current = nums2[i2];
                i2++;
            }else if (i2 >= nums2.length){
                current = nums1[i1];
                i1++;
            }else if (nums2[i2] < nums1[i1]){
                current = nums2[i2];
                i2++;
            }else {
                current = nums1[i1];
                i1++;
            }
            if(((i1 + i2-1) == (nums1.length + nums2.length)/2) && (isOdd)){
                return (double)current;
            }
            if(((i1 + i2) == (nums1.length + nums2.length)/2) && (!isOdd)){
                if(i1 >= nums1.length){
                    current += nums2[i2];
                }else if (i2 >= nums2.length){
                    current += nums1[i1];
                }else if (nums2[i2] < nums1[i1]){
                    current += nums2[i2];
                }else {
                    current += nums1[i1];
                }
                return ((double)current)/2;
            }
        }
        return ((double)current)/2;
    }
    public static void main(String[] args){
        MedianofTwoSortedArrays_4 a = new MedianofTwoSortedArrays_4();
        int[] n1 = {1,2,3};
        int[] n2 = {1,2,3};
        System.out.println(a.findMedianSortedArrays(n1,n2));
    }
}
