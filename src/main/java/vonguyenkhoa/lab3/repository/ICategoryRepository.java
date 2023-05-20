package vonguyenkhoa.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vonguyenkhoa.lab3.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
