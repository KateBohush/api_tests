package de.fidor.bl.services;

import de.fidor.bl.services.endpoints.AuthService;
import de.fidor.bl.services.endpoints.UserRegistrService;
import de.fidor.core.RestClient;

public class ServiceFactory implements IEnvironment {

    private static ThreadLocal<RestClient> client = new ThreadLocal<>();

    protected String env = TestEnv;

    protected static RestClient getClient() {
        if (client.get() != null) {
            return client.get();
        } else {
            client.set(new RestClient());
        }
        return client.get();
    }

    public static AuthService getAuthService(){
        return new AuthService();
    }

    public static UserRegistrService  getUserRegistrService() { return new UserRegistrService();}

}
