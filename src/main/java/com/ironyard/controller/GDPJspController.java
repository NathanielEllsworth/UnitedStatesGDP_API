package com.ironyard.controller;


import com.ironyard.LoggingRequestInterceptor;
import com.ironyard.dto.USAGDP;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by nathanielellsworth on 11/7/16.
 */

@Controller
public class GDPJspController {

    @RequestMapping(value = "/us/gdp", method = RequestMethod.GET)
    public String list(Map<String, Object> model) {

        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(interceptors);
        USAGDP[] USgdp = restTemplate.getForObject("http://api.undata-api.org/WB/GDP growth (annual percent)/United States of America/records?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1" , USAGDP[].class);

        // GET RID OF ALL THE %20 IN THE URL's!! (those represent blank spaces)

        model.put("country", USgdp);
        return "USA";


    }
}
