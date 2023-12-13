package ru.job4j.serialization.json;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserProfile {
    @XmlElement
    private boolean isActive;

    @XmlElement
    private int age;

    @XmlElement
    private String username;

    @XmlElement
    private Address address;

    @XmlElementWrapper(name = "hobbies")
    @XmlElement(name = "hobby")
    private String[] hobbies;

    public UserProfile() {
    }

    public UserProfile(boolean isActive, int age, String username, Address address, String[] hobbies) {
        this.isActive = isActive;
        this.age = age;
        this.username = username;
        this.address = address;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "UserProfile{"
                + "isActive=" + isActive
                + ", age=" + age
                + ", username='" + username + '\''
                + ", address=" + address
                + ", hobbies=" + Arrays.toString(hobbies)
                + '}';
    }
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Address {
    @XmlElement
    private String city;

    @XmlElement
    private String country;

    public Address() {
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", country='" + country + '\''
                + '}';
    }
}

