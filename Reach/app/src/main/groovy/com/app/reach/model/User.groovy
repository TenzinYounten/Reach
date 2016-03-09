package com.app.reach.model;

/**
 * Created by noel on 4/3/16.
 */
public class User {

        private String username;
        private def roles;
        private String token_type;
        private def access_token;
        private def expires_in;
        private String refresh_token;

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
            return token_type;
        }

/**
 *
 * @param tokenType
 * The token_type
 */
        public void setTokenType(String tokenType) {
            this.token_type = tokenType;
        }

/**
 *
 * @return
 * The accessToken
 */
        public String getAccessToken() {
            return access_token;
        }

/**
 *
 * @param accessToken
 * The access_token
 */
        public void setAccessToken(String accessToken) {
            this.access_token = accessToken;
        }

/**
 *
 * @return
 * The expiresIn
 */
        public Integer getExpiresIn() {
            return expires_in;
        }

/**
 *
 * @param expiresIn
 * The expires_in
 */
        public void setExpiresIn(Integer expiresIn) {
            this.expires_in = expiresIn;
        }

/**
 *
 * @return
 * The refreshToken
 */
        public String getRefreshToken() {
            return refresh_token;
        }

/**
 *
 * @param refreshToken
 * The refresh_token
 */
        public void setRefreshToken(String refreshToken) {
            this.refresh_token = refreshToken;
        }


    }