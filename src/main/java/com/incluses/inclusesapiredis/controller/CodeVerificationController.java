package com.incluses.inclusesapiredis.controller;

import com.incluses.inclusesapiredis.model.CodeVerification;
import com.incluses.inclusesapiredis.service.CodeVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api-redis/code-verification")
public class CodeVerificationController {

    @Autowired
    private CodeVerificationService codeVerificationService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CodeVerification save(@RequestBody CodeVerification codeVerification) {
        return codeVerificationService.save(codeVerification);
    }

    @GetMapping("/list/id/{id}")
    public ResponseEntity<CodeVerification> findById(@PathVariable String id) {
        Optional<CodeVerification> codeVerification = Optional.ofNullable(codeVerificationService.findById(id));
        if (codeVerification.isPresent()) {
            return new ResponseEntity<>(codeVerification.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/code/{code}")
    public ResponseEntity<CodeVerification> findByCode(@PathVariable String code) {
        Optional<CodeVerification> codeVerification = Optional.ofNullable(codeVerificationService.findByCode(code));
        if (codeVerification.isPresent()) {
            return new ResponseEntity<>(codeVerification.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/list")
    public List<CodeVerification> findAll() {
        return codeVerificationService.findAll();
    }

    @DeleteMapping("/delete/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCode(@PathVariable String code) {
        codeVerificationService.deleteByCode(code);
    }
}
