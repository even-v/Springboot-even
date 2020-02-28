//Node.js 中使用http服务器和客户端

/**************************** Hello China ***************************************/
// //1.加载http模块
// var http=require('http');
//
// //2.创建一个http 服务对象
// var server=http.createServer();
//
// //3.监听用户的请求事件(request事件)
//
// server.once('request',function(req,resp){
//
//     //解决乱码
//     resp.setHeader('Content-Type','text/html;charset=utf-8');
//
//     //响应内容
//     resp.write('hello china 你好 中国！');
//
//     //每个请求服务器必须结束响应，否则客户端会一直等待服务器响应结束
//     resp.end();
// });
//
// server.listen(8080,function(){
//     console.log('服务启动了，请访问：http://localhost:8080');
// });


/***************************** 根据不同请求做出不同响应 **************************************/
// //1.加载http模块
// var http=require('http');
//
// //2.创建一个http 服务对象
// http.createServer(function (req,resp) {
//     resp.setHeader('Content-Type','text/html;charset=utf-8');
//
//     //请求路径
//     // req.url
//     console.log(req.url);
//     if(req.url=== '/'|| req.url ==='/index'){
//         resp.end('index.html');
//     }else if(req.url==='/login'){
//         resp.end('login.html');
//     }else if(req.url==='/register'){
//         resp.end('register.html');
//     }else{
//         resp.end('404 Error,page not found');
//     }
//
// }).listen(8080,function () {
//     console.log('http://localhost:8080');
// });


/***************************** 根据不同请求响应不同页面 **************************************/
//1.加载http模块
var http=require('http');
var fs=require('fs');
var path=require('path');

//2.创建一个http 服务对象
http.createServer(function (req,resp) {
    resp.setHeader('Content-Type','text/html;charset=utf-8');

    //请求路径
    // req.url
    console.log(req.url);
    if(req.url=== '/'|| req.url ==='/index'){
      fs.readFile(path.join('../','html','index.html'),function (err,data) {
          if(err){
              throw err;
          }
          resp.end(data);
      }) ;
    }else if(req.url==='/login'){
        resp.end('login.html');
    }else if(req.url==='/register'){
        resp.end('register.html');
    }else{
        resp.end('404 Error,page not found');
    }

}).listen(8080,function () {
    console.log('http://localhost:8080');
});
