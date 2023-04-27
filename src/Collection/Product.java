package Collection;

import Expections.InvalidValue;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Product implements Comparable<Product>{
    final private Integer id; // Filed can't be null, Value of field should be grader than 0, value of field should be unique and generate automatic
    private String name; // Filed can't be null, and String shouldn't be empty
    private Coordinates coordinates; // Field can be null
    private java.time.ZonedDateTime creationDate; // Field can't be null, value generations automatic
    private Double price; // Field can't be null, Value of field should be grader than 0
    private String partNumber; // Field can be null
    private UnitOfMeasure unitOfMeasure; // Field can be null
    private Organization manufacturer; // Field can be null

    private static Integer tmp_id = 1;

    public Product() {
        this.id = tmp_id;
        tmp_id++;

        creationDate = ZonedDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates(Coordinates coordinates) {
        return this.coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    private void setId(Long id) {}

    public void setName(String name) throws InvalidValue {
        if (name == null) {throw new InvalidValue("name shouldn't be null");}
        if (name.length() == 0) {throw new InvalidValue("name shouldn't be empty");}
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) throws InvalidValue {
        if (coordinates == null) {throw new InvalidValue("coordinates shouldn't be null");}
        this.coordinates = coordinates;
    }

    public void setPrice(Double price) throws InvalidValue {
        if (price == null) {throw new InvalidValue("price shouldn't be null");}
        if (price < 0) {throw new InvalidValue("price shouldn't be less than 0");}
        this.price = price;
    }

    public void setPartNumber(String partNumber) throws InvalidValue {
        if (partNumber == null) {throw new InvalidValue("partNumber shouldn't be null");}
        this.partNumber = partNumber;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) throws InvalidValue {
        if (unitOfMeasure == null) {throw new InvalidValue("unitOfMeasure shouldn't be null");}
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setManufacturer(Organization manufacturer) throws InvalidValue {
        if (manufacturer == null) {throw new InvalidValue("manufacturer shouldn't be null");}
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product: id = " + this.id +
                ", name = " + this.name +
                ", " + this.coordinates +
                ", creationDate = " + this.creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) +
                ", price = " + this.price +
                ", partNumber = " + this.partNumber +
                ", unitOfMeasure = " + this.unitOfMeasure +
                ", manufacturer = " + this.manufacturer;
    }

    @Override
    public int compareTo(Product oth) {
        return partNumber.compareTo(oth.partNumber);
    }
}
