package com.jay.learnscala.ch13;

/**
 * Created by jay on 2018/2/16.
 */
public class JavaOuter {
    class Inner {
        private void f() {
            System.out.println("f");
        }
        class InnerMost {
            private void t() {
                f();
            }
        }
    }

    private void o() {
        new Inner().f();
    }

    protected void prot() {
        System.out.println("prot");
    }
}
