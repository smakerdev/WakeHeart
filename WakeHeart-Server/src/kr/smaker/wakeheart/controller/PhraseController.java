package kr.smaker.wakeheart.controller;

import java.util.HashMap;

import org.servoframework.annotation.Route;
import org.servoframework.request.Request;
import org.servoframework.response.Response;

import kr.smaker.wakeheart.model.Phrase;

public class PhraseController {
	private static Phrase phrase = new Phrase();
	
	@Route(route = "/API/phrase/all", method = Route.RouteMethod.GET)
    public static void allFind(Request req, Response res) {
		phrase.connect();
        res.setHeader("Content-Type", "application/json;charset=utf-8");
        HashMap<String, Object> map = new HashMap<>();
        map.put("phrase", phrase.findAll());
        
        res.json(map);
        res.end();
	}
	
	@Route(route = "/API/phrase/set", method = Route.RouteMethod.GET)
    public static void setPhrase(Request req, Response res) {
		phrase.connect();
		try {
			if (phrase.findAll() == null) {
				phrase.init();
			} else {
				res.send("�̹� �����Ǿ� �ֽ��ϴ�.");
			}
		} catch (NullPointerException e) {
			phrase.init();
			e.printStackTrace();
		}
		
		
		res.send("������ �Ϸ�Ǿ����ϴ�.");
		res.end();
	}
}
