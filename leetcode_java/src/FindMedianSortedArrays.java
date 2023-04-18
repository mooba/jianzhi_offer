public class FindMedianSortedArrays {
    public static void main(String[] args) {
        // testcase1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        // testcase2
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};

        FindMedianSortedArrays mainClass = new FindMedianSortedArrays();
        double medianSortedArrays = mainClass.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int point1 = 0;
        int point2 = 0;
        int resultIndex = 0;
        int[] resultArr = new int[m + n];
        while (point1 < m && point2 < n) {
            if (nums1[point1] < nums2[point2]) {
                resultArr[resultIndex] = nums1[point1++];
            } else {
                resultArr[resultIndex] = nums2[point2++];
            }
            resultIndex++;
        }

        if (point1 == m) {
            while(point2 < n) {
                resultArr[resultIndex++] = nums2[point2++];
            }
        }

        if (point2 == n) {
            while (point1 < m) {
                resultArr[resultIndex++] = nums1[point1++];
            }
        }

        double retNum;
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            retNum = (resultArr[mid] + resultArr[mid - 1]) / 2.0;
        } else {
            retNum = resultArr[mid];
        }

        return retNum;
    }
}