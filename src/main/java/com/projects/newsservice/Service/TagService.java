package com.projects.newsservice.Service;

import com.projects.newsservice.dto.TagDto;
import com.projects.newsservice.entity.Tag;
import com.projects.newsservice.repository.TagRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepo tagRepo;

    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public TagDto save(TagDto tagDto) {
        Tag tag = tagRepo.save(convertToTag(tagDto));
        tagDto.setId(tag.getTag_id());
        return tagDto;
    }

    public List<TagDto> getAllTag() {
        return tagRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Tag convertToTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        return tag;
    }

    private TagDto convertToDto(Tag tag) {
        return new TagDto(tag.getTag_id(), tag.getName());
    }
}
