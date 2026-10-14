import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaitingListManager manager = new WaitingListManager();

        manager.add("zhangsan");
        manager.add("wangwu");
        manager.add("zhaoliu");
        manager.add("xiaoqi");

        manager.show();
        manager.join();

        System.out.println("请输入需要加入候补名单的学生姓名：");
        String newName = scanner.nextLine();
        manager.add(newName);

        System.out.println("请输入需要取消候补的学生姓名：");
        String cancelName = scanner.nextLine();
        manager.off(cancelName);

        manager.show();
        scanner.close();
    }
}

/** 校园活动候补名单管理器。 */
class WaitingListManager {

    private final LinkedList<String> formal = new LinkedList<>();
    private final LinkedList<String> houbu = new LinkedList<>();

    public void add(String name) {
        confirm(name);
        if (formal.contains(name) || houbu.contains(name)) {
            System.out.println(name + " 已经报名，请勿重复报名");
            return;
        }
        houbu.addLast(name);
        System.out.println(name + " 加入候补名单成功");
    }

    /** 调用时假设正式名单已有空位。 */
    public void join() {
        if (houbu.isEmpty()) {
            System.out.println("没有候补学生");
            return;
        }
        String name = houbu.removeFirst();
        formal.addLast(name);
        System.out.println(name + " 候补转正成功");
    }

    public void off(String name) {
        confirm(name);
        boolean removed = houbu.remove(name);
        if (removed) {
            System.out.println(name + " 取消候补成功");
        } else {
            System.out.println("没有找到该候补学生：" + name);
        }
    }

    private void confirm(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("学生姓名不得为空");
        }
    }

    public void show() {
        System.out.println("========== 当前报名情况 ==========");
        System.out.println("正式名单：" + formal);
        System.out.println("候补名单：" + houbu);
        System.out.println("正式人数：" + formal.size());
        System.out.println("候补人数：" + houbu.size());
        System.out.println("================================");
    }
}


