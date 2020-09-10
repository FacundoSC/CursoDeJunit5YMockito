package mockito;

public class WebService {

    public void login(String user, String password,Callback callback){

        if (checkLogin(user,password)){
            callback.onSuccess("Correct User");
        }
        else{
            callback.onFail("Incorrect User or Password");
        }
    }
    public boolean checkLogin(String user, String password){
        if(user.equals("Facundo") && password.equals("1234")){
            return true;
        }
        else{
            return false;
        }
    }

}
