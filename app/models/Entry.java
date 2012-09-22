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