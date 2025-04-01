public class BInarySearch {
    public static void main(String[] args) {
//        char[] letters = {'c','f','j'};
//        int[] arr = {19,16,14,11,4,4,4,4,9,7,5,3,1};
//        binaryascending(arr, 2);
//        BinarySearchDescending(arr,5);
//            AgnosticBinary(arr,9);
//            BinarySearchFirstlastOccurrence(arr,4,true);
//        CountOccurences(arr, 4);
//        StrictBinaryCeiling(arr, 9);

//        char result = SmallestGreaterChar(letters, 'a');
//        System.out.println(result);
//        int[] array = {1,2,5,6,8,10,14,17,19,28};

//        int[] result = InfiniteArrayRange(array,15);

//        System.out.println("Element range is "+result[0]+" --> "+ result[1]);

//        SearchInInfiniteArray
//        findElementInInfiniteSortedArray(array,14);
//        MinimumDifference(array,20);
//        int[] binary = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
//        FirstOccurenceOfOne(binary, 1);
        int[] arr = {3,4,5,6,7,10,14,1,2};
//        int result1 = MinimumElementInBitonicArray(arr);
        int result =  MinElementInRotatedArray(arr);
//        int result = MinElementInRotatedArray(arr);
//        int answer = FindElementInBitonicArray(arr,3);
//        System.out.println("Target present at "+answer);
//        int[] array = {3,4,5,7,0,1,2};
//        int result = SearchInRotatedArray(array, 7);

        System.out.println(result);

    }

    public static int binaryascending(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                return ans;
            }
        }
        return ans;

    }

    public static int BinarySearchInRange(int[] arr, int target, int start, int end) {
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                return ans;
            }
        }
        return ans;

    }

    public static void BinarySearchDescending(int[] arr, int target) {
        // 15,14,13,11,7,6,4,3,2,1

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                end = mid - 1;
            } else if (arr[mid] > target) {
                start = mid + 1;

            } else {
                ans = mid;
                break;
            }

        }
        if (ans == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at " + ans);
        }
    }

    public static void AgnosticBinary(int[] arr, int target) {

        int size = arr.length;
        if (arr[0] <= arr[size - 1]) {
            binaryascending(arr, target);
        } else {
            BinarySearchDescending(arr, target);
        }


    }


    public static int BinarySearchFirstlastOccurrence(int[] arr, int target, boolean firstoccurence) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
//                System.out.println("Checking mid index: " + mid + ", value: " + arr[mid]); // Debugging

            if (arr[mid] < target) {
                start = mid + 1;  // Move right
            } else if (arr[mid] > target) {
                end = mid - 1;  // Move left
            } else {
                ans = mid;  // Found target, but check earlier occurrences
                if (firstoccurence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        if (ans == -1) {
            return -1;
        } else {
            return ans;
        }
    }


    public static void CountOccurences(int[] arr, int element) {
        int first = BinarySearchFirstlastOccurrence(arr, element, true);
        int last = BinarySearchFirstlastOccurrence(arr, element, false);

        if (first == -1) {
            System.out.println("Occurence of the target is 0");
        }
        int length = last - first + 1;
        System.out.println("Count of elements in array " + length);
    }

    //Floor of a Number
    public static void BinaryCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                ans = arr[mid];
                end = mid - 1;
            } else {
                ans = arr[mid];
                break;
            }
        }
        if (ans == -1) {
            System.out.println("Ceiling of the number not found");
        } else {
            System.out.println("Ceiling of the number is " + ans);
        }


    }


    public static void BinaryFloor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
                ans = arr[mid];
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = arr[mid];
                break;
            }
        }
        if (ans == -1) {
            System.out.println("Floor of the number not found");
        } else {
            System.out.println("Floor of the number is " + ans);
        }


    }


    public static void StrictBinaryFloor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
                ans = arr[mid];
            } else if (arr[mid] >= target) {
                end = mid - 1;
            }
        }
        if (ans == -1) {
            System.out.println("Floor of the number not found");
        } else {
            System.out.println("Floor of the number is " + ans);
        }


    }

    //Floor of a Number
    public static void StrictBinaryCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                ans = arr[mid];
                end = mid - 1;
            }
        }
        if (ans == -1) {
            System.out.println("Ceiling of the number not found");
        } else {
            System.out.println("Ceiling of the number is " + ans);
        }


    }

    //letters = ["c","f","j"]
    // target = c
    public static char SmallestGreaterChar(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        char ans = '$';
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = arr[mid];
                end = mid - 1;
            }

        }
        if (ans == '$') {
            return '$';
        } else {
            return ans;
        }
    }


    public static int[] InfiniteArrayRange(int[] arr, int target) {
        int start = 0;
        int end = 1;
        int[] range = new int[2];

        while (arr[end] < target) {
            start = end;
            end = end * 2;

        }
        range[0] = start;
        range[1] = end;

//        System.out.println("Range of the element is :"+range[0]+" "+range[1]);
        return range;
    }


    public static void findElementInInfiniteSortedArray(int[] array, int target) {
        int[] range = InfiniteArrayRange(array, target);
        int ans = BinarySearchInRange(array, target, range[0], range[1]);
        if (ans == -1) {
            System.out.println("Element didn't found");
        } else {
            System.out.println("Element found at " + ans);
        }


    }


    public static void MinimumDifference(int[] array, int target) {
        if (array.length == 0) {
            return;
        }

        int ans = -1;
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                ans = mid;
                break;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int result = 0;

        if (ans != -1) {
            System.out.println("Minimum difference is" + result);
        } else {
            if (end < 0) {
                result = Math.abs(array[start] - target);
            } else if (start >= array.length) {
                result = Math.abs(array[end] - target);
            } else {
                int ans1 = Math.abs(target - array[start]);
                int ans2 = Math.abs(target - array[end]);
                result = Math.min(ans1, ans2);


            }
        }
        System.out.println("Minimum difference is: " + result);
    }

    public static int BinarySearchFirstOccurence(int[] arr, int target, int start, int end) {
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
//                System.out.println("Checking mid index: " + mid + ", value: " + arr[mid]); // Debugging

            if (arr[mid] < target) {
                start = mid + 1;  // Move right
            } else if (arr[mid] > target) {
                end = mid - 1;  // Move left
            } else {
                ans = mid;  // Found target, but check earlier occurrences
                end = mid - 1;
            }
        }
        return ans;
    }


    public static void FirstOccurenceOfOne(int[] array, int target) {
        int start = 0;
        int end = 1;

        int[] range = new int[2];
        while (target > array[end]) {
            start = end;
            end = end * 2;

        }
        range[0] = start;
        range[1] = end;

        int result = BinarySearchFirstOccurence(array, target, range[0], range[1]);
        if (result == -1) {
            System.out.println("Element doesnt present");
        } else {
            System.out.println("Element found at " + result);
        }

    }

    // 1,2,5,9,10,7,7,3,1

    public static boolean ValidMountainArray(int[] array) {
        int i = 0;

        while (i < array.length - 1) {
            if (array[i] < array[i + 1]) {
                i += 1;
            } else {
                break;
            }
        }

        if (i == array.length - 1 || i == 0) {
            return false; // will execute if array is strictly increasing or decresing
        }

        while (i < array.length - 1) {
            if (array[i] > array[i + 1]) {
                i += 1;
            } else {
                break;
            }
        }
        return (i == array.length - 1);
    }

    public static int PeakIndexBitonicArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
