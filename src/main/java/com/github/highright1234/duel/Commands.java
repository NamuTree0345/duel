package com.github.highright1234.duel;
// 나 시작전이다 이새꺄
// 내가 이걸 까먹겠냐 ㅋㅋ
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("duel")) {
            if (sender instanceof Player) {
                if (args.length >= 1) {
                    if (args[0].equals("help")) {
                        sender.sendMessage("=========================");
                        sender.sendMessage("1. 듀얼신청: /duel send <플레이어이름>");
                        sender.sendMessage("2. 듀얼수락: /duel accept <플레이어이름>");
                        sender.sendMessage("3. 듀얼거절: /duel deny <플레이어 이름>");
                        sender.sendMessage("=========================");
                        return true;
                    } else if (args[0].equals("send")) {
                        sender.sendMessage("/duel send <플레이어이름>");
                        return true;
                    } else if (args[0].equals("accept")){
                        sender.sendMessage("/duel accept <플레이어이름>");
                        return true;
                    }
                } //길이가 1일시
            } else { //플레이어가 아닐시
                System.out.println("이 커맨드는 플레이어만 실행할수 있습니다!");
                return false;
            }
        } // 이름이 듀얼일시
        return false;
    }
}