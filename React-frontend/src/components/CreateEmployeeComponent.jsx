import React, { Component } from "react";
import EmployeeService from "../services/EmployeeService";

class CreateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        //properties used to store data
        this.state = {
            firstName: '',
            lastName: '',
            emailId: ''

        }

        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveEmployee = this.saveEmployee.bind(this);

    }

    //Called everytime on save
    saveEmployee = (e) => {
        e.preventDefault();

        //JS created object
        let employee = { firstName: this.state.firstName, lastName: this.state.lastName, emailId: this.state.emailId };
        console.log('employee => ' + JSON.stringify(employee));
 
        EmployeeService.createEmployee(employee).then(res => {
            this.props.history.push('/employees');
        });
    }


    //Assign name in form to firstName
    changeFirstNameHandler = (event) => {
        this.setState({ firstName: event.target.value });
    }

    changeLastNameHandler = (event) => {
        this.setState({ lastName: event.target.value });
    }

    changeEmailHandler = (event) => {
        this.setState({ emailId: event.target.value });
    }

    //if you click, go to that url
    cancel(){
        this.props.history.push('/employees');
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3"></div>
                        <h3 className="text-center">Add Employee</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> First Name: </label>
                                    <input placeholder="First Name" name="firstName" className="form-control"
                                        value={this.state.firstName} onChange={this.changeFirstNameHandler} />
                                </div>

                                <div className="form-group">
                                    <label> Last Name: </label>
                                    <input placeholder="Last Name" name="lastName" className="form-control"
                                        value={this.state.lastName} onChange={this.changeLastNameHandler} />
                                </div>

                                <div className="form-group">
                                    <label> Email Id: </label>
                                    <input placeholder="Email Address" name="emailId" className="form-control"
                                        value={this.state.emailId} onChange={this.changeEmailHandler} />
                                </div>
                                <button className="btn btn-success" onClick={this.saveEmployee}>Save</button>
                                <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>


                            </form>

                        </div>
                    </div>


                </div>
            </div>
        )


    }

}

export default CreateEmployeeComponent