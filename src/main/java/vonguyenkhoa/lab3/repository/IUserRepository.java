package vonguyenkhoa.lab3.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vonguyenkhoa.lab3.entity.User;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Query("Select u From User u where u.username = ?1")
    User findByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_role (user_id, role_id)"+"VALUES(?1, ?2)", nativeQuery = true)
    void addRoleToUser(Long userId, Long roleId);
    @Query("Select u.id From User u where u.username = ?1")
    Long getUserIdByUsername(String username);
    @Query(value = "SELECT r.name FROM role r \n" +
            "INNER JOIN user_role ur\n" +
            "    ON r.id = ur.role_id \n" +
            "\t WHERE ur.user_id = ?1", nativeQuery = true)
    String[] getRolesOfUser(Long userId);
}
