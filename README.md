### 一、JUnit5总结

1. 必须以Test开头或者以Test结尾，如果不满足，在IDEA下可以运行。但是在maven终端下执行mvn test，则不会执行没满足的类名
2. 如果想改变命名规则，那么可以配置pom来改变自定义命名规则，但是这回覆盖Test开头或者以Test结尾的规则
3. 一条测试用例存在多个断言，执行到出错的这个断言就会停止向下执行。如果想要全部都执行，那么使用assertAll
4. 如果存在类继承，那么用例顺序是![image-20240421002746222](README.assets/image-20240421002746222.png)；先蓝后黑最后红；如果子类的方法名跟父类的方法名一致了，那么就是重写，会覆盖父类的实现
5. 可以通过在pom里面配置插件然后使用include标签和exclude标签，指定运行某个包/某个类/某个方法
6. assertThat包含很多意思，借助其他第三方依赖，可以是相等、包含、大于小于等等
7. ```java
   List<Executable> executableList = new ArrayList<>();
   executableList.add(()->assertThat(title1, containsString("测试")));
   executableList.add(()->assertThat(title2, "测试开发"));
   assertAll(executableList);
   //这样就能实现全部测试
   ```
8. 



### 二、Selenium

1. 三种等待：
   1. 直接等待：Thread.sleep()。简单灵活；造成不必要等待
   2. 隐式等待driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))。默认**轮询0.5秒**查找元素是否出现，如果没有就抛出异常。注意，**此操作是全局性配置，所有的findElement都会是隐式等待**；隐式等待只会检测元素是否存在，并不会检测元素是否可用
   3. 显示等待：new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("hhh"))).click() 不仅检测元素出现，还必须是元素可点击了，才会去点击元素
   4. 元素未加载----元素出现了但是还不能交互----元素出现了且可交互

2. 获取属性：WebElement.getAttribute("style")

3. findElement的如果有很多，**并不会报错，而是会找到第一个**

4. CSS表达式：

   1. console输入：$("css表达式")，如果出错那么输入$$("css表达式")

   2. | 类型 | 表达式            |      |
      | ---- | ----------------- | ---- |
      | 标签 | 标签名            |      |
      | 类   | .class属性值      |      |
      | ID   | #id属性值         |      |
      | 属性 | [属性名='属性值'] |      |

   3. 如果有一个div的class="abc cvb"，那么css定位就是$(".abc.cvb")

   4. | 类型     | 格式        | 用例                 |
      | -------- | ----------- | -------------------- |
      | 并集     | 元素，元素  | $('.bg,.aa,.bb,.cc') |
      | 邻近兄弟 | 元素+元素   | $('#success>input')  |
      | 兄弟     | 元素1~元素2 | $('#form~input')     |
      | 父子     | 元素>元素   | $('.aa+input')       |
      | 后代     | 元素   元素 | $(‘.bbb  .cc’)       |

   5. css表达式中的如nth-child(2)等等，**都是从1开始，而不是从0开始**

   6. | 类型                   | 格式11111111111 | 用例                            |
      | ---------------------- | --------------- | ------------------------------- |
      | 父子关系+顺序          | 元素  元素      | $('#form>:nth-child(2)')        |
      | 父子关系+标签类型+顺序 | 元素  元素      | $('#form>input:nth-of-type(1)') |

5. xpath表达式

   1. xpath的索引也是从1开始，而不是0开始

   2. console中xpath结构：$x('xpath语法')

   3. [last()]选取最后一个

   4. [@属性名='属性值' and @属性名='属性值']与关系

   5. [@属性名='属性值' or @属性名='属性值']或关系

   6. [text()='文本信息']根据文本信息包含定位

   7. [contains(**text()**, '文本信息')]根据文本模糊匹配，加粗部分不仅可以是文本值，还可以是属性(@id)，也可以对属性进行模糊定位

6. 显示等待until的返回值是期望条件的返回值

7. > <a><p>111</p></a>   text()

8. 定位到了一个元素，在某次操作B之前获到的文本值是A，经过这次操作B后获得的文本值是C，A跟C是可以不同的。也就是Selenium会像跟Vue一样“聪明”

9. ```java
   // 动作链
   // 1.定位输入框
   // 2.输入文本并点击回车
   // 因为这里涉及到了键盘事件，所以用到了
   Actions actions = new Actions(webDriver);
   actions.sendKeys(sendEle, "Selenium")
       .sendKeys(Keys.ENTER)
       .build()
       .perform();
   
   // 点击command+元素同时进行
   Actions actions = new Actions(webDriver);
   actions.keyDown(Keys.COMMAND)
       .click(firstEle)
       .KeyUp(Keys.COMMAND)
       .build()
       .perform();
   
   // 鼠标悬浮移入移出
   ```

10. **涉及到键盘事件才会在perform之前有一个build**

11. 任何元素只要文本包含**移入**：$x("//*[contains(text(),\\"移入\\")]")

12. 如果要精准定位文本信息是**鼠标移入**：$x("//*[contains(text(),\\"移入\\")]")

13. 鼠标悬浮移入移出涉及动作链

14. `WebDriver.getPageSource()` 是 WebDriver 的一个方法，用于返回当前页面的源代码。它返回一个字符串，其中包含当前页面的 HTML 代码。通常情况下，这个方法可以用于获取页面上的所有内容，包括文本、标签、属性等，以便进行进一步的分析或处理。有时候一闪而过的弹框很难定位，那么可以使用assertThat(pageSource, containsString("asd"))

15. ```java
    //传统低效的跳转新标签页
    String originalHandle = webDriver.getWindowHandle();
    Set<String> allHandles = webDriver.getWindowHandles();
    for(String windowHandle: allHandles) {
        if(!windowHandle.equals(originalWindow)) {
            webDriver.switchTo().window(windowHandle);
            break;
        }
    }
    
    //一种新型便捷的写法。默认率先get的网址就是0
    driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    ```

16. 浏览器console页面能定位到元素，但是java代码却会报错No Such Element的原因多半是**frame**！

17. iframe可以单独存在，但是frame必须和frameset配合使用。frame/iframe可以使用index、id、name、webElement定位。frameset看做是一个普通的标签，并不像iframe一样看做一层

18. xpath定位`$x("//*[@class=\"ma-2 frame3\"]/button")`xpath中可以直接写这种两个类，但是css表达式不行

19. 在主页面中定位到iframe1中的button1并点击后，需要冲iframe1中切回到主页面，然后才能定位到iframe2中的button2

20. 在代码中编写的By.id、By.name等等都会被Selenium转换成css表达式运行

21. 在孙框架里webDriver.switchTo().defaultContent()会跳转到爷框架而不是父框架，也就是说defaultContent是跳到最外层，跳转父级是webDriver.switchTo().parentFrame()

