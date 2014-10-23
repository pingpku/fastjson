package oschina.other;

/**
 * Created with IntelliJ IDEA.
 * User: guoping
 * Date: 14-9-4
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
import java.lang.reflect.Constructor;

public class Singleton {
    //导出全局成员
    public final static Singleton INSTANCE = new Singleton();
    //私有构造
    private Singleton(){
        if (null != INSTANCE) {
            throw new IllegalArgumentException("不能存在两个实例对象");
        }
    }

    public static void main(String[] args) throws Exception {
        final Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            //忽略检查
            constructor.setAccessible(false);
            //构造对象实例 此时这里回抛出异常
            final Object newInstance = constructor.newInstance();
            System.out.println(newInstance == Singleton.INSTANCE);
        }
    }
}
