package ma.code.securityservice.sec.service;

import ma.code.securityservice.sec.entities.AppRole;
import ma.code.securityservice.sec.entities.AppUser;
import ma.code.securityservice.sec.repository.AppRoleRepository;
import ma.code.securityservice.sec.repository.AppUserRepository;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {

        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(userName);
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return null;
    }

    @Override
    public List<AppUser> listUsers() {
        return null;
    }
}
