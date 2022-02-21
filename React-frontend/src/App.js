import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

{/* container - bootstrap css class) */ }
{/* switch - render one component at a time) */ }
function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
          <div className="container">
            <Switch>
            <Route path = "/" exact component = {ListEmployeeComponent}></Route>
            <Route path = "/test" exact component = {ListEmployeeComponent}></Route>
              
            </Switch>
          </div>
          <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
