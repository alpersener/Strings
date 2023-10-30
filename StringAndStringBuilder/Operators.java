package StringAndStringBuilder;

import java.sql.Array;
import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        //char degerlerinde herhangi bir operator kullanılırsa onu ascii değeri olarak alır
        System.out.println('a'+'b');
        //string'ler ascii'ye çevirilmez.
        System.out.println("a"+"b");
        System.out.println("a"+'b');
        System.out.println('b'+"a");

        System.out.println("--------------------");

        System.out.println('a'+3);
        System.out.println('a');
        System.out.println((char)('a'+3));
        System.out.println("a"+1);
        System.out.println("alper"+new ArrayList<>());
        System.out.println("alper"+new Integer(33));
        /*
        + operatoru java'da sadece primitive ile bir değeri string olanlar için kullanılır
        System.out.println(new Integer(56)+new ArrayList<>()); ->bu error verecektir çünkü string yok ancak aşağıdaki
        error vermeyecektir
        */
        System.out.println(new Integer(56)+" "+new ArrayList<>());

        //String objelerinde bulunan + operatoru overloaded'dir.Stringlerde concat ve joining işlemi sağlar.Normalde
        // Java'da operator overloading bulunmaz c++ ve python ile bunlar yapılabilir ancak java'da yok

        System.out.println("a"+2+2);
        System.out.println(2+2+"a");
        System.out.println("a"+(2+2));

    }
}
