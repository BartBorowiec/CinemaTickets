package uph.ii.borowiec.cinematickets.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max=36)
    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
    public User() {

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>(List.of(new Role(Role.Type.ROLE_USER)));
    }
    public User(String username, String password, Set<GrantedAuthority> grantedAuthorities){
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>(List.of(new Role(Role.Type.ROLE_USER)));
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
