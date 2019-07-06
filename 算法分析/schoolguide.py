
from turtle import *
import turtle
import math
import time
sc = Screen()
school = {"一教": [0, 5],
              "二教": [10, -40],
              "三教": [-30, -5],
              "四教": [-15, 45],
              "三实验楼": [-15, 100],
              "一实验楼": [80, 100],
              "中央水体": [60, 45],
              "图书馆": [100, 20],
              "足球场": [-120, -40],
              "蝴蝶山": [160, 90]
              }



# 使用dijkstra算法，无向图和目标节点作为函数的输入
def dijkstraoface(photo, target):
    # 判断图是否为空，如果为空直接退出
    if (not photo) :
        return
    nodes = [i for i in range(len(photo))]  # 获取图中所有节点
    # print(nodes)

    # print(len(photo))
    visited=[]  # 表示已经访问到最短路径的节点集合
    #将目标节点归类到最初的已经访问到最短路劲集合visited中
    if target in nodes:
        visited.append(target)
        nodes.remove(target)
    else:
        return None
    # print(nodes)
    aimdist={target:0}  # 用字典记录目标节点到各个节点的距离
    for i in nodes:
        aimdist[i]=photo[target][i]  # 初始化
    # print(aimdist)
    path={target:{target:[]}}  # 用字典记录目标节点到每个节点的路径，这是路径过程的集合
    k=temp=target
    #当需要解决的节点还存在时
    while nodes:
        tempdist=float('inf')#无穷大表示没有进行访问前一个初始距离
        # tempdist=1000
        for v in visited:
            for d in nodes:
                newdist = photo[target][v] + photo[v][d]
                if newdist <=tempdist:
                    tempdist=newdist
                    photo[target][d]=newdist  # 进行距离更新
                    k=d
                    temp=v
        aimdist[k]=tempdist  # 进行松弛过的最短路径
        path[target][k]=[i for i in path[target][temp]]#将找到的一个节点的寻路过程存储起来
        path[target][k].append(k)#将每个寻路过程加入到路径过程的集合中

        nodes.remove(k)#需要解决的节点减一
        visited.append(k)#解决的节点加一

        print(visited,nodes)  # 输出节点的添加的具体过程
    return aimdist,path
#返回到每个点的最短距离，每个点的路径，都是用字典装的

#通过迪杰斯特拉完成的寻路算法，返回最短路径长度，路径情况
def serchbydjs(graph,start,end):


    distance, path = dijkstraoface(graph, start)  # 查找从源点0开始带其他节点的最短路径

    # print(distance,path)
    # print(start,end)
    # # print(end)
    # print(distance.get(end))
    # print(path)
    return distance.get(end),path[start].get(end)







#获得地图上的各个地点的情况，返回这些点的坐标和地址数字号对照表
def getpoint():

    point = []

    for i in school:
        point.append(school[i])

    # 地点和名字的对照字典
    nametonum = {}
    k = 0
    for i in school:
        nametonum[i] = k
        k += 1
    print(nametonum)
    return point,nametonum
#将出发、抵达地点的名子对应的数字返回
def nametonum(nametonum,startname,endname):
    startnum=nametonum[startname]
    endnum=nametonum[endname]
    return startnum,endnum
#将数字号对应的地点名返回
def numtoname(startnum,endnum):
    k=0
    for i in school:
        if(startnum==k):
            a=i
            break
        k+=1
    k=0
    for i in school:
        if(endnum==k):
            b=i
            break
        k+=1

    return a,b
#画出原始路径，并将距离打印出来
def drawline(start,end):
    turtle.up()
    x1=school.get(start)[0]
    x2=school.get(end)[0]
    y1=school.get(start)[1]
    y2=school.get(end)[1]
    # print(school.get(start)[0], school.get(start)[1])
    # print(school.get(end)[0], school.get(end)[1])
    turtle.goto(school.get(start)[0],school.get(start)[1])
    turtle.down()
    turtle.goto((x1+x2)/2,(y1+y2)/2)
    distance=int(math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2)))
    turtle.pencolor("white")
    turtle.pensize(3)
    turtle.write(distance)
    turtle.pencolor("yellow")
    turtle.pensize(1)
    turtle.goto(school.get(end)[0],school.get(end)[1])
    turtle.up()

    return 1

#画出寻路路径，每次传入一个单元格的路径
def drawline2(start,end):
    turtle.up()
    turtle.speed(1)
    time.sleep(1)
    x1=school.get(start)[0]
    x2=school.get(end)[0]
    y1=school.get(start)[1]
    y2=school.get(end)[1]
    # print(school.get(start)[0], school.get(start)[1])
    # print(school.get(end)[0], school.get(end)[1])
    turtle.goto(x1,y1)
    turtle.down()

    turtle.pencolor("blue")
    turtle.pensize(3)

    turtle.goto(x2,y2)
    turtle.up()

    return 1
