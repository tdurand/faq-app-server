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
	
    public String title_fr;
	@MaxSize(10000)
    public String desc_fr;
	
	public String title_en;
    @MaxSize(10000)
    public String desc_en;
    
    public String title_es;
    @MaxSize(10000)
    public String desc_es;
    
    public String title_it;
    @MaxSize(10000)
    public String desc_it;
    
    public String title_de;
    @MaxSize(10000)
    public String desc_de;
    
    public String title_pt;
    @MaxSize(10000)
    public String desc_pt;

    @Override
    public String toString() {
        return title_en;
    }
	
	
}