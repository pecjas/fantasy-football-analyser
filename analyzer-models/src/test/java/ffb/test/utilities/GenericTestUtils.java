package ffb.test.utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

public abstract class GenericTestUtils {
    private static final List<String> GETTER_METHOD_PATTERNS = List.of("^get[A-Z].*", "^is[A-Z].*");

    public static void validateGetMethodsReturnNonNullValue(List<?> testObjects) throws InvocationTargetException, IllegalAccessException {
        List<Method> getterMethods = new ArrayList<Method>();

        getterMethods = Stream.of(testObjects.get(0).getClass().getMethods())
                .filter(GenericTestUtils::isGetterMethod)
                .collect(Collectors.toList());

        for (var testObj : testObjects) {
            for (Method method : getterMethods) {
                Assert.assertNotNull(method.invoke(testObj));
            }
        }
    }

    public static void validateGetMethodsReturnNonNullValue(Object testObject) throws InvocationTargetException, IllegalAccessException {
        Stream.of(testObject.getClass().getMethods())
                .filter(GenericTestUtils::isGetterMethod)
                .forEach(method -> {
                            try {
                                method.invoke(testObject);
                            } catch(Exception e) {
                                Assert.fail("Exception: " + e);
                            };
                });

        for (Method method : testObject.getClass().getMethods()) {
            if (isGetterMethod(method)) {
                Assert.assertNotNull(method.invoke(testObject));
            }
        }
    }

    private static boolean isGetterMethod(Method method) {
        if (!isPublicAndReturnsType(method)) {
            return false;
        }

        if (hasGetterName(method)) {
            return true;
        }

        return false;
    }

    private static boolean isPublicAndReturnsType(Method method) {
        var returnType = method.getReturnType();

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
