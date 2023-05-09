package uph.ii.borowiec.cinematickets;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import uph.ii.borowiec.cinematickets.entity.Role;
import uph.ii.borowiec.cinematickets.entity.User;
import uph.ii.borowiec.cinematickets.repository.RoleRepository;
import uph.ii.borowiec.cinematickets.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Configuration
public class RepositoriesInitializer {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public InitializingBean initDb() {
        return () -> {
            Role roleUser = new Role(Role.Type.ROLE_USER);
            Role roleAdmin = new Role(Role.Type.ROLE_ADMIN);

            roleRepository.save(roleUser);
            roleRepository.save(roleAdmin);

            User user = new User("user", passwordEncoder.encode("user"));
            User admin = new User("admin", passwordEncoder.encode("admin"));

            user.setRoles(new HashSet<>(List.of(roleUser)));
            admin.setRoles(new HashSet<>(Arrays.asList(roleUser, roleAdmin)));

            userRepository.save(user);
            userRepository.save(admin);
        };
    }
}
