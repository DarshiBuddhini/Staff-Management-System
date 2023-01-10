package Intefaces;

import Models.Salary;
import java.util.List;

public interface SalaryCRUD {
    public List list_array();
    public Salary list(int id);
    public boolean add(Salary st);
    public boolean edit(Salary st);
    public boolean delete(int id);
}
