package vn.hoidanit.laptopshop.domain;

public class User {

    public static Long UserCount = 0L;

    Long Id;
    String Email;
    String Password;
    String Fullname;
    String Address;
    String Phone;

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId() {
        return this.Id;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setFullname(String fname) {
        this.Fullname = fname;
    }

    public String getFullname() {
        return this.Fullname;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return this.Password;
    }

    public void UserAdded() {

    }

    @Override
    public String toString() {
        return "Hello";
    }
}
