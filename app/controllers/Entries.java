package controllers;

import play.*;
import play.mvc.*;
import models.Entry;

@With(Secure.class)
@CRUD.For(Entry.class)
public class Entries extends CRUD {
    
    
    
}