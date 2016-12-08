package com.shivang.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by sshah20 on 12/7/16.
 */
@RestController
@RequestMapping("/dev")
@Profile("dev")
public class DevController {

    private static Logger logger = LoggerFactory.getLogger(DevController.class);

    @RequestMapping(method = GET)
    public ResponseEntity<String> e2eEndpoint(HttpServletRequest request) {
        logger.info("Call made to Dev Controller from address {}", request.getRemoteAddr());
        return ResponseEntity.ok("Response from Dev Controller !");
    }
}
