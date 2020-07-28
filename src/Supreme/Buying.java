package Supreme;


public class Buying {

    // Instance Variables
    String name;
    String catagory;
    String color;
    String size;
    long timeInMilli;

    // Constructor Declaration of Class
    public Buying(String name, String catagory,String color, long timeInMilli, String size)
    {
        this.name = name;
        this.catagory = catagory;
        this.timeInMilli = timeInMilli;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getTimeInMilli() {
        return timeInMilli;
    }

    public void setTimeInMilli(long timeInMilli) {
        this.timeInMilli = timeInMilli;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Buying{" +
                "name='" + name + '\'' +
                ", catagory='" + catagory + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", timeInMilli=" + timeInMilli +
                '}';
    }


}
