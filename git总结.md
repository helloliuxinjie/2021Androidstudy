# **git总结**

1.git init 初始化一个仓库，即该文件下的所有文件都变成了未跟踪文件

然后再git remote  原理：当你在本地创建了一个工作目录，使用git init进行初始化，git后就会对版本进行控制，这个时候如果你需要将它放到远程服务器，就git remote

2.一般来说：目录下的文件有跟踪和未跟踪两种状态。

3.git status查看当前仓库的状态

4.git add newfiles 添加文件到暂存区 

5.git commit –m”miaoshu” 这里只是保存到了本地，即提交到了本地仓库

6.git push 推送到远程仓库

7.git remote 不带参数，列出已经存在的远程分支

8.git remote –v 列出详细信息，在每个名字后面列出其远程的url

9.git remote add shortname url  要添加一个新的远程仓库，可以指定一个简单的名字，以便将来引用，

例如：$git remote

origin

$git remote add pb git://github.com/paulboone/ticgit.git

$git remote –v

origin url

pb git://github.com/paulboone/ticgit.git

10.我们要在cmd命令行中用git命令，必须编辑path环境变量，在其中加入git安装路径

11.git log查看我们的修改的历史

12.git reset –hard ID

13.git checkout 切换到某分支

14.git branch –d XXX 删除本地分支，注意在当前这个分支不能删除自己

15.git diff 文件  比较当前文件和暂存区文件的差异

 