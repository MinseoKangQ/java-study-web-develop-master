package Part2_Ch03._13.domain.userinfo.dao.oracle;

import Part2_Ch03._13.domain.userinfo.UserInfo;
import Part2_Ch03._13.domain.userinfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {


    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert Into Oracle DB userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update Into Oracle DB userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from Oracle DB userID = " + userInfo.getUserId());
    }
}
