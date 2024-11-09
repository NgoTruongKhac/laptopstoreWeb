package entity;

public class Laptop {
    private int laptopId;
    private String name;
    private String description;
    private String image;
    private int price;
    private String brand;
    private String category;
    private String cpu;
    private String gpu;
    private String ram;
    private String drive;
    private String size;
    private String resolution;

    // Constructor
    public Laptop(String name, String description, String image, int price, String brand, String category, String cpu, String gpu, String ram,
            String drive, String size, String resolution) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.drive = drive;
        this.size = size;
        this.resolution = resolution;
    }

    // Getters and Setters
    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // toString method
    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
