package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import com.google.gson.Gson;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void faq(String lang) {
        List<Category> categories = Category.findAll();
        
        //Render JSONP
        if (request.params._contains("callback")) {

            Gson gson = new Gson();

            String out = gson.toJson(categoryJSON(categories,lang));

            renderText(request.params.get("callback") + "(" + out + ")");

         } else {

            renderJSON(categoryJSON(categories,lang));

         }
    }
    
    public static void categories(String lang) {
        List<Category> categories = Category.findAll();
        
        //Render JSONP
        if (request.params._contains("callback")) {

            Gson gson = new Gson();

            String out = gson.toJson(categoryRestJSON(categories,lang));

            renderText(request.params.get("callback") + "(" + out + ")");

         } else {

            renderJSON(categoryRestJSON(categories,lang));

         }
    }
    
    
    public static void entries(String lang,Long idCategory) {
        Category category = Category.findById(idCategory);
        if(category!=null) {
          //Render JSONP
            if (request.params._contains("callback")) {

                Gson gson = new Gson();

                String out = gson.toJson(entryRestJSON(category.entries,lang));

                renderText(request.params.get("callback") + "(" + out + ")");

             } else {

                renderJSON(entryRestJSON(category.entries,lang));

             }
        }else {
            renderText("");
        }
        
    }
    
    
    
    
    public static List<CategoryJSON> categoryJSON(List<Category> categories,String lang) {
        
        List<CategoryJSON> categoriesJSON = new ArrayList<CategoryJSON>();
        
        for (Iterator iterator = categories.iterator(); iterator.hasNext();) {
            Category category = (Category) iterator.next();
            
            List<EntryJSON> entriesJSON = new ArrayList<EntryJSON>();
            
            for (Iterator iterator2 = category.getEntries().iterator(); iterator2.hasNext();) {
                Entry entry = (Entry) iterator2.next();
                if(!entry.getTitleAndDesc(lang).title.equals("")) {
                    entriesJSON.add(new EntryJSON(entry.getTitleAndDesc(lang).title, entry.getTitleAndDesc(lang).desc));
                }
            }
            
            if(category.getTitleAndDesc(lang)!=null) {
                categoriesJSON.add(new CategoryJSON(category.getTitleAndDesc(lang).title, category.getTitleAndDesc(lang).desc,entriesJSON));
            }
        }
        return categoriesJSON;
    }
    
    public static List<CategorySimpleJSON> categoryRestJSON(List<Category> categories,String lang) {
        List<CategorySimpleJSON> categoriesJSON = new ArrayList<CategorySimpleJSON>();
        
        for (Iterator iterator = categories.iterator(); iterator.hasNext();) {
            Category category = (Category) iterator.next();
 
            if(!category.getTitleAndDesc(lang).title.equals("")) {
                categoriesJSON.add(new CategorySimpleJSON(category.getTitleAndDesc(lang).title, category.getTitleAndDesc(lang).desc,category.id));
            }
        }
        return categoriesJSON;
        
    }
    
    public static List<EntryJSON> entryRestJSON(List<Entry> entries,String lang) {
        List<EntryJSON> entriesJSON = new ArrayList<EntryJSON>();
        
        for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
            Entry entry = (Entry) iterator.next();
            if(!entry.getTitleAndDesc(lang).title.equals("")) {
                entriesJSON.add(new EntryJSON(entry.getTitleAndDesc(lang).title, entry.getTitleAndDesc(lang).desc));
            }
        }
        return entriesJSON;
        
    }

}