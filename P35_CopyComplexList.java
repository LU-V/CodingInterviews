package CodingInterviews;

public class P35_CopyComplexList {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode p = pHead;
        RandomListNode t = pHead;
        while (p != null) {
            RandomListNode q = new RandomListNode(p.label+10);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        while (t != null) {
            RandomListNode q = t.next;
            if (t.random != null)
                q.random = t.random.next;
            t = q.next;

        }
        RandomListNode s = new RandomListNode(0);
        RandomListNode s1 = s;
        while (pHead != null) {
            RandomListNode q = pHead.next;
            pHead.next = q.next;
            q.next = s.next;
            s.next = q;
            s = s.next;
            pHead = pHead.next;
        }
        return s1.next;

    }

    public static void main(String[] args) {
        RandomListNode h = new RandomListNode(1);
        h.next = new RandomListNode(2);
        h.next.next= new RandomListNode(3);
        h.next.next.next = new RandomListNode(4);
        h.next.next.next.next = new RandomListNode(5);
        h.random =   h.next.next;//3
        h.next.random=h.next.next.next.next;//5
        h.next.next.random=h.next;//2
        P35_CopyComplexList p = new P35_CopyComplexList();
//        p.Clone(h);
        System.out.println( p.Clone(h));
    }
}
