package cn.zjw.algorithm.interview.divideandconquer;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 分治法，Divide And Conquer
 */
public class DivideTest {

    public static void main(String[] args){

        int[] sortedArr = { 0, 1, 3, 4, 5, 7, 11, 12, 23, 37, 41, 43, 47};
        int[] unSortedArr = {0, 4, 2, 5, 7, 45, 22, 56, 12, 13, 34, 23,11};
       // halfSearch1(sortedArr, 37);
       // halfSearch2(sortedArr, 37, 0, sortedArr.length - 1);
        //quickSort1(unSortedArr);
        //quickSort2(unSortedArr, 0 , unSortedArr.length - 1);
        //quickSort3(unSortedArr, 0 , unSortedArr.length - 1);
        //quickSort4(unSortedArr, 0 , unSortedArr.length - 1);
        //mergeSort(unSortedArr, 0 , unSortedArr.length - 1);
        //System.out.println(Arrays.toString(unSortedArr));
       // bigMulity("11","1");
        quickSort4(unSortedArr, 0 , unSortedArr.length - 1);
        System.out.println(Arrays.toString(unSortedArr));
        System.out.println(findKth(unSortedArr,4));


    }

    /**
     * @author zjw
     * @date   2020/5/10 23:10
     * @description    交换数组中两个位置的值
     * @params
     * @return
     * @throws
     */
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    /**
     * @author zjw
     * @date 2020-05-10 16:10
     * @description 二分搜索，循环
     * @Param: null
     * @return
     * @throws
     */
    public static void halfSearch1(int[] arr, int key){
        if (arr == null || arr.length == 0){
            return;
        }
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high){
            mid = (low + high) / 2;
            if (key > arr[mid]){
                low = mid + 1;
            }else if (key < arr[mid]){
                high = mid - 1;
            }else {
                System.out.println("the key's index is " + mid);
                return;
            }
            
        }
        System.out.println("not found " + key);
    }

    /**
     * @author zjw
     * @date   2020/5/10 16:52
     * @description    二分搜索，递归
     * @params
     * @return 
     * @throws
     */
    public  static void halfSearch2(int[] arr, int key, int low, int high){
        if (arr == null || arr.length == 0 || low > high){
            System.out.println("not found " + key);
            return;
        }
        int mid = (low + high) / 2;
        if (key > arr[mid]){
            halfSearch2(arr, key, mid + 1, high);
        }else if (key < arr[mid]){
            halfSearch2(arr, key, low, mid - 1);
        }else {
            System.out.println("the key's index is " + mid);
            return;
        }

    }

    /**
     * @author zjw
     * @date   2020/5/10 21:00
     * @description    快排非递归解法
     * @params
     * @return
     * @throws
     */
    public static void quickSort1(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }

        int low = 0, high = arr.length - 1;
        int i = low, j = high;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(i);
        stack.push(j);
        int sentinel = 0;
        while (!stack.isEmpty()) {
            high = j = stack.pop();
            low = i = stack.pop();
            sentinel = arr[i];
            while (i < j) {

                while (i < j && arr[j] > sentinel) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < sentinel) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = sentinel;
            if (i - 1 > low){
                stack.push(low);
                stack.push(i - 1);
            }
            if (i + 1 < high){
                stack.push(i + 1);
                stack.push(high);
            }
        }
    }

    /**
     * @author zjw
     * @date   2020/5/10 21:14
     * @description    快排，递归，挖坑法
     * @params
     * @return
     * @throws
     */
    public static void quickSort2(int[] arr, int low , int high){
        if (arr == null || arr.length == 0 || low >= high){
            return;
        }
        int sentinel = arr[low];
        int i = low, j = high;
        while (i < j){
            while (i < j && arr[j] >= sentinel){
                j--;
            }
            if (i < j){
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= sentinel){
                i++;
            }
            if (i < j){
                arr[j--] = arr[i];
            }

        }
        arr[i] = sentinel;
        quickSort2(arr, low, i - 1);
        quickSort2(arr, i + 1, high);

    }

    /**
     * @author zjw
     * @date   2020/5/10 23:04
     * @description    快排，递归，左右指针法
     * @params
     * @return
     * @throws
     */
    public static void quickSort3(int[] arr, int low , int high){
        if (arr == null || arr.length == 0 || low >= high){
            return;
        }
        int sentinel = arr[low];
        int i = low, j = high,temp = 0;
        while (i < j){
            while (i < j && arr[j] >= sentinel){
                j--;
            }
            while (i < j && arr[i] <= sentinel){
                i++;
            }
            if (i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
        arr[low] = arr[i];
        arr[i] = sentinel;
        quickSort3(arr, low, i - 1);
        quickSort3(arr, i + 1, high);

    }

    /**
     * @author zjw
     * @date   2020/5/18 21:32
     * @description    TODO 查找第k小的奇数
     * @params
     *         arr 目标数组
     *         k
     * @return
     * @throws
     */
    public int findKth(int[] arr, int k){
        if (arr == null || arr.length == 0 ){
            return -1;
        }
        int n = 0,m = arr.length - 1,temp = 0;

        //简单partition将奇数偶数分在数组两侧
        while (n < m){
            while (n < m && arr[m] % 2 ==0){
                m--;
            }
            while (n < m && arr[n] % 2 == 1){
                n++;
            }
            if (n < m){
                temp = arr[n];
                arr[n] = arr[m];
                arr[m] = temp;
                n++;
                m--;
            }

        }

        //某些情况，m最后会是偶数，加个判断
        if (arr[m] % 2 ==0){
            m--;
        }

        //对奇数排序，选择排序，第k项可以直接返回
        for(int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (i == k -1){
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * @author zjw
     * @date   2020/5/10 23:24
     * @description    快排，递归，前后指针法
     * @params
     * @return
     * @throws
     */
    public static void quickSort4(int[] arr, int low , int high){
        if (arr == null || arr.length == 0 || low >= high){
            return;
        }
        int sentinel = arr[low];
        int cur = low, pre = cur - 1,temp = 0;
        while (cur <= high) {
            while (arr[cur] <= sentinel && ++pre < cur) {
                swap(arr, pre, cur);
            }
            cur++;
        }
        swap(arr, pre, low);

        quickSort4(arr, low, pre - 1);
        quickSort4(arr, pre + 1, high);

    }

    public static void mergeSort(int[] arr, int low , int high){
        if (arr == null || arr.length == 0 || low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }

    /**
     * @author zjw
     * @date   2020/5/14 21:15
     * @description    递归，归并排序
     * @params
     * @return
     * @throws
     */
    public static void merge(int[] arr, int low, int high, int mid){
        int[] temp = new int[high - low + 1];
        int index = mid + 1;
        int k = 0;
        while (low <= mid && index <= high){
            if (arr[low] <= arr[index]){
                temp[k++] = arr[low++];
            }else {
                temp[k++] = arr[index++];
            }
        }
        while (low <= mid){
            temp[k++] = arr[low++];
        }
        while (index <= high){
            temp[k++] = arr[index++];
        }
        while (--k >=0){
            arr[high--] = temp[k];
        }
    }



/**
 * @author zjw
 * @date   2020/5/19 22:26
 * @description    大整数相乘，模拟乘法计算
 * @params
 * @return
 * @throws
 */
    public static void bigMulity(String num1, String num2){
        if ("0".equals(num1) || "0".equals(num2)){
            System.out.println(0);
        }
        int length  = num1.length() + num2.length();
        int[] arr = new int[length];
        int m1 = 0, m2 = 0, temp = 0, mod = 0, divide = 0, k = 0, n = 0;
        for (int i = num1.length() -1; i >= 0; i--){
            m1 = Integer.valueOf(num1.charAt(i) + "");
            n=k;
            for (int j = num2.length() -1; j >= 0; j--){
                m2 = Integer.valueOf(num2.charAt(j) + "");
                temp = m1 * m2 + arr[n];
                mod = temp % 10;
                divide = temp / 10;
                arr[n++] = mod;
                arr[n] = divide;

            }
            k++;

        }
        long result = 0;
        for (int i = 0; i < arr.length; i++){
            result = result + arr[i] * (long)Math.pow(10,i);
        }
        System.out.println(result);

    }


    public static String bigMulity2(String num1, String num2){
        String a,b,c,d;
        if (num1.length() == 1 && num2.length() == 1){
            return (Integer.parseInt(num1) * Integer.parseInt(num2)) + "";
        }else if (num1.length() == 1){
            a = num1;
            c = num2.substring(0,num2.length() / 2);
            d = num2.substring(num2.length() / 2);
            return bigMulity2(a, c * 10^(num2.length() - num2.length() / 2))


        }
        int a =
                , b, c, d;

        int length  = num1.length() + num2.length();
        int[] arr = new int[length];
        int m1 = 0, m2 = 0, temp = 0, mod = 0, divide = 0, k = 0, n = 0;
        for (int i = num1.length() -1; i >= 0; i--){
            m1 = Integer.valueOf(num1.charAt(i) + "");
            n=k;
            for (int j = num2.length() -1; j >= 0; j--){
                m2 = Integer.valueOf(num2.charAt(j) + "");
                temp = m1 * m2 + arr[n];
                mod = temp % 10;
                divide = temp / 10;
                arr[n++] = mod;
                arr[n] = divide;

            }
            k++;

        }
        long result = 0;
        for (int i = 0; i < arr.length; i++){
            result = result + arr[i] * (long)Math.pow(10,i);
        }
        System.out.println(result);

    }





}


