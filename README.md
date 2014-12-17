###卡车帮用户中心

####用户中心功能列表

*用户管理

*资源管理(应用)

*角色管理

*在线用户管理
删除记录即该用户下线

*关系(必须)

用户-(MM)->角色-(MM)->资源

附加功能
缓存机制(未实现待系统验证后添加)


####登陆方式

1. 直接登陆-->进入用户中心管理系统

2. 应用登陆方式

`http://localhost:9000/login?return_url=app_url`

添加return_url参数

app_url为跳转回的应用地址

**正常返回带access_token

`http://app_url?access_token=1331kdfa324eewq1`


####验证用户并获取用户名

方式一

`http://localhost:9000/auth?ak=c600db79-9588-47cb-b606-17b3e35c8e2b&sk=ae580fc8-afd2-417e-b01d-406fc452bb4f&token=465a7438-7dd3-4c06-aac7-21ba282ba065`

方式二

` http://localhost:9000/auth/c600db79-9588-47cb-b606-17b3e35c8e2b/ae580fc8-afd2-417e-b01d-406fc452bb4f/465a7438-7dd3-4c06-aac7-21ba282ba065`

正常返回

` {"members":{"appkey":"c600db79-9588-47cb-b606-17b3e35c8e2b","securekey":"ae580fc8-afd2-417e-b01d-406fc452bb4f","status":true,"username":"zp@qq.com"}}`

错误

` {"members":{"appkey":"c600db79-9588-47cb-b606-17b3e35c8e2b","securekey":"ae580fc8-afd2-417e-b01d-406fc452bb4f","error":"用户没有登陆","status":false}}`

` {"members":{"appkey":"c600db79-9588-47cb-b606-17b3e35c8e2b","securekey":"ae580fc8-afd2-417e-b01d-406fc452b4f","error":"没有此应用","status":false}}`

` {"members":{"appkey":"c600db79-9588-47cb-b606-17b3e35c8e2b","securekey":"ae580fc8-afd2-417e-b01d-406fc452bb4f","error":"无权登陆此应用","status":false}}`
