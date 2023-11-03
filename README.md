String vs StringBuilder
=======================

String Pool
-----------

Eğer pool’da bulunan değer ile bir tane daha referans yaratılırsa aynı yeri gösterir.Çünkü pool’da bulunan bir nesne için ayrı bir nesne daha yaratılmaz.

![photo1](https://github.com/alpersener/Strings/blob/string/photos/photo1.png)

String İmmutability
-------------------

String’ler immutable’dır.Değerini değiştirmemiz mümkün değildir, ancak değerini değiştirirsek String Pool içerisinde yeni bir nesne oluşturulup ona referans edilir.

![photo2](https://github.com/alpersener/Strings/blob/string/photos/photo2.png)

Yani biz değerini değiştiriğimizde aslında yeni bir obje yaratıp referansını ona doğru veriyoruz bu da bize büyük sıkıntılar yaşatır String’i modify ederken bu nedenden dolayı mutable sınıf olan StringBuilder kullanılması daha mantıklıdır.

String Comparison
-----------------

![photo3](https://github.com/alpersener/Strings/blob/string/photos/photo3.png)

String Concatenation
====================
```

    //char degerlerinde herhangi bir operator kullanılırsa onu ascii değeri olarak alır
            System.out.println('a'+'b');
            //string'ler ascii'ye çevirilmez.
            System.out.println("a"+"b");
    
    				System.out.println("a"+'b');
    
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

```

    Output:
    195
    ab
    ab
    100
    a
    d
    a1
    alper[]
    alper33
    56[]
    a22
    4a
    a4

String Performance
------------------

    public class Performance {
        public static void main(String[] args) {
            String series="";
            for (int i = 0; i < 26; i++) {
                char ch=(char)('a'+i);
                series=series+ch;
    
    
            }
            System.out.println(series);
        }
    
    }

*   “”+’a’=”a”;

*   “a”+’b’=”ab”;

*   “ab”+’c’=”abc”;

*   Bu şekilde devam ediyor ancak her string ekleme işleminde yeni bir nesne yaratılıyor sebebi ise String’lerin immutable olması ve değerinin değişmesi için her defasında yeni bir obje yaratılması.

*   Yukarıdaki kodun time complexity’si O(n^2)’dir.Sebebi ise şudur→ 1+2+3….+N şekilde ilerliyor formülü ise n\*(n+1)/2 burası da n^2 çıkar.

*   n^2 olması kötü bir şey her defasında nesne yaratılması falan vs… bunun yerine string’leri modify etmemiz için StringBuilder kullanırız

StringBuilder
-------------
```
    public class SB {
        public static void main(String[] args) {
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i < 26; i++) {
                char ch=(char)('a'+i);
                builder.append(ch);
            }
            System.out.println(builder);
            builder.deleteCharAt(0);
            System.out.println(builder);
            builder.reverse();
            System.out.println(builder);
        }
    }
```

*   Bu işlemleri yaptığımızda yeni bir obje yaratılmayacak ve böylece daha performanslı bir hale gelecek ve ek methodlara sahibiz StringBuilder’da

String vs StringBuilder
-----------------------

Java’da String yapısı immutable olduğundan concatenation(birleştirme),substring(ayrıştırma) gibi manipülasyon işlemleri yaptığımızda yeni bir string nesnesi oluşur.Eski string nesnesi gc tarafından temizlenir.Bu işlemler ağır işlemlerdir ve heap’te çok fazla çöp oluşturur.

Bu yüzden string manipilasyonu için kullanılması gereken sınıflar StringBuilder ve StringBuffer’dır.

Bu nesneler mutable yapıdadır ve append,insert,delete,substring gibi methodları içerirler.

EK OLARAK;

String concatemation işlemi(+) arkasında StringBuilder veya StringBuffer kullanmaktadır.**(performans ve bellek kullanımı açısından daha verimli bir yaklaşım sunmak için)**

* * *

StringBuffer,StringBuilder’a göre ekstra methodlar içerir.

Eğer tek thread yapıda çalışılıyorsa ve thread safe konusu önemli değilse StringBuilder,diğer türlü ise StringBuffer kullanılmalıdır.

![photo4](https://github.com/alpersener/Strings/blob/string/photos/photo4.png)

![photo5](https://github.com/alpersener/Strings/blob/string/photos/photo5.png)

String intern() Method
======================

String poolda bulunamayan String değerlerinin kopyasını oluşturup String pool içerisinde alır.

  ```    
    public class Test {
        public static void main(String[] args) {
            String s1 = "abc";  //pool
            String s2 = new String("abc"); //heap
            String s3 = new String("foo"); //heap
            String s4 = s1.intern();   //pool
            String s5 = s2.intern();   //pool
    
            System.out.println(s3 == s4); //F
            System.out.println(s1 == s5); //T
        }
    }
```

* * *

String neden Java'da popüler bir HashMap anahtarıdır?
=====================================================

String immutable olduğundan, hashcode'u oluşturulduğu anda önbelleğe alınır ve tekrar hesaplanması gerekmez. Bu, onu bir Map'teki anahtarlar için harika bir aday yapar ve işlenmesi diğer HashMap anahtar nesnelerinden daha hızlıdır. Bu nedenle String çoğunlukla HashMap anahtarları olarak kullanılır.

* * *

Kaç Tane obje oluşur?
=====================
```

    String s1 = new String("javaguides");
     
    String s2 = "javaguides";
```

*   2 tane obje oluşacaktır.

```

    String s1 = new String("javaguides");
     
    String s2 = "javaguides";
```

*   2 tane obje oluşur.

*   1 Tanesi heap’de “javaguides”

*   1 Tanesi string pool’da “javaguides”
