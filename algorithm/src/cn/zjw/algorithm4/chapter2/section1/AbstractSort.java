package cn.zjw.algorithm4.chapter2.section1;

import java.util.Arrays;

public abstract  class AbstractSort {

    public abstract void sort(Comparable[] a);

    protected boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0 ;
    }

    protected void swap(Comparable[] a, int x, int y ){
        Comparable t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    protected void show(Comparable[] a){
        System.out.println(Arrays.toString(a));
    }

    private boolean isSort(Comparable[] a){
        for(int i =1; i < a.length; i++){
            if (less(i,i - 1)){
                return false;
            }
        }
        return true;
    }

}
