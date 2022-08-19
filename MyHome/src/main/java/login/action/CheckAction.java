package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class CheckAction implements Action {
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPassword(password);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		dto = dao.checkLogin(dto);
		
		boolean check = false;
		String msg = null;
		
		if(dto.getName() != null){
			msg = dto.getName() + "���� �α��� �ϼ̽��ϴ�.";
			check = true;
			//�α���ó��
			HttpSession session = request.getSession();
			
			session.setAttribute("login", dto);
			
			//��Ű���� ����
			String ckid = request.getParameter("ckid");
			
			//���� ��Ű���� �о����
			Cookie[] cks = request.getCookies();
			
			Cookie ck = null;
			
			//���� ���� �˻�
			if(cks != null){
				for(Cookie c: cks){
					if(c.getName().equals("ckid")){
						ck = c;
						break;
					}
				}
			}
			
			if(ckid != null){
				if(ck == null){
					//��Ű���� ����
					ck = new Cookie("ckid",dto.getId());
					
					ck.setMaxAge(60*60*24);
					
					response.addCookie(ck);
				}else{
					if(!ck.getValue().equals(dto.getId())) {
						ck.setValue(id);
						response.addCookie(ck);
					}
				}
			}else{
				if(ck != null && ck.getValue().equals(dto.getId())){
					//��Ű���� ����
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
			
			
		}else{
			check = false;
			msg = "���̵� Ȥ�� ��й�ȣ�� �߸��Ǿ����ϴ�.";
		}
		System.out.println(msg);
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
	}
}
