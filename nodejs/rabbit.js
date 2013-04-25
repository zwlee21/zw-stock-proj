var amqp = require('amqp');
var httpd = require('http').createServer(handler);
var io = require('socket.io').listen(httpd);
var fs = require('fs');
   
var connection = amqp.createConnection({ host: "localhost", port: 5672 });
var count = 1;

//web client request handler
function handler(req, res) {
    fs.readFile('index.html',
     function(err, data) {
       if (err) {
         res.writeHead(500);
         return res.end('Error loading index.html');
        }
       res.writeHead(200);
       res.end(data);
      }
   );
  }

//rabbit connection on ready
connection.on('ready', function () {
  connection.exchange("node_exchange", options={type:'fanout'}, function(exchange) {   
   

    var tempData={},queueA,queueB,queueC,queueD,queueE; 
    var currentWebClient;
   
    function sendData(message){
                 var conns = io.sockets.clients(); 
                 console.log('current clients numbers :' +conns.length);      
                 if(conns.length>0){
                    if(currentWebClient){
                       currentWebClient.emit('data-update',[message]);  
                       currentWebClient.broadcast.emit('data-update',[message]); 
                       console.log('Recieved a message and send : '+message.stockNo+'  '+message.stockName+' '+message.totalCount); 
                    }
                 }
                 message.marketNo;
                 tempData[message.marketNo] = message;
                 console.log('Recieved a message to tempdata'); 
     };

    connection.queue('queue_node_A',function(queue){
         queueA=queue;
         queue.bind(exchange, 'key.q.a');
         queueA.subscribe(function (message) {
		sendData(message);
           });
    });
    connection.queue('queue_node_B',function(queue){
         queueB=queue;
         queue.bind(exchange, 'key.q.b');
         queueB.subscribe(function (message) {
		sendData(message);
           });
    });
    connection.queue('queue_node_C',function(queue){
         queueC=queue;
         queue.bind(exchange, 'key.q.c');
         queueC.subscribe(function (message) {
		sendData(message);
           });
    });
    connection.queue('queue_node_D',function(queue){
          queueD=queue;
          queue.bind(exchange, 'key.q.d');
          queueD.subscribe(function (message) {
		sendData(message);
           });
    });
   connection.queue('queue_node_E',function(queue){
         queueE=queue;
         queue.bind(exchange, 'key.q.e');
         queueE.subscribe(function (message) {
		sendData(message);
         });
    });
       
        
    
    //listen to web client
      httpd.listen(5588);
      console.log('listen to 5588')
      io.sockets.on('connection', function (webSocket) {
             console.log('one web client connect,clientId is :' +webSocket.id);
             var  clients = io.sockets.clients(); 
             console.log('current clients numbers :' +clients.length);           
              var tempDataList=[];
              for(stNo in tempData){
               tempDataList.push(tempData[stNo]);
              }
              webSocket.emit('data-update',tempDataList); 
              currentWebClient =  webSocket;     
          
              webSocket.on('message', function(msg){

             
             });
             webSocket.on('disconnect', function(){
                console.log('one web client disconnect'); 
                 clients = io.sockets.clients();                        
                console.log('current clients numbers :' +clients.length);  
             });         
         
          
      });
     
   
 });
});



 


