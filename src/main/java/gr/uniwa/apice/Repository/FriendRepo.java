package gr.uniwa.apice.Repository;

import gr.uniwa.apice.Domain.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepo extends JpaRepository<Friend,Integer> {

}
