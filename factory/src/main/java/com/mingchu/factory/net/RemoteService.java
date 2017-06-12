package com.mingchu.factory.net;

import com.mingchu.factory.model.api.RspModel;
import com.mingchu.factory.model.api.account.AccountRspModel;
import com.mingchu.factory.model.api.account.LoginModel;
import com.mingchu.factory.model.api.account.RegisterModel;
import com.mingchu.factory.model.api.user.UserUpdateModel;
import com.mingchu.factory.model.card.UserCard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by wuyinlei on 2017/6/10.
 *
 * @function 网络请求的所有接口
 */

public interface RemoteService {

    /**
     * 网络请求的一个注册接口
     *
     * @param model 传入的model
     * @return 返回的是AccountRspModel
     */
    @POST("account/register")
    Call<RspModel<AccountRspModel>> accountRegister(@Body RegisterModel model);

    /**
     * 登录接口
     *
     * @param model 传入的model
     * @return 返回的是AccountRspModel
     */
    @POST("account/login")
    Call<RspModel<AccountRspModel>> accountLogin(@Body LoginModel model);

    /**
     * 绑定PushId
     *
     * @param pushId 传入的pushId
     * @return 绑定PushId
     */
    @POST("account/bind/{pushId}")
    Call<RspModel<AccountRspModel>> accountBind(@Path(encoded = true, value = "pushId") String pushId);


    /**
     * 用户更新的接口
     *
     * @param userUpdateModel 更新model
     * @return UserCard
     */
    @PUT("user")
    Call<RspModel<UserCard>> userUpdate(@Body UserUpdateModel userUpdateModel);


    /**
     * 用户搜索接口
     *
     * @param name 搜索内容
     * @return 搜索到的用户集合
     */
    @GET("user/search/{name}")
    Call<RspModel<List<UserCard>>> userSearch(@Path(value = "name", encoded = true) String name);


    /**
     * 用户关注接口
     *
     * @param userId 关注的用户id
     * @return UserCard
     */
    @PUT("user/follow/{followId}")
    Call<RspModel<UserCard>> userFollow(@Path(value = "followId", encoded = true) String userId);


}