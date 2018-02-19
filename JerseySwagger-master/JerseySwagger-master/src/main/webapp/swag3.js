

self.addEventListener("message", function(e) {
  var data = e.data;
  
  
	var grade="grade2";
	var color="";
	var putFlash="";
	var showLikes="";
	var likeUrl="img/likes.svg";
	var like="";
	var key = data.key;

	var render= '<img width="260" height="200" src="downloadimages/'+data.third[key].id+'.jpg" ></img>';
	
	
	
	if(parseInt(data.third[key].likes)>200000)
	{
	 
	 showLikes ="putLike";
	 likeUrl="img/thumbsilver.png";
	grade="grade5";
	}
	
	if(parseInt(data.third[key].views)>3500000)
	{
	putFlash="viewFlash";
	 grade="grade3";
	 color="black";
	}
	
	if(parseInt(data.third[key].likes) - parseInt(data.third[key].dislikes)<1200)
	{
	showLikes ="downLike";
	likeUrl="img/thumbdown.png";
	grade="grade4";
	color="red";
	}
	
	if(data.third[key].isAuto ==='1')
	{
	grade="grade";
	color="black";
	}

	 render = '<div id="embc'+key+'" data-cuttings="embc'+key+'cuthere"  data-idttings="'+data.third[key].id+'puthere"></div>';
	
	
	var str= '<div style="display:none" id="'+key+'" class="main '+grade+'"> <b class="videohead"><span class="in '+color+'">'+data.third[key].title+'</span></b>'+
    '<div class="img">'+
       render+
   '</div>'+
    '<div class="viewIcon">'+
      '<img width="60" class="'+putFlash+'" height="60" src="img/views.png">'+
    '<img style="margin-left:5px;" class="img2 '+showLikes+'" width="40" height="40" src="'+likeUrl+'">'  +
	
    	'<img style="margin-top:14px;margin-left:5px;" class="img2" width="40" height="40" src="img/comments.png">'+
      
      '<div class="viewCount">'+
        '<b class="viewLine view '+putFlash+'"><span class="viewLine '+color+'">'+data.third[key].views+'</span></b> <b class="viewLine like '+color+'"><span class="" class="viewLine">'+data.third[key].likes+'</span> </b>'+
        '<b class="viewLine comment">                       <span class="viewLine '+color+'">'+data.third[key].comments+'</span>            </b>'+
      '</div> </div> </div>'
			
		

        setTimeout(function(){
    		postMessage(str);
          },1000);
  
  
}, false);