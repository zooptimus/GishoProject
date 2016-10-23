/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.spring.interceptor;

import org.gisho.model.entity.FacebookDTO;
import org.gisho.spring.services.UserTaskService;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author ZO-PC
 */
public class CustomConnectInterceptor implements ConnectInterceptor<Facebook> {

    private UserTaskService userTaskService;

    public CustomConnectInterceptor(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    public CustomConnectInterceptor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preConnect(ConnectionFactory<Facebook> connectionFactory, MultiValueMap<String, String> valueMap, WebRequest request) {

    }

    @Override
    public void postConnect(Connection<Facebook> connection, WebRequest request) {
        UserProfile userProfile = connection.fetchUserProfile();

        FacebookDTO dto = new FacebookDTO();
        dto.setDisplayName(connection.getDisplayName());
        dto.setEmail(userProfile.getEmail());
        dto.setId(extractId(connection.getProfileUrl()));
        dto.setImageURL(getImageUrl(connection, 285, 285));

        userTaskService.loginOrCreateFacebookUser(dto);
    }

    /**
     * Retrieve the image URL resized
     *
     * @param connection
     * @param height
     * @param width
     * @return URL as a {@link String} of where the resized profile image is
     * located
     */
    private String getImageUrl(Connection<Facebook> connection, int height, int width) {
        return connection.getImageUrl() + "?height=x&width=y".replaceAll("x", new Integer(height).toString()).replace("y", new Integer(width).toString());
    }

    /**
     * Retrieving the ID sometimes yields null values through the connection
     * However this data is simply included in both the image and the profile
     * url
     * <br /><br />
     * You could leave this as such, or change it to something else you prefer.
     * Only rule is that it has to be something persistent.
     *
     * @param profileUrl
     * @return Facebook ID extracted from profile url as a {@link String}
     */
    private String extractId(String profileUrl) {
        profileUrl = profileUrl.replace("https://www.facebook.com/app_scoped_user_id/", "");
        profileUrl = profileUrl.replace("/", "");
        return profileUrl;
    }
}
