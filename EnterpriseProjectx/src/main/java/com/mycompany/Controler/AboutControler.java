
package com.mycompany.Controler;

import com.mycompany.Service.PrintPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/info")
public class AboutControler {
    @Autowired
    private PrintPersonService service;

    public AboutControler() {
        System.out.println("Kontroler gjukhgjk");
    }
    
    
    
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String redirect()
    {
        return "/aboutx.jsp";
    }
}
