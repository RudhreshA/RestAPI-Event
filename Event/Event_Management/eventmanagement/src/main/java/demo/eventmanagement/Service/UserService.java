package demo.eventmanagement.Service;

import demo.eventmanagement.Model.User;
import demo.eventmanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, String username, String email) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(username);
            user.setEmail(email);
            return userRepository.save(user);
        }
        return null;
    }

    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        }
        return "User not found!";
    }

    public List<User> getUsersPaginated(int page, int size) {
        Page<User> usersPage = userRepository.findAll(PageRequest.of(page, size));
        return usersPage.getContent();
    }    

    public List<User> getUsersPaginatedAndSorted(int page, int size, String field) {
        Page<User> usersPage = userRepository.findAll(PageRequest.of(page, size, Sort.by(field)));
        return usersPage.getContent();
    }
        
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
