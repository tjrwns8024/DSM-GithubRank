package dms.tjrwns8024.githubrank.entity

data class RankInfo(
    val email: String,
    val githubId: String,
    val githubImage: String,
    val name: String,
    val description: String,
    val contributions: Int
)