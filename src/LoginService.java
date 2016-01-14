import java.util.HashMap;

import UserClass.User;

//business service
public class LoginService
{
	
	 HashMap<String, String> map = new HashMap<>();
	
	public LoginService()
	{
		map.put("1", "Rutvik");
		map.put("2", "Darpan");
		map.put("3", "Saheb");
		
	 }
	 
	 
	 
	 
	public boolean authenticate(String userId , String passward)
	{
		if(passward != null && passward.trim() != "")
		{
			return true;
		}
		return false;
	}
	
	public User getUserDetails(String userId)
	{
		User user = new User();
		user.setUserName(map.get(userId));
		user.setUserId(userId);
		return user;
	}
	
}
