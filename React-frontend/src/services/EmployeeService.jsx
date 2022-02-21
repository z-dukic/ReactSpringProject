import React from "react";
import axios from "axios";

//Same URL you put in java
const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/employees";

class EmployeeService {

    //axios gets response of get method
    getEmployees() {
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

}

//Not exporting class but object of a class
export default new EmployeeService()