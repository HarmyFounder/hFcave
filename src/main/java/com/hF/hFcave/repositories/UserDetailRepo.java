package com.hF.hFcave.repositories;

import com.hF.hFcave.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<User,String> {



}
