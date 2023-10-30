package StringAndStringBuilder;

import java.util.Arrays;

public class Comparison {
    public static void main(String[] args) {
        String a="alper";
        String b="alper";
        int[] arr={1,2,3,4};
        String a2=a;
        //true dönecektir
        System.out.println(a==b);
        System.out.println(a2==a);
        int f=56;
        System.out.println(f);
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));







        String c=new String("abc");
        String d=new String("abc");
        System.out.println(c==d);
        System.out.println(c.equals(d));







    }
}
