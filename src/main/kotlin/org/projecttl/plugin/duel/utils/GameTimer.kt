package org.projecttl.plugin.duel.utils

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Score
import org.bukkit.scoreboard.Scoreboard
import org.projecttl.plugin.duel.DuelPlugin

@Suppress("DEPRECATION")
class GameTimer(private var player: Player, private val plugin: DuelPlugin) {

    var count: Int = 300

    private var objective: Objective
    private var timerBoard: Scoreboard? = null
    private var timerObject: Objective? = null

    init {
        val scoreboard: Scoreboard = Bukkit.getServer().scoreboardManager.newScoreboard.let {
            objective = it.registerNewObjective("Left_Time", "dummy", "${ChatColor.GREEN}Left Time")

            it
        }

        objective.displaySlot = DisplaySlot.SIDEBAR

        timerBoard = scoreboard
        timerObject = objective
    }

    fun runTimer() {
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(plugin, { timerFunction() }, 0L, 20L)
    }

    private fun timerFunction() {
        count--
        val score: Score = objective.getScore(Bukkit.getOfflinePlayer("${ChatColor.GREEN}Time:"))
        score.score = count

        if (count == 0) {
            plugin.server.scheduler.cancelTasks(plugin)
        }
    }
}