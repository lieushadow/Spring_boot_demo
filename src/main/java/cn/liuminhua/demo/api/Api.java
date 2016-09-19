package cn.liuminhua.demo.api;

import cn.liuminhua.demo.model.Param;
import cn.liuminhua.demo.model.Result;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lmh on 2016/9/18.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/ja/v1")
public class Api {


	@RequestMapping("/hello")
	public Result get(@RequestHeader("token") String token, String id) {
		return Result.SuccessResult("token:" + token, id);
	}

	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	public Result post(@RequestHeader("token") String token, @RequestBody Map<String, String> param) {
		return Result.SuccessResult("token:" + token, param);
	}

	@RequestMapping(path = "/hello", method = RequestMethod.PUT)
	public Result put(@RequestHeader("token") String token, @RequestBody Map<String, String> param) {
		return Result.SuccessResult("token:" + token, param);
	}

	@RequestMapping(path = "/hello", method = RequestMethod.DELETE)
	public Result delete(@RequestHeader("token") String token, @RequestBody Param param) {
		return Result.SuccessResult("token:" + token, param);
	}


}
