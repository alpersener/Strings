package Sorting.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={-1,7,-32,89};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
   }

    public static void bubble(int[] arr){
        boolean swapped;
        //n-1 adımda dönecek
        for (int i = 0; i < arr.length; i++) {
            swapped=false;
            //her step'te nax item en son indexe gelecek
            for (int j = 1; j < arr.length-i; j++) {
                //item önceki itemden küçükse swap'la
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            if(!swapped) //true
                break;


        }
    }



}


