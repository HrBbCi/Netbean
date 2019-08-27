package thuchanh.model;

import java.io.Serializable;

public class Product implements Serializable{

  private String id;
  private String name;
  private String type;
  private String price;

  private ProductType pd;

  public ProductType getPd() {
    return pd;
  }

  public void setPd(ProductType pd) {
    this.pd = pd;
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public Product() {
  }

  public Product(String id, String name, String type, String price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  @Override
  public String toString() {
    return " "+id + "-" + name + "-" + price + "-" + pd.getId() +"\n";
  }

}
