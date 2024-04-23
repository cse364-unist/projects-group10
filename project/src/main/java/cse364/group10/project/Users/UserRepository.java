package cse364.group10.project.Users;

import  cse364.group10.project.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
