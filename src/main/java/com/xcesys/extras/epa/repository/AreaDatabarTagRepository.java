package com.xcesys.extras.epa.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xcesys.extras.epa.entity.AreaDatabarTag;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

@CacheConfig(cacheNames = "querycache")
public interface AreaDatabarTagRepository extends IBaseRepository<AreaDatabarTag, Long> {
	List<AreaDatabarTag> findByAreaAndDatabarOrderByOrders(Long area, Long databar);

	@Cacheable
	@Query("select c from #{#entityName} c join fetch c.tag t order by c.area, c.databar, c.orders")
	List<AreaDatabarTag> findList();

	@Cacheable
	@Query("select c from #{#entityName} c join fetch c.tag t where c.databar=:databar order by  c.databar, c.orders")
	List<AreaDatabarTag> findByDatabar(@Param("databar") Long databar);
}
