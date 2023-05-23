package com.byelblog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.byelblog.entity.Users;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenUtil {

    private static final String  TOKEN_SECRET = "SLFKHADSPIFPIA";
    /**
     * 生成token
     * @param user
     * @return
     */
    public static  String generateToken(Users user) {
        String token = "";
        try {
            Date start = new Date();
            long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Date end = new Date(currentTime);
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",user.getUsername())
                    .withClaim("password",user.getUsername())
                    .withExpiresAt(end)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return token;
    }


    /**
     *
     * @param token
     * @param key
     * @return userId
     * 获取制定token中某个属性值
     */
    public static String get(String token, String key) {
        List<String> list= JWT.decode(token).getAudience();
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }


    /**
     *
     * @param request
     * @return
     * 获取token
     */
    public String getToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c :
                cookies) {
            if (c.getName().equals("token")) {
                return c.getValue();
            }
        }
        return null;
    }
}
