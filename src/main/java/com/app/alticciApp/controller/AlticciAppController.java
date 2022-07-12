package com.app.alticciApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.alticciApp.dto.AlticciDto;
import com.app.alticciApp.service.AlticciService;

@RestController
@RequestMapping("/alticci")
public class AlticciAppController {

    @Autowired
    private AlticciService alticciService;

    @GetMapping(path = "/{n}")
    public ResponseEntity<AlticciDto> getAlticci(@PathVariable String n) {
        return new ResponseEntity<>(alticciService.getAlticci(n), HttpStatus.OK);

    }

    @GetMapping(path = "/deleteAll")
    public ResponseEntity<Void> deleteRedisData() {
        alticciService.deleteAll();
        return ResponseEntity.noContent().build();

    }
}