#将字典形式的坐标转化为邻接矩阵
def dictchangezhuzhen(point):
    #注释的代码是计算每个地点的距离并打印
    # jz=[]
    # for i in range(len(point)):
    #     ct=[]
    #     for j in range(len(point)):
    #         # print(point[i][0]-point[j][0])
    #         # print(point[i][1]-point[j][1])
    #         dist=int(math.sqrt(math.pow(point[i][0]-point[j][0],2)+math.pow(point[i][1]-point[j][1],2)))
    #         ct.append(dist)
    #     jz.append(ct)
    #
    # for i in jz:
    #     print(i)
    nowschool={1:{1:0,2:46,3:31,4:42,7:72,8:101},
               2:{2:0,1:46,3:53,9:130},
               3:{3:0,1:31,2:53,4:52,9:96},
               4:{4:0,1:42,3:52,5:55},
               5:{5:0,4:55,6:95},
               6:{6:0,5:95,7:58,10:80},
               7:{7:0,1:72,6:58,8:47},
               8:{8:0,1:101,7:47,10:92},
               9:{9:0,2:130,3:96},
               10:{10:0,6:80,8:92}



    }
    # for row in nowschool:
    #     k=nowschool.get(row)
    #     for n in k:
    #         print(k[n],end=" ")
    #     print()



    M=float("inf")
    schooljz=[([M] * len(point)) for i in range(len(point))]
    # print(schooljz)
    for i in range(len(point)):
        for j in range(len(point)):
            for row in nowschool:
                k = nowschool.get(row)
                for n in k:
                    if(i==row-1 and j==n-1):

                        schooljz[i][j]=k[n]
    # for i in schooljz:
    #     print(i)

    return schooljz



#将地点各个可走的路径获得
def drawpath():
    a,b=getpoint()


    jz=dictchangezhuzhen(a)
    l=len(jz)
    # for i in range(len(jz)):
    #     for j in range(len(jz)):
    #         if(jz[i][j]!=jz[j][i]):
    #             print("jz[%d][%d]!=jz[%d][%d]"%(i,j,j,i))
    # print(jz)
    list1=[]
    for i in range(l):

        for j in range(l):
            flag=0
            if(jz[i][j]>0 and jz[i][j]<float("inf")):
                for k in list1:
                    c,d=nametonum(b,k[0],k[1])
                    if(i==d and c==j):
                        flag=1
                        break
                if(flag==1):
                    continue
                list0=[]
                start=i
                end=j
                start,end=numtoname(start,end)
                list0.append(start)
                list0.append(end)
                list1.append(list0)
    # print(list1)
    # l=len(list1)
    # print(l)
    #删除重复的边

    return list1,jz




#主驱动，演示寻路
def drawpoint():
    sc.bgpic('cqlgdx.gif')
    picture,duizhaolist=getpoint()

    # print(point)


    turtle.setup(800, 450, 0, 0)
    turtle.pensize(1)
    turtle.pencolor("white")
    turtle.speed(8)
    turtle.up()#让下一次的移动不画出颜色
    i=1
    # for m in picture:
    #     turtle.goto(m[0], m[1])
    #
    #
    #     turtle.down()#落笔
    #     turtle.write(i)
    #     turtle.circle(10)
    #     turtle.fillcolor("blue")
    #     turtle.goto(m[0], m[1])
    #     turtle.up()#让下一的移动不画出颜色,抬笔
    #     i+=1
    path,jz=drawpath()
    # print(path)
    for i in path:
        drawline(i[0],i[1])
    bulidings=[]
    for i in school:
        bulidings.append(i)
    print(bulidings)
    flag=0
    while(flag==0):
        startname=input("请输入出发地点")
        endname=input("请输入终点")
        if(startname in bulidings and endname in bulidings):
            flag=1
        else:
            print("地点错误，其中有地点不存在，请重新输入")
    num1,num2=nametonum(duizhaolist,startname,endname)
    distance,path=serchbydjs(jz,num1,num2)
    print(distance)
    # print(path)
    allpath=[]
    allpath.append(num1)
    allpath[1:]=path[0:]
    # print(distance)
    # print(allpath)
    finallpath=[]
    for i in range(len(allpath)-1):
        part=[]
        x,y=numtoname(allpath[i],allpath[i+1])
        part.append(x)
        part.append(y)
        finallpath.append(part)
    turtle.pensize("5")
    turtle.pencolor("blue")
    turtle.speed(1)
    print(finallpath)
    time.sleep(2)
    #画出寻路
    for i in finallpath:
        drawline2(i[0],i[1])
    turtle.exitonclick()

    # turtle.write(s[, font=("font-name", font_size, "font_type")])
    # 写文本，s为文本内容，font是字体的参数，分别为字体名称，大小和类型；font为可选项，font参数也是可选项
def main():
    drawpoint()

if __name__ == '__main__':

   main()



