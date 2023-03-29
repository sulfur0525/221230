package controller.admin;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	public static ArrayList< ClientDto > 알림명단 = new ArrayList<>();
	
	@OnOpen
	public void 서버입장(Session session,@PathParam("mid") String mid) {
		알림명단.add( new ClientDto(session, mid)  );
	}

	@OnClose
	public void 서버나가기(Session session) {
		for(ClientDto dto : 알림명단) {
			if(dto.getSession() == session ) {알림명단.remove(dto);}
		}
	}
	
	@OnError
	public void 서버오류(Session session, Throwable e) throws Exception {System.out.println(session);}
	
	@OnMessage
	public static void 서버메시지(Session session, String msg) throws Exception {
		int tomno = Integer.parseInt(msg.split(",")[0]);
		String tomsg = msg.split(",")[1];
		for(ClientDto dto : 알림명단) {
			
			int cmno = MemberDao.getInstance().getMember(dto.getMid()).getMno();
			if(cmno == tomno) {
				dto.getSession().getBasicRemote().sendText("");
			}
			
		}
	}
	
}
