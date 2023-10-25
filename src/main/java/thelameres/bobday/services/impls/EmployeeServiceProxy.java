package thelameres.bobday.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import thelameres.bobday.configurations.properties.FileSaverConfigurationProperties;
import thelameres.bobday.responses.EmployeeControllerResponse;
import thelameres.bobday.services.EmployeeService;
import thelameres.bobday.services.FileSaverService;

@Service
@Slf4j
public class EmployeeServiceProxy implements EmployeeService {
    private final EmployeeService employeeService;
    private final FileSaverService fileSaverService;
    private final FileSaverConfigurationProperties saverConfigurationProperties;

    public EmployeeServiceProxy(@Qualifier("employeeServiceImpl") EmployeeService employeeService,
                                FileSaverService fileSaverService,
                                FileSaverConfigurationProperties saverConfigurationProperties) {
        this.employeeService = employeeService;
        this.fileSaverService = fileSaverService;
        this.saverConfigurationProperties = saverConfigurationProperties;
    }

    @Override
    public EmployeeControllerResponse getEmployees() {
        EmployeeControllerResponse employees = employeeService.getEmployees();
        if (saverConfigurationProperties.save()) fileSaverService.saveAsJsonFile(employees);
        return employees;
    }
}
