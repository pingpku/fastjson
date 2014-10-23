package csdn;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-10-17
 * Time: 下午1:21
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld implements IHelloWorld{

    @Override
    public String sayHello(String name) {
        return "hello " + name + "!";
    }

}