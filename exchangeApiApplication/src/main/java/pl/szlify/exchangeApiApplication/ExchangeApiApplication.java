package pl.szlify.exchangeApiApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.szlify.exchangeApiApplication.model.entity.UserEntity;
import pl.szlify.exchangeApiApplication.repository.UserRepository;
import pl.szlify.exchangeApiApplication.security.Role;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class ExchangeApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		UserEntity admin = new UserEntity();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin123"));
		admin.setEmail("adrianks@op.pl");
		admin.setRoles(new HashSet<>(Arrays.asList(Role.ADMIN)));
		userRepository.save(admin);
	}
}
