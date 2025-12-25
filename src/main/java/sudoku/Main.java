package sudoku;

public class Main {
    public static void main(String[] args) {
        String[] messages = {
                "Sudoku",
                "快 乐 数 独",
                "来自开发者",
                "难度选择",
                "",
                "菜就多练！",
                "就这水平？",
                "这对你而言可能太难了",
                "反正你不知道这一条其实完全没有用过",
                "期待与你的重逢",
                "简单",
                "中等",
                "困难",
                "<html>全部正确<br><br></html>",
                "<html>有错误哦<br><br></html>",
                "检查完毕"
        };
        Window window = new Window();
        window.setMessages(messages);
        window.run();
        window.game();
    }
}