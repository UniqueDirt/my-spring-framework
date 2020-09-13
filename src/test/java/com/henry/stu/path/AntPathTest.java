package com.henry.stu.path;

import org.springframework.util.AntPathMatcher;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1
 */
public class AntPathTest {

  final static Pattern GLOB_PATTERN = Pattern.compile("\\?|\\*|\\{[^/]+?\\}");

  /**
   * a{ a show times between 1 to 3
   *
   * @param args
   */
  public static void main(String[] args) {

    String pattern = "{path}?bb}";

    Matcher matcher = GLOB_PATTERN.matcher(pattern);

    StringBuilder patternBuilder = new StringBuilder();

    int end = 0;

    while (matcher.find()) {
      String match = matcher.group();
      patternBuilder.append(pattern.substring(end, matcher.start()));

      if ("?".equals(match)) {
        patternBuilder.append(".");
      } else if ("*".equals(match)) {
        patternBuilder.append(".*");
      } else if (match.startsWith("{") && match.endsWith("}")) {
        patternBuilder.append("(.*)");
      }

      end = matcher.end();
    }

    patternBuilder.append(pattern.substring(end, pattern.length()));

    System.out.println(patternBuilder.toString());

    Pattern reg = Pattern.compile(patternBuilder.toString());

    if (reg.matcher("{bb}a").matches()) {
      System.out.println("matching");
    } else {
      System.out.println("no matching");
    }
  }


  public static void autBasic() {
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    boolean ret = antPathMatcher.match("/aa/bb/cc/1.txt", "/aa/bb/cc/1.txt");

    System.out.println(ret);

    ret = antPathMatcher.match("/aa/b?/cc/1.txt", "/aa/bb/cc/1.txt");

    System.out.println(ret);

    ret = antPathMatcher.match("/aa/b*/cc/1.txt", "/aa/bb/cc/1.txt");

    System.out.println(ret);

    ret = antPathMatcher.match("/aa/**/1.txt", "/aa/bb/cc/1.txt");

    System.out.println(ret);

    Map<String, String> map = antPathMatcher.extractUriTemplateVariables("/aa/{path1}/{path2}/", "/aa/bb/cc/");

    System.out.println(map);

    map = antPathMatcher.extractUriTemplateVariables("/aa/{path1:\\w+}/{path2:\\d+}/", "/aa/bb/132/");

    System.out.println(map);
  }
}
