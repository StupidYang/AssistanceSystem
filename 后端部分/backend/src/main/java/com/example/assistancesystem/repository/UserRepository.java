package com.example.assistancesystem.repository;

import com.example.assistancesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*public interface XXXRepository extends JpaRepository<表名,数据类型>
* 使用方法 普通的增加就不需要自定义函数 它会自己先查 如果有重复会直接覆盖 如果没有重复会新增一条
* 自定义方法可以使用如下：
* Keyword                     Sample                                 JPQL snippet
* IsNotNull                findByAgeNotNull                      where x.age not null
* Like	                    findByNameLike	                     where x.name like ?1
* NotLike	               findByNameNotLike	                where x.name not like ?1
* OrderBy	              findByAgeOrderByName	            where x.age = ?1 order by x.name desc
* Not	                   findByNameNot	                       where x.name <> ?1
* In	                   findByAgeIn	                           where x.age in ?1
* NotIn	                   findByAgeNotIn	                       where x.age not in ?1
* And 	                   findByNameAndAge                  where x.name = ?1 and x.age = ?2
* Or	                   findByNameOrAge	                  where x.name = ?1 or x.age = ?2
* Between	               findBtAgeBetween	                    where x.age between ?1 and ?2
* LessThan	               findByAgeLessThan	                   where x.age  <  ?1
* GreaterThan	           findByAgeGreaterThan	                    where x.age > ?1
* IsNull	               findByAgeIsNull                        where x.age is null
* ?1是对应函数的参数，例如findByAgeIn(XXX x),?1为x*/
public interface UserRepository extends JpaRepository<User,String> {
//    直接在这里写函数
}
