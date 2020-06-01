import com.sun.org.apache.regexp.internal.RE;

/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/6/1
 * @Content:
 */
//枚举

    //面试问题：为什么枚举实现单利模式是最安全的?
    //普通的类在类外可以拿到它的实例 枚举的类不可以
public enum TestEnum {
    RED(1,"红色"),BLACK(2,"黑色"),
    GREEN(3,"绿色"),WHITE(4,"白色");//枚举对象

    public int ordinal;
    public String color;

    //1.枚举的构造方法默认是私有的
    //2.默认继承于java.lang.Enum
    TestEnum(int ordinal,String color){
        this.ordinal = ordinal;
        this.color = color;
    }

    public static TestEnum getEnumKey(int ordinal){
        for(TestEnum t : TestEnum.values()){
            if(t.ordinal == ordinal){
                return  t;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getEnumKey(2));
    }


    public static void main3(String[] args) {
        TestEnum testEnum = TestEnum.BLACK;
        TestEnum testEnum21 = TestEnum.RED;
        System.out.println(testEnum.compareTo(testEnum21));
        System.out.println(BLACK.compareTo(RED));
        System.out.println(RED.compareTo(BLACK));
    }


    public static void main2(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 0;i < testEnums.length;i++) {
            System.out.println(testEnums[i] + " " + testEnums[i].ordinal());
        }


        System.out.println("==============");
        System.out.println(TestEnum.valueOf("BLACK"));//把普通字符串转换为枚举实例
    }

    public static void main1(String[] args) {
        TestEnum testEnum2 = TestEnum.BLACK;
        switch (testEnum2){
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case WHITE:
                System.out.println("white");
                break;
            case GREEN:
                System.out.println("green");
                break;
            default:
                break;
        }
    }
}
