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
	
    @Column(name="title_ent")
    public String title;
    
    @Column(name="desc_ent")
	@MaxSize(10000)
    public String desc;

    @Override
    public String toString() {
        return title;
    }
	
	
}