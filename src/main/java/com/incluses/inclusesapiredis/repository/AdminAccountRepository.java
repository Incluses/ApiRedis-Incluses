package com.incluses.inclusesapiredis.repository;

import com.incluses.inclusesapiredis.model.AdminAccount;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AdminAccountRepository extends CrudRepository<AdminAccount, String> {
}