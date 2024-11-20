package harmo.projects.services;

import harmo.projects.entities.AppUser;
import harmo.projects.entities.UserPrincipal;
import harmo.projects.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    /**
     * This calls the (user)repository/service that handles user interactions or fetching
     * from the database.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found!"));
        return new UserPrincipal(user);
    }
}
