package com.app.reach.model;

/**
 * Created by noel on 4/3/16.
 */

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class User {

        private String username;
        private String roles;
        private String tokenType;
        private String accessToken;
        private Integer expiresIn;
        private String refreshToken;

/**
 *
 * @return
 * The username
 */
        public String getUsername() {
            return username;
        }

/**
 *
 * @param username
 * The username
 */
        public void setUsername(String username) {
            this.username = username;
        }

/**
 *
 * @return
 * The roles
 */
        public String getRoles() {
            return roles;
        }

/**
 *
 * @param roles
 * The roles
 */
        public void setRoles(String roles) {
            this.roles = roles;
        }

/**
 *
 * @return
 * The tokenType
 */
        public String getTokenType() {
            return tokenType;
        }

/**
 *
 * @param tokenType
 * The token_type
 */
        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

/**
 *
 * @return
 * The accessToken
 */
        public String getAccessToken() {
            return accessToken;
        }

/**
 *
 * @param accessToken
 * The access_token
 */
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

/**
 *
 * @return
 * The expiresIn
 */
        public Integer getExpiresIn() {
            return expiresIn;
        }

/**
 *
 * @param expiresIn
 * The expires_in
 */
        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

/**
 *
 * @return
 * The refreshToken
 */
        public String getRefreshToken() {
            return refreshToken;
        }

/**
 *
 * @param refreshToken
 * The refresh_token
 */
        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }


    }