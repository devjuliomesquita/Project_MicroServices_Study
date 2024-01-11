package com.juliomesquita.authentication.infra.config.security.user;

import com.juliomesquita.core.domain.model.entities.AuthenticationUser;
import com.juliomesquita.core.infra.repository.AuthenticationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor()
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthenticationUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Procurando no banco pelo username '{}'",username);
        AuthenticationUser user = this.repository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("Usuário de username '%s', não encontrado.", username));
        }
        return new CustomUserDetails(user);
    }
    public static final class CustomUserDetails extends AuthenticationUser implements UserDetails{
        public CustomUserDetails(AuthenticationUser authenticationUser) {
            super(authenticationUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("Role_" + this.getRole());
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
