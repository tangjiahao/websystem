import time

duomimonum=0
chessnode=[([-1] * 100) for i in range(100)]


'''
currentx,currenty,tx,ty,size分别为棋盘的左上角x坐标，左上角y坐标；tx,ty表示特殊棋子的xy坐标
size表示当前棋盘大小，是可变得
'''
#打印棋盘情况的函数
def printchess(n):

    for i in range(n):
        for j in range(n):
            print("%4d"%chessnode[i][j],end=" ")
        print()
    print()

#duonimor算法，处理优先顺序为左上，右上，左下，右下
def duominor(currentx,currenty,tx,ty,size):
    global duomimonum
    global chessnode
    if(size==1):
        return 0
    duomimonum+=1
    a=duomimonum
    #用a记住这个多米诺牌号，以防这个变量在递归中变化发生错误的记录
    s0=int(size/2)
    #分之，将棋盘减小为1/4
    #处理左上的子棋盘
    #如果特殊的棋子在子棋盘中，就直接进入子棋盘，直到size=1
    if(tx<currentx+s0 and ty<currenty+s0):
        duominor(currentx,currenty,tx,ty,s0)
    else:
        #特殊棋子不在子棋盘中，就将左上棋子置为特殊棋子
        chessnode[currenty+s0-1][currentx+s0-1]=a
        a=duomimonum
        duominor(currentx,currenty,currentx+s0-1,currenty+s0-1,s0)
    #处理右上的子棋盘
    if(tx>=currentx+s0 and ty<currenty+s0):
        duominor(currentx+s0,currenty,tx,ty,s0)
    else:
        chessnode[currenty+s0-1][currentx+s0]=a
        duominor(currentx+s0,currenty,currentx+s0,currenty+s0-1,s0)
    #处理左下的子棋盘
    if(tx<currentx+s0 and ty>=currenty+s0):
        duominor(currentx,currenty+s0,tx,ty,s0)
    else:
        chessnode[currenty+s0][currentx+s0-1]=a
        duominor(currentx,currenty+s0,currentx+s0-1,currenty+s0,s0)
    #处理右下的子棋盘
    if(tx>=currentx+s0 and ty>=currenty+s0):
        duominor(currentx+s0,currenty+s0,tx,ty,s0)
    else:
        chessnode[currenty+s0][currentx+s0]=a
        duominor(currentx+s0,currenty+s0,currentx+s0,currenty+s0,s0)
    # printchess(8)
#大致达到和结构体数组一样的效果，为了存储算法执行的每一步在棋盘上的坐标和正在执行哪一步
class ace:
    def __init__(self):
        self.x=0#存储棋盘的x坐标
        self.y=0#存储棋盘的y坐标
        self.value=0#正在执行哪一步
#按覆盖的顺序排序的函数，返回一个类的数组，类似于结构体数组的应用
def acerank(list,length):
    for i in range(length-1):
        for j in range(i+1,length):
            if(list[i].value > list[j].value):
                t1=list[i].value
                list[i].value=list[j].value
                list[j].value=t1
                t2=list[i].x
                list[i].x=list[j].x
                list[j].x=t2
                t3=list[i].y
                list[i].y=list[j].y
                list[j].y=t3

    return list
import math
#启动函数，用于调用写好的timinor函数并打印出进程情况
def driveduominor(size,x,y):
    global chessnode
    global duomimonum
    duomimonum=0

    duominor(0,0,x,y,size)
    # print("hello")
    # printchess(8)
    # printchess(size)
    qp=list()
    length=size*size
    for i in range(length):

       q=ace()
       qp.append(q)
    #用类的列表存储棋盘的解决情况
    for i in range(size):
        for j in range(size):
            qp[i*size+j].y=i
            qp[i*size+j].x=j
            qp[i*size+j].value=chessnode[i][j]
    #将列表按步数进行排序
    qp=acerank(qp,length)

    for i in range(size):
        for j in range(size):
            chessnode[i][j]=0
    chessnode[x][y]=-1
    for k in range(1,length):
        for i in range(size):
            for j in range(size):
                if(i==qp[k].y and j==qp[k].x):
                    chessnode[i][j]=qp[k].value
        if(k%3==0):
            #打印棋盘情况
            print("第%d步："%(k/3))
            printchess(size)
            print()

    return qp,size
    # print(chessnode)








