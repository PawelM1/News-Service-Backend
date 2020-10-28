package com.projects.newsservice.Service;

import com.projects.newsservice.dto.VoteDto;
import com.projects.newsservice.entity.Post;
import com.projects.newsservice.entity.User;
import com.projects.newsservice.entity.Vote;
import com.projects.newsservice.entity.VoteType;
import com.projects.newsservice.exception.NotFoundPostException;
import com.projects.newsservice.exception.NotFoundUserException;
import com.projects.newsservice.exception.OtherAppException;
import com.projects.newsservice.repository.PostRepo;
import com.projects.newsservice.repository.UserRepo;
import com.projects.newsservice.repository.VoteRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VoteService {

    private VoteRepo voteRepo;
    private PostRepo postRepo;
    private UserRepo userRepo;

    public VoteService(VoteRepo voteRepo, PostRepo postRepo, UserRepo userRepo) {
        this.voteRepo = voteRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public Vote save(VoteDto voteDto, String username) {
        Post post = postRepo.findById(voteDto.getPostId()).orElseThrow(() -> new NotFoundPostException(voteDto.getPostId().toString()));
        User user = userRepo.findByUsername(username).orElseThrow(NotFoundUserException::new);
        Optional<Vote> voteByUserAndPost = voteRepo.findTopByUserAndPostOrderByVoteIdDesc(user, post);

        //if isPresent, user vote, so if clik same VoteType throw error, else change voteresult by 2, if notPresent user vote first time
        if (voteByUserAndPost.isPresent()) {
            if (voteByUserAndPost.get().getVoteType().equals(voteDto.getVoteType()))
                throw new OtherAppException("You already voted like this");
            else {
                if (voteByUserAndPost.get().getVoteType().equals(VoteType.PLUS))
                    post.setVoteResult(post.getVoteResult() - 2);
                else
                    post.setVoteResult(post.getVoteResult() + 2);
            }
        } else {
            if (voteDto.getVoteType().equals(VoteType.PLUS))
                post.setVoteResult(post.getVoteResult() + 1);
            else
                post.setVoteResult(post.getVoteResult() - 1);
        }

        postRepo.save(post);
        return voteRepo.save(mapVoteDtoToVote(voteDto, post, user));
    }

    private Vote mapVoteDtoToVote(VoteDto voteDto, Post post, User user) {
        Vote vote = new Vote();
        vote.setPost(post);
        vote.setUser(user);
        vote.setVoteType(voteDto.getVoteType());
        return vote;
    }
}
