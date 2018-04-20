package CodingInterviews;
//����2������ģʽ����̬�ڲ��ࣩ
public class P2_Singleton {
    private static class SingleHolder{
        private final static P2_Singleton instance = new P2_Singleton();
    }
    private P2_Singleton(){}
    public static final P2_Singleton getSingleton(){
        return SingleHolder.instance;
    }
    public static void Message(){
        System.out.println("HelloP2");
    }

    public static void main(String[] args) {
        getSingleton().Message();
    }
}
