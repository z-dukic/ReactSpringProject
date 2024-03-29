import React from "react";
import axios from "axios";



//Same URL you put in java
//const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/employees";
//const EMPLOYEE_API_BASE_URL = "https://anypoint.mulesoft.com/mocking/api/v1/links/d4794ced-cb84-4673-8089-7618277d3cba/employees";
const EMPLOYEE_API_BASE_URL = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/de8feddc-8a34-4393-8449-bce00a2ce605/reactapi/1.0.4/m/employees";

class EmployeeService {

    //axios gets response of get method
    getEmployees() {
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

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




}

//Not exporting class but object of a class
export default new EmployeeService()