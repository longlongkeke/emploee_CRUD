package cn.itcast.bean;

public class Emplyee {
    @Override
    public String toString() {
        return "Emplyee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                ", department=" + department +
                '}';
    }

    private Integer id;
    public Emplyee(){
        super();
    }
    public Emplyee(Integer id, String empname, String gender, String email, Integer dId) {
        this.id = id;
        this.empname = empname;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
   }

    private String empname;

    private String gender;

    private String email;

    private Integer dId;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}