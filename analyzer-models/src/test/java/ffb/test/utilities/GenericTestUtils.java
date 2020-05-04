package ffb.test.utilities;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

public final class GenericTestUtils {
    private static final List<String> GETTER_METHOD_PATTERNS = List.of("^get[A-Z].*", "^is[A-Z].*");

    private GenericTestUtils() {

    }

    public static void validateGetMethodsReturnNonNullValue(List<Object> testObjects) {

        List<Method> getterMethods = Stream.of(testObjects.get(0).getClass().getMethods())
            .filter(GenericTestUtils::isGetterMethod)
            .collect(Collectors.toList());

        testObjects.forEach(obj -> validateGetMethodsReturnNonNullValue(getterMethods, obj));
    }

    public static void validateGetMethodsReturnNonNullValue(Object testObject) {
        List<Method> getterMethods = Stream.of(testObject.getClass().getMethods())
            .filter(GenericTestUtils::isGetterMethod)
            .collect(Collectors.toList());

        validateGetMethodsReturnNonNullValue(getterMethods, testObject);
    }

    private static void validateGetMethodsReturnNonNullValue(List<Method> methods, Object obj) {
        methods.forEach(method -> {
            try {
                Assert.assertNotNull(method.invoke(obj));
            }
            catch (Exception e) {
                Assert.fail();
            }
        });
    }

    private static boolean isGetterMethod(Method method) {
        return isPublicAndReturnsType(method) && hasGetterName(method);
    }

    private static boolean isPublicAndReturnsType(Method method) {
        Class<?> returnType = method.getReturnType();

        return returnType.equals(Void.TYPE) ||
                Modifier.isPublic(method.getModifiers());
    }

    private static boolean hasGetterName(Method method) {
        for (String pattern : GETTER_METHOD_PATTERNS) {
            if (method.getName().matches(pattern)) {
                return true;
            }
        }

        return false;
    }
}
