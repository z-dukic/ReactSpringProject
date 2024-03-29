import React from "react";
import axios from "axios";

//Same URL you put in java
//const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/";

const EMPLOYEE_API_BASE_URL = "https://anypoint.mulesoft.com/mocking/api/v1/sources/vcs/projects/96dd3bcc-eef7-486d-986c-8c8669dd2f54/master/m/employees";

class EmployeeService {

    //axios gets response of get method
    getEmployees() {
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    /*
    
    createEmployee(employee) {
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }

    updateEmployee(employee, employeeId){
        return axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }

    */



}

//Not exporting class but object of a class
export default new EmployeeService()