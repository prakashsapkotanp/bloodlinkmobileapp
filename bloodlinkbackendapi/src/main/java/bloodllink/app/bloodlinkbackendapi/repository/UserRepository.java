package bloodllink.app.bloodlinkbackendapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import bloodllink.app.bloodlinkbackendapi.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
	UserEntity findByUsername(String username);
}
