package com.udemycourse.springboot.learnspringbootjpa.limitservice;

import com.udemycourse.springboot.learnspringbootjpa.limitservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bibek
 */
@RestController
public class LimitsController {

    @Autowired
    Configuration configuration;

    @RequestMapping(method = RequestMethod.GET, path = "/limits")
    public Limits getLimits() {
        return new Limits(configuration.getMin(), configuration.getMax());
    }
}