//        int ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < array.length - 1 && array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return mid;
            } else if (mid != array.length - 1 && array[mid] < array[mid + 1]) {
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

    public static int MinimumElementInBitonicArray(int[] array) {
        int result = Math.min(array[0], array[array.length - 1]);
        return result;
    }

    public static int FindElementInBitonicArray(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int peak = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < array.length - 1 && array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                peak = mid;
                break;

            } else if (mid != 0 && array[mid] > array[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int start1 = 0;
        int end1 = peak - 1;

        while (start1 <= end1) {
            int mid1 = start1 + (end1 - start1) / 2;

            if (array[mid1] < target) {
                start1 = mid1 + 1;
            } else if (array[mid1] > target) {
                end1 = mid1 - 1;
            } else {
                return mid1;
            }
        }

        int start2 = peak + 1;
        int end2 = array.length - 1;
        while (start2 <= end2) {
            int mid2 = start2 + (end2 - start2) / 2;

            if (array[mid2] < target) {
                start2 = mid2 + 1;
            } else if (array[mid2] > target) {
                end2 = mid2 - 1;
            } else {
                return mid2;
            }
        }
        return -1;
    }

    //finding any element in rotated sorted array
    //find the minimum element in Rotated sorted array


    public static int PivotElement(int[] A, int start, int end) {
        int l = start, r = end, ans = A.length;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (A[mid] >= A[0]) {
                // We are on the left side, go right
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int SearchInRotatedArray(int[] A, int B) {
        int n = A.length;
        int pivot = PivotElement(A, 0, n - 1);

        int l, r;
        if (B >= A[0]) {
            l = 0;
            r = pivot - 1;
        } else {
            l = pivot;
            r = n - 1;
        }

        while (l <= r) {
            int mid = (l + r) / 2;

            if (B < A[mid]) {
                r = mid - 1;
            } else if (B > A[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int PeakElementInRotatedArray(int[] array){
        int start = 0;
        int end = array.length-1;

        while (start<=end){
            int mid = start + (end-start)/2;

            if (mid > 0 && array[mid]<array[mid-1]){
                end = mid -1;
            }else if(mid < array.length-1 && array[mid]<array[mid+1]){
                start = mid +1;

            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int MinElementInRotatedArray(int[] array){
        int start = 0;
        int end = array.length-1;

                int pivot_element = PeakElementInRotatedArray(array);
                return ((pivot_element+1)%array.length);

    }
}





