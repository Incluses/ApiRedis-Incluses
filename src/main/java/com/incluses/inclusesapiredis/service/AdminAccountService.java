package com.incluses.inclusesapiredis.service;

import com.incluses.inclusesapiredis.model.AdminAccount;
import com.incluses.inclusesapiredis.model.CodeVerification;
import com.incluses.inclusesapiredis.repository.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAccountService {

    @Autowired
    private AdminAccountRepository adminAccountRepository;

    public AdminAccount save(AdminAccount adminAccount) {
        return adminAccountRepository.save(adminAccount);
    }

    public AdminAccount findByEmail(String email) {
        for (AdminAccount adminAccount : adminAccountRepository.findAll()) {
            if (adminAccount.getEmail().equals(email)) {
                return adminAccount;
            }
        }
        return null;
    }


    public List<AdminAccount> findAll() {
        return (List<AdminAccount>) adminAccountRepository.findAll();
    }

    public void delete(AdminAccount adminAccount) {
        adminAccountRepository.delete(adminAccount);
    }

    public AdminAccount deleteByEmail(String email) {
        for (AdminAccount adminAccount : adminAccountRepository.findAll()) {
            if (adminAccount.getEmail().equals(email)) {
                adminAccountRepository.delete(adminAccount);
                return adminAccount;
            }
        }
        return null;
    }

    public void update(AdminAccount adminAccount) {
        adminAccountRepository.save(adminAccount);
    }

    public void updateByEmail(String email, AdminAccount adminAccount) {
        adminAccount.setEmail(email);
        adminAccountRepository.save(adminAccount);
    }

    public void updateByPassword(String password, AdminAccount adminAccount) {
        adminAccount.setPassword(password);
        adminAccountRepository.save(adminAccount);
    }
}
