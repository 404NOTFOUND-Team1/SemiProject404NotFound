package com.nf.not404found.admin.product.model.service;


import com.nf.not404found.admin.product.model.dao.AdminProductMapper;
import com.nf.not404found.admin.product.model.dto.AdminAttachmentDTO;
import com.nf.not404found.admin.product.model.dto.AdminProductDTO;
import com.nf.not404found.common.exception.admin.ThumbnailRegistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdminProductServiceImpl implements AdminProductService{

    private final AdminProductMapper mapper;

    public AdminProductServiceImpl(AdminProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AdminProductDTO> selectConditionProduct(AdminProductDTO product) {
        log.info("서비스 왔냐 ======================================================>");

        List<AdminProductDTO> productList1 = mapper.selectConditionProduct(product);

        log.info("잘들어갔냐 ============================================>>");

        return productList1;
    }

    @Override
    public List<AdminProductDTO> selectAllProduct() {
        log.info("전체 상품 서비스 왔냐 ===================================>");

        List<AdminProductDTO> productList = mapper.selectAllProduct();

        log.info("전체 상품 잘 들어갔냐 ====================================================");

        return productList;
    }

    @Override
    @Transactional
    public void insertProduct(AdminProductDTO thumbnail) throws ThumbnailRegistException {
        
        log.info("상품등록 서비스 단으로 왔냐 ============================================>");

        int productResult = mapper.insertProduct(thumbnail);

        log.info("상품등록 매퍼 잘 갔다 왔냐 ===========================================>");

        Long productCode = thumbnail.getProductCode();

        thumbnail.getAdminOption().setProductCode(productCode);


        int optionsResult = mapper.insertOptions(thumbnail);

        log.info("옵션 경로 잘 타고 왔냐 =============================================");

        List<AdminAttachmentDTO> attachmentList = thumbnail.getAttachmentList();

        log.info("이미지 매퍼 시작 =================================================>");

        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setProductCode(thumbnail.getProductCode());
        }

        log.info("여기까진 오는거냐 ==========================================>");

        int attachmentResult = 0;
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.insertAttachment(attachmentList.get(i));
        }

        log.info("===========================================================이미지 매퍼 끝 ===================>");

        if (!(productResult > 0 && attachmentResult == attachmentList.size() && optionsResult > 0 )){
            log.info("오지마 제발 ================================> 상품 등록이 실패해부렀어===========>");
            throw new ThumbnailRegistException("상품 등록에 실패하셨습니다.");
        }


    }

    @Override
    public List<AdminProductDTO> selectOneProduct(String productName) {

        log.info("========================================================> 서비스단 시작");
        log.info("========================================================> productName = " + productName);

        List<AdminProductDTO> productList = mapper.selectOneProduct(productName);

        log.info("==========================================================> 비동기 잘 들어왔나 = > productList = " + productList);


        return productList;
    }

    @Override
    public List<AdminProductDTO> selectOneProduct2(Long productCode) {

        List<AdminProductDTO> productList = mapper.selectOneProduct2(productCode);

        log.info("======================================================> 잘 되냐?");

        return productList;
    }
}
