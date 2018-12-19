package net.skhu.e201632003;

public class Item {
    String stuNumber;
    String stuName;

    public Item() {

    }

    public Item(String stuNumber, String stuName) {
        this.stuNumber = stuNumber;
        this.stuName = stuName;
    }

    public String getStuNumber() {
        return  stuNumber;
    }

    public void setStuNumber(String stuNumber) { this.stuNumber = stuNumber; }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) { this.stuName = stuName; }
}
