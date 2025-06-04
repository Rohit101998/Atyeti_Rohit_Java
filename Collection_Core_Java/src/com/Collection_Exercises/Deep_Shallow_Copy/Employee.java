package com.Collection_Exercises.Deep_Shallow_Copy;

public class Employee {

    private String name;
    private Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee shallowCopy() {
        return new Employee(this.name, this.address); // shares address
    }

    public Employee deepCopy() {
        return new Employee(this.name, new Address(this.address.getCity())); // new address
    }

    public Address getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    @Override
    public String toString() {
        return name + " from " + address;
    }

}
