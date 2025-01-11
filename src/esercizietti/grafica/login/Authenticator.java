package esercizietti.grafica.login;

import java.util.HashMap;

public class Authenticator {
    static HashMap<String, String> db = new HashMap<>();

    Authenticator() {
        for(int i=0 ; i<5 ; i++){
            db.put("user"+i, "pwd"+i);
        }
    }
    public boolean authenticate(String username, String password) throws UserNotFoundException {
        if (db.containsKey(username)){
            return db.get(username).equals(password);
        }
        else {
            throw new UserNotFoundException("L'utente: ["+username+"] non esiste");
        }
    }
}
