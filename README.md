

程序安装与测试：

  测试环境 ： ubuntu 12.04
  需要有网络链接！
  在github上下载文件解压后最好能保持‘nodejs’这个文件目录结构！

1.安装java jdk 7
      *下载地址 ：http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
      *提选 ：Accept License Agreement  
      *选择版本 ： jdk-7u21-linux-x64.tar.gz（64系统） 或 jdk-7u21-linux-i586.tar.gz（32位）
      *下载后打开命令窗口 ：ctrl+alt+t
      *定位到你的保存目录 ： cd 你的路径 如：cd programs
      *输入 ：tar -xzvf jdk-7u21-linux-x64.tar.gz 回车

2.安装nodejs
     *下载地址：http://nodejs.org/download/
     *选择：linux binaris(.tar.gz) 32 or 64  下载
     *打开命令窗口 ： ctrl+alt+t (或在已打开的命令窗口操作) 
     *跳转到你的保存目录 ：cd 你的目录  如 ： cd programs  ;  返回上一层命令 ： cd ..
     *输入 ：tar -xzvf node-v0.10.4-linux-x64.tar.gz 回车    


3 .安装gradle
     *下载地址 ：http://www.gradle.org/downloads
     *选择 ： gradle-1.5-bin.zip 下载
     *选定gradle-1.5-bin.zip，右键点击‘提取到此处’


4. 设置环境变量
     *打开命令窗口 (或在已打开的命令窗口操作) 
     *输入 sudo gedit /etc/profile
     *输入本机密码
     *在打开的profile文件最后面加入以下内容：
        export 	JAVA_HOME=你的路径/jdk1.7.0_21
        export  PATH=$PATH:$JAVA_HOME/bin
        export  CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
        export  PATH=$PATH:你的路径/gradle-1.5/bin
        export  PATH=$PATH:你的路径/node-v0.10.4-linux-x64/bin
       
         如 ：export  JAVA_HOME=/home/lee/programs/jdk1.7.0_21
              export  PATH=$PATH:$JAVA_HOME/bin
              export  CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
              export  PATH=$PATH:/home/lee/programs/gradle-1.5/bin
              export  PATH=$PATH:/home/lee/programs/node-v0.10.4-linux-x64/bin
     * 保存后输入命令 ：source /etc/profile
     * 测试 ： 输入 gradle -v   返回  Gradle 1.5 表示成功               
               输入 java -version  返回  java version "1.X.x.x"
               输入 node -v 返回  v0.10.4
     
5.安装erlang
    *打开命令窗口 ： ctrl+alt+t (或在已打开的命令窗口操作) 
    *输入 ：sudo apt-get install erlang  回车 输入登录密码
    * y/n选择 ： 选择y  回车
    * 此安装需要点时间，请耐心等待
    *下载运行完后输入 ：erl 
    *返回 ：Eshell V5.8.5 表示安装成功


6. 安装Rabbitmq-server
    *打开命令窗口 ： ctrl+alt+t (或在已打开的命令窗口操作) 
    *输入 ：sudo apt-get install rabbitmq-server  回车 输入登录密码
    * y/n选择 ： 选择y  回车   
    *Starting rabbitmq-server: SUCCESS 表示安装成功


7. 重启系统


8.安装nodejs amqp 与socket.io组件
  *打开命令窗口 ： ctrl+alt+t (或在已打开的命令窗口操作) 
  *cd 到 ‘你的路径’/nodejs 下 
  *输入 ：npm install amqp
  *完后输入 ：npm install socket.io
  *安装 socket.io时也需要点时间
  *如果看到 > (node-gyp rebuild 2> builderror.log) || (exit 0) 这信息时仍需等待
  *直到自动跳回命令行


9.开启nodejs服务
  *打开命令窗口 ： ctrl+alt+t (或在已打开的命令窗口操作) 
  *cd 到 ‘你的路径’/nodejs 下 
  *输入 ：node rabbit.js
  *返回信息 ： info  - socket.io started
             listen to 5588
             表示nodejs server 已成功启动！

10.开启java端服务
   *打开另一个命令窗口 ： ctrl+alt+t (注意：不能跟运行nodejs的是同一个命令窗口)
   *在命令窗口输入 ：cd ‘你的路径’/nodejs/java
   *输入 ：gradle run
   *该过程需要下载比较多文件，需要时间，请耐心等待
   *成功后会看到一下信息：   sending 百洋股份 002696
                         sending 博实股份 002698
   *这时nodejs与java已经建立连接通信！

11.打开浏览器开结果
   *输入地址：http://localhost:5588
   *看到股票变动信息表示已成功！！！
   *每个股票会在1分钟左右更换一次，数据几秒钟更新一次！
   *thanks for your patient !!!




  


 

  
  
   
   
    

