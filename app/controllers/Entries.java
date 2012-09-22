package controllers;

import java.util.Iterator;
import java.util.List;

import play.*;
import play.mvc.*;
import models.Entry;
import models.Category;
@With(Secure.class)
@CRUD.For(Entry.class)
public class Entries extends CRUD {
    
    //Update relation OneToMany of category
    public static void bidirectionnal(Long idCategory,Long idEntry) {
        
        Category category=Category.findById(idCategory);
        Entry entry=Entry.findById(idEntry);
        
        category.entries.add(entry);
        
    }
    
}