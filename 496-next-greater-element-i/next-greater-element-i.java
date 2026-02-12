class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] indexArray = new int[10001]; // Stores the index of each number in nums2
        
        // Fill indexArray with indices of nums2 elements
        for (int i = 0; i < nums2.length; i++) {
            indexArray[nums2[i]] = i;
        }

        // Replace each element in nums1 with its next greater element from nums2
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = findNextGreater(nums2, indexArray[nums1[i]]);
        }
        return nums1;
    }

    // Helper function to find the next greater element in nums2
    public int findNextGreater(int[] nums2, int index) {
        for (int i = index + 1; i < nums2.length; i++) {
            if (nums2[i] > nums2[index]) return nums2[i];
        }
        return -1; // No greater element found
    }
}