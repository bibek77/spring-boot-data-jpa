package com.udemycourse.springboot.learnspringbootjpa.versioning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bibek
 */
@RestController
public class VersionPersonController {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/person")
    public PersonV1 getFirstVersionOfPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v2/person")
    public PersonV2 getFirstVersionOfPersonV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonReqParamV1() {
        return new PersonV1("Bob Charlie");
    }
    // parameter type version

    @RequestMapping(method = RequestMethod.GET, path = "/person", params = "version=2")
    public PersonV2 getFirstVersionOfPersonReqParamV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    // Header type versioning
    @RequestMapping(method = RequestMethod.GET, path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonReqHeader() {
        return new PersonV1("Bob Charlie");
    }

    // Media type versioning
    @RequestMapping(method = RequestMethod.GET, path = "/person/accept", headers = "test.app-v1.json")
    public PersonV1 getFirstVersionOfPersonReqAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }
}
