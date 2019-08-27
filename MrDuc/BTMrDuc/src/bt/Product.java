package bt;

import java.io.File;
import java.io.IOException;

public class Product {

  private int id;
  private String name;
  private String type;
  private float price;

  public Product() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Product(int id, String name, String type, float price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public void write(File f) throws IOException {
    f = new File("BT.txt");
    if (!f.exists()) {
      f.createNewFile();
    }
    FileUtils.writeString(f, id + "|" + name + "|" + type + "|" + price +"\n");
  }
}
