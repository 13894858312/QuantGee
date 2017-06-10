<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/31
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <META content="fason,阿信" name=Author>
    <title>动态提示的下拉框</title>
    <style>

    </style>
</head>
<body onload="Init()">
<center>
    <h2>动态提示的下拉框</h2>
    <hr>
    <form name=newform>
        <table>
            <tr>
                <td>请输入1或2或3或4或5进行测试：<br><input name="txtPlace" style="width:100px" onkeyup="SelectTip(0)"> </td>
            </tr>
            <tr>
                <td>
<span id="myselect">  <select name="myselect" style="width:100px" size=10 onchange="txtPlace.value=options[selectedIndex].text;" id="sq2" >
    <option value="1">一飞冲天</option>
    <option value="12">12</option>
    <option value="123">123</option>
    <option value="1234">1234</option>
    <option value="2">2</option>
    <option value="23">23</option>
    <option value="234">234</option>
    <option value="2345">2345</option>
    <option value="3">3</option>
    <option value="34">34</option>
    <option value="345">345</option>
    <option value="3456">3456</option>
    <option value="5">5</option>
    <option value="51">51</option>
    <option value="51w">51w</option>
    <option value="51wi">51wi</option>
    <option value="51win">51win</option>
    <option value="51windows">51windows</option>
</span>    </select>
                </td>
            </tr>
    </form>
    </table>


    <hr>
    <td>

        <script language="javascript">
            var TempArr=[];//存贮option

            function Init(){
                var SelectObj=document.newform.elements["myselect"]
                /*先将数据存入数组*/
                with(SelectObj)
                    for(i=0;i<length;i++)TempArr[i]=[options[i].text,options[i].value]
            }

            function SelectTip(flag){
                var TxtObj=document.newform.elements["txtPlace"]
                var SelectObj=document.getElementById("myselect")
                var Arr=[]
                with(SelectObj){
                    var SelectHTML=innerHTML.match(/<[^>]*>/)[0]
                    for(i=0;i<TempArr.length;i++)
                        if(TempArr[i][0].indexOf(TxtObj.value)==0||flag)//若找到以txt的内容开头的，添option。若flag为true,对下拉框初始化
                            Arr[Arr.length]="<option value='"+TempArr[i][1]+"'>"+TempArr[i][0]+"</option>"
                    innerHTML=SelectHTML+Arr.join()+"</SELECT>"
                }
            }
        </script>
</body>
