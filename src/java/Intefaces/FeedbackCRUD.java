package Intefaces;

import Models.Feedback;
import java.util.List;

public interface FeedbackCRUD {
    public List list_array();
    public Feedback list(int id);
    public boolean add(Feedback st);
    public boolean edit(Feedback st);
    public boolean delete(int id);
}
