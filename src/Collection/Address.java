package Collection;

import Expections.InvalidValue;

public class Address {
    private String zipCode; // Field can be null

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) throws InvalidValue{
        if (zipCode == null){throw new InvalidValue("zipCode shouldn't be null");}
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address: zipCode = " + this.zipCode;
    }
}
