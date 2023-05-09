package uph.ii.borowiec.cinematickets.service;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uph.ii.borowiec.cinematickets.ProfileNames;
import uph.ii.borowiec.cinematickets.dto.UserDto;
import uph.ii.borowiec.cinematickets.entity.Role;
import uph.ii.borowiec.cinematickets.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
@Profile(ProfileNames.USERS_IN_DATABASE)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User registerNewUserAccount(@Valid UserDto userDto) throws UsernameExistsException {
//        if (usernameExists(userDto.getUsername())) {
//            throw new UsernameExistsException("There is an account with that email address: " + userDto.getUsername());
//        }
//
//        User user = new User();
//        user.setUsername(userDto.getUsername());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//        return userRepository.save(user);
//    }

    private boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public User loginUserAccount(UserDto userDto) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
            var user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return convertToUserDetails(user);
    }

    private UserDetails convertToUserDetails(uph.ii.borowiec.cinematickets.entity.User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getType().toString()));
        }

        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);//UWAGA: klasa ma też drugi konstruktor – więcej parametrów!!!
    }

}