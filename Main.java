import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OnlineShop o = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product p1 = new Product("Laptop", 3200.5, 1,1, 1123, "");
        Product p2 = new Product("Frigider", 207.95, 1,2, 1245, "");

        Product p3 = new Product(p1);

        p3.setQuantity(5);
        p3.setName("Paine");

        o.modifyProductsList(1,p1);
        o.modifyProductsList(1,p2);

        o.modifyProductsList(2, p1);
        System.out.println(p1.areEqual(p2));
    }
}

class OnlineShop {
    private String name;
    private String image;
    private ArrayList<Product> products;

    OnlineShop(String name, String image, ArrayList<Product> products)
    {
        this.products = new ArrayList<Product>();
        this.image = image;
        this.name = name;
    }

    public void modifyProductsList(int what, Product product)
    {
        if(what == 1)
        {
            this.products.add(product);
        }
        else
            this.products.remove(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

class Product
{
    private int id;
    private String name;
    private double price;
    private int type;
    private int category;
    private int quantity;
    private String expiryDate; //expiry date - only for goods
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(String name, double price, int type, int category, int id, String expiryDate)
    {
        this.name = name;
        this.price = price;
        this.type = type;
        this.category = category;
        this.id = id;
        this.expiryDate = expiryDate;
    }

    public Product(Product product)
    {
        this.name = product.name;
        this.price = product.price;
        this.type = product.type;
        this.category = product.category;
        this.id = product.id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * @param product
     * The function compares the id, name, price, type and category of the parameter and the object that calls the function
     */
    public boolean areEqual(Product product)
    {
        if(product.id != this.id)
            return false;
        if(!product.name.equals(this.name))
            return false;
        if(product.price != this.price)
            return false;
        if(product.type != this.type)
            return false;
        if(product.category != this.category)
            return false;

        return true;
    }

    public void modifyPrice(boolean flag, double value)
    {
        if(flag)
            this.price+=this.price*value;
        if(!flag)
            this.price-=this.price*value/100;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

class User
{
    private String name;
    private String id;
    private ArrayList<Order> orders;
    private ArrayList<Order> cart;

    public User(String name, String id)
    {
        this.name = name;
        this.id = id;
        this.orders = new ArrayList<Order>();
        this.cart = new ArrayList<Order>();
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

    public void addToCart(Order order)
    {
        this.cart.add(order);
    }
}

class Order
{
    private ArrayList<Product> products;
    private String address;

    public Order()
    {
        products = new ArrayList<Product>();
    }
    public void addProduct(Product product)
    {
        if(products.size() > 99)
            return;

        products.add(product);
    }

    public void removeProduct(Product product)
    {
        products.remove(product);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class ProductInventory
{
    private Product product;
    private int quantity;

    public ProductInventory(Product product, int quantity)
    {
        this.product = new Product(product);
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}