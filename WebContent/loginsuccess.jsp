<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="bean.userBean"%>
<HTML>
	<head>
		<title>系统登录成功页面</title>
	</head>
	<body>
		<%
			userBean user = (userBean)(request.getAttribute("user"));
		 %>
		 <script type="text/javascript">
		 	alert("登录成功！")
		 </script>
		 欢迎用户：<%=user.getUserName() %>
		 <div id="box" style="width:252px;font:25px/25px 宋体;background:#000;color:#9f9;border:#999 20px ridge;text-shadow:2px 3px 1px #0f0;"></div>
<script>
	var domain="www.zuidaima.com";
		var author="zuidaima";
	var map=eval("["+Array(23).join("0x801,")+"0xfff]");
	var tatris=[[0x6600],[0x2222,0xf00],[0xc600,0x2640],[0x6c00,0x4620],[0x4460,0x2e0,0x6220,0x740],[0x2260,0xe20,0x6440,0x4700],[0x2620,0x720,0x2320,0x2700]];
	var keycom={"38":"rotate(1)","40":"down()","37":"move(2,1)","39":"move(0.5,-1)"};
	var dia, pos, bak, run;
	function start(){
		dia=tatris[~~(Math.random()*7)];
  		bak=pos={fk:[],y:0,x:4,s:~~(Math.random()*4)};
	    rotate(0);
	}
	function over(){
    	document.onkeydown=null;
    	clearInterval(run);
    	alert("GAME OVER");
	}
	function update(t){
    	bak={fk:pos.fk.slice(0),y:pos.y,x:pos.x,s:pos.s};
    	if(t) return;
    	for(var i=0,a2=""; i<22; i++)
        	a2+=map[i].toString(2).slice(1,-1)+"<br/>";
    	for(var i=0,n; i<4; i++)
        	if(/([^0]+)/.test(bak.fk[i].toString(2).replace(/1/g,"\u25a1")))
            	a2=a2.substr(0,n=(bak.y+i+1)*15-RegExp.$_.length-4)+RegExp.$1+a2.slice(n+RegExp.$1.length);
    	document.getElementById("box").innerHTML=a2.replace(/1/g,"\u25a0").replace(/0/g,"\u3000");
	}
	function is(){
    	for(var i=0; i<4; i++)
        	if((pos.fk[i]&map[pos.y+i])!=0) return pos=bak;
	}
	function rotate(r){
    	var f=dia[pos.s=(pos.s+r)%dia.length];
    	for(var i=0; i<4; i++)
        	pos.fk[i]=(f>>(12-i*4)&15)<<pos.x;
    	update(is());
	}
	function down(){
    	++pos.y;
    if(is()){
        for(var i=0; i<4 && pos.y+i<22; i++)
            if((map[pos.y+i]|=pos.fk[i])==0xfff)
                map.splice(pos.y+i,1), map.unshift(0x801);
        if(map[1]!=0x801) return over();
        start();
    }
    update();
}
function move(t,k){
    pos.x+=k;
    for(var i=0; i<4; i++)
        pos.fk[i]*=t;
    update(is());
}
document.onkeydown=function(e){
    eval(keycom[(e?e:event).keyCode]);
};
start();
run=setInterval("down()",400);
</script>
	</body>

</HTML>