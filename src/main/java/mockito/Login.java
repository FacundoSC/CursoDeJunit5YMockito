package mockito;

public class Login {
    private final WebService webService;
    private Boolean isLogin;

    public Boolean getLogin() {

        return isLogin;
    }

    public Login(WebService webService){

        this.webService = webService;
        isLogin= false;
    }

    public void doLogin(){
        webService.login("Facundo", "1234", new Callback() {
            @Override
            public void onSuccess(String respuesta) {
             System.out.println(respuesta);
             isLogin = true;
            }

            @Override
            public void onFail(String error) {
                System.out.println(error);
            }
        });


    }
}
