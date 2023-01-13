package Part3_Ch02._05_Decorator;

public class A3 extends AudiDecorator{
    public A3(ICar audi, String modelName) {
        super(audi, modelName,1000);
    }
}
