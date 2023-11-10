package bloodllink.app.bloodlinkbackendapi.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegistrationRequest {


	private String username;
	private String password;


}
