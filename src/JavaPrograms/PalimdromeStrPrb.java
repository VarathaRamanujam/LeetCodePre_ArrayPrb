package JavaPrograms;

public class PalimdromeStrPrb {
    public static void main(String[] args) {
        System.out.println( countSubstrings("aaa"));
    }

    static int countSubstrings(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() < 2) return s.length();
        StringBuilder recStr = new StringBuilder();
        return recSubString(0, s, recStr, 0);
    }

    static int recSubString(int i, String s, StringBuilder recStr, int count) {
        if (i == s.length()) {
            String temp = recStr.toString();
            if (temp.contentEquals(recStr.reverse())) {
                recStr.reverse();
                count++;
                return 0;
            }
        }

        recStr.append(s.charAt(i));
        recSubString(i + 1, s, recStr, count);
        recStr.deleteCharAt(recStr.length() - 1);
        recSubString(i + 1, s, recStr, count);
        return count;
    }

    private static int binarySearch(int[] arr, int i) {
        int s = 0;
        int e = arr.length-1;
        boolean isAsc = arr[s] < arr[e];
        while (s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == i){
                return mid;
            }else {
                if(isAsc){
                    s=mid+1;
                }else  e=mid-1;
            }
        }

        return -1;
    }
}