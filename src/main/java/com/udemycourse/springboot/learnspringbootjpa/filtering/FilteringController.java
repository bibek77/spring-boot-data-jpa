package com.udemycourse.springboot.learnspringbootjpa.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author bibek
 */

@RestController
public class FilteringController {

    @RequestMapping(method = RequestMethod.GET, path = "/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("val1", "val2", "val3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("val1","val2","val3"), new SomeBean("val4", "val5", "val6"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/filtering-list2")
    public MappingJacksonValue filteringList2() {
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("val1","val2","val3"), new SomeBean("val4", "val5", "val6"));
        MappingJacksonValue mappingJacksonValue = new
                MappingJacksonValue(someBeanList);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
