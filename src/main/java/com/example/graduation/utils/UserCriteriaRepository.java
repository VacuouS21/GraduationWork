package com.example.graduation.utils;


import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserDTO;
import com.sun.xml.bind.v2.TODO;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserCriteriaRepository {


    private final EntityManager entityManager;

    private final CriteriaBuilder criteriaBuilder;

    public UserCriteriaRepository(EntityManager entityManager){
        this.entityManager=entityManager;
        this.criteriaBuilder=entityManager.getCriteriaBuilder();

    }

    public List<UserInfo> FindAllWithFilters( UserDTO userSearchCriteria){
        CriteriaQuery<UserInfo> criteriaQuery= criteriaBuilder.createQuery(UserInfo.class);

        Root<UserInfo> userRoot=criteriaQuery.from(UserInfo.class);
        Predicate predicate = getPredicate(userSearchCriteria,userRoot);
        criteriaQuery.where(predicate);
        //TODO setOrder(userPage,criteriaQuery,userRoot);

        TypedQuery<UserInfo> typedQuery= entityManager.createQuery(criteriaQuery);


        return typedQuery.getResultList();// PageImpl<>(typedQuery.getResultList(),pageable,userCount);
    }

/*    private void setOrder(UserPage userPage, CriteriaQuery<UserInfo> criteriaQuery, Root<UserInfo> userRoot) {
        if(userPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get(userPage.getSortBy())));
        }
        else {
            criteriaQuery.orderBy(criteriaBuilder.desc(userRoot.get(userPage.getSortBy())));
        }
    }*/

    private Predicate getPredicate(UserDTO userSearchCriteria, Root<UserInfo> userRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(userSearchCriteria.getUsername())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("username"),"%"+userSearchCriteria.getUsername()+"%")
            );
        }
        if(Objects.nonNull(userSearchCriteria.getInfoEasy())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("infoEasy"),"%"+userSearchCriteria.getInfoEasy()+"%")
            );
        }
        if(Objects.nonNull(userSearchCriteria.getInfoMedium())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("infoMedium"),"%"+userSearchCriteria.getInfoMedium()+"%")
            );
        }

        if(Objects.nonNull(userSearchCriteria.getInfoHard())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("infoHard"),"%"+userSearchCriteria.getInfoHard()+"%")
            );
        }
        if(Objects.nonNull(userSearchCriteria.isBossLevel())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("bossLevel"),"%"+userSearchCriteria.isBossLevel()+"%")
            );
        }
        if(Objects.nonNull(userSearchCriteria.getBossMax())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("bossMax"),"%"+userSearchCriteria.getBossMax()+"%")
            );
        }

        /*
        private Integer infoEasy;
    private Integer infoMedium;
    private Integer infoHard;
    private boolean bossLevel;
    private Integer bossMax;
         */
        /*if(Objects.nonNull("expand")){
            predicates.add(
                    criteriaBuilder.notLike(userRoot.get("user_login"),"")
            );
            System.out.println("YES");
        }*/
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}