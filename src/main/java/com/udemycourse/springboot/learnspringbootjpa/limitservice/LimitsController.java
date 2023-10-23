package com.udemycourse.springboot.learnspringbootjpa.limits;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bibek
 */
@RestController
public class LimitsController {

    @RequestMapping(method = RequestMethod.GET, path = "/limits")
    public Limits getLimits() {
        return new Limits(1, 100);
    }
}
