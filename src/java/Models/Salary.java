package Models;
public class Salary {
    
    // Define VAriables  
    int salary_id;
    String member_code;
    int salary;

    public Salary() {
    }

    public Salary(String member_code, int salary) {
        this.member_code = member_code;
        this.salary = salary;
    }

    public int getSalaryId() {
        return salary_id;
    }

    public void setSalaryId(int salary_id) {
        this.salary_id = salary_id;
    }

    public String getMemberCode() {
        return member_code;
    }

    public void setMemberCode(String member_code) {
        this.member_code = member_code;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    
    
}
