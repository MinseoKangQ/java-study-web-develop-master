package Part3_Ch02._05_Decorator;

public class A5 extends AudiDecorator{
    public A5(ICar audi, String modelName) {
        super(audi, modelName,3000);
    }
}
