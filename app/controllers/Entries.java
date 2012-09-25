package controllers;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

import controllers.CRUD.ObjectType;

import play.*;
import play.data.binding.Binder;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.mvc.*;
import models.Entry;
import models.Category;
@With(Secure.class)
@CRUD.For(Entry.class)
public class Entries extends CRUD {
    
    public static void create() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Model object = (Model) constructor.newInstance();
        Binder.bindBean(params.getRootParamNode(), "object", object);
        validation.valid(object);
        if (validation.hasErrors()) {
            renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
            try {
                render(request.controller.replace(".", "/") + "/blank.html", type, object);
            } catch (TemplateNotFoundException e) {
                render("CRUD/blank.html", type, object);
            }
        }
        //Get the category id and get the object in database
        String idCategory=params.get("object.category.id");
        Category category=Category.findById(Long.parseLong(idCategory));
        //persist the object
        object._save();
        //get all entries
        List<Entry> entries=Entry.findAll();
        //get the last entry (just persisted)
        Entry entry=entries.get(entries.size()-1);
        //add it to our category
        category.entries.add(entry);
        //persist the category
        category.save();
        
        flash.success(play.i18n.Messages.get("crud.created", type.modelName));
        if (params.get("_save") != null) {
            redirect(request.controller + ".list");
        }
        if (params.get("_saveAndAddAnother") != null) {
            redirect(request.controller + ".blank");
        }
        
        redirect(request.controller + ".show", object._key());
    }
    
    public static void save(String id) throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Model object = type.findById(id);
        notFoundIfNull(object);
        
        Long idEntry=((Entry) object).id;
        Entry oldEntry=Entry.findById(idEntry);
        Long oldCategoryId=oldEntry.category.id;
        
        Binder.bindBean(params.getRootParamNode(), "object", object);
        validation.valid(object);
        if (validation.hasErrors()) {
            renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
            try {
                render(request.controller.replace(".", "/") + "/show.html", type, object);
            } catch (TemplateNotFoundException e) {
                render("CRUD/show.html", type, object);
            }
        }
        
        Long potencialNewCategoryId=Long.parseLong(params.get("object.category.id"));
        
        //if we have changed the category of the entry
        if(!oldCategoryId.equals(potencialNewCategoryId)) {
            //get the new category id
            Category newCategory=Category.findById(potencialNewCategoryId);
            //System.out.println("New category " + newCategory);
            //get the old category to remove the entry
            Category oldCategory=Category.findById(oldCategoryId);
            //System.out.println("Old category " + oldCategory);
            //System.out.println("Old entry" + oldEntry);
            Entry entryToDeleteFromOldCategory=oldCategory.findEntryById(oldEntry.id);
            if(entryToDeleteFromOldCategory!=null) {
                //System.out.println("Remove successful "+ oldCategory.entries.remove(entryToDeleteFromOldCategory));
                oldCategory.save();
            }
            object._save();
            //Add the new entry to his new Category
            Entry newEntry=Entry.findById(entryToDeleteFromOldCategory.id);
            newCategory.entries.add(newEntry);
            newCategory.save();
        }
        else {
            object._save();
        }
        
        flash.success(play.i18n.Messages.get("crud.saved", type.modelName));
        if (params.get("_save") != null) {
            redirect(request.controller + ".list");
        }
        redirect(request.controller + ".show", object._key());
    }
    
    public static void delete(String id) throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Model object = type.findById(id);
        notFoundIfNull(object);
        
        Entry entry=(Entry) object;
        Category category=Category.findById(entry.category.id);
        category.entries.remove(entry);
        category.save();
        
        try {
            object._delete();
        } catch (Exception e) {
            flash.error(play.i18n.Messages.get("crud.delete.error", type.modelName));
            redirect(request.controller + ".show", object._key());
        }
        flash.success(play.i18n.Messages.get("crud.deleted", type.modelName));
        redirect(request.controller + ".list");
    }
    
}