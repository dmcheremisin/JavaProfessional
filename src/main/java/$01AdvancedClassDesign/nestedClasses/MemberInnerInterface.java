package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 11.01.2018.
 */
public class MemberInnerInterface {
    private interface Secret {
        void tellSecret();
    }
    class SecretMessage implements Secret {
        @Override
        public void tellSecret() {
            System.out.println("Secret");
        }
    }

    public static void main(String[] args) {
        Secret secret = new MemberInnerInterface().new SecretMessage();
        secret.tellSecret();
        Secret lambdaSecret = () -> System.out.println("Secret from lambda");
        lambdaSecret.tellSecret();
    }
}
