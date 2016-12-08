package com.shivang.demo.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by sshah20 on 12/7/16.
 */
@RestController
@RequestMapping("/e2e")
@Profile("e2e")
public class E2EController {

    @RequestMapping(method = GET)
    public ResponseEntity<String> e2eEndpoint() {
        return ResponseEntity.ok("Response from E2E Controller !");
    }
}
