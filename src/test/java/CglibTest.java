import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CglibTest {

    @Test
    public void test() {
        User user = new User("Jack");

        MethodInterceptor handler = (obj, method, args, proxy) -> {
            if (method.getName().equals("getName")) {
                return ((String) proxy.invoke(user, args)).toUpperCase();
            }
            return proxy.invoke(user, args);
        };

        User userProxy = (User) Enhancer.create(User.class, handler);
        assertEquals("JACK", userProxy.getName());
    }
}
