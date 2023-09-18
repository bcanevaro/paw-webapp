package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.services.UserService;
import ar.edu.itba.paw.webapp.exceptions.UserNotFoundException;
import ar.edu.itba.paw.webapp.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.function.Supplier;

@Controller
public class HelloWorldController {

    private final UserService us;

    @Autowired
    public HelloWorldController(final UserService us){
        this.us = us;
    }

    @RequestMapping("/")
    public ModelAndView helloWorld() {
        final ModelAndView mav = new ModelAndView("helloworld/index");
        mav.addObject("user", us.createUser("paw@itba.edu.ar","mysecret",0));
        return mav;
    }

    //con esta anotación (exception handler), generamos la página que le aparecerá al usuario al encontrarse con el problema
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ModelAndView noSuchUser(){
        return new ModelAndView("404");
    }

    public ModelAndView index(@RequestParam(value = "userId",required = true) final long id){
        final ModelAndView mav = new ModelAndView("index");
        mav.addObject("user",us.findById(id).orElseThrow(UserNotFoundException::new));
        return mav;

    }

    @RequestMapping("/{id:\\d+}")
    public ModelAndView profile(@PathVariable("id") final long userId){
        final ModelAndView mav = new ModelAndView("helloworld/profile");
        mav.addObject("userid",userId);
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("userForm") final UserForm userForm, final BindingResult errors){
        if(errors.hasErrors()){
            return registerForm(userForm);
        }
        final User u = us.createUser(userForm.getName(),userForm.getPassword(),0);
        return new ModelAndView("redirect:/?userId="+u.getId());
    }

    @RequestMapping("/register")
    public ModelAndView registerForm(@ModelAttribute("userForm") final UserForm userForm){
        return new ModelAndView("register");
    }

    @ModelAttribute("loggedUser")
    public User getLoggedUser(){
        return new User("Test User","secret",1);
    }
}
