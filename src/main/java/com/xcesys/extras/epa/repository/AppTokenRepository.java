package com.xcesys.extras.epa.repository;

import com.xcesys.extras.epa.entity.AppToken;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface AppTokenRepository extends IBaseRepository<AppToken, Long> {

	AppToken findByUserIdAndToken(Long userId, String token);

}
