package org.example.present;

import java.sql.Connection;
import java.util.Scanner;
import java.util.Vector;

public interface TablePresent {
    public Object[] input();
    public void output (Object[] list);
    public void insert ();
    public void delete ();
    public void select ();
    public void update ();
}
