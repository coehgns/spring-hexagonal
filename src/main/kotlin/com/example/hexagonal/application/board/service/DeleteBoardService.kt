package com.example.hexagonal.application.board.service

import com.example.hexagonal.application.board.port.`in`.DeleteBoardUseCase
import com.example.hexagonal.application.board.port.out.BoardPort
import com.example.hexagonal.domain.board.exception.BoardNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteBoardService(
    private val boardPort: BoardPort
) : DeleteBoardUseCase{
    @Transactional
    override fun deleteBoard(boardId: UUID) {
        val board = boardPort.findById(boardId) ?: throw BoardNotFoundException
        boardPort.deleteBoard(board)
    }
}