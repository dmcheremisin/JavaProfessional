package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 11.01.2018.
 */
public class Anonymous {
    private abstract class AbstractSale {
        abstract int dollarsOff();
    }
    private interface InterfaceSale {
        int dollarsOff();
    }

    private int getAbstractPrice(int price, AbstractSale sale) {
        return price - sale.dollarsOff();
    }
    private int getInterfacePrice(int price, InterfaceSale sale) {
        return price - sale.dollarsOff();
    }

    public static void main(String[] args) {
        Anonymous a = new Anonymous();
        // doesn't compile if created as new AbstractSale() {....
        // compilator insists to create instance from non static context
        AbstractSale abstractSale = a.new AbstractSale() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        System.out.println(abstractSale.dollarsOff());
        int abstractPrice = a.getAbstractPrice(10, a.new AbstractSale() {
            @Override
            int dollarsOff() {
                return 3;
            }
        });
        System.out.println(abstractPrice);
        // 7

        InterfaceSale interfaceSale = () -> 4;
        System.out.println(interfaceSale.dollarsOff());
        int interfacePrice = a.getInterfacePrice(10, interfaceSale);
        System.out.println(interfacePrice);
        // 6
    }
}
