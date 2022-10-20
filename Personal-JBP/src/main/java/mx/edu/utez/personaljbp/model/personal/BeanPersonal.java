package mx.edu.utez.personaljbp.model.personal;

import mx.edu.utez.personaljbp.model.position.BeanPosition;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanPersonal {
    Long id;
    String name;
    String surname;
    String lastname;
    String birthday;
    Double salary;
    BeanPosition position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public BeanPosition getPosition() {
        return position;
    }

    public void setPosition(BeanPosition position) {
        this.position = position;
    }
}
