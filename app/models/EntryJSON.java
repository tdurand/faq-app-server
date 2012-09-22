package models;
 
import play.*;
import play.db.jpa.Model;
 
import javax.persistence.*;

import java.util.*;
 
public class EntryJSON extends Model {
	
    public String title;
    public String desc;

    @Override
    public String toString() {
        return title;
    }

    public EntryJSON(String title, String desc) {
        super();
        this.title = title;
        this.desc = desc;
    }
	
}