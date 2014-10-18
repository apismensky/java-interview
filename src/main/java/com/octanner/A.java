package com.octanner;

/**
 * Without running main method in the class A try to "predict" the output. Explain.
 * Then run A.main and check your results.
 * What are the static and instance initialization blocks?
 * What happens if the code inside static initialization block produces a RuntimeException (or its subclasses)
 */
public class A extends B {

    public static void main(String[] a) {
        System.out.println("In A main method");
        new A();
    }

    static {
       System.out.println("In A static block");
    }

    {
        System.out.println("In A initialization block");
    }

    public A() {
        System.out.println("In A constructor");
    }
}

class B {

    static {
        System.out.println("In B static block");
    }

    {
        System.out.println("In B initialization block");
    }

    public B() {
        System.out.println("In B constructor");
    }
}
