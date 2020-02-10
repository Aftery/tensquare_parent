package top.aftery.common;

import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName CreateJwt
 * @Description CreateJwt
 * @Author Aftery
 * @Date 2020/2/9 19:21
 * @Version 1.0
 */
@SpringBootTest
public class CreateJwt {

    @Test
  public   void create() {
        String compact = Jwts.builder()
                .setId(IdUtil.createSnowflake(1, 1) + "")
                .setSubject("小米")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"aftery")
                .setExpiration(new Date(new Date().getTime()+1*60*1000))
                .compact();
        System.out.println(compact);
    }

    @Test
    public void  parseJwtTest(){
        Claims aftery = Jwts.parser().setSigningKey("aftery").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjbi5odXRvb2wuY29yZS5sYW5nLlNub3dmbGFrZUA2YzM3MDhiMyIsInN1YiI6IuWwj-exsyIsImlhdCI6MTU4MTI0ODYxMywiZXhwIjoxNTgxMjQ4NjczfQ.uoLpptHtDt31HYEz3LyFM-gdn_EpMO3OY9GoeYJZ_Dg").getBody();
        System.out.println("aftery.getId() = " + aftery.getId());
        System.out.println("aftery.getIssuedAt() = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aftery.getIssuedAt()));
        System.out.println("aftery.getSubject() = " + aftery.getSubject());
    }
}
