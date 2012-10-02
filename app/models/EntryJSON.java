package models;
 
import play.*;
 
public class EntryJSON {
	
    public String title;
    public String desc;
    public Long id;

    @Override
    public String toString() {
        return title;
    }

    public EntryJSON(String title, String desc,Long id) {
        super();
        this.title = title;
        this.desc = desc;
        this.id = id;
    }
	
}