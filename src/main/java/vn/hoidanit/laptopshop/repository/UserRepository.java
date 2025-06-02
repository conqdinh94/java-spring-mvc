package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoidanit.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);

    List<User> findAll();

    List<User> findAllUserByEmail(String email);

    List<User> findAllUserByEmailAndAddress(String email, String address);

    User findById(int id);

    void deleteById(int id);
}
