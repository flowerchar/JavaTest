### 一、JUnit5总结

1. 必须以Test开头或者以Test结尾，如果不满足，在IDEA下可以运行。但是在maven终端下执行mvn test，则不会执行没满足的类名
2. 如果想改变命名规则，那么可以配置pom来改变自定义命名规则，但是这回覆盖Test开头或者以Test结尾的规则
3. 一条测试用例存在多个断言，执行到出错的这个断言就会停止向下执行。如果想要全部都执行，那么使用assertAll
4. 如果存在类继承，那么用例顺序是![image-20240421002746222](README.assets/image-20240421002746222.png)；先蓝后黑最后红；如果子类的方法名跟父类的方法名一致了，那么就是重写，会覆盖父类的实现
5. 可以通过在pom里面配置插件然后使用include标签和exclude标签，指定运行某个包/某个类/某个方法



### 二、Selenium

1. 三种等待：
   1. 直接等待：Thread.sleep()。简单灵活；造成不必要等待
   2. 隐式等待driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))。默认**轮询0.5秒**查找元素是否出现，如果没有就抛出异常。注意，**此操作是全局性配置，所有的findElement都会是隐式等待**；隐式等待只会检测元素是否存在，并不会检测元素是否可用
   3. 显示等待：new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("hhh"))).click() 不仅检测元素出现，还必须是元素可点击了，才会去点击元素
   4. 元素未加载----元素出现了但是还不能交互----元素出现了且可交互
2. 获取属性：WebElement.getAttribute("style")
3. findElement的如果有很多，**并不会报错，而是会找到第一个**