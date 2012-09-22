package controllers;

import play.*;
import play.mvc.*;
import models.Category;

@With(Secure.class)
@CRUD.For(Category.class)
public class Categories extends CRUD {
    
    
    
}