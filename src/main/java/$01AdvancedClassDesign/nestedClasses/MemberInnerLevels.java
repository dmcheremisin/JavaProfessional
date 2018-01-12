package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 11.01.2018.
 */
public class MemberInnerLevels {
    private int level = 0;
    class A {
        private int level = 1;
        class B {
            private int level = 2;
            class C {
                private int level = 3;
                private void printLevels() {
                    System.out.println(level);
                    System.out.println(this.level);
                    System.out.println(B.this.level);
                    System.out.println(A.this.level);
                    System.out.println(MemberInnerLevels.this.level);
                }
            }
        }
    }

    public static void main(String[] args) {
        MemberInnerLevels tl = new MemberInnerLevels();
        A a = tl.new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        A.B.C c1 = tl.new A().new B().new C();
        A.B b1 = new MemberInnerLevels().new A().new B();
        c1.printLevels();
    }
}
