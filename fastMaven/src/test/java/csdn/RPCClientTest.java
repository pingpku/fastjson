package csdn;

public class RPCClientTest {

    public static void main(String[] args) {

        IHelloWorld helloWorld =
                RPCClient.findService("127.0.0.1" , 8080 , IHelloWorld.class) ;
        String  result = helloWorld.sayHello("is_zhoufeng");
        System.out.println(result );

    }

}
