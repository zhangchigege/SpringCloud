package springCloud.Controller.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class creatJwt {

    public static void main(String[] args) {
        JwtBuilder builder =Jwts.builder().setId("123456")
                .setSubject("zhangchi")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256 , "zhangchigege")
                .claim("roles" , "admin");
        String token = builder.compact();
        System.out.println(token);
    }



}
