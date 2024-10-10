package com.incluses.inclusesapiredis.controller;

import com.incluses.inclusesapiredis.model.CodeVerification;
import com.incluses.inclusesapiredis.service.CodeVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/list/{code}") // Alterar {id} para {code}
    public Optional<CodeVerification> findByCode(@PathVariable String code) { // Usar @PathVariable
        return Optional.ofNullable(codeVerificationService.findByCode(code));
    }

    @GetMapping("/list")
    public List<CodeVerification> findAll() {
        return codeVerificationService.findAll();
    }

    @DeleteMapping("/delete/{code}") // Alterar {id} para {code}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCode(@PathVariable String code) { // Usar @PathVariable
        codeVerificationService.deleteByCode(code);
    }
}
