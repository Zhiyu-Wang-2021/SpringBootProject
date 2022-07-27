package com.example.springbootproject.service;


import com.example.springbootproject.domain.Ebook;
import com.example.springbootproject.domain.EbookExample;
import com.example.springbootproject.mapper.EbookMapper;
import com.example.springbootproject.req.EbookReq;
import com.example.springbootproject.resp.EbookResp;
import com.example.springbootproject.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        /*
        put all the ebooks in an ebook response list
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
            respList.add(ebookResp);
        }
        */
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);

        return respList;
    }
}
