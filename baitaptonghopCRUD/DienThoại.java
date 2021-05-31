package baitaptonghopCRUD;

public class DienThoại {
    private String name;
    private int price;
    private String brand;
    private String maMay;

    public DienThoại(String name, int price, String brand, String maMay) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.maMay = maMay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    @Override
    public String toString() {
        return name + ","+ price+ "," + brand+ "," + maMay;
    }
}
