package models;
 
import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;
 
import javax.persistence.*;

import java.util.*;
 
@Entity
@Table(name="entry")
public class Entry extends Model {
	
	@ManyToOne
	public Category category;
	
	public String title_fr;
	
	@MaxSize(10000)
    public String desc_fr;

    @Override
    public String toString() {
        return title_fr;
    }
	
	
}