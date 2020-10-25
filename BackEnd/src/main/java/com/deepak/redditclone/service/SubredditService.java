package com.deepak.redditclone.service;

import com.deepak.redditclone.exception.SpringRedditException;
import com.deepak.redditclone.repository.SubredditRepository;
import com.deepak.redditclone.dto.SubredditDto;
import com.deepak.redditclone.mapper.SubredditMapper;
import com.deepak.redditclone.model.Subreddit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit subreddit = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(subreddit.getId());
        return subredditDto;
    }
    
    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("Subreddit not found with id -" + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}

