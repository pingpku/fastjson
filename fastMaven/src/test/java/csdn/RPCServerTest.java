package csdn;

public class RPCServerTest {

    public static void main(String[] args) {

        RPCServer server = new RPCServer() ;
        server.registService(new HelloWorld()) ;
        server.startServer(8080) ;

    }

}