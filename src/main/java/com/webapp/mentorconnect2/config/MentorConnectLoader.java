package com.webapp.mentorconnect2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.models.Comment;
import com.webapp.mentorconnect2.models.ForumPost;
import com.webapp.mentorconnect2.repository.AccountService;
import com.webapp.mentorconnect2.repository.CommentService;
import com.webapp.mentorconnect2.repository.ForumPostService;

@Component
public class MentorConnectLoader implements CommandLineRunner{
    
    @Autowired
    AccountService accountDB;

    @Autowired
    ForumPostService forumPostDB;

    @Autowired 
    CommentService commentDB;

    @Override
    public void run(String... args) throws Exception {
        localSeedData();
    }
    
    private void localSeedData(){
        if (accountDB.count() == 0){
            Account account1 = new Account("avssssssss", "password", "Mentor");
            Account account2 = new Account("mfdskjldskjm", "204324", "Mentee");

            accountDB.save(account1);
            accountDB.save(account2);
        }

        if (forumPostDB.count() == 0){
            ForumPost post1 = new ForumPost("rap god", "im beginning to feel like a rap god", 1);
            ForumPost post2 = new ForumPost("gee", "wilikers", 2);

            forumPostDB.save(post1);
            forumPostDB.save(post2);
        }

        if (commentDB.count() == 0){
            Comment cm = new Comment("whats up dudes", 1, 1, 8);
            commentDB.save(cm);
        }
    }
}
