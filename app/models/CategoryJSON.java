package models;
 
import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;
 
import javax.persistence.*;

import java.util.*;
 
public class CategoryJSON extends Model {

    public String title;
    public String desc;
	
	@OneToMany
    public List<EntryJSON> entries;
	
	@Override
    public String toString() {
        return title;
    }

    public CategoryJSON(String title, String desc, List<EntryJSON> entries) {
        super();
        this.title = title;
        this.desc = desc;
        this.entries = entries;
    }
}