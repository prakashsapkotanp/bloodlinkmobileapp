package bloodllink.app.bloodlinkbackendapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bloodllink.app.bloodlinkbackendapi.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

}
