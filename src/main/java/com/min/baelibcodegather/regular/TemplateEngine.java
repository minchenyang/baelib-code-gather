package com.min.baelibcodegather.regular;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {


    public static void main(String[] args) {
        String template = "Hi {name}, you code is {code}";
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", "老毛");
        params.put("code", 7878);
        System.out.println(templateEngine(template, params));
    }

    private static Pattern templatePattern = Pattern.compile("\\{(\\w+)\\}");
    public static String templateEngine(String template, Map<String, Object> params){
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = templatePattern.matcher(template);
        while (matcher.find()){
            String key = matcher.group(1);
            Object value = params.get(key);
            matcher.appendReplacement(stringBuffer, value!= null ? Matcher.quoteReplacement(value.toString()): "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
