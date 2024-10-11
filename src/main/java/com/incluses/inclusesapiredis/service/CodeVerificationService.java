package com.incluses.inclusesapiredis.service;

import com.incluses.inclusesapiredis.model.CodeVerification;
import com.incluses.inclusesapiredis.repository.CodeVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeVerificationService {

    @Autowired
    private CodeVerificationRepository codeVerificationRepository;

    public CodeVerification save(CodeVerification codeVerification) {
        codeVerification.setExpiration(300L); // Expira em 5 minutos
        return codeVerificationRepository.save(codeVerification);
    }

    public CodeVerification findById(String id) {
        return codeVerificationRepository.findById(id).orElse(null);
    }

    public CodeVerification findByCode(String code) {
        for (CodeVerification codeVerification : codeVerificationRepository.findAll()) {
            if (codeVerification != null && codeVerification.getValue().equals(code)) {
                return codeVerification;
            }
        }
        return null;
    }

    public List<CodeVerification> findAll() {
        return (List<CodeVerification>) codeVerificationRepository.findAll();
    }

    public void delete(CodeVerification codeVerification) {
        codeVerificationRepository.delete(codeVerification);
    }

    public void deleteByCode(String code) {
        codeVerificationRepository.deleteById(code);
    }

    public CodeVerification update(CodeVerification codeVerification) {
        return codeVerificationRepository.save(codeVerification);
    }

    public CodeVerification updateByCode(String code, CodeVerification codeVerification) {
        codeVerification.setCode(code);
        return codeVerificationRepository.save(codeVerification);
    }
}
