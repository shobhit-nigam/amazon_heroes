class CompositionFour {
  public static void main(String[] args) {
    Product pa = new Product(11, "Pringles", "wafers");
    Product pb = new Product(20, "kurkure", "munchies");
    Product pc = new Product(30, "choclates", "dessert");

    Shelf s1 = new Shelf(10, 20, pa);
    Shelf s2 = new Shelf(10, 20, pb);
    Shelf s3 = new Shelf(10, 20, pc);

    System.out.println(s1.getId());
    System.out.println(s1.getNum());
    System.out.println(s1.getP());

    System.out.println("--------");
    // nullify /delete the product 
    s1 = null;
    System.out.println(pa);
  }
}

class Product{
  int id;
  String name;
  String description;
  
  Product(int id, String name, String description){
    this.id = id;
    this.name = name;
    this.description = description;
  }
   public int getId()
   {
    return id;
   }
 public String getName()
   {
    return name;
   }
  public String getDescription(){
    return description;
  }
  public void setId(int newid)
   {
    id = newid;
   }
 public void setName(String newname)
   {
    name = newname;
   }
  public void setDescription(String desc){
    this.description = desc;
  }
  public String toString(){
    return "Product (id= " + id + ", name= " + name + ", desc = " + description + ")";
  }
}

class Shelf{
  int id;
  int num;
  Product p;
  public Shelf(int id, int num, Product p){
    this.id = id;
    this.num = num;
    this.p = p;
  }
  public int getId()
   {
    return id;
   }
  public int getNum(){
    return num;
  }
  public Product getP(){
    return p;
  }
  public void setId(int newid)
   {
    id = newid;
   }
  public void setNum(int n)
   {
    this.num = n;
   }
  public void setP(Product p){
    this.p = p;
  }
}