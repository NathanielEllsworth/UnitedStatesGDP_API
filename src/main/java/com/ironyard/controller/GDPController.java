package com.ironyard.controller;

import com.ironyard.dto.USAGDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by nathanielellsworth on 11/7/16.
 */
@RestController
public class GDPController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/usagdp/year", method = RequestMethod.GET)
    public Iterable<USAGDP> list(@RequestParam(value = "filter", required = false) String filter) {
        log.debug("Request to list Country gdp.");
        RestTemplate restTemplate = new RestTemplate();
        USAGDP[] cntry = restTemplate.getForObject("http://api.undata-api.org/WB/GDP growth (annual percent)/United States of America/records?app_id=d472233a&app_key=bb0c4591863b91d6208ca6679af8d0e1", USAGDP[].class);
        log.info(cntry.toString());
        log.debug("Fetch Country gdp complete.");
        List<USAGDP> foundAllList = Arrays.asList(cntry);
        List<USAGDP> filteredList = new ArrayList<>();

        if (filter != null) {
            // filter the list
            for (USAGDP aCountry : foundAllList) {
                if (aCountry.getArea_name().startsWith(filter)) {
                    filteredList.add(aCountry);
                }
            }
        } else {
            filteredList = foundAllList;
        }
        return filteredList;
    }
}
