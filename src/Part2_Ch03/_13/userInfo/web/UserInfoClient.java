package Part2_Ch03._13.userInfo.web;

import Part2_Ch03._13.domain.userinfo.UserInfo;
import Part2_Ch03._13.domain.userinfo.dao.UserInfoDao;
import Part2_Ch03._13.domain.userinfo.dao.mysql.UserInfoMySqlDao;
import Part2_Ch03._13.domain.userinfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {

    public static void main(String [] args) throws IOException {

//        String path = System.getProperty("user.dir");
//        System.out.println("현재 작업 경로: " + path);
//
        FileInputStream fis = new FileInputStream("db.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPassword("!@#$");
        userInfo.setUserName("LEE");

        UserInfoDao userInfoDao = null;

        if(dbType.equals("ORACLE")) {
            userInfoDao = new UserInfoOracleDao();
        }
        else if(dbType.equals("MYSQL")) {
            userInfoDao = new UserInfoMySqlDao();
        }
        else {
            System.out.println("error");
            return;
        }

        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);
    }
}
