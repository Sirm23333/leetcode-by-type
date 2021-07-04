package dahua;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

public class Test2 {
    static int x = 10;
    static {x += 5;}
    public static void main(String[] args) {
        System.out.println(x);
    }
    static {x /= 3;}
}
class A{
    static {
        System.out.println("a");
    }
    public A(){
        System.out.println("b");
    }
}
class B extends A{
    static {
        System.out.println("c");
    }
    public B(){
        System.out.println("d");
    }
}