#背景色，用来区分L块，0,1,2,3,4,分别代表了黄、蓝、黑、红、紫色,'white'用来表示特殊格子的颜色
bkcolor={'0':"QLabel{background-color: rgb(50, 255, 0);color:white}",
         '1':'QLabel{background-color: rgb(0, 0, 255);color:white}',
         '2':'QLabel{background-color: rgb(0, 0, 0);color:white}',
         '3':'QLabel{background-color: rgb(255, 0, 0);color:white}',
         '4':'QLabel{background-color: rgb(0, 255, 255);color:white}',
         'white':'QLabel{background-color: rgb(255, 255, 255);color:white}'

}


import PyQt5
import sys
from PyQt5 import QtGui, QtPrintSupport , QtWidgets, QtCore,uic
from PyQt5.QtWidgets import *
from PyQt5.QtCore import Qt
#加载已经存在的棋盘ui文件产生界面

qtCreatorFile = "qpfg.ui"  # Enter file here.
Ui_MainWindow, QtBaseClass = uic.loadUiType(qtCreatorFile)
class qpfg(QtWidgets.QMainWindow, Ui_MainWindow):

    qpMap={}
    def __init__(self):
        QtWidgets.QMainWindow.__init__(self)
        Ui_MainWindow.__init__(self)
        super(qpfg, self).__init__()
        self.setupUi(self)

        #img=ImageTk.PhotoImage(Image.open('F:\\pyqtProject\\doubanTitle.jpg'))
        self.setWindowTitle("Ace带你解决torminor")#设置舞台头部

        self.start.clicked.connect(self.solveqp)

    #响应开始的槽函数，执行打印的情况
    def solveqp(self):
        # qpMap.clear()

        count=1
        color=0
        n=int(self.qpsize.toPlainText())
        x=int(self.x.toPlainText())
        y=int(self.y.toPlainText())

        #这里是为了关闭上一次的运行结果，不然会发生错误的重叠显示
        if(self.qpMap):
            # print("已经有值")
            # print(len(self.qpMap))
            now=int(math.pow(len(self.qpMap),0.5))

            for i in range(0,len(self.qpMap)):
                for i in range(0, now):
                    for j in range(0, now):
                        self.qpMap[i * now+ j].close()#关闭格子，即label


            self.qpMap.clear()#清空字典
            print(self.qpMap)
        #在舞台上动态创建棋盘大小的格子，用字典来存取一个个格子也就是label对象
        for i in range(0,n):
            for j in range(0,n):
                self.qpMap[i*n+j]=QLabel(self)

                self.qpMap[i*n+j].setGeometry(QtCore.QRect(50+60*(8/n)*j,50+60*(8/n)*i,59*(8/n),59*(8/n)))
                self.qpMap[i*n+j].show()#必须有这一句，不然创建的格子没法显示出来

        result,size=driveduominor(n,x,y)
        #将特殊格子定义为黑色
        self.qpMap.get(result[0].y*size+result[0].x).setStyleSheet(bkcolor['white'])

        #打印显示覆盖情况
        for k in range(1, size*size):

            for i in range(size):
                for j in range(size):
                    if (i == result[k].y and j == result[k].x):
                        color=result[k].value%5#改变格子的颜色
                        self.qpMap.get(result[k].y * size + result[k].x).setStyleSheet(bkcolor['%d' %color])
                        self.qpMap.get(result[k].y * size + result[k].x).setText("%d"%result[k].value)
                        self.qpMap.get(result[k].y * size + result[k].x).setAlignment(Qt.AlignCenter)  # 设置文字居中




#加载已经存在的start ui文件产生界面
qtCreatorFile = "qpfgstart.ui"  # Enter file here.
Ui_MainWindow, QtBaseClass = uic.loadUiType(qtCreatorFile)



class startmenu(QtWidgets.QMainWindow, Ui_MainWindow):
    def __init__(self):
        QtWidgets.QMainWindow.__init__(self)
        Ui_MainWindow.__init__(self)
        super(startmenu, self).__init__()
        self.setupUi(self)
        png = QtGui.QPixmap('3.jpg').scaled(780, 460)
        self.bkp.setPixmap(png)
        #img=ImageTk.PhotoImage(Image.open('F:\\pyqtProject\\doubanTitle.jpg'))
        self.setWindowTitle(" start of Timinor")#设置舞台头部



        self.ct.clicked.connect(self.changewt)#打开新窗口，关闭本窗口
        self.ct.clicked.connect(self.close)




    # 跳转到注册界面
    def changewt(self):
        self.sec= qpfg()
        self.sec.show()
        self.sec.setWindowOpacity(0.9)
        print("跳转")








def main():
    app = QtWidgets.QApplication(sys.argv)

    w=startmenu()
    w.show()
    sys.exit(app.exec_())
if __name__ == '__main__':
    main()
    # driveduominor()
    # for i in range(10):
    #     time.sleep(1)
    #     print(i)

    # driveduominor()



