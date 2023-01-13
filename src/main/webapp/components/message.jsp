
<%
	String msg = (String)session.getAttribute("message");
	if(msg != null){
		out.println(msg);
		session.removeAttribute("message");
	}
%>