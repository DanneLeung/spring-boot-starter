package com.xcesys.extras.framework.repository;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.entity.Setting;

public interface SettingRepository extends IBaseRepository<Setting, Long> {

	Setting findByName(String name);

	int countByName(String name);

	Setting findUsersById(Long id);
}
