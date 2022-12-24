package Part2_Ch03._13.domain.userinfo.dao.mysql;

import Part2_Ch03._13.domain.userinfo.UserInfo;
import Part2_Ch03._13.domain.userinfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao {

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert Into MYSQL DB userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update Into MYSQL DB userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from MYSQL DB userID = " + userInfo.getUserId());
    }

}