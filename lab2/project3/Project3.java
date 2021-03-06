package lab2.project3;

/*
 * “石头剪刀布”是一种很受孩子们欢迎的游戏，用三个手势代表“石头”、“布”和“剪刀”，经常被用作决胜局。
 * 游戏的细节可以在https://en.wikipedia.org/wiki/Rock-paper-scissors上找到。
 * 规则如下表所示:开发两个套接字程序:一个服务器，一个客户端。
 * 1. 客户端有两个线程(你可以把每个线程看作一个子线程):
 * 	a)线程a(即Kid a)和线程B(即Kid B)都是随机睡眠时间(不超过1秒)，然后分别在[石头、布、剪刀]中进行随机选择;
 * 	b)线程A使用TCP向服务器发送数据c)线程B使用UDP发送数据到服务器
 * 2. 服务器从客户端接收数据(服务器同时充当TCP服务器和UDP服务器)
 * 3. 一旦服务器接收到Kid A和Kid B做出的两个选择(一个来自TCP套接字，另一个来自UDP套接字)，服务器将比较这两个选择(用“Kid A”和“Kid B”表示)，并根据【表1】给这两个孩子打分。
 *    【石头剪刀布】计分台。
 * 4. 服务器以以下格式打印结果。您可以使用控制台或GUI作为程序的UI。
 *    最终结果:A(或B或None)为获胜者(提示:不需要打印表格框架)
 * 5. 重复步骤1 -步骤4至少3次。
 * 6. 最后，服务器分别比较线程A和线程B获得的总点数，以声明谁是赢家:A(或B或None)是赢家。
 */

public class Project3 {

    public static void main(String[] args) {

    }

}