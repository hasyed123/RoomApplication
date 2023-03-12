package com.example.roomapplication.data

import com.example.roomapplication.data.game.GameDao
import com.example.roomapplication.data.game.GameEntity
import com.example.roomapplication.data.game.TeamWithGames
import com.example.roomapplication.data.league.LeagueEntity
import com.example.roomapplication.data.league.LeagueDao
import com.example.roomapplication.data.team.LeagueWithTeams
import com.example.roomapplication.data.team.TeamEntity
import com.example.roomapplication.data.team.TeamDao
import com.example.roomapplication.domain.Repository
import com.example.roomapplication.domain.model.Game
import com.example.roomapplication.domain.model.League
import com.example.roomapplication.domain.model.Team
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val leagueDao: LeagueDao,
    private val teamDao: TeamDao,
    private val gameDao: GameDao
): Repository {

//    suspend fun createSampleData(id: Int) {
//        for(i in 0..5) {
//            teamDao.insert(TeamEntity(
//                name = "League${id}Team$i",
//                leagueId = id,
//                wins = 0,
//                losses = 0,
//                ties = 0
//            ))
//        }
//        val teamList = teamDao.selectTeamsInLeague(id)?.teamEntities
//        teamList?.let {
//            for (team1 in it) {
//                for (team2 in it) {
//                    addGame(team1.name, team2.name)
//                }
//            }
//        }
//    }

    override suspend fun addLeague(league: League) {
        leagueDao.insert(league.toLeagueEntity())
    }

    override suspend fun getLeagues(): List<League> {
        return leagueDao.selectAll().map {
            it.toLeague()
        }
    }

    override suspend fun addTeam(team: Team) {
        teamDao.insert(team.toTeamEntity())
    }

    override suspend fun getTeamsInLeague(leagueId: Int): List<Team> {
        return teamDao.selectTeamsInLeague(leagueId)?.teamEntities?.map {
            it.toTeam()
        } ?: emptyList()
    }

    override suspend fun addGame(game: Game) {
        gameDao.insert(game.toGameEntity())
    }

    override suspend fun getGamesInLeague(leagueId: Int): List<Game> {
        return gameDao.selectGamesInLeague(leagueId)?.gameEntities?.map {
            it.toGame()
        } ?: emptyList()
    }


    override suspend fun getTeamGames(teamName: String): List<Game> {
        val teamWithGames = gameDao.selectGamesInTeam(teamName)
        val list = mutableListOf<Game>()
        teamWithGames?.let {
            list.addAll(it.games1.map { it.toGame() })
            list.addAll(it.games2.map { it.toGame() })
        }
        return list
    }

    private fun LeagueEntity.toLeague(): League {
        return League(
            id = this.id,
            name = this.name
        )
    }

    private fun League.toLeagueEntity(): LeagueEntity {
        return LeagueEntity(
            id = this.id,
            name = this.name
        )
    }

    private fun TeamEntity.toTeam(): Team {
        return Team(
            name = this.name,
            leagueId = this.leagueId,
            wins = this.wins,
            losses = this.losses,
            ties = this.ties
        )
    }

    private fun Team.toTeamEntity(): TeamEntity {
        return TeamEntity(
            name = this.name,
            leagueId = this.leagueId,
            wins = this.wins,
            losses = this.losses,
            ties = this.ties
        )
    }

    private fun GameEntity.toGame(): Game {
        return Game(
            id = this.id,
            team1Id = this.team1Id,
            team2Id = this.team2Id,
            leagueId = this.leagueId
        )
    }

    private fun Game.toGameEntity(): GameEntity {
        return GameEntity(
            id = this.id,
            team1Id = this.team1Id,
            team2Id = this.team2Id,
            leagueId = this.leagueId
        )
    }
}