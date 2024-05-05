import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<>();

    IDandPasswords() {
        logininfo.put("admin","password");
        logininfo.put("saim","dicey");
    }

    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
