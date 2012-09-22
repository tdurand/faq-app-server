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
        
        renderJSON(categoryJSON(categories,lang));
    }
    
    public static List<CategoryJSON> categoryJSON(List<Category> categories,String lang) {
        
        List<CategoryJSON> categoriesJSON = new ArrayList<CategoryJSON>();
        
        for (Iterator iterator = categories.iterator(); iterator.hasNext();) {
            Category category = (Category) iterator.next();
            
            List<EntryJSON> entriesJSON = new ArrayList<EntryJSON>();
            
            for (Iterator iterator2 = category.getEntries().iterator(); iterator2.hasNext();) {
                Entry entry = (Entry) iterator2.next();
                entriesJSON.add(new EntryJSON(entry.getTitleAndDesc(lang).title, entry.getTitleAndDesc(lang).desc));
            }
            
            categoriesJSON.add(new CategoryJSON(category.getTitleAndDesc(lang).title, category.getTitleAndDesc(lang).desc,entriesJSON));
            
        }
        return categoriesJSON;
    }

}