package com.sun.fox.demo.server.foxdemoserver.demo.coverter;

import com.sun.fox.common.entity.BaseComverter;
import com.sun.fox.demo.api.pojo.dto.DemoUserDto;
import com.sun.fox.demo.api.pojo.vo.DemoUserVo;
import com.sun.fox.demo.server.foxdemoserver.demo.model.DemoUsers;
import org.springframework.beans.BeanUtils;

/**
 * Demo User 转换
 */
public class DemoUserCoverts {

    public static final DemoUserCoverts.DemoUserToDto DEMO_USER_TO_DTO = new DemoUserCoverts.DemoUserToDto();
    public static final DemoUserCoverts.VoToDemoUser VO_TO_DEMO_USER = new DemoUserCoverts.VoToDemoUser();

    /**
     *  Demo  转换为 出参
     */
    public static class DemoUserToDto extends BaseComverter<DemoUsers,DemoUserDto>{

        @Override
        public DemoUserDto coverter( DemoUsers source ) {
            if (source == null) {
                return null;
            }
            DemoUserDto dto = new DemoUserDto();
            BeanUtils.copyProperties(source, dto);
            return dto;
        }
    }

    /**
     * 入参转换为 Demo
     */
    public static class VoToDemoUser extends BaseComverter<DemoUserVo,DemoUsers>{

        @Override
        public DemoUsers coverter( DemoUserVo source ) {
            if (source == null) {
                return null;
            }
            DemoUsers demoUsers = new DemoUsers();
            BeanUtils.copyProperties(source, demoUsers);
            return demoUsers;
        }
    }
}
