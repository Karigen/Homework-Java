package MidTerm;

/*
 * 写一个界面中秋带一个功能吃月饼代表中秋节，另一个界面国庆节带一个功能唱歌代表国庆节。
 * 写一个班级特殊的日子，代表这一天既是中秋节又是国庆节。
 * 在main函数中，创建一个SpecialDay的实例，然后判断该实例是MidAutumn类型还是NationalDay类型。
 * 根据判断，分别开展传统活动(吃月饼或唱歌)。您可以在接口的函数中输出一些文本。
 */

public class Question1 {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	SpecialDay sd = new SpecialDay();

	if (sd instanceof MidAutumn) {
	    MidAutumn ma = (MidAutumn) sd;
	    ma.eatMooncake();
	}

	// 这考的是反多态？我咋觉着怪怪的

	if (sd instanceof NationalDay) {
	    NationalDay nd = (NationalDay) sd;
	    nd.singSong();
	}
    }

}

interface MidAutumn {
    void eatMooncake();
}

interface NationalDay {
    void singSong();
}

/**
 * 
 * @author 作者 我其实觉着我这个没啥要用到Javadoc的地方，只能在这强行Javadoc了
 * 这个颜色粘贴出来就是这样，要求又是加亮，我也没办法
 *
 */
class SpecialDay implements MidAutumn, NationalDay {

    @Override
    public void singSong() {
	// TODO 自动生成的方法存根
	System.out.println("国庆节唱歌");
    }

    @Override
    public void eatMooncake() {
	// TODO 自动生成的方法存根
	System.out.println("中秋节吃月饼");
    }

}