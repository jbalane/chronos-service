package com.sensis.chronosservice.service;

import com.sensis.chronosservice.model.User;
import com.sensis.chronosservice.model.UserDTO;
import com.sensis.chronosservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority(){
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public User save(UserDTO user) {

        User newUser = new User();

        newUser.setEnterpriseId(user.getEnterpriseId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setContactNumber(user.getContactNumber());
        newUser.setIsApprover(user.getIsApprover());
        newUser.setProjectStartDate(user.getProjectStartDate());
        newUser.setProjectEndDate(user.getProjectEndDate());


        return userRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {

        Optional<User> user = findById(id);
        if(user != null){
            userRepository.deleteById(id);
        }

    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User update(Long id, User user) {

        Optional<User> u = findById(id);

        if(u.isPresent()){
            u.get().setUsername(user.getUsername());
            u.get().setPassword(user.getPassword());
            u.get().setFirstName(user.getFirstName());
            u.get().setLastName(user.getLastName());
            u.get().setEmail(user.getEmail());
        }else{
            //TODO: return exception
        }

        return userRepository.save(u.get());
    }



}
