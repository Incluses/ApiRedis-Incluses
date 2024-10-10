package com.incluses.inclusesapiredis.controller;

import com.incluses.inclusesapiredis.model.AdminAccount;
import com.incluses.inclusesapiredis.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api-redis/admin-account")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;

    // Criar uma nova conta de administrador
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminAccount save(@RequestBody AdminAccount adminAccount) {
        return adminAccountService.save(adminAccount);
    }


    // Buscar todas as contas de administrador
    @GetMapping("/list")
    public List<AdminAccount> findAll() {
        return adminAccountService.findAll();
    }

    // Buscar conta de administrador por email
    @GetMapping("/find/{email}")
    public Optional<AdminAccount> findByEmail(@PathVariable String email) {
        return Optional.ofNullable(adminAccountService.findByEmail(email));
    }

    // Atualizar conta de administrador por email
    @PutMapping("/update/{email}")
    public void updateByEmail(@PathVariable String email, @RequestBody AdminAccount adminAccount) {
        adminAccountService.updateByEmail(email, adminAccount);
    }

    // Atualizar a senha de uma conta de administrador
    @PutMapping("/update-password/{email}")
    public AdminAccount updatePassword(@PathVariable String email, @RequestBody String newPassword) {
        AdminAccount adminAccount = adminAccountService.findByEmail(email);
        if (adminAccount != null) {
            adminAccountService.updateByPassword(newPassword, adminAccount);
        }
        return adminAccount;
    }

    // Excluir conta de administrador por email
    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<AdminAccount> deleteByEmail(@PathVariable String email) {
        return Optional.ofNullable(adminAccountService.deleteByEmail(email));
    }

    //Delete por id
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody AdminAccount adminAccount) {
        adminAccountService.delete(adminAccount);
    }
}
