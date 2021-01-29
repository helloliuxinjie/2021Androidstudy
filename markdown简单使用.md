\1.   下划线操作：<u>Underlined Text</u>

\2.   利用github存储图片，在markdown引用图片链接，步骤如下：

first将markdown需要用的图片放到git仓库中，发布到github上
 
 second访问github仓库,[smshen/MarkdownPhotos · GitHub](https://link.zhihu.com/?target=https%3A//github.com/smshen/MarkdownPhotos)

third访问图片[MarkdownPhotos/test.jpg at master · smshen/MarkdownPhotos · GitHub](https://link.zhihu.com/?target=https%3A//github.com/smshen/MarkdownPhotos/blob/master/Res/test.jpg)

forth点 download 按钮，在地址栏可以复制图片地址，或者在Download按钮上直接右键 "复制链接地址"

fifth拷贝链接地址[https://raw.githubusercontent.com/smshen/MarkdownPhotos/master/Res/test.jpg](https://link.zhihu.com/?target=https%3A//raw.githubusercontent.com/smshen/MarkdownPhotos/master/Res/test.jpg)

sixth在Markdown中引用图片，![Aaron Swartz]([https://raw.githubusercontent.com/smshen/MarkdownPhotos/master/Res/test.jpg](https://link.zhihu.com/?target=https%3A//raw.githubusercontent.com/smshen/MarkdownPhotos/master/Res/test.jpg))。

\3.  *斜体*   _斜体_   **粗体**   ***加粗斜体***  ~~删除线~~

\4. # 一级标题   ## 二级标题  以此类推

 我展示的是一级标题

 =============

我展示的是二级标题

\-------------------

\5. 超链接：

5.1. 行内式

语法说明：

[]里写链接文字，()里写链接地址, ()中的”“中可以为链接指定title属性，title属性可加可不加。title属性的效果是鼠标悬停在链接上会出现指定的 title文字。[链接文字](链接地址 “链接标题”)’这样的形式。链接地址与链接标题前有一个空格。

欢迎来到四川[成都里巷](http://blog.le.com”点我”)

5.2 参考式

参考式超链接一般用在学术论文上面，或者另一种情况，如果某一个链接在文章中多处使用，那么使用引用 的方式创建链接将非常好，它可以让你对链接进行统一的管理。

 

语法说明：

参考式链接分为两部分，文中的写法 [链接文字][链接标记]，在文本的任意位置添加[链接标记]:链接地址 “链接标题”，链接地址与链接标题前有一个空格。

 

如果链接文字本身可以做为链接标记，你也可以写成[链接文字][] 

[链接文字]：链接地址的形式，见代码的最后一行。

实例：1.我经常去的几个网站[Google][1]  [Leanote][2]  以及[自己的博客][3]

[1]: http://www.google.com”google”
[2]: http://www.leanote.com”Leanote”

 

6.自动链接  <网址>  然后就会自动生成超链接

<http://example.com>  

\7. https://blog.csdn.net/witnessai1/article/details/52551362  下次笔记网址 

8.如何换行:方法一:编辑好一行文字后敲两个空格符,在按回车编辑另一行文字  方法二:编辑一行文字后回车,再回车编辑另一行  方法三:编辑第一行的时候前后加上<br/>和</br>