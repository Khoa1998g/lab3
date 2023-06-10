package vonguyenkhoa.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vonguyenkhoa.lab3.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r.id From Role r WHERE r.name = ?1")
    Long getRoleIdByName(String roleName);
}
