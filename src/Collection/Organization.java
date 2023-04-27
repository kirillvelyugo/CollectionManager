package Collection;

import Expections.InvalidValue;

public class Organization {
    private long id; // Value of field should be grader than 0, value of field should be unique and generate automatic
    private String name; // Field can't be null, String shouldn't be empty
    private Long employeesCount; // Field can't be null, value of field should be grader than 0
    private OrganizationType type; // Field can't be null
    private Address officialAddress; // Field can't be null

    private static long tmp_id = 1L;

    public Organization() {
        this.id = tmp_id;
        tmp_id++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidValue {
        if (name == null) {throw new InvalidValue("name shouldn't be null");}
        if (name.length() == 0) {throw new InvalidValue("name shouldn't be empty");}
        this.name = name;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Long employeesCount) throws InvalidValue {
        if (employeesCount == null) {throw new InvalidValue("employeesCount can't be null");}
        if (employeesCount < 0) {throw new InvalidValue("employeesCount should be grader than 0");}
        this.employeesCount = employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) throws InvalidValue {
        if (type == null){throw new InvalidValue("organizationType shouldn't be null");}
        this.type = type;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) throws InvalidValue {
        if (officialAddress == null) {throw new InvalidValue("officialAddress shouldn't be null");}
        this.officialAddress = officialAddress;
    }

    @Override
    public String toString() {
        return "Organization: id = " + this.id +
                ", name = " + this.name +
                ", employeesCount = " + this.employeesCount +
                ", type = " + this.type +
                ", officialAddress = " + this.officialAddress;
    }
}
