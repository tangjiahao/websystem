

import turtle
#画分形树，用的是创建二叉树的算法
def treeoface(length):

    #如果枝干长度小于15就不画
    if length<15:
        return 0
    turtle.forward(length)#往前画

    turtle.up()#在回退的时候关闭画笔的工作
    turtle.backward(length * (1 / 3))#回退到三分之一的地方
    turtle.down()#重新打开画笔工作

    turtle.left(60)

    #time.sleep(1)#画左枝干，长度为主枝干的1/3
    treeoface(length*(1/3))

    turtle.right(60)
    turtle.up()
    turtle.backward(length * (1 / 3))
    turtle.down()

    # 画右枝干，长度为主枝干的2/3
    turtle.right(60)


    treeoface(length*(2/3))

    turtle.left(60)
    turtle.up()
    turtle.backward(length * (1 / 3))
    turtle.down()

    return 0
def main():
    #画笔一开始是水平向右的，让它左转90度竖直向上
    turtle.left(90)
    turtle.backward(250)
    turtle.pensize(3)
    turtle.speed(2)
    #设置线条粗细
    #设置线条颜色
    turtle.color("blue")

    # turtle.size(3)
    #设定树的最大长度为500
    treeoface(500)
    #关闭画板
    turtle.exitonclick()
main()
