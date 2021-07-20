package com.demo.tojson;

import com.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
public class TestController {

    @GetMapping("/hello")
    public String test1() {
        return "hell111o1";
    }

    @PostMapping("/hello")
    public String test2(@RequestParam("javaStr") String javaStr) {
        Pattern pattern = Pattern.compile("private .*");
        Matcher matcher = pattern.matcher(javaStr);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (matcher.find()) {
            String[] split = matcher.group().split(" ");
            String s = split[2].split(";")[0];
            sb.append(s).append(":").append("\"\"").append(",");
        }
        sb.append("}");

        return sb.toString();
    }

    @PostMapping("/test")
    public String test(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }
}
