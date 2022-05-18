package guru.springframework.sfgpetclinic.controllers;

public class IndexController {

    public String index(){
        return "index";
    }

    public String ooupsHandler(){
        throw new ValueNotFoundException();
    }
}
