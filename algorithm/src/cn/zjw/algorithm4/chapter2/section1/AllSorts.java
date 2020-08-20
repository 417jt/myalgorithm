package cn.zjw.algorithm4.chapter2.section1;

public class AllSorts extends AbstractSort{
    public  void selectSort(Comparable a[]){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(super.less(a[j], a[i])){
                    super.swap(a, i, j);
                }
            }
        }
    }

    public  void bulbSort(Comparable a[]){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 0; j < a.length - 1 - i; j++){
                if(super.less(a[j + 1], a[j])){
                    super.swap(a, j + 1, j);
                }
            }
        }
    }

    public  void insertSort(Comparable a[]){
        for(int i = 1; i < a.length; i++){
            Comparable temp = a[i];
            if (super.less(a[i], a[i - 1])) {
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && super.less(temp, a[j - 1])) {
                        a[j] = a[j - 1];
                    }else{
                        a[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public  void sort(Comparable a[]){
        for(int gap = a.length / 2; gap > 0; gap /= 2)
        {
            for(int i = gap; i < a.length; i++){
                Comparable temp = a[i];
                if (super.less(a[i], a[i - gap])) {
                    for (int j = i; j >= 0; j -= gap) {
                        System.out.println(j);
                        if (j >= gap && super.less(temp, a[j - gap])) {
                            a[j] = a[j - gap];
                        }else{
                            a[j] = temp;
                            break;
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args){
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
        Integer[] a = new Integer[]{1,4,2,8,3,12,5,0,9,10,7,6,11};

        AllSorts sorts = new AllSorts();
        sorts.sort(a);
        sorts.show(a);

    }
}
