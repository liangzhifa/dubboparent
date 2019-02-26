package com.ts.ipackage;
import com.ts.model.User;

import java.io.Serializable;

public interface ITsUserService extends Serializable {

    public int insertUser(User user);

    public User findUserByIdentificationAndPassword(String identification,String password);

}
