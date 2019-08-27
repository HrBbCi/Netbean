
package b1_mrduc;

public class Main {

  public static void main(String[] args) {
    Shape s = new Shape(){
      @Override
      public void Draw() {
          System.out.println("Vẽ Hình: ");
      }    
    };
    Shape r = new Rectangle();
    Shape c = new Circle();
    r.Draw();
    c.Draw();
    
    Flyable f = new Flyable() {
      @Override
      public void fly() {
          System.out.println("Bay : ");
      }
    };
    Flyable p = new Plane();
    p.fly();
    Flyable b = new Bird();
    b.fly();
    
  }
  
}
