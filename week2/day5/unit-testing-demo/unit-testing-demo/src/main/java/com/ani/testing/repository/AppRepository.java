package com.ani.testing.repository;

import com.ani.testing.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {
    List<App> findByPubDtBetween(Date st, Date ed);
}
