import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ListEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            employees: [] //Array of employees, call restAPI
        }
        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);

    }

    viewEmployee(id){
        this.props.history.push(`/view-employee/${id}`);
    }

    deleteEmployee(id){
        EmployeeService.deleteEmployee(id).then( res => {
            this.setState({employees: this.state.employees.filter(employee => employee.id !== id)});
        });
    }

    editEmployee(id) {
        this.props.history.push(`/update-employee/${id}`);

    }

    //Component get mounted as soon as component is mounted
    //Stored response data inside of the array
    componentDidMount() {
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data })
        })
    }

    //Route - after you click, this is where you go
    addEmployee() {
        this.props.history.push('/add-employee');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Employees List</h2>
                <div className="row" className="w-25 p-3">
                    <button className="btn btn-primary" onClick={this.addEmployee}>Add employee</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> Employee First Name</th>
                                <th> Employee Last Name</th>
                                <th> Employee Email Id</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.employees.map(
                                    employee =>
                                        <tr key={employee.id}>
                                            <td> {employee.firstName} </td>
                                            <td> {employee.lastName}</td>
                                            <td> {employee.emailId}</td>
                                            <td>
                                                <button className="btn btn-info" onClick={() => this.editEmployee(employee.id)}>Update</button>
                                                <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(employee.id)} className="btn btn-danger">Delete </button>
                                                <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.id)} className="btn btn-info">View </button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>

                </div>


            </div>
        )
    }

}

export default ListEmployeeComponent