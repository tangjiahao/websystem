yctime=0#设置延迟时间
import random
class ace:
    def __init__(self):
        self.x=0#存储数塔一个格子的x坐标
        self.y=0#存储数塔的一个格子的y坐标
        self.value=0#存储格子中的数
def maxtwo(a,b):
    if a>=b:
        return a
    else:
        return b
#产生数塔，用列表存储,返回原始数据
def getnt(n):
    nt=[]
    for i in range(1,n+1):
        row=[]
        for j in range(0,i):
            row.append(random.randint(1,25))
        nt.append(row)
    return nt
#解决数塔问题
def solvent(row,nt):
    #定义一个row*row大小的二维列表存储辅助数塔，nt为二维列表，存储的原来数塔情况
    temp=[([-1] * row) for i in range(row)]
    #辅助数塔的最底层和原来的数塔nt相同，为辅助数塔最底层赋值
    for i in range(row):
        temp[row-1][i]=nt[row-1][i]
    k=row-2

    #自底向上得到辅助数塔
    while(k>=0):
        for j in range(0,k+1):
            temp[k][j]=max(temp[k+1][j+1],temp[k+1][j])+nt[k][j]
        k-=1
        #打印数塔
    for i in range(0,row):
        for j in range(0,i+1):
            print(nt[i][j],end=" ")
        print()
        #打印辅助数塔
    for i in range(0,row):
        for j in range(0,i+1):
            print(temp[i][j],end=" ")
        print()
    return temp
#返回辅助数塔，其中temp[0][0]即为最大总和值
import time
def driveslove(row):

    nt=getnt(row)
    path=[]#用来装最终路径
    maxlist=solvent(row,nt)
    dataclass=[]#这个列表用来装源数据的对象
    maxclass=[]#这个列表用来装选择时的数据对象
    for i in range(int((1+row)*row/2)):
       p=ace()
       q=ace()
       dataclass.append(p)
       maxclass.append(q)
    # print(maxlist)
    next=0
    print(str(nt[0][0]))
    path.append(nt[0][0])
    if(row>=2):
        print("从[%d(max:%d),%d(max:%d)]选择"%(nt[1][next],maxlist[1][next],nt[1][next+1],maxlist[1][next+1]),end=" ")
        print()

        for i in range(1,row):
            if(maxtwo(maxlist[i][next],maxlist[i][next+1])==maxlist[i][next]):
                path.append(nt[i][next])
                print("->"+str(nt[i][next]))
                time.sleep(yctime)
                if(i<row-1):
                    print("从[%d(max:%d),%d(max:%d)]选择"%(nt[i+1][next],maxlist[i+1][next],nt[i+1][next+1],maxlist[i+1][next+1]),end=" ")
                    print()
            if(maxtwo(maxlist[i][next],maxlist[i][next+1])==maxlist[i][next+1]):
                next=next+1
                path.append(nt[i][next])
                print("->"+str(nt[i][next]))
                time.sleep(yctime)
                if (i < row - 1):
                    print("从[%d(max:%d),%d(max:%d)]选择"%(nt[i+1][next],maxlist[i+1][next],nt[i+1][next+1],maxlist[i+1][next+1]),end=" ")
                    print()
        print("和的最大值为：%d"%maxlist[0][0])
    k=0
    for i in range(row):
        for j in range(0,i+1):
            dataclass[k].x=j
            dataclass[k].y= i
            dataclass[k].value= nt[i][j]
            maxclass[k].x=j
            maxclass[k].y=i
            maxclass[k].value=maxlist[i][j]
            k+=1

    return dataclass,maxclass,maxlist,path,row
        #返回两个对象列表,两个数组列表和数塔的阶层






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
#加载已经存在的数塔ui文件产生界面

