package Intefaces;

import Models.Leave;
import java.util.List;

public interface LeaveCRUD {
    public List list_array();
    public Leave list(int id);
    public boolean add(Leave st);
}
