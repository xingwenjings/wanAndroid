package com.example.wan_android.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/21.
 */

public class LoginInfo {

    /**
     * data : {"password":"","chapterTops":[],"icon":"","admin":false,"collectIds":[8455,8389],"id":24185,"type":0,"email":"","token":"","username":"Rinkaze"}
     * errorCode : 0
     * errorMsg :
     */
    private DataEntity data;
    private int errorCode;
    private String errorMsg;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public class DataEntity {
        /**
         * password :
         * chapterTops : []
         * icon :
         * admin : false
         * collectIds : [8455,8389]
         * id : 24185
         * type : 0
         * email :
         * token :
         * username : Rinkaze
         */
        private String password;
        private List<?> chapterTops;
        private String icon;
        private boolean admin;
        private List<Integer> collectIds;
        private int id;
        private int type;
        private String email;
        private String token;
        private String username;

        public void setPassword(String password) {
            this.password = password;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public void setCollectIds(List<Integer> collectIds) {
            this.collectIds = collectIds;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public String getIcon() {
            return icon;
        }

        public boolean isAdmin() {
            return admin;
        }

        public List<Integer> getCollectIds() {
            return collectIds;
        }

        public int getId() {
            return id;
        }

        public int getType() {
            return type;
        }

        public String getEmail() {
            return email;
        }

        public String getToken() {
            return token;
        }

        public String getUsername() {
            return username;
        }
    }
}
