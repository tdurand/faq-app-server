package models;
 
import play.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;
 
import javax.persistence.*;

import java.util.*;
 
@Entity
@Table(name="category")
public class Category extends Model {

    @Column(name="title_cat")
	public String title;
	
    @Column(name="desc_cat")
	@MaxSize(10000)
	public String desc;
	
	@OneToMany
    public List<Entry> entries;
	
	@Override
    public String toString() {
        return title;
    }
	
}