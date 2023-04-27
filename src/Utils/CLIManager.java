package Utils;

import Collection.*;
import Expections.InvalidValue;
import Expections.WrongArguments;

import java.util.Scanner;

public class CLIManager {
    private static final Scanner scanner = new Scanner(System.in);

    public String requestString(){
        return scanner.nextLine();
    }

    public Integer requestInteger() throws NumberFormatException {
        String line = scanner.nextLine();
        if (line.length() == 0) return null;
        return Integer.parseInt(line);
    }

    public Double requestDouble() throws NumberFormatException {
        String line = scanner.nextLine();
        if (line.length() == 0) return null;
        return Double.parseDouble(line);
    }

    public Float requestFloat() throws NumberFormatException {
        String line = scanner.nextLine();
        if (line.length() == 0) return null;
        return Float.parseFloat(line);
    }

    public Long requestLong() throws NumberFormatException {
        String line = scanner.nextLine();
        if (line.length() == 0) return null;
        return Long.parseLong(line);
    }

    public OrganizationType requestOrganizationType() throws IllegalArgumentException {
        for (var item : OrganizationType.values()){
            System.out.print(item + " ");
        }
        System.out.println();
        String line = scanner.nextLine().strip().toUpperCase();
        if (line.length() == 0) return null;
        return OrganizationType.valueOf(line);
    }

    public UnitOfMeasure requestUnitOfMeasure() throws IllegalArgumentException {
        for (var item : UnitOfMeasure.values()){
            System.out.print(item + " ");
        }
        System.out.println();
        String line = scanner.nextLine().strip().toUpperCase();
        if (line.length() == 0) return null;
        return UnitOfMeasure.valueOf(line);
    }

    public Address requestAddress() {
        Address address = new Address();

        // zipCode field
        while (true){
            try {
                System.out.println("Enter Zip Code:");
                address.setZipCode(requestString());
                break;
            } catch (InvalidValue e){
                System.out.println("Problem with Zip Code. " + e.getMessage() + ". Try again!");
            }
        }

        return address;
    }

    public Coordinates requestCoordinates(){
        Coordinates coordinates = new Coordinates();

        // X field
        while (true){
            try{
                System.out.println("Enter X coordinate:");
                Long temp = requestLong();
                if (temp == null){
                    throw new NumberFormatException();
                }
                coordinates.setX(temp);
                break;
            } catch (NumberFormatException e){
                System.out.println("X should be long. Try again!");
            }
        }

        // Y field
        while (true){
            try{
                System.out.println("Enter Y coordinate:");
                coordinates.setY(requestLong());
                break;
            } catch (InvalidValue e){
                System.out.println("Problem with Y coordinate " + e.getMessage() + ". Try again!");
            } catch (NumberFormatException e){
                System.out.println("Y should be Long. Try again!");
            }
        }

        return coordinates;
    }

    public Organization requestOrganization(){
        Organization organization = new Organization();

        // name field
        while (true){
            try{
                System.out.println("Enter organization name:");
                organization.setName(requestString());
                break;
            }catch (InvalidValue e){
                System.out.println("Problem with name " + e.getMessage() + ". Try again!");
            }
        }

        // employeesCount field
        while (true){
            try{
                System.out.println("Enter employees count:");
                organization.setEmployeesCount(requestLong());
                break;
            }catch (InvalidValue e){
                System.out.println("Problem with employees count " + e.getMessage() + ". Try again!");
            }catch (NumberFormatException e){
                System.out.println("Employees count should be Long. Try again!");
            }
        }

        // type field
        while (true){
            try{
                System.out.println("Choose organization type:");
                organization.setType(requestOrganizationType());
                break;
            }catch (InvalidValue e){
                System.out.println("Problem with organization type " + e.getMessage() + ". Try again!");
            }catch (IllegalArgumentException e){
                System.out.println("Organization type should be choose from options. Try again!");
            }
        }

        // officialAddress field
        try {
            System.out.println("Enter official address:");
            organization.setOfficialAddress(requestAddress());
        } catch (InvalidValue e){

        }

        return organization;
    }

    public Product requestProduct (){
        Product product = new Product();

        // name field
        while (true){
            try {
                System.out.println("Enter name of product:");
                product.setName(requestString());
                break;
            }catch (InvalidValue e){
                System.out.println("Problem with " + e.getMessage() + ". Try again!");
            }
        }

        // coordinates field
        try {
            System.out.println("Enter coordinates:");
            product.setCoordinates(requestCoordinates());
        }catch (InvalidValue e){

        }


        // price field
        while (true){
            try {
                System.out.println("Enter price of product:");
                product.setPrice(requestDouble());
                break;
            }catch (InvalidValue e){
                System.out.println("Problem with " + e.getMessage() + ". Try again!");
            }catch (NumberFormatException e){
                System.out.println("Price should be Double. Try again!");
            }
        }

        // partNumber field
        while (true){
            try {
                System.out.println("Enter part number of product:");
                product.setPartNumber(requestString());
                break;
            }catch (InvalidValue e){
                System.out.println("Problem with " + e.getMessage() + ". Try again!");
            }
        }

        // UnitOfMeasure field
        while (true){
            try {
                System.out.println("Choose unit of measure:");
                product.setUnitOfMeasure(requestUnitOfMeasure());
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Incorrect option. Try again!");
            } catch (InvalidValue e){
                System.out.println(e.getMessage());
            }
        }


        // manufacturer field
        try {
            System.out.println("Enter information about manufacture:");
            product.setManufacturer(requestOrganization());
        } catch (InvalidValue e){

        }
        return product;
    }
}
