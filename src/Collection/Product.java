package Collection;

import Expections.InvalidValue;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@XmlAccessorType(XmlAccessType.NONE)
public class Product implements Comparable<Product>{
    @XmlElement(name = "id", required = true)
    final private Integer id; // Filed can't be null, Value of field should be grader than 0, value of field should be unique and generate automatic
    @XmlElement(name = "name", required = true)
    private String name; // Filed can't be null, and String shouldn't be empty
    @XmlElement(name = "coordinates")
    private Coordinates coordinates; // Field can be null
//    @XmlElement(name = "creation_date", required = true)
    private java.time.ZonedDateTime creationDate; // Field can't be null, value generations automatic
    @XmlElement(name = "price", required = true)
    private Double price; // Field can't be null, Value of field should be grader than 0
    @XmlElement(name = "part_number")
    private String partNumber; // Field can be null
    @XmlElement(name = "unit_of_measure")
    private UnitOfMeasure unitOfMeasure; // Field can be null
    @XmlElement(name = "manufacturer")
    private Organization manufacturer; // Field can be null
    @XmlElement(name = "tmp_id", required = true)
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
