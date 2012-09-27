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
    
    @Required
    @ManyToOne
    public Category category;
	
    public String title_fr;
	@MaxSize(value = 100000)
	@Column(columnDefinition="TEXT")
    public String desc_fr;
	
	public String title_en;
	@MaxSize(value = 100000)
	@Column(columnDefinition="TEXT")
    public String desc_en;
    
    public String title_es;
    @MaxSize(value = 100000)
    @Column(columnDefinition="TEXT")
    public String desc_es;
    
    public String title_it;
    @MaxSize(value = 100000)
    @Column(columnDefinition="TEXT")
    public String desc_it;
    
    public String title_de;
    @MaxSize(value = 100000)
    @Column(columnDefinition="TEXT")
    public String desc_de;
    
    public String title_pt;
    @MaxSize(value = 100000)
    @Column(columnDefinition="TEXT")
    public String desc_pt;

    @Override
    public String toString() {
        return "["+category.title_en+"] "+title_en+" - "+title_fr;
    }
    
    public TitleDesc getTitleAndDesc(String lang) {
        TitleDesc titleDesc=new TitleDesc("","");
        if(lang.equals("fr")) {
            titleDesc.title=title_fr;
            titleDesc.desc=desc_fr;
        }
        else if(lang.equals("en")) {
            titleDesc.title=title_en;
            titleDesc.desc=desc_en;
        }
        else if(lang.equals("de")) {
            titleDesc.title=title_de;
            titleDesc.desc=desc_de;
        }
        else if(lang.equals("es")) {
            titleDesc.title=title_es;
            titleDesc.desc=desc_es;
        }
        else if(lang.equals("it")) {
            titleDesc.title=title_it;
            titleDesc.desc=desc_it;
        }
        else if(lang.equals("pt")) {
            titleDesc.title=title_pt;
            titleDesc.desc=desc_pt;
        }
        return titleDesc;
    }
	
	
}