package StringAndStringBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String name="alper sener";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.getBytes(StandardCharsets.UTF_8));
        System.out.println(name.charAt(0));
        System.out.println(name.indexOf('l'));
        System.out.println("a          lp e      r".strip());

    }
}
