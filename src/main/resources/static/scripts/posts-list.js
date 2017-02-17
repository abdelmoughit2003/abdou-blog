/**
 * Created by abdelmoughit on 2/15/2017.
 */

(function () {
  var request= $.ajax({
        url:"/posts.json"
    });
    request.done(function (posts) {
        //the HTTP response-> an array of JSON objects->

        var i, html='';
        for(i=0; i<posts.length;i++){
            html += "<div><h1>" + posts[i].title + "</h1><p>" + posts[i].description + "</p>" +'<img src="/uploads/'+ posts[i].image+'"/>'+"</div>";
        }

        $('#load-posts').html(html);
    })
})();