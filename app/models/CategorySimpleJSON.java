package models;
 
import play.*;

import java.util.*;
 
public class CategorySimpleJSON {

    public String title;
    public String desc;
    public Long id;
	
	@Override
    public String toString() {
        return title;
    }

    public CategorySimpleJSON(String title, String desc,Long id) {
        super();
        this.title = title;
        this.desc = desc;
        this.id=id;
    }
}