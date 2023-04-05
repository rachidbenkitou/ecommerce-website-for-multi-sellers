package com.ecommerce.manager.service;

import com.ecommerce.manager.Manager;
import com.ecommerce.manager.ManagerDto;
import com.ecommerce.manager.ManagerMapper;
import com.ecommerce.manager.ManagerRepository;
import com.ecommerce.manager.exception.ManagerAlreadyExistException;
import com.ecommerce.manager.exception.NoManagerFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    @Override
    public List<ManagerDto> getAllMangers() {
        // Retrieve all managers from the database as a list.
        List<Manager> managers=managerRepository.findAll();
        if (managers.isEmpty()) throw  new NoManagerFoundException("Manager list is empty");
        // Convert the list of Manager objects to a list of ManagerDto objects and return it.
        return managerMapper.modelToDtos(managers);
    }

    @Override
    public List<ManagerDto> getManagersByEmail(String managerEmail) {
        // Retrieve all managers by name from the database as a list.
        List<Manager> managers=managerRepository.findManagersByEmailLikeIgnoreCase(managerEmail);
        if (managers.isEmpty()) throw  new NoManagerFoundException("No manager found with this name");
        // Convert the list of Manager objects to a list of ManagerDto objects and return it.
        return managerMapper.modelToDtos(managers);
    }

    @Override
    public ManagerDto saveManager(ManagerDto managerDto) {
        // We first check whether the manager already exists in the database. If it exists, a ManagerAlreadyExistException will be thrown.
        if(isManagerExist(managerDto.getEmail()))
            throw new ManagerAlreadyExistException(String.format("The manager %s %s is already  exists.", managerDto.getFirstName(),managerDto.getLastName()));
        return savedManager(managerDto);
    }
    @Override
    public ManagerDto updateManager(ManagerDto managerDto) {
        return saveManager(managerDto);
    }
    @Override
    public void deleteManagerByEmail(String managerEmail) {
        managerRepository.deleteManagerByEmail(managerEmail);
    }
    /**
     * Check if a manager exists in the database.
     *
     * @param managerEmail The name of manager that we will check if exists in the database.
     * @return If the manager exists, the function returns true, if not, it returns false.
     */


    private boolean isManagerExist(String managerEmail){
        boolean isExistManager=managerRepository.existsManagerByEmail(managerEmail);
        if(isExistManager) return true;
        else return false;
    }
    /**
     * save a manager in the database.
     *
     * @param managerDto The  manager that we will save in the database.
     * @return the manager that we just saved in the database.
     */
    public ManagerDto savedManager(ManagerDto managerDto){
        return managerMapper.modelToDto(managerRepository.save(managerMapper.dtoToModel(managerDto)));
    }

}
