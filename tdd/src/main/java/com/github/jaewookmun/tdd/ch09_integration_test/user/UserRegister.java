package com.github.jaewookmun.tdd.ch09_integration_test.user;


import com.github.jaewookmun.tdd.ch09_integration_test.user.domain.User;
import com.github.jaewookmun.tdd.ch09_integration_test.user.exception.DupIdException;
import com.github.jaewookmun.tdd.ch09_integration_test.user.exception.WeakPasswordException;
import com.github.jaewookmun.tdd.ch09_integration_test.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegister {

    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    @Transactional
    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
