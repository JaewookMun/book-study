package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_set_duplicate_env;

public class ChangeUserService implements UserService {

    private UserRepository userRepository;

    public ChangeUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void changeAddress(String id, Address address) {
        User user = userRepository.findById(id);
        if (user == null) throw new UserNotFoundException();

        user.setAddress(address);
    }

    @Override
    public void changePw(String id, String prevPw, String newPw) {
        User user = userRepository.findById(id);

        if (user.getPassword().equals(prevPw)) {
            user.setPassword(newPw);
        }
        else throw new IdPwNotMatchException();
    }
}
