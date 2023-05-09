package com.dlewburg.Recipie.repos;

import com.dlewburg.Recipie.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepo extends JpaRepository<SiteUser, Long> {
    public SiteUser getSiteUserByUsername(String userName);
}
