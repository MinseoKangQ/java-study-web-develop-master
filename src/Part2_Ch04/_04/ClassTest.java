package Part2_Ch04._04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

    public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class c1 = Class.forName("Part2_Ch04._04.Person");

        Person person = (Person)c1.newInstance();

        person.setName("Lee");
        System.out.println(person);

        Class c2 = person.getClass();
        Person p = (Person)c2.newInstance();
        System.out.println(p);

        Class[] parameterTypes = {String.class};
        Constructor cons = c2.getConstructor(parameterTypes);

        Object [] initargs = {"Kim"};
        Person kimPerson = (Person)cons.newInstance(initargs);
        System.out.println(kimPerson);

    }

}
