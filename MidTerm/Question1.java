package MidTerm;

/*
 * дһ�����������һ�����ܳ��±���������ڣ���һ���������ڴ�һ�����ܳ���������ڡ�
 * дһ���༶��������ӣ�������һ�������������ǹ���ڡ�
 * ��main�����У�����һ��SpecialDay��ʵ����Ȼ���жϸ�ʵ����MidAutumn���ͻ���NationalDay���͡�
 * �����жϣ��ֱ�չ��ͳ�(���±��򳪸�)���������ڽӿڵĺ��������һЩ�ı���
 */

public class Question1 {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	SpecialDay sd = new SpecialDay();

	if (sd instanceof MidAutumn) {
	    MidAutumn ma = (MidAutumn) sd;
	    ma.eatMooncake();
	}

	// �⿼���Ƿ���̬����զ���Źֵֹ�

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
 * @author ���� ����ʵ���������ûɶҪ�õ�Javadoc�ĵط���ֻ������ǿ��Javadoc��
 * �����ɫճ����������������Ҫ�����Ǽ�������Ҳû�취
 *
 */
class SpecialDay implements MidAutumn, NationalDay {

    @Override
    public void singSong() {
	// TODO �Զ����ɵķ������
	System.out.println("����ڳ���");
    }

    @Override
    public void eatMooncake() {
	// TODO �Զ����ɵķ������
	System.out.println("����ڳ��±�");
    }

}