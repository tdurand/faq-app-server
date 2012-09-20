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
        if(lang.equals("fr")) {
            List<Category> categories = Category.findAll();
            renderJSON(categories);
        }
    }

}