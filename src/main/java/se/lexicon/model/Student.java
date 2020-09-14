package se.lexicon.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/*

id int not null primary key auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
personal_number bigint not null unique,
address varchar(400),
reagister_date timestamp default now(),
status tinyint default false
*/
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal personalNumber;
    private String address;
    private LocalDate registerDate;
    private boolean status;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, BigDecimal personalNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.address = address;
    }

    public Student(int id, String firstName, String lastName, BigDecimal personalNumber, String address, LocalDate registerDate, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.address = address;
        this.registerDate = registerDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(BigDecimal personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                status == student.status &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(personalNumber, student.personalNumber) &&
                Objects.equals(address, student.address) &&
                Objects.equals(registerDate, student.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, personalNumber, address, registerDate, status);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", personalNumber=").append(personalNumber);
        sb.append(", address='").append(address).append('\'');
        sb.append(", registerDate=").append(registerDate);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
