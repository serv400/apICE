package gr.uniwa.apice.Service;

import gr.uniwa.apice.Repository.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendRepo friendRepo;
}
