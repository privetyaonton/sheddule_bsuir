package org.example.logic;

import java.sql.ResultSet;
import java.util.Vector;

public interface TableLogic {
    public void insert (Object[] list);
    public void delete (int id);
    public Vector<Object[]> select ();
    public Object[] select (int id) throws UndefindedIndexException;
    public void update (int id, Object[] list);
}
