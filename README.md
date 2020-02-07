# 简介
Java大作业结束后自己又挑了一个题目做的，剩下一些过于重复的功能没有实现  
题目要求及数据库建表均在仓库里给出  

# 编译环境
eclipseIDE  
jdk8  
win10  

# 用到的工具
MySQL数据库   
JavaFx Scene Builder   
Navicat for MySQL  

# 实现功能图
![Image Text](https://github.com/Chaos-Chou/Doctor-workstation-management-system/blob/master/img/%E5%8A%9F%E8%83%BD%E5%AE%9E%E7%8E%B0.jpg)  
# 备注信息
项目难度并不大，主要须要理解的就是Dao模式的几个接口及其实现，根据自己的须要去设计接口及函数即可。  
  
除此之外，程序界面实现了命令行界面(在test.java文件中，实现全功能)，也实现了UI的患者界面、医生界面以及管理员界面的医生管理功能，剩余的管理功能由于与医生管理相似，而且在接口中均已经实现，就没有继续画界面完成。  
  
另外，界面实现过程中需要的数据交互在StageManage类中，使用了一个静态字典来存储，程序在界面的调用中仍有缺憾，由于是自己摸索的界面调用，可能不符合一些工作方面的要求，不过也只能暂时这样了。而且界面并没有进行美化，实在不想在这个项目继续花费更多的时间了，就完成到这里结束了。