qtCreatorFile = "numtower.ui"  # Enter file here.
Ui_MainWindow, QtBaseClass = uic.loadUiType(qtCreatorFile)
class numtower(QtWidgets.QMainWindow, Ui_MainWindow):

    datadic={}
    datalen=0#原始数据字典的长度
    maxdic={}
    maxlen=0#选择时的数据字典的长度
    dataclass=[]
    maxclass=[]
    maxlist=[]
    path=[]
    next1=0
    len0=-1#数塔的阶层,随着下一步函数nextbutton会改变
    row= -1# 数塔的阶层,不会改变
    pathnum=-1#存储的寻路path中的节点个数，不会随着进程运行而改变
    def __init__(self):
        QtWidgets.QMainWindow.__init__(self)
        Ui_MainWindow.__init__(self)
        super(numtower, self).__init__()
        self.setupUi(self)
        self.start.clicked.connect(self.startbutton)
        #img=ImageTk.PhotoImage(Image.open('F:\\pyqtProject\\doubanTitle.jpg'))
        self.setWindowTitle("数塔问题")#设置舞台头部
        self.next.clicked.connect(self.nextbutton)
        self.path.clicked.connect(self.serchpathnext)
        # self.start.clicked.connect(self.solveqp)

    #响应开始的槽函数，执行打印的情况
    def startbutton(self):


        n=int(self.jiecen.toPlainText())
        #判定输入的阶层为正整数
        if(n>0):


            # #这里是为了关闭上一次的运行结果，不然会发生错误的重叠显示
            print(self.datalen)
            print(self.maxlen)
            if(self.datalen>0 and self.maxlen>0):
                # print("已经有值")
                print(1)
                for i in range(self.datalen):
                   self.datadic.get(i).close()#关闭格子，即label
                for i in range(self.maxlen):
                   self.maxdic.get(i).close()
                # print(2)
                self.datadic.clear()#清空字典
                self.maxdic.clear()
                self.dataclass.clear()
                self.maxclass.clear()
                self.datalen=0
                self.maxlen=0
                self.next1=0
                self.maxlist.clear()


            # print(self.datalen)
            # print(self.maxlen)
            #在舞台上动态创建格子大小的数塔，用字典来存取一个个格子也就是label对象

            for i in range(0,n):
                for j in range(0,i+1):
                    self.datadic[self.datalen]=QLabel(str(self.datalen), self)
                    #设置在画板的文字
                    self.datadic[self.datalen].setGeometry(QtCore.QRect(50 + (60 * j + 60 * (n-1 - i) / 2)*6/n, 50 + (60 * i)*6/n, 40*6/n, 40*6/n))
                    self.datadic[self.datalen].setAlignment(Qt.AlignCenter)#设置文字居中
                    self.datadic[self.datalen].show()#必须有这一句，不然创建的格子没法显示出来

                    self.datalen+=1


            self.dataclass,self.maxclass,self.maxlist,self.path,self.len0=driveslove(n)
            self.row=self.pathnum=self.len0

            # print(self.path)
            # print(path)

            for i in range(int((self.len0+1)*self.len0/2)):
                self.datadic.get(i).setStyleSheet(bkcolor['1'])
                self.datadic.get(i).setText("%d" % self.dataclass[i].value)
        else:
            print("请输入正整数亲，重新输！")

    def nextbutton(self):


        if(self.len0>0 and self.maxlen<=self.datalen):
            for i in range(0,self.len0):
                self.maxdic[self.maxlen] = QLabel(str(self.maxlen), self)

                self.maxdic[self.maxlen].setGeometry(QtCore.QRect(50 + ((self.row+0.5)* 60 + 60 * i+60*(self.row-self.len0)/2 )*6/self.row, 50 + (60 * (self.len0-1))*6/self.row, 40*6/self.row, 40*6/self.row))

                self.maxdic[self.maxlen].show()
                self.maxlen+=1


            t=self.maxlen-self.len0
            for i in range(int((self.row+1)*self.row/2)):
                if(self.maxclass[i].y==self.len0-1):
                    self.maxdic.get(t).setStyleSheet(bkcolor['4'])
                    self.maxdic.get(t).setText("%d" % self.maxclass[i].value)
                    self.maxdic.get(t).setAlignment(Qt.AlignCenter)  # 设置文字居中
                    t+=1
            self.len0-= 1
        else:
            return

    #在原来的数塔上显示一步步路径

    def serchpathnext(self):
        if(self.pathnum>1):
            k=self.row-self.pathnum
            # print(self.next1)
            # print(maxtwo(2,3))
            if(maxtwo(self.maxlist[k+1][self.next1],self.maxlist[k+1][self.next1+1])==self.maxlist[k+1][self.next1]):

                print(int((1+(k+1))*(k+1)/2+self.next1))

                # print(self.next)
                self.datadic.get(int((1+(k+1))*(k+1)/2+self.next1)).setStyleSheet(bkcolor['0'])
            if(maxtwo(self.maxlist[k+1][self.next1],self.maxlist[k+1][self.next1+1])==self.maxlist[k+1][self.next1+1]):
                self.next1=self.next1+1
                print(int((1+(k+1))*(k+1)/2+self.next1))
                self.datadic.get(int((1 + (k + 1)) * (k + 1) / 2 + self.next1)).setStyleSheet(bkcolor['0'])

            self.pathnum-= 1
        else:
            return





#加载已经存在的start ui文件产生界面
qtCreatorFile = "ntstart.ui"  # Enter file here.
Ui_MainWindow, QtBaseClass = uic.loadUiType(qtCreatorFile)



class startmenu(QtWidgets.QMainWindow, Ui_MainWindow):
    def __init__(self):
        QtWidgets.QMainWindow.__init__(self)
        Ui_MainWindow.__init__(self)
        super(startmenu, self).__init__()
        self.setupUi(self)
        png = QtGui.QPixmap('2.jpg').scaled(780, 460)
        self.bkp.setPixmap(png)
        #img=ImageTk.PhotoImage(Image.open('F:\\pyqtProject\\doubanTitle.jpg'))
        self.setWindowTitle(" start of datatower")#设置舞台头部



        self.ct.clicked.connect(self.changewt)#打开新窗口，关闭本窗口
        self.ct.clicked.connect(self.close)




    # 跳转到界面
    def changewt(self):
        self.sec= numtower()
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
















