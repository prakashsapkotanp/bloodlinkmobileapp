package bloodllink.app.bloodlinkbackendapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "userid")
    int userId;
     @Column(name = "username")
    int name;
     @Column(name = "usrrole")
    int role;
}
