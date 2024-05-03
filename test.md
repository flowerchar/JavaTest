脚踏实地，手握星辰。他与大数据审计有个七年之约



罗伟力，男，计算机学院23级计算机技术专硕班。在校期间参与并组织多项大数据审计科研项目，担任江苏省重点研究基地"经济监督研究中心"科研助理和南京审计大学审计处学生审计员。积极参与科研竞赛，获得第二十届华为杯中国研究生数学建模竞赛国家三等奖、第八届全国大学生软件测试大赛国家三等奖和第十五届蓝桥杯软件大赛江苏省一等奖等多项计算机类奖项。2023年上半年在贵州省大数据中心实习期间，参与西南地区大数据资源建设，独立开发了云上政声大数据可视化分析平台，为政府决策提供了直观数据支持，该作品获得2023年12月江苏省“领航杯”大学生信息技术应用能力赛三等奖。



1. 在设计测试用例时，如果要覆盖产品业务场景，可以使用黑盒测试方法为**场景法**
2. 对于输入框来说，设计测试用例应该从哪些方面进行考虑？**A：输入内容的长度、B：输入内容的类型、C：是否必填、D：动作项**
3. 关于测试用例设计，下列说法错误的是：**选项C: 判定表必须与因果图配合使用，不可以单独使用**
4. 常见的导致软件存在 Bug 的原因有？**A：软件的复杂度、B：编程错误、D：需求的不断变更**
5. 测试web项目中的搜索功能时，可以考虑的测试场景有：**A：超长内容搜索、B：搜索系统中不存在的与之匹配的条件、C：搜索系统中存在的与之匹配的条件、D：查询条件的组合测试**
6. web 自动化测试中有哪些断言方式：**A: 获取页面元素信息完成断言、C: 获取页面url验证跳转逻辑、D: 断言逻辑与功能测试用例一致**
7. 元素明明被定位到了，但是点击无效，也没报错，关于这个原因下面说法正确的是：**A：页面同步加载js，导致点击无效、B：定位到之后，被突然出现的弹框遮档，导致点击失败、C：页面存在多个相同属性的元素，导致点击的不是想要操作的那个元素**
8. xpath语法中，通过下标获取最后一个元素正确的是：**[last]**
9. 以下关于css选择器语法说明正确的是：**A: 并集使用逗号：,**
10. web自动化中，通过下面哪种方法可以获取元素的属性信息：**A：java语法：getAttribute**
11. web自动化过程中，frame可以通过什么来定位然后进行切换：**A：index下标定位、B：id定位、C：name定位、D：css或xpath定位**
12. 判断页面上的元素是否成功展示，下面错误的说法：**D: 使用隐式等待来判断元素是否展示**`隐式等待适用于整个 WebDriver 实例的生命周期，在查找元素时会等待一定时间，但它并不能直接判断元素是否成功展示。正确的做法是使用显式等待来判断元素是否成功展示，因为显式等待会在特定的条件满足时等待一段时间，直到条件成立或超时。`
13. 关于接口测试中基于输入域的测试，包含以下哪些选项：**A：边界值、B：特殊字符、C：参数类型、D：排重逻辑**
14. 常见的POST提交数据方式有：**C：multipart/form-data、D：application/json**
15. 关于接口测试中的cookie，以下说法正确的是：**A: 可以通过headers传递、B: 接口自动化中可以传递cookie、C: cookie通常采用键值对**
16. json path中$表示什么？**A：查询根元素**
17. 在发起请求后，requests.get()中的使用哪个默认参数可以定制请求头？**B：headers**
18. http请求报文通常包含以下哪几部分：**A：请求头、C：请求体**
19. 以下常用状态码，表示客户端差错的状态码为：**D：4xx**





给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。

示例 1：

- 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
- 输出：8
- 解释：矩阵中共有 8 个负数。

示例 2：

- 输入：grid = [[3,2],[1,0]]
- 输出：0

```python
class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        count = 0
        for row in grid:
            for num in row:
                if num < 0:
                    count += 1
        return count

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        count = 0
        row, col = 0, n - 1
        
        while row < m and col >= 0:
            if grid[row][col] < 0:
                count += m - row
                col -= 1
            else:
                row += 1
                
        return count

```



## 题目说明

1. 要求实现一个冒泡排序算法。
2. 可以使用 Python 或者 Java 实现。
3. 要求必须使用以下模版（不使用模版，自动判零分）。

### python 模版

```python
def bubble_sort(arr):
    """
    冒泡排序算法
    """
    n = len(arr)
    for i in range(n):
        # 标志位，表示本轮是否发生交换，若没有交换则说明数组已经有序
        flag = False
        for j in range(0, n - i - 1):
            # 如果当前元素大于下一个元素，则交换它们
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                flag = True
        # 如果本轮没有发生交换，说明数组已经有序，直接返回
        if not flag:
            return arr
    return arr
```



#### 搜索功能接口信息

- url ：`https://ceshiren.com/search`
- 请求方法: `get`

##### URL 参数

| url参数 | 说明         |
| :------ | :----------- |
| q       | 搜索字段     |
| limit   | 返回条数     |
| trem    | 用户搜索字段 |

##### 头信息（headers）

**注意**： 必须添加，否则返回值不正确

| key    | value            |
| :----- | :--------------- |
| Accept | application/json |

```java
package com.flowerchar.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SearchTest {

    @Test
    void searchTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("q", "selenium");
        map.put("limit",5);
        map.put("trem", "java");
        given()
                .header("Accept", "application/json")
                .queryParams(map)
        .when()
                .get("https://ceshiren.com/search")
        .then().log().all();
    }
}
