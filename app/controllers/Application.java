package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void faq(String lang) {
        List<Category> categories = Category.findAll();
        
        List<CategoryJSON> categoriesJSON = new ArrayList<CategoryJSON>();
        
        if(lang.equals("fr")) {
            for (Iterator iterator = categories.iterator(); iterator.hasNext();) {
                Category category = (Category) iterator.next();
                
                List<EntryJSON> entriesJSON = new ArrayList<EntryJSON>();
                
                for (Iterator iterator2 = category.getEntries().iterator(); iterator2.hasNext();) {
                    Entry entry = (Entry) iterator2.next();
                    entriesJSON.add(new EntryJSON(entry.title_fr, entry.desc_fr));
                }
                
                categoriesJSON.add(new CategoryJSON(category.title_fr, category.desc_fr,entriesJSON));
                
            }
            renderJSON(categoriesJSON);
        }
        else if(lang.equals("en")) {
            
        }
        else if(lang.equals("es")) {
            
        }
        else if(lang.equals("de")) {
            
        }
        else if(lang.equals("it")) {
            
        }
        else if(lang.equals("pt")) {
            
        }
        
        
    }

}