/**
 * UserUtils.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 ott 2017
 * For further information please write to info@2clever.it
 */
package com.webapp.web.utils;

import com.opengest.core.business.dto.UserDto;
import com.opengest.core.business.vo.User;

/**
 * @author robgion
 *
 */
public class UserUtils {

	/**
	 * Metodo peril travaso delle informazioni dal VO al DTO.
	 * @param user
	 * @return
	 */
	public static UserDto fromUserVoToDto(User user) {
		UserDto retDto = new UserDto();
		retDto.setCognome(user.getCognome());
		retDto.setNome(user.getNome());
		retDto.setId(user.getId());
		retDto.setUsername(user.getUsername());
		// ...
		return retDto;
	}

	public static User fromUserDtoToVo(UserDto dto) {
		User vo = new User();
		vo.setCognome(dto.getCognome());
		vo.setNome(dto.getNome());
		vo.setId(dto.getId());
		vo.setUsername(dto.getUsername());
		// ...
		return vo;
	}
}
