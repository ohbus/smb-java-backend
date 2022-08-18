package xyz.subho.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.subho.inventory.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
