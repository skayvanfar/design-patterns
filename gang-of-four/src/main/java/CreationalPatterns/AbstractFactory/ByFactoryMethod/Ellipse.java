package CreationalPatterns.AbstractFactory.ByFactoryMethod;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 9/28/2016
 */
public class Ellipse extends Shape {
    @Override
    void draw() {
        System.out.println("draw in Ellipse id: " + id);
    }
}
