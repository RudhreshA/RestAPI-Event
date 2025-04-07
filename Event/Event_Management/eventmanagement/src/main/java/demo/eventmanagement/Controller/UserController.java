package demo.eventmanagement.Controller;

import demo.eventmanagement.Model.User;
import demo.eventmanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User u = userService.getUserById(id);
        if (u != null)
            return new ResponseEntity<>(u, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User u = userService.updateUser(id, user.getUsername(), user.getEmail());
        if (u != null)
            return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @GetMapping("/users/paginate")
    public ResponseEntity<List<User>> getUsersPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
    return new ResponseEntity<>(userService.getUsersPaginated(page, size), HttpStatus.OK);
    }


    @GetMapping("/users/paginate-sort")
    public ResponseEntity<List<User>> getUsersPaginatedAndSorted(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "id") String field) {
    return new ResponseEntity<>(userService.getUsersPaginatedAndSorted(page, size, field), HttpStatus.OK);
    }

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
