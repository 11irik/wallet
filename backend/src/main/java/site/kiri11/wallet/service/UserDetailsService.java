package site.kiri11.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.kiri11.wallet.domain.Account;
import site.kiri11.wallet.domain.User;
import site.kiri11.wallet.repo.UserDetailsRepo;

@Service
public class UserDetailsService {
    private final UserDetailsRepo userDetailsRepo;

    @Autowired
    public UserDetailsService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    public User getByEmail(String email) {
        return userDetailsRepo.findByEmail(email);
    }

    public User setDefaultAccount(User user, Account account) {
        user.setDefaultAccount(account);
        return userDetailsRepo.save(user);
    }
}
