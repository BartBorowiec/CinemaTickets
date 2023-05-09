package uph.ii.borowiec.cinematickets.repository;

import uph.ii.borowiec.cinematickets.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}