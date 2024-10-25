package com.pra.demo.utils;

import com.pra.demo.model.DimensionValues;
import com.pra.demo.model.MemberReference;
import com.pra.demo.model.RequestPayload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DimensionValidatorImpl implements DimensionValidator{

    @Override
    public void validateDimensions(RequestPayload payload) {
        if(payload.getDimensions()!=null && payload.getDimensions().getMember_ref()!=null){
            List<MemberReference> memberReferences = payload.getDimensions().getMember_ref();
            memberReferences.forEach(DimensionValidatorImpl::validateMemberRef);
        }
    }

    private static void validateMemberRef(MemberReference memberRef) {
        if(memberRef.getDimension_values()!=null){
            DimensionValues values = memberRef.getDimension_values();
            checkRefMemberAndTargetMember(values, memberRef);
            checkRefLevelAndTargetLevel(values,memberRef);
        }
    }

    private static void checkRefLevelAndTargetLevel(DimensionValues values, MemberReference memberRef) {
        if(!EqualityChecker.isEqual(values.getRef_level() ,values.getTarget_level())){
            memberRef.setIsModifiedDimensionRefLevel(true);
        }

    }

    private static void checkRefMemberAndTargetMember(DimensionValues values, MemberReference memberRef) {
        if(!EqualityChecker.isEqual(values.getRef_member(),values.getTarget_member())){
            memberRef.setIsModifiedDimensionRefMember(true);
        }
    }


}
