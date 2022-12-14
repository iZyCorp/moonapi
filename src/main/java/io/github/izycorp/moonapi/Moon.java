package io.github.izycorp.moonapi;

import io.github.izycorp.moonapi.exceptions.MoonViolationException;
import io.github.izycorp.moonapi.query.RequestManager;
import io.github.izycorp.moonapi.abstraction.RequestRoute;
import io.github.izycorp.moonapi.abstraction.Route;
import io.github.izycorp.moonapi.components.ApiVersion;
import io.github.izycorp.moonapi.components.Platform;
import org.json.JSONObject;

/**
 * @author iZy
 * @version 1.0
 * @since 1.0
 * <p>
 *     This class is the main class of the API. It contains all methods of ProtectedRoute and PublicRoute that you can access with a simple instance of Moon Object.
 * </p>
 */
public class Moon {

    private final RequestManager request;
    /**
     * Initialize the Title Object with a RequestManager object
     *
     * @param request - A valid RequestManager Object
     */
    public Moon(RequestManager request) {
        this.request = request;
    }

    /**
     * This method is used to search a player on the wanted platform
     * @param playerName - The name of the player you want to search
     * @param platform - The platform of the player you want to search see {@link Platform}
     * @return A valid JSONObject
     * @throws MoonViolationException - If the request is not valid
     */
    @Route(requestRoute = RequestRoute.PROTECTED)
    public JSONObject searchPlayer(String playerName, Platform platform) throws MoonViolationException {
        String responseBody = request.sendRequestWithAuthentication("crm/cod/"+ ApiVersion.V2 + "/platform/" + platform.getIdentifier() + "/username/" + playerName + "/search", request.authenticate("izy"));
        return new JSONObject(responseBody);
    }
}
