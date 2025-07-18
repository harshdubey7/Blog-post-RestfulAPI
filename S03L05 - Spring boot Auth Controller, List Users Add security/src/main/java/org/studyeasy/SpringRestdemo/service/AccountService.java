package org.studyeasy.SpringRestdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringRestdemo.model.Account;
import org.studyeasy.SpringRestdemo.repository.AccountRepository;



@Service
public class AccountService implements UserDetailsService{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        if (account.getRole() == null){
            account.setRole("ROLE_USER");
        }
        return accountRepository.save(account);
        
    }

    public List<Account> findall(){

        return accountRepository.findAll();

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Account> optionaAccount =  accountRepository.findByEmail(email);
       if (!optionaAccount.isPresent()){
            throw new UsernameNotFoundException("Account not found");
       }
       Account account = optionaAccount.get();

       List<GrantedAuthority> grantedAuthoriy = new ArrayList<>();
       grantedAuthoriy.add(new SimpleGrantedAuthority(account.getRole()));
       return new User(account.getEmail(), account.getPassword(), grantedAuthoriy);
    }

}
