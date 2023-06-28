package com.samiak.azure.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest) {
        return "hello";
    }

    /**
     * Access resource servers from a web application
     * graph is the client ID configured in the previous step. OAuth2AuthorizedClient contains the access token, which is used to access the resource server.
     * @param graphClient
     * @return
     */
    @GetMapping("/graph")
    @ResponseBody
    public String graph(
            @RegisteredOAuth2AuthorizedClient("graph") OAuth2AuthorizedClient graphClient) {
        return graphClient.getAccessToken().getTokenValue();
    }

    @GetMapping("/resource-server")
    @ResponseBody
    public String resourceServer(
            @RegisteredOAuth2AuthorizedClient("resource-server") OAuth2AuthorizedClient resourceServer) {
        return resourceServer.getAccessToken().getTokenValue();
    }
}